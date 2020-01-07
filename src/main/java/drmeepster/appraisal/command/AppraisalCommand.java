package drmeepster.appraisal.command;

import static net.minecraft.server.command.CommandManager.literal;

import java.util.ArrayList;
import java.util.List;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;

import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class AppraisalCommand{
	
	public static final String ROOT = "appraise";
	
	public static final Text NO_APPRAISAL_FOUND = new TranslatableText("commands.appraise.none");
	
	public static final List<SubCommand> SUB_COMMANDS = new ArrayList<>();
	
	public static final ItemSubCommand ITEM = subcommand(new ItemSubCommand());
	public static final BlockSubCommand BLOCK = subcommand(new BlockSubCommand());

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher){
		LiteralArgumentBuilder<ServerCommandSource> root = literal(ROOT);
		
		for(SubCommand command : SUB_COMMANDS){
			root.then(command.getCommand());
		}
		
		dispatcher.register(root);
	}
	
	public static <T extends SubCommand> T subcommand(T command){
		SUB_COMMANDS.add(command);
		
		return command;
	}
	
	public static int appraise(CommandContext<ServerCommandSource> ctx, List<Text> texts)	{	
		ServerCommandSource src = ctx.getSource();
		
		if(texts.isEmpty()){
			src.sendFeedback(NO_APPRAISAL_FOUND, true);
			return 0;
		}
		
		for(Text text : texts){
			src.sendFeedback(text, true);
		}
		
		return 1;
	}
}

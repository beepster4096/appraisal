package drmeepster.appraisal.command;

import static net.minecraft.server.command.CommandManager.literal;

import java.util.ArrayList;
import java.util.List;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.minecraft.server.command.ServerCommandSource;

public class AppraisalCommand{
	
	public static final String ROOT = "appraise";
	
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
}

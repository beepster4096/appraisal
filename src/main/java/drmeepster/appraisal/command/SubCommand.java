package drmeepster.appraisal.command;

import java.util.List;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;

import drmeepster.appraisal.util.ApUtil;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public interface SubCommand{

	public Identifier getId();
	
	public LiteralArgumentBuilder<ServerCommandSource> getCommand();
	
	public static int appraise(CommandContext<ServerCommandSource> ctx, List<Text> texts)	{	
		ServerCommandSource src = ctx.getSource();
		
		if(texts.isEmpty()){
			src.sendFeedback(ApUtil.NO_APPRAISAL_TEXT, true);
			return 0;
		}
		
		for(Text text : texts){
			src.sendFeedback(text, true);
		}
		
		return 1;
	}
}

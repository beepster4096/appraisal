package drmeepster.appraisal.command;

import static net.minecraft.server.command.CommandManager.literal;

import java.util.List;

import com.google.common.collect.Lists;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.CommandNode;

import drmeepster.appraisal.command.AppraisalSubCommands.Entry;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.Identifier;

public class AppraisalCommand{
	
	public static final String ROOT = "appraise";

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher){
		LiteralArgumentBuilder<ServerCommandSource> root = literal(ROOT);
		
		for(Entry entry : AppraisalSubCommands.COMMANDS){
			ArgumentBuilder<ServerCommandSource, ?> command = entry.getCommand();
			List<String> path = entry.getPath();
			Identifier id = entry.getIdentifier();
			String idStr = id.getNamespace() == "minecraft" ? id.getPath() : id.toString();
					
			ArgumentBuilder<ServerCommandSource, ?> prev = command;
			
			for(String s : Lists.reverse(path)){
				prev = literal(s).then(prev);
			}
			
			root.then(literal(idStr).then(prev));
		}
		
		dispatcher.register(root);
	}
}

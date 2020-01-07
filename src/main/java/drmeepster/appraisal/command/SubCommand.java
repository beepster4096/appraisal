package drmeepster.appraisal.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.Identifier;

public interface SubCommand{

	public Identifier getId();
	
	public LiteralArgumentBuilder<ServerCommandSource> getCommand();
}

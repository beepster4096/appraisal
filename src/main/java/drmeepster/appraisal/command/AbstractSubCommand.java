package drmeepster.appraisal.command;

import java.util.List;

import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.Identifier;

public abstract class AbstractSubCommand implements SubCommand{

	protected Identifier id;
	
	public AbstractSubCommand(Identifier id){
		this.id = id;
	}
	
	protected abstract List<ArgumentBuilder<ServerCommandSource, ?>> generateBranches();
	
	@Override
	public LiteralArgumentBuilder<ServerCommandSource> getCommand(){
		List<ArgumentBuilder<ServerCommandSource, ?>> branches = this.generateBranches();
		LiteralArgumentBuilder<ServerCommandSource> root = CommandManager.literal(this.getIdString());
		
		for(ArgumentBuilder<ServerCommandSource, ?> branch : branches){
			root.then(branch);
		}

		return root;
	}
	
	@Override
	public Identifier getId(){
		return this.id;
	}
	
	public String getIdString(){
		if(this.id.getNamespace() == "minecraft"){
			return this.id.getPath();
		}else{
			return this.id.toString();
		}
	}
}

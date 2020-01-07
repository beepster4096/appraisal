package drmeepster.appraisal.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.Identifier;

public abstract class AbstractSubCommand implements SubCommand{

	protected Identifier id;
	
	public AbstractSubCommand(Identifier id){
		this.id = id;
	}
	
	protected abstract void generateBranches(LiteralArgumentBuilder<ServerCommandSource> root);
	
	@Override
	public LiteralArgumentBuilder<ServerCommandSource> getCommand(){
		LiteralArgumentBuilder<ServerCommandSource> root = CommandManager.literal(this.getIdString());
		
		this.generateBranches(root);

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

package drmeepster.appraisal.command;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

import java.util.List;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;

import drmeepster.appraisal.context.BlockAppraisalContext;
import drmeepster.appraisal.quack.block.AppraisalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.command.arguments.BlockStateArgumentType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BlockSubCommand extends AbstractSubCommand{

	public static final Identifier ID = new Identifier("minecraft", "block");
	
	public BlockSubCommand(){
		super(ID);
	}
	
	private static int executeBlockAbstract(CommandContext<ServerCommandSource> ctx){
		BlockState state = BlockStateArgumentType.getBlockState(ctx, "blockstate").getBlockState();
		
		List<Text> texts = ((AppraisalBlock) state.getBlock()).getAppraisalManager().getAppraisal(
			new BlockAppraisalContext.Builder().setState(state).build()
		);
		
		return AppraisalCommand.appraise(ctx, texts);
	}

	@Override
	protected void generateBranches(LiteralArgumentBuilder<ServerCommandSource> root){
		root.then(literal("abstract")
			.then(argument("blockstate", BlockStateArgumentType.blockState())
				.executes(ctx -> executeBlockAbstract(ctx))
			)
		);
	}

}

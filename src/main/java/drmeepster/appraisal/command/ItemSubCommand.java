package drmeepster.appraisal.command;

import static com.mojang.brigadier.arguments.BoolArgumentType.bool;
import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

import java.util.List;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import drmeepster.appraisal.context.ItemAppraisalContext;
import drmeepster.appraisal.quack.item.AppraisalItem;
import net.minecraft.command.arguments.ItemStackArgumentType;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemSubCommand extends AbstractSubCommand{

	public static final Identifier ID = new Identifier("minecraft", "item");
	
	public ItemSubCommand(){
		super(ID);
	}
	
	private static int executeItemAbstract(CommandContext<ServerCommandSource> ctx, int count, boolean advanced)
		throws CommandSyntaxException{
		
		ItemStack stack = ItemStackArgumentType.getItemStackArgument(ctx, "item").createStack(count, false);
		
		List<Text> texts = ((AppraisalItem) stack.getItem()).getAppraisalManager().getAppraisal(
			new ItemAppraisalContext.Builder().setStack(stack).setAdvanced(advanced).build()
		);
		
		return AppraisalCommand.appraise(ctx, texts);
	}

	@Override
	protected void generateBranches(LiteralArgumentBuilder<ServerCommandSource> root){
		root.then(literal("abstract")
			.then(argument("item", ItemStackArgumentType.itemStack())
				.executes(ctx -> executeItemAbstract(ctx, 1, false))
				.then(argument("count", integer())
					.executes(ctx -> 
						executeItemAbstract(ctx, IntegerArgumentType.getInteger(ctx, "count"), false)
					)
					.then(argument("advanced", bool())
						.executes(ctx ->
							executeItemAbstract(
								ctx,
								IntegerArgumentType.getInteger(ctx, "count"),
								BoolArgumentType.getBool(ctx, "advanced")
							)
						)
					)
				)
			)
		);
	}

}

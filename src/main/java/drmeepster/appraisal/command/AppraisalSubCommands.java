package drmeepster.appraisal.command;

import static net.minecraft.server.command.CommandManager.argument;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import drmeepster.appraisal.context.BlockAppraisalContext;
import drmeepster.appraisal.context.ItemAppraisalContext;
import drmeepster.appraisal.quack.block.AppraisalBlock;
import drmeepster.appraisal.quack.item.AppraisalItem;
import drmeepster.appraisal.util.ApUtil;
import net.minecraft.block.BlockState;
import net.minecraft.command.arguments.BlockStateArgumentType;
import net.minecraft.command.arguments.ItemStackArgumentType;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AppraisalSubCommands{

	public static final Set<Entry> COMMANDS = new HashSet<>();
	
	//BLOCK ABSTRACT
	
	private static int executeBlockAbstract(CommandContext<ServerCommandSource> ctx){
		BlockState state = BlockStateArgumentType.getBlockState(ctx, "blockstate").getBlockState();
		
		List<Text> texts = ((AppraisalBlock) state.getBlock()).getAppraisalManager().getAppraisal(
			new BlockAppraisalContext.Builder().setState(state).build()
		);
		
		return appraise(ctx, texts);
	}
	
	public static final ArgumentBuilder<ServerCommandSource, ?> BLOCK_ABSTRACT = register(
		argument("blockstate", BlockStateArgumentType.blockState())
			.executes(ctx -> executeBlockAbstract(ctx)),
		"block", "abstract"
	);
	
	//ITEM ABSTRACT
	
	private static int executeItemAbstract(CommandContext<ServerCommandSource> ctx, int count)
		throws CommandSyntaxException{
		
		ItemStack stack = ItemStackArgumentType.getItemStackArgument(ctx, "item").createStack(count, false);
		
		List<Text> texts = ((AppraisalItem) stack.getItem()).getAppraisalManager().getAppraisal(
			new ItemAppraisalContext.Builder().setStack(stack).build()
		);
		
		return appraise(ctx, texts);
	}
	
	public static final ArgumentBuilder<ServerCommandSource, ?> ITEM_ABSTRACT = register(
		argument("item", ItemStackArgumentType.itemStack())
			.executes(ctx -> executeItemAbstract(ctx, 1))
			.then(argument("count", IntegerArgumentType.integer())
				.executes(ctx -> 
					executeItemAbstract(ctx, IntegerArgumentType.getInteger(ctx, "count"))
				)
			),
		"item", "abstract"
	);
	
	public static ArgumentBuilder<ServerCommandSource, ?> register(Entry entry){
		COMMANDS.add(entry);
		return entry.getCommand();
	}
	
	public static ArgumentBuilder<ServerCommandSource, ?> register(ArgumentBuilder<ServerCommandSource, ?> command, Identifier id, List<String> path){
		return register(new Entry(command, id, path));
	}
	
	public static ArgumentBuilder<ServerCommandSource, ?> register(ArgumentBuilder<ServerCommandSource, ?> command, Identifier id, String... path){
		return register(new Entry(command, id, path));
	}
	
	public static ArgumentBuilder<ServerCommandSource, ?> register(ArgumentBuilder<ServerCommandSource, ?> command, String... path){
		return register(new Entry(command, path));
	}
	
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
	
	public static class Entry{
		private List<String> path;
		private Identifier id;
		
		private ArgumentBuilder<ServerCommandSource, ?> command;
		
		public Entry(ArgumentBuilder<ServerCommandSource, ?> command, Identifier id, List<String> path){
			this.command = command;
			this.path = path;
			this.id = id;
		}
		
		public Entry(ArgumentBuilder<ServerCommandSource, ?> command, Identifier id, String... path){
			this(command, id, Arrays.asList(path));
		}
		
		public Entry(ArgumentBuilder<ServerCommandSource, ?> command, String... path){
			this(command, new Identifier(path[0]), Arrays.copyOfRange(path, 1, path.length));
		}
		
		public ArgumentBuilder<ServerCommandSource, ?> getCommand(){
			return this.command;
		}
		
		public Identifier getIdentifier(){
			return this.id;
		}
		
		public List<String> getPath(){
			return this.path;
		}
	}
}

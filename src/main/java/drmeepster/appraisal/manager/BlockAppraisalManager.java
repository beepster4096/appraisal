package drmeepster.appraisal.manager;

import java.util.List;

import drmeepster.appraisal.context.AppraisalContext;
import drmeepster.appraisal.context.BlockAppraisalContext;
import drmeepster.appraisal.context.ItemAppraisalContext;
import net.minecraft.block.Block;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;

public class BlockAppraisalManager<T extends Block> extends AbstractAppraisalManager<T, BlockAppraisalContext>{

	public static final String KEY_TYPE = "appraisal.block";

	public BlockAppraisalManager(T block){
		super(block, Registry.BLOCK, KEY_TYPE);
	}

	@Override
	public List<String> getTranslationKeys(BlockAppraisalContext context){
		List<String> out = super.getTranslationKeys(context);

		Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base = context.getBase();

		if(base.getLeft() instanceof BlockItemAppraisalManager<?>){
			out.addAll(0, ((BlockItemAppraisalManager<?>) base.getLeft())
				.getTranslationKeys((ItemAppraisalContext) base.getRight()));
		}
		
		return out;
	}
}
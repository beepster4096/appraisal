package drmeepster.appraisal.manager;

import java.util.List;

import drmeepster.appraisal.context.AppraisalContext;
import drmeepster.appraisal.context.FluidAppraisalContext;
import drmeepster.appraisal.context.ItemAppraisalContext;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;

public class FluidAppraisalManager<T extends Fluid> extends AbstractAppraisalManager<T, FluidAppraisalContext>{

	public static final String KEY_TYPE = "appraisal.fluid";

	public FluidAppraisalManager(T block){
		super(block, Registry.FLUID, KEY_TYPE);
	}

	@Override
	public List<String> getTranslationKeys(FluidAppraisalContext context){
		List<String> out = super.getTranslationKeys(context);
		
		Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base = context.getBase();

		if(base.getLeft() instanceof BucketItemAppraisalManager<?>){
			out.addAll(0, ((BucketItemAppraisalManager<?>) base.getLeft())
				.getTranslationKeys((ItemAppraisalContext) base.getRight()));
		}
		
		return out;
	}
}
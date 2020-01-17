package drmeepster.appraisal.quack.block;

import net.minecraft.fluid.Fluid;

/**
 * Mixin interface for <code>FluidBlockMixin</code>.
 */
public interface AppraisalFluidBlock extends AppraisalBlock{
	
	/**
	 * @return this <code>FluidBlock</code>'s <code>Fluid</code>.
	 */
	public Fluid getFluid();
}

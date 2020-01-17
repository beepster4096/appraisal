package drmeepster.appraisal.quack.item;

import net.minecraft.fluid.Fluid;

/**
 * Mixin interface for <code>BucketItemMixin</code>.
 */
public interface AppraisalBucketItem extends AppraisalItem{

	/**
	 * @return this <code>BucketItem</code>'s <code>Fluid</code>.
	 */
	public Fluid getFluid();
}

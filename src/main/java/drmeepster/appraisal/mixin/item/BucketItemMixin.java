package drmeepster.appraisal.mixin.item;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import drmeepster.appraisal.manager.item.BucketItemAppraisalManager;
import drmeepster.appraisal.quack.item.AppraisalBucketItem;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;

@Mixin(BucketItem.class)
public abstract class BucketItemMixin extends Item implements AppraisalBucketItem{

	protected BucketItemAppraisalManager<BucketItem> appraisal_appraisalManager = new BucketItemAppraisalManager<>(
		(BucketItem) (Object) this);

	@Shadow
	private Fluid fluid;

	private BucketItemMixin(Settings settings){
		super(settings);
	}

	@Override
	public Fluid getFluid(){
		return this.fluid;
	}

	@Override
	public BucketItemAppraisalManager<BucketItem> getAppraisalManager(){
		return this.appraisal_appraisalManager;
	}
}

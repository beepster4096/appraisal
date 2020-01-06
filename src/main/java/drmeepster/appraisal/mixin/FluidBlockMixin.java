package drmeepster.appraisal.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import drmeepster.appraisal.manager.block.FluidBlockAppraisalManager;
import drmeepster.appraisal.quack.block.AppraisalFluidBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.BaseFluid;
import net.minecraft.fluid.Fluid;

@Mixin(FluidBlock.class)
public abstract class FluidBlockMixin extends Block implements AppraisalFluidBlock{

	protected FluidBlockAppraisalManager<FluidBlock> appraisal_appraisalManager = new FluidBlockAppraisalManager<>((FluidBlock)(Object)this);
	
	@Shadow
	protected BaseFluid fluid;
	
	private FluidBlockMixin(Settings settings){
		super(settings);
	}
	
	@Override
	public FluidBlockAppraisalManager<FluidBlock> getAppraisalManager(){
		return this.appraisal_appraisalManager;
	}
	
	@Override
	public Fluid getFluid(){
		return this.fluid;
	}
}

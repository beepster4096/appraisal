package drmeepster.appraisal.mixin;

import org.spongepowered.asm.mixin.Mixin;

import drmeepster.appraisal.manager.FluidAppraisalManager;
import drmeepster.appraisal.quack.AppraisalFluid;
import net.minecraft.fluid.Fluid;

@Mixin(Fluid.class)
public abstract class FluidMixin implements AppraisalFluid{
	
	protected FluidAppraisalManager<Fluid> appraisal_appraisalManager = new FluidAppraisalManager<>((Fluid)(Object)this);
	
	@Override
	public FluidAppraisalManager<Fluid> getAppraisalManager(){
		return this.appraisal_appraisalManager;
	}
}

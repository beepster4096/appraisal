package drmeepster.appraisal.quack;

import drmeepster.appraisal.manager.FluidAppraisalManager;

/**
 * Mixin interface for <code>FluidMixin</code>.
 */
public interface AppraisalFluid extends Appraisable{
	
	@Override
	public FluidAppraisalManager<?> getAppraisalManager();
}

package drmeepster.appraisal.quack;

import drmeepster.appraisal.Appraisable;
import drmeepster.appraisal.manager.FluidAppraisalManager;

public interface AppraisalFluid extends Appraisable{
	
	@Override
	public FluidAppraisalManager<?> getAppraisalManager();
}

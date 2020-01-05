package drmeepster.appraisal.quack;

import drmeepster.appraisal.Appraisable;
import drmeepster.appraisal.manager.BlockAppraisalManager;

public interface AppraisalBlock extends Appraisable{
	
	@Override
	public BlockAppraisalManager<?> getAppraisalManager();
}

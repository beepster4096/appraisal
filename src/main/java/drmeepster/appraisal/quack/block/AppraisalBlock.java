package drmeepster.appraisal.quack.block;

import drmeepster.appraisal.Appraisable;
import drmeepster.appraisal.manager.block.BlockAppraisalManager;

public interface AppraisalBlock extends Appraisable{
	
	@Override
	public BlockAppraisalManager<?> getAppraisalManager(); //FluidBlock
}

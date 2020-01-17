package drmeepster.appraisal.quack.block;

import drmeepster.appraisal.manager.block.BlockAppraisalManager;
import drmeepster.appraisal.quack.Appraisable;

/**
 * Mixin interface for <code>BlockMixin</code>.
 */
public interface AppraisalBlock extends Appraisable{
	
	@Override
	public BlockAppraisalManager<?> getAppraisalManager();
}

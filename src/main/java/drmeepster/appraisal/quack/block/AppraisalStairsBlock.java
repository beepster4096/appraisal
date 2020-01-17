package drmeepster.appraisal.quack.block;

import drmeepster.appraisal.manager.block.StairsBlockAppraisalManager;
import net.minecraft.block.BlockState;

/**
 * Mixin interface for <code>BlockMixin</code>.
 */
public interface AppraisalStairsBlock extends AppraisalBlock{

	@Override
	public StairsBlockAppraisalManager<?> getAppraisalManager();
	
	/**
	 * @return this <code>StairsBlock</code>'s base <code>BlockState</code>.
	 */
	public BlockState getBaseBlockState();
}

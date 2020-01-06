package drmeepster.appraisal.quack.block;

import drmeepster.appraisal.manager.block.StairsBlockAppraisalManager;
import net.minecraft.block.BlockState;

public interface AppraisalStairsBlock extends AppraisalBlock{

	@Override
	public StairsBlockAppraisalManager<?> getAppraisalManager();
	
	public BlockState getBaseBlockState();
}

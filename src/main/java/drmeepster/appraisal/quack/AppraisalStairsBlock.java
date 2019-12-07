package drmeepster.appraisal.quack;

import drmeepster.appraisal.manager.StairsBlockAppraisalManager;
import net.minecraft.block.BlockState;

public interface AppraisalStairsBlock extends AppraisalBlock{

	@Override
	public StairsBlockAppraisalManager<?> getAppraisalManager();
	
	public BlockState getBaseBlockState();
}

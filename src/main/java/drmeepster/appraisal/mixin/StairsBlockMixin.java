package drmeepster.appraisal.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import drmeepster.appraisal.manager.block.StairsBlockAppraisalManager;
import drmeepster.appraisal.quack.block.AppraisalStairsBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

/**
 * Mixin for <code>StairsBlock</code>.
 */
@Mixin(StairsBlock.class)
public abstract class StairsBlockMixin extends Block implements AppraisalStairsBlock{

	protected StairsBlockAppraisalManager<StairsBlock> appraisal_appraisalManager = new StairsBlockAppraisalManager<>(
		(StairsBlock) (Object) this);

	@Shadow
	private BlockState baseBlockState;

	private StairsBlockMixin(Settings settings){
		super(settings);
	}

	@Override
	public BlockState getBaseBlockState(){
		return this.baseBlockState;
	}

	@Override
	public StairsBlockAppraisalManager<?> getAppraisalManager(){
		return this.appraisal_appraisalManager;
	}
}

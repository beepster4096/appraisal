package drmeepster.appraisal.mixin;

import org.spongepowered.asm.mixin.Mixin;

import drmeepster.appraisal.manager.block.BlockAppraisalManager;
import drmeepster.appraisal.quack.block.AppraisalBlock;
import net.minecraft.block.Block;

@Mixin(Block.class)
public abstract class BlockMixin implements AppraisalBlock{ //BedrockBlock
	
	protected BlockAppraisalManager<Block> appraisal_appraisalManager = new BlockAppraisalManager<>((Block)(Object)this);
	
	@Override
	public BlockAppraisalManager<Block> getAppraisalManager(){
		return this.appraisal_appraisalManager;
	}
}

package drmeepster.appraisal.mixin.block;

import org.spongepowered.asm.mixin.Mixin;

import drmeepster.appraisal.manager.block.InfestedBlockAppraisalManager;
import drmeepster.appraisal.quack.block.AppraisalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.InfestedBlock;

@Mixin(InfestedBlock.class)
public abstract class InfestedBlockMixin extends Block implements AppraisalBlock{

	protected InfestedBlockAppraisalManager<InfestedBlock> appraisal_appraisalManager = new InfestedBlockAppraisalManager<>((InfestedBlock)(Object)this);
	
	private InfestedBlockMixin(Settings block$Settings_1){
		super(block$Settings_1);
	}
	
	@Override
	public InfestedBlockAppraisalManager<InfestedBlock> getAppraisalManager(){
		return this.appraisal_appraisalManager;
	}
}


package drmeepster.appraisal.mixin;

import org.spongepowered.asm.mixin.Mixin;

import drmeepster.appraisal.manager.item.BlockItemAppraisalManager;
import drmeepster.appraisal.quack.item.AppraisalItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

@Mixin(BlockItem.class)
public abstract class BlockItemMixin extends Item implements AppraisalItem{
	
	private BlockItemMixin(Settings settings){
		super(settings);
	}

	protected BlockItemAppraisalManager<BlockItem> appraisal_appraisalManager = new BlockItemAppraisalManager<>((BlockItem)(Object)this);
	
	@Override
	public BlockItemAppraisalManager<BlockItem> getAppraisalManager(){
		return this.appraisal_appraisalManager;
	}
}

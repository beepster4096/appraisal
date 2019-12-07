package drmeepster.appraisal.context;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;

public class ItemAppraisalContext implements AppraisalContext{

	protected boolean advanced;
	protected ItemStack stack;
	
	public ItemAppraisalContext(boolean advanced, ItemStack stack){
		this.advanced = advanced;
		this.stack = stack;
	}
	
	@Override
	public boolean isAdvanced(){
		return this.advanced;
	}
	
	public ItemStack getStack(){
		return this.stack;
	}
	
	public static ItemAppraisalContext of(TooltipContext tooltip, ItemStack stack){
		return new ItemAppraisalContext(tooltip.isAdvanced(), stack);
	}
}

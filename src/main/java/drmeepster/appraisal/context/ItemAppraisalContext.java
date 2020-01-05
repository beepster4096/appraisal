package drmeepster.appraisal.context;

import drmeepster.appraisal.context.BlockAppraisalContext.Builder;
import drmeepster.appraisal.manager.AppraisalManager;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemAppraisalContext extends AbstractApprasialContext{

	protected boolean advanced;
	protected ItemStack stack;
	
	public ItemAppraisalContext(boolean advanced, ItemStack stack, Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base){
		super(base);
		
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
		return new ItemAppraisalContext(tooltip.isAdvanced(), stack, null);
	}
	
	public static class Builder{
		
		public boolean advanced = false;
		public ItemStack stack = ItemStack.EMPTY;

		public Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base = AppraisalContext.EMPTY_PAIR;
		
		public Builder(){}
		
		public Builder(ItemAppraisalContext context){
			this.advanced = context.advanced;
			this.stack = context.stack;
			this.base = context.base;
		}
		
		public ItemAppraisalContext build(){
			return new ItemAppraisalContext(this.advanced, this.stack, this.base);
		}
		
		public Builder setAdvanced(boolean advanced){
			this.advanced = advanced;
			
			return this;
		}
		
		public Builder setAdvanced(){
			this.setAdvanced(true);
			
			return this;
		}
		
		public Builder setStack(ItemStack stack){
			this.stack = stack;
			
			return this;
		}
		
		public Builder setBase(Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base){
			this.base = base;
			
			return this;
		}
	}
}

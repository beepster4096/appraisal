package drmeepster.appraisal.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import drmeepster.appraisal.context.ItemAppraisalContext;
import drmeepster.appraisal.manager.item.ItemAppraisalManager;
import drmeepster.appraisal.quack.item.AppraisalItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

@Mixin(Item.class)
public abstract class ItemMixin implements AppraisalItem{

	protected ItemAppraisalManager<Item> appraisal_appraisalManager = new ItemAppraisalManager<>((Item)(Object)this);
	
	@Inject(method = "appendTooltip", at = { @At("HEAD") })
	private void onAppendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context,
		CallbackInfo callback){
		
		tooltip.addAll(this.getAppraisalManager().getAppraisal(ItemAppraisalContext.of(context, stack)));
	}
	
	@Override
	public ItemAppraisalManager<Item> getAppraisalManager(){
		return this.appraisal_appraisalManager;
	}
}


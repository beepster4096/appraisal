package drmeepster.appraisal.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;

import drmeepster.appraisal.interfaces.AppraisalItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

@Mixin(Item.class)
public abstract class ItemMixin implements AppraisalItem{

	@Override
	public Text getAppraisal(ItemStack stack, World world, List<Text> tooltip, TooltipContext context){
		return null;
	}
}

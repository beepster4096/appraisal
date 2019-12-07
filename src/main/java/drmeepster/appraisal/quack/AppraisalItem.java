package drmeepster.appraisal.lib;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public interface AppraisalItem{

	public List<Text> getAppraisal(ItemStack stack, World world, List<Text> tooltip, TooltipContext context);

	public String getAppraisalTranslationKey(ItemStack stack);
	
	public void setAppraisalTranslationKey(String newKey);
	
	public Style getAppraisalStyle();

	public void setAppraisalStyle(Style appraisalStyle);
}

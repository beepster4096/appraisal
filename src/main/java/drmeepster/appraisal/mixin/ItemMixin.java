package drmeepster.appraisal.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import drmeepster.appraisal.lib.AppraisalItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Language;
import net.minecraft.util.SystemUtil;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

@Mixin(Item.class)
public abstract class ItemMixin implements AppraisalItem{

	// Might as well be explicitly private, its in a Mixin Items
	private String appraisalTranslationKey = null;
	private Style appraisalStyle = new Style().setColor(Formatting.YELLOW);

	@Inject(method = "appendTooltip", at = { @At("HEAD") })
	private void onAppendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context,
		CallbackInfo callback){

		Text appraisal = getAppraisal(stack, world, tooltip, context);
		
		if(appraisal != null){
			tooltip.add(appraisal);
		}
	}

	@Override
	public Text getAppraisal(ItemStack stack, World world, List<Text> tooltip, TooltipContext context){
		String key = this.getAppraisalTranslationKey(stack);
		
		if(Language.getInstance().hasTranslation(key)){
			return new TranslatableText(key).setStyle(this.getAppraisalStyle());
		}else{
			return null;
		}
	}

	@Override
	public String getAppraisalTranslationKey(ItemStack stack){
		if(this.appraisalTranslationKey == null){
			// Class#cast used to avoid compile error
			this.appraisalTranslationKey = SystemUtil.createTranslationKey("appraisal",
				Registry.ITEM.getId(Item.class.cast(this)));
		}

		return appraisalTranslationKey;
	}

	@Override
	public void setAppraisalTranslationKey(String newKey){
		appraisalTranslationKey = newKey;
	}

	@Override
	public Style getAppraisalStyle(){
		return appraisalStyle;
	}

	@Override
	public void setAppraisalStyle(Style appraisalStyle){
		this.appraisalStyle = appraisalStyle;
	}
}

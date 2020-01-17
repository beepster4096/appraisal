package drmeepster.appraisal.util;

import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;

/**
 * Utility variables and classes.
 */
public class ApUtil{

	public static final String TRANSLATION_ITEM_TYPE = "appraisal.item";
	public static final String TRANSLATION_BLOCK_TYPE = "appraisal.block";
	public static final String TRANSLATION_ENTITY_TYPE = "appraisal.entity"; // Maybe
	
	public static final Style APPRAISAL_STYLE = new Style().setColor(Formatting.YELLOW);
	public static final Style NO_APPRAISAL_STYLE = new Style().setColor(Formatting.GRAY).setItalic(true);
	public static final Text NO_APPRAISAL_TEXT = new TranslatableText("appraisal.none").setStyle(NO_APPRAISAL_STYLE);

	/**
	 * Creates a translation key
	 * 
	 * @param <T> Type of object the key is for
	 * @param type Prefix for the key
	 * @param obj The object to make a key for
	 * @param registry A <code>Registry</code> containing <code>obj</code>
	 * @return A translation key for <code>obj</code>
	 */
	public static <T> String getKey(String type, T obj, Registry<T> registry){
		return Util.createTranslationKey(type, registry.getId(obj)) + ".";
	}
}

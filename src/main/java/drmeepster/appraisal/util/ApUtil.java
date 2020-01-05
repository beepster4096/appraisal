package drmeepster.appraisal.util;

import java.lang.reflect.InvocationTargetException;

import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;

public class ApUtil{

	public static final String TRANSLATION_ITEM_TYPE = "appraisal.item";
	public static final String TRANSLATION_BLOCK_TYPE = "appraisal.block";
	public static final String TRANSLATION_ENTITY_TYPE = "appraisal.entity"; // Maybe
	
	public static final Style APPRAISAL_STYLE = new Style().setColor(Formatting.YELLOW);
	public static final Style NO_APPRAISAL_STYLE = new Style().setColor(Formatting.GRAY).setItalic(true);
	public static final Text NO_APPRAISAL_TEXT = new TranslatableText("appraisal.none").setStyle(NO_APPRAISAL_STYLE);

	public static <T> String getKey(String type, T t, Registry<T> registry){ // Registry
		return Util.createTranslationKey(type, registry.getId(t)) + ".";
	}

	@SuppressWarnings("unchecked")
	public static <T, U> U callAs(T caller, Class<? super T> clazz, String name, Class<?>[] paramTypes, Object... args)
		throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
		InvocationTargetException{
		
		return (U) clazz.getMethod(name, paramTypes).invoke(caller, args);
	}
	
	public static <T, U> U callAs(T caller, Class<? super T> clazz, String name)
		throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
		InvocationTargetException{
		
		return callAs(caller, clazz, name, new Class<?>[]{});
	}
}

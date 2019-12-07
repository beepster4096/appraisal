package drmeepster.appraisal;

import java.lang.reflect.InvocationTargetException;

import net.minecraft.util.SystemUtil;
import net.minecraft.util.registry.Registry;

public class ApUtil{

	public static final String TRANSLATION_ITEM_TYPE = "appraisal.item";
	public static final String TRANSLATION_BLOCK_TYPE = "appraisal.block";
	public static final String TRANSLATION_ENTITY_TYPE = "appraisal.entity"; // Maybe

	public static <T> String getKey(String type, T t, Registry<T> registry){ // Registry
		return SystemUtil.createTranslationKey(type, registry.getId(t)) + ".";
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

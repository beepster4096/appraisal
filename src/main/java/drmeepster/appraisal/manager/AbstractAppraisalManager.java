package drmeepster.appraisal.manager;

import java.util.ArrayList;
import java.util.List;

import drmeepster.appraisal.context.AppraisalContext;
import drmeepster.appraisal.util.ApUtil;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Language;
import net.minecraft.util.registry.Registry;

/**
 * Implementation of <code>AppraisalManager</code>.
 *
 * @param <T> class of the owning object
 * @param <C> <code>AppraisalContext</code> type needed for appraisal
 */
public abstract class AbstractAppraisalManager<T, C extends AppraisalContext> implements AppraisalManager<T, C>{
	
	/**
	 * Construct an <code>AbstractAppraisalManager</code>
	 * 
	 * @param obj the owning object
	 * @param registry a <code>Registry</code> containing <code>obj</code>
	 * @param keyType a prefix for the appraisal translation key
	 */
	public AbstractAppraisalManager(T obj, Registry<? super T> registry, String keyType){
		this.object = obj;
		this.registry = registry;
		
		this.keyType = keyType;
	}
	
	protected final T object;
	protected final Registry<? super T> registry;
	
	protected final String keyType;
	
	protected Style appraisalStyle = ApUtil.APPRAISAL_STYLE;
	
	protected Text noAppraisalText = ApUtil.NO_APPRAISAL_TEXT;
	
	protected List<String> keys = null;
	
	@Override
	public T getObject(){
		return this.object;
	}
	
	@Override
	public List<Text> getAppraisal(C context){
		List<Text> out = this.getRawAppraisal(context);
		
		if(out.size() == 0 && context.isAdvanced()){
			out.add(this.noAppraisalText);
		}

		return out;
	}
	
	/**
	 * Returns the appraisal. This method, unlike {@link #getAppraisal(AppraisalContext)}
	 * will always return an empty <code>List</code> if there is no defined appraisal in the translation files.
	 * 
	 * @param context
	 * @return
	 */
	public List<Text> getRawAppraisal(C context){
		List<Text> out = new ArrayList<>();
		
		List<String> keys = this.getTranslationKeys(context);
		
		for(String key : keys){
			int i = 0;
			
			for(; Language.getInstance().hasTranslation(key + i); i++){
				out.add(new TranslatableText(key + i).setStyle(this.appraisalStyle));
			}
			
			if(i > 0){
				break;
			}
		}

		return out;
	}
	
	/**
	 * @return a <code>Registry</code> containing the owning registry
	 */
	public Registry<? super T> getRegistry(){
		return this.registry;
	}
	
	/**
	 * @param context
	 * @return the translation keys for this appraisal in priority order
	 */
	public List<String> getTranslationKeys(C context){
		if(this.keys == null){
			this.keys = this.generateKeys();
		}
		
		return new ArrayList<>(this.keys);
	}
	
	/**
	 * Generates new translation keys
	 * 
	 * @return the translation keys
	 */
	protected List<String> generateKeys(){
		ArrayList<String> out = new ArrayList<>(1);
		out.add(ApUtil.getKey(this.keyType, this.getObject(), this.getRegistry()));
		
		return out;
	}
}

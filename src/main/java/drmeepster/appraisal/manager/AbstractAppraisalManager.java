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

public abstract class AbstractAppraisalManager<T, C extends AppraisalContext> implements AppraisalManager<T, C>{
	
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
	public Registry<? super T> getRegistry(){
		return this.registry;
	}
	
	@Override
	public List<Text> getAppraisal(C context){
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
		
		if(out.size() == 0 && context.isAdvanced()){
			out.add(this.noAppraisalText);
		}

		return out;
	}
	
	@Override
	public List<String> getTranslationKeys(C context){
		if(this.keys == null){
			this.keys = this.generateKeys();
		}
		
		return new ArrayList<>(this.keys);
	}
	
	public List<String> generateKeys(){
		ArrayList<String> out = new ArrayList<>(1);
		out.add(ApUtil.getKey(this.keyType, this.getObject(), this.getRegistry()));
		
		return out;
	}
}

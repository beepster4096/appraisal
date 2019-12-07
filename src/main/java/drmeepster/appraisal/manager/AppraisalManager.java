package drmeepster.appraisal.manager;

import java.util.List;

import drmeepster.appraisal.context.AppraisalContext;
import net.minecraft.text.Text;
import net.minecraft.util.registry.Registry;

public interface AppraisalManager<T, C extends AppraisalContext> {

	public T getObject();
	
	public Registry<? super T> getRegistry();
	
	public List<Text> getAppraisal(C context);
	
	public List<String> getTranslationKeys(C context);
}

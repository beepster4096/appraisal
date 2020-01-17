package drmeepster.appraisal.manager;

import java.util.List;

import drmeepster.appraisal.context.AppraisalContext;
import net.minecraft.text.Text;

/**
 * Manages the owning object's appraisal.
 *
 * @param <T> class of the owning object
 * @param <C> <code>AppraisalContext</code> type needed for appraisal
 */
public interface AppraisalManager<T, C extends AppraisalContext> {

	/**
	 * @return the owning object
	 */
	public T getObject();
	
	/**
	 * Creates an appraisal.
	 * 
	 * @param context the <code>AppraisalContext</code> to generate the appraisal with
	 * @return an appraisal for the owning object
	 */
	public List<Text> getAppraisal(C context);
}

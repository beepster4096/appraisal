package drmeepster.appraisal.quack;

import drmeepster.appraisal.manager.AppraisalManager;

/**
 * Represents an object that has an <code>AppraisalManager</code>.
 */
public interface Appraisable{

	/**
	 * @return this object's <code>AppraisalManager</code>.
	 */
	public AppraisalManager<?, ?> getAppraisalManager();
}

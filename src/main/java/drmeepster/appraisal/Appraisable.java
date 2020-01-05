package drmeepster.appraisal;

import drmeepster.appraisal.manager.AppraisalManager;

public interface Appraisable{

	public AppraisalManager<?, ?> getAppraisalManager();
}

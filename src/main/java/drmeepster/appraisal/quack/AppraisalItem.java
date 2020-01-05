package drmeepster.appraisal.quack;

import drmeepster.appraisal.Appraisable;
import drmeepster.appraisal.manager.ItemAppraisalManager;

public interface AppraisalItem extends Appraisable{

	@Override
	public ItemAppraisalManager<?> getAppraisalManager();
}

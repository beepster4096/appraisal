package drmeepster.appraisal.quack.item;

import drmeepster.appraisal.Appraisable;
import drmeepster.appraisal.manager.item.ItemAppraisalManager;

public interface AppraisalItem extends Appraisable{

	@Override
	public ItemAppraisalManager<?> getAppraisalManager();
}

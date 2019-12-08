package drmeepster.appraisal.manager;

import java.util.List;

import drmeepster.appraisal.context.FluidAppraisalContext;
import drmeepster.appraisal.context.ItemAppraisalContext;
import drmeepster.appraisal.quack.AppraisalBucketItem;
import drmeepster.appraisal.quack.AppraisalFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.text.Text;

public class BucketItemAppraisalManager<T extends BucketItem> extends ItemAppraisalManager<T>{

	public BucketItemAppraisalManager(T item){
		super(item);
	}

	@Override
	public List<Text> getAppraisal(ItemAppraisalContext context){
		return ((AppraisalFluid) ((AppraisalBucketItem) this.getObject()).getFluid()).getAppraisalManager()
			.getAppraisal(FluidAppraisalContext.of(this, context));
	}
}

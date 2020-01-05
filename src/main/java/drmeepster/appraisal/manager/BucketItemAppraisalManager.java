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
	public List<Text> getRawAppraisal(ItemAppraisalContext context){
		List<Text> out = super.getRawAppraisal(context);
		
		if(out.size() == 0){
			out = ((AppraisalFluid) ((AppraisalBucketItem) this.getObject()).getFluid()).getAppraisalManager()
				.getRawAppraisal(FluidAppraisalContext.of(this, context));
		}
		
		return out;
	}
}

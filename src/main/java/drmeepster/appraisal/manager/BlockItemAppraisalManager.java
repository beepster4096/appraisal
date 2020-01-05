package drmeepster.appraisal.manager;

import java.util.List;

import drmeepster.appraisal.context.BlockAppraisalContext;
import drmeepster.appraisal.context.ItemAppraisalContext;
import drmeepster.appraisal.quack.AppraisalBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.text.Text;

public class BlockItemAppraisalManager<T extends BlockItem> extends ItemAppraisalManager<T>{

	public BlockItemAppraisalManager(T item){
		super(item);
	}

	@Override
	public List<Text> getRawAppraisal(ItemAppraisalContext context){
		List<Text> out = super.getRawAppraisal(context);

		if(out.size() == 0){
			out = ((AppraisalBlock) this.getObject().getBlock()).getAppraisalManager()
				.getRawAppraisal(BlockAppraisalContext.of(this, context));
		}

		return out;
	}
}

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
	public List<Text> getAppraisal(ItemAppraisalContext context){
		return ((AppraisalBlock) this.getObject().getBlock()).getAppraisalManager()
			.getAppraisal(BlockAppraisalContext.of(this, context));
	}
}

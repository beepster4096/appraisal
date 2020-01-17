package drmeepster.appraisal.manager.block;

import java.util.List;

import drmeepster.appraisal.context.BlockAppraisalContext;
import drmeepster.appraisal.quack.block.AppraisalBlock;
import drmeepster.appraisal.quack.block.AppraisalStairsBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.text.Text;

/**
 * The <code>AppraisalManager</code> for <code>StairsBlock</code>.
 *
 * @param <T> class of the owning object
 */
public class StairsBlockAppraisalManager<T extends StairsBlock> extends BlockAppraisalManager<T>{

	public StairsBlockAppraisalManager(T block){
		super(block);
	}

	@Override
	public List<Text> getRawAppraisal(BlockAppraisalContext context){
		List<Text> out = super.getRawAppraisal(context);

		if(out.size() == 0){
			out = ((AppraisalBlock) ((AppraisalStairsBlock) this.getObject()).getBaseBlockState().getBlock()).getAppraisalManager()
				.getRawAppraisal(context);
		}

		return out;
	}
}

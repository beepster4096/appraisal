package drmeepster.appraisal.manager;

import java.util.List;

import drmeepster.appraisal.context.BlockAppraisalContext;
import drmeepster.appraisal.quack.AppraisalBlock;
import drmeepster.appraisal.quack.AppraisalStairsBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.text.Text;

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

package drmeepster.appraisal.manager.block;

import java.util.List;

import drmeepster.appraisal.context.BlockAppraisalContext;
import drmeepster.appraisal.quack.block.AppraisalBlock;
import net.minecraft.block.InfestedBlock;
import net.minecraft.text.Text;

public class InfestedBlockAppraisalManager<T extends InfestedBlock> extends BlockAppraisalManager<T>{

	public InfestedBlockAppraisalManager(T block){
		super(block);
	}
	
	@Override
	public List<Text> getRawAppraisal(BlockAppraisalContext context){
		List<Text> out = super.getRawAppraisal(context);

		if(out.size() == 0){
			out = ((AppraisalBlock) this.getObject().getRegularBlock()).getAppraisalManager()
				.getRawAppraisal(context);
		}

		return out;
	}
}

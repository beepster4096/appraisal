package drmeepster.appraisal.manager;

import java.util.List;

import drmeepster.appraisal.context.BlockAppraisalContext;
import drmeepster.appraisal.quack.AppraisalBlock;
import drmeepster.appraisal.quack.AppraisalStairsBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class StairsBlockAppraisalManager<T extends StairsBlock> extends BlockAppraisalManager<T>{

	public StairsBlockAppraisalManager(T block){
		super(block);
	}

	@Override
	public List<String> getTranslationKeys(BlockAppraisalContext context){
		List<String> out = super.getTranslationKeys(context);

		BlockState state = ((AppraisalStairsBlock) this.getObject()).getBaseBlockState();

		out.addAll(((AppraisalBlock) state.getBlock()).getAppraisalManager()
			.getTranslationKeys(new BlockAppraisalContext.Builder(context).setState(state).build()));
		return out;
	}
}

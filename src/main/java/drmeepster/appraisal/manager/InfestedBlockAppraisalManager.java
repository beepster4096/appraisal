package drmeepster.appraisal.manager;

import java.util.List;

import drmeepster.appraisal.context.BlockAppraisalContext;
import drmeepster.appraisal.quack.AppraisalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.InfestedBlock;

public class InfestedBlockAppraisalManager<T extends InfestedBlock> extends BlockAppraisalManager<T>{

	public InfestedBlockAppraisalManager(T block){
		super(block);
	}

	@Override
	public List<String> getTranslationKeys(BlockAppraisalContext context){
		List<String> out = super.getTranslationKeys(context);

		Block base = this.getObject().getRegularBlock();

		out.addAll(((AppraisalBlock) base).getAppraisalManager()
			.getTranslationKeys(new BlockAppraisalContext.Builder(context).setState(base.getDefaultState()).build()));
		return out;
	}
}

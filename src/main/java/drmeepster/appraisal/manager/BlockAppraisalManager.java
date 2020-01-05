package drmeepster.appraisal.manager;

import drmeepster.appraisal.context.BlockAppraisalContext;
import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;

public class BlockAppraisalManager<T extends Block>
	extends AbstractAppraisalManager<T, BlockAppraisalContext>{

	public static final String KEY_TYPE = "appraisal.block";

	public BlockAppraisalManager(T block){
		super(block, Registry.BLOCK, KEY_TYPE);
	}
}
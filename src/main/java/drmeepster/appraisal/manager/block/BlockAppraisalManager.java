package drmeepster.appraisal.manager.block;

import drmeepster.appraisal.context.BlockAppraisalContext;
import drmeepster.appraisal.manager.AbstractAppraisalManager;
import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;

/**
 * The <code>AppraisalManager</code> for <code>Block</code>.
 *
 * @param <T> class of the owning object
 */
public class BlockAppraisalManager<T extends Block>
	extends AbstractAppraisalManager<T, BlockAppraisalContext>{

	public static final String KEY_TYPE = "appraisal.block";

	public BlockAppraisalManager(T block){
		super(block, Registry.BLOCK, KEY_TYPE);
	}
}
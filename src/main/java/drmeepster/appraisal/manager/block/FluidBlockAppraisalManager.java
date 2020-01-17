package drmeepster.appraisal.manager.block;

import java.util.List;

import drmeepster.appraisal.context.BlockAppraisalContext;
import drmeepster.appraisal.context.FluidAppraisalContext;
import drmeepster.appraisal.quack.AppraisalFluid;
import drmeepster.appraisal.quack.block.AppraisalFluidBlock;
import net.minecraft.block.FluidBlock;
import net.minecraft.text.Text;

/**
 * The <code>AppraisalManager</code> for <code>FluidBlock</code>.
 *
 * @param <T> class of the owning object
 */
public class FluidBlockAppraisalManager<T extends FluidBlock> extends BlockAppraisalManager<T>{

	public FluidBlockAppraisalManager(T block){
		super(block);
	}
	
	@Override
	public List<Text> getRawAppraisal(BlockAppraisalContext context){
		List<Text> out = super.getRawAppraisal(context);
		
		if(out.size() == 0){
			out = ((AppraisalFluid) ((AppraisalFluidBlock) this.getObject()).getFluid()).getAppraisalManager()
				.getRawAppraisal(FluidAppraisalContext.of(this, context));
		}
		
		return out;
	}
}

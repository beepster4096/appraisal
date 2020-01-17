package drmeepster.appraisal.manager;

import drmeepster.appraisal.context.FluidAppraisalContext;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.registry.Registry;

/**
 * The <code>AppraisalManager</code> for <code>Fluid</code>.
 *
 * @param <T> class of the owning object
 */
public class FluidAppraisalManager<T extends Fluid> extends AbstractAppraisalManager<T, FluidAppraisalContext>{

	public static final String KEY_TYPE = "appraisal.fluid";

	public FluidAppraisalManager(T block){
		super(block, Registry.FLUID, KEY_TYPE);
	}
}
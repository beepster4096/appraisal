package drmeepster.appraisal.context;

import drmeepster.appraisal.manager.AppraisalManager;
import net.minecraft.util.Pair;

public abstract class AbstractApprasialContext implements AppraisalContext{

	protected Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base;
	
	public AbstractApprasialContext(Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base){
		this.base = base != null ? base : AppraisalContext.EMPTY_PAIR;
	}
	
	@Override
	public Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> getBase(){
		return this.base;
	}
}

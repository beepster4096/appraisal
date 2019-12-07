package drmeepster.appraisal.context;

import drmeepster.appraisal.manager.AppraisalManager;
import net.minecraft.util.Pair;

public interface AppraisalContext{

	public static final Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> EMPTY_PAIR = new Pair<>(null, null);
	
	public boolean isAdvanced();
	
	public default Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> getBase(){
		return EMPTY_PAIR;
	}
}

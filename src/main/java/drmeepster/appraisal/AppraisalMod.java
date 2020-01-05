package drmeepster.appraisal;

import drmeepster.appraisal.command.AppraisalCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CommandRegistry;

public class AppraisalMod implements ModInitializer{

	@Override
	public void onInitialize(){
		CommandRegistry.INSTANCE.register(false, AppraisalCommand::register);
	}

}

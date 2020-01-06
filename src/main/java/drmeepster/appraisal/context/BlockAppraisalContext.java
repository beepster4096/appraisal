package drmeepster.appraisal.context;

import drmeepster.appraisal.manager.AppraisalManager;
import drmeepster.appraisal.manager.item.BlockItemAppraisalManager;
import net.minecraft.block.BlockState;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockAppraisalContext extends AbstractApprasialContext{

	protected boolean advanced;
	protected BlockState state;

	protected World world;
	protected BlockPos pos;

	public BlockAppraisalContext(boolean advanced, BlockState state, World world, BlockPos pos,
		Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base){
		super(base);
		
		this.advanced = advanced;
		this.state = state;
		this.world = world;
		this.pos = pos;
	}

	public static BlockAppraisalContext of(BlockItemAppraisalManager<?> manager, ItemAppraisalContext context){
		return new BlockAppraisalContext(context.isAdvanced(), manager.getObject().getBlock().getDefaultState(), null,
			null, new Pair<>(manager, context));
	}

	@Override
	public boolean isAdvanced(){
		return this.advanced;
	}
	
	public BlockState getState(){
		return this.state;
	}
	
	public World getWorld(){
		return this.world;
	}
	
	public BlockPos getPos(){
		return this.pos;
	}
	
	public static class Builder{
		
		public boolean advanced = false;
		public BlockState state = null;

		public World world = null;
		public BlockPos pos = null;

		public Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base = AppraisalContext.EMPTY_PAIR;
		
		public Builder(){}
		
		public Builder(BlockAppraisalContext context){
			this.advanced = context.advanced;
			this.state = context.state;
			this.world = context.world;
			this.pos = context.pos;
			this.base = context.base;
		}
		
		public BlockAppraisalContext build(){
			return new BlockAppraisalContext(this.advanced, this.state, this.world, this.pos, this.base);
		}
		
		public Builder setAdvanced(boolean advanced){
			this.advanced = advanced;
			
			return this;
		}
		
		public Builder setAdvanced(){
			this.setAdvanced(true);
			
			return this;
		}
		
		public Builder setState(BlockState state){
			this.state = state;
			
			return this;
		}
		
		public Builder setWorld(World world){
			this.world = world;
			
			return this;
		}
		
		public Builder setPos(BlockPos pos){
			this.pos = pos;
			
			return this;
		}
		
		public Builder setBase(Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base){
			this.base = base;
			
			return this;
		}
	}

}

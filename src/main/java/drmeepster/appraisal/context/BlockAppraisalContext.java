package drmeepster.appraisal.context;

import drmeepster.appraisal.manager.AppraisalManager;
import drmeepster.appraisal.manager.BlockItemAppraisalManager;
import net.minecraft.block.BlockState;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockAppraisalContext implements AppraisalContext{

	protected boolean advanced;
	protected BlockState state;

	protected World world;
	protected BlockPos pos;

	protected Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base;

	public BlockAppraisalContext(boolean advanced, BlockState state, World world, BlockPos pos,
		Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base){

		this.advanced = advanced;
		this.state = state;
		this.world = world;
		this.pos = pos;
		this.base = base != null ? base : AppraisalContext.EMPTY_PAIR;
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
		return state;
	}
	
	public World getWorld(){
		return world;
	}
	
	public BlockPos getPos(){
		return pos;
	}
	
	@Override
	public Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> getBase(){
		return this.base;
	}
	
	public static class Builder{
		
		public boolean advanced;
		public BlockState state;

		public World world;
		public BlockPos pos;

		public Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base;
		
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

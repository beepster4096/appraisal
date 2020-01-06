package drmeepster.appraisal.context;

import drmeepster.appraisal.manager.AppraisalManager;
import drmeepster.appraisal.manager.block.FluidBlockAppraisalManager;
import drmeepster.appraisal.manager.item.BucketItemAppraisalManager;
import drmeepster.appraisal.quack.item.AppraisalBucketItem;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FluidAppraisalContext implements AppraisalContext{

	protected boolean advanced;
	protected FluidState state;

	protected World world;
	protected BlockPos pos;

	protected Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base;

	public FluidAppraisalContext(boolean advanced, FluidState state, World world, BlockPos pos,
		Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base){

		this.advanced = advanced;
		this.state = state;
		this.world = world;
		this.pos = pos;
		this.base = base != null ? base : AppraisalContext.EMPTY_PAIR;
	}

	public static FluidAppraisalContext of(BucketItemAppraisalManager<?> manager, ItemAppraisalContext context){
		return new FluidAppraisalContext(context.isAdvanced(),
			((AppraisalBucketItem) manager.getObject()).getFluid().getDefaultState(), null, null,
			new Pair<>(manager, context));
	}

	public static FluidAppraisalContext of(FluidBlockAppraisalManager<?> manager, BlockAppraisalContext context){
		return new FluidAppraisalContext(context.isAdvanced(),
			((AppraisalBucketItem) manager.getObject()).getFluid().getDefaultState(), context.getWorld(),
			context.getPos(), new Pair<>(manager, context));
	}

	@Override
	public boolean isAdvanced(){
		return this.advanced;
	}

	public FluidState getState(){
		return this.state;
	}

	public World getWorld(){
		return this.world;
	}

	public BlockPos getPos(){
		return this.pos;
	}

	@Override
	public Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> getBase(){
		return this.base;
	}

	public static class Builder{

		public boolean advanced;
		public FluidState state;

		public World world;
		public BlockPos pos;

		public Pair<? extends AppraisalManager<?, ?>, ? extends AppraisalContext> base;

		public Builder(){}

		public Builder(FluidAppraisalContext context){
			this.advanced = context.advanced;
			this.state = context.state;
			this.world = context.world;
			this.pos = context.pos;
			this.base = context.base;
		}

		public FluidAppraisalContext build(){
			return new FluidAppraisalContext(this.advanced, this.state, this.world, this.pos, this.base);
		}

		public Builder setAdvanced(boolean advanced){
			this.advanced = advanced;

			return this;
		}

		public Builder setAdvanced(){
			this.setAdvanced(true);

			return this;
		}

		public Builder setState(FluidState state){
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

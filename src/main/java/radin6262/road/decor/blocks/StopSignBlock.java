package radin6262.road.decor.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StopSignBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    // North-facing hitbox (matches Blockbench model)
    private static final VoxelShape SHAPE_NORTH = Shapes.or(
            // Pole
            Block.box(7.0, 0.0, 7.0, 9.0, 13.0, 9.0),
            // Sign background
            Block.box(0.0, 19.0, 7.0, 16.0, 24.0, 9.0),
            // Bottom extension
            Block.box(6.0, 13.0, 7.0, 10.0, 19.0, 9.0),
            // Top extension
            Block.box(6.0, 24.0, 7.0, 10.0, 30.0, 9.0),
            // Right corner up
            Block.box(10.0, 24.0, 7.0, 15.0, 28.0, 9.0),
            // Right corner down
            Block.box(10.0, 15.0, 7.0, 15.0, 19.0, 9.0),
            // Left corner down
            Block.box(1.0, 15.0, 7.0, 6.0, 19.0, 9.0),
            // Left corner up
            Block.box(1.0, 24.0, 7.0, 6.0, 28.0, 9.0)
    );

    // South-facing hitbox (rotated 180 degrees)
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(
            Block.box(7.0, 0.0, 7.0, 9.0, 13.0, 9.0),
            Block.box(0.0, 19.0, 7.0, 16.0, 24.0, 9.0),
            Block.box(6.0, 13.0, 7.0, 10.0, 19.0, 9.0),
            Block.box(6.0, 24.0, 7.0, 10.0, 30.0, 9.0),
            Block.box(1.0, 24.0, 7.0, 6.0, 28.0, 9.0),
            Block.box(1.0, 15.0, 7.0, 6.0, 19.0, 9.0),
            Block.box(10.0, 15.0, 7.0, 15.0, 19.0, 9.0),
            Block.box(10.0, 24.0, 7.0, 15.0, 28.0, 9.0)
    );

    // East-facing hitbox (rotated 90 degrees clockwise)
    private static final VoxelShape SHAPE_EAST = Shapes.or(
            Block.box(7.0, 0.0, 7.0, 9.0, 13.0, 9.0),
            Block.box(7.0, 19.0, 0.0, 9.0, 24.0, 16.0),
            Block.box(7.0, 13.0, 6.0, 9.0, 19.0, 10.0),
            Block.box(7.0, 24.0, 6.0, 9.0, 30.0, 10.0),
            Block.box(7.0, 24.0, 10.0, 9.0, 28.0, 15.0),
            Block.box(7.0, 15.0, 10.0, 9.0, 19.0, 15.0),
            Block.box(7.0, 15.0, 1.0, 9.0, 19.0, 6.0),
            Block.box(7.0, 24.0, 1.0, 9.0, 28.0, 6.0)
    );

    // West-facing hitbox (rotated 90 degrees counter-clockwise)
    private static final VoxelShape SHAPE_WEST = Shapes.or(
            Block.box(7.0, 0.0, 7.0, 9.0, 13.0, 9.0),
            Block.box(7.0, 19.0, 0.0, 9.0, 24.0, 16.0),
            Block.box(7.0, 13.0, 6.0, 9.0, 19.0, 10.0),
            Block.box(7.0, 24.0, 6.0, 9.0, 30.0, 10.0),
            Block.box(7.0, 24.0, 1.0, 9.0, 28.0, 6.0),
            Block.box(7.0, 15.0, 1.0, 9.0, 19.0, 6.0),
            Block.box(7.0, 15.0, 10.0, 9.0, 19.0, 15.0),
            Block.box(7.0, 24.0, 10.0, 9.0, 28.0, 15.0)
    );

    public StopSignBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return simpleCodec(StopSignBlock::new);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        return switch (facing) {
            case NORTH -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case EAST -> SHAPE_EAST;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
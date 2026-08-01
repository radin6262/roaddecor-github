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
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;

public class LowerSplitAsphaltSlopeBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    // Hitbox matching the Blockbench model (lower half, rises from north to south)
    private static final VoxelShape SHAPE_NORTH = Shapes.or(
            Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
            Block.box(0.0, 2.0, 3.0, 16.0, 4.0, 16.0),
            Block.box(0.0, 4.0, 7.0, 16.0, 6.0, 16.0),
            Block.box(0.0, 6.0, 11.0, 16.0, 8.0, 16.0),
            Block.box(0.0, 8.0, 14.0, 16.0, 10.0, 16.0)
    );

    private static final VoxelShape SHAPE_SOUTH = Shapes.or(
            Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
            Block.box(0.0, 2.0, 0.0, 16.0, 4.0, 13.0),
            Block.box(0.0, 4.0, 0.0, 16.0, 6.0, 9.0),
            Block.box(0.0, 6.0, 0.0, 16.0, 8.0, 5.0),
            Block.box(0.0, 8.0, 0.0, 16.0, 10.0, 2.0)
    );

    private static final VoxelShape SHAPE_EAST = Shapes.or(
            Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
            Block.box(0.0, 2.0, 0.0, 13.0, 4.0, 16.0),
            Block.box(0.0, 4.0, 0.0, 9.0, 6.0, 16.0),
            Block.box(0.0, 6.0, 0.0, 5.0, 8.0, 16.0),
            Block.box(0.0, 8.0, 0.0, 2.0, 10.0, 16.0)
    );

    private static final VoxelShape SHAPE_WEST = Shapes.or(
            Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
            Block.box(3.0, 2.0, 0.0, 16.0, 4.0, 16.0),
            Block.box(7.0, 4.0, 0.0, 16.0, 6.0, 16.0),
            Block.box(11.0, 6.0, 0.0, 16.0, 8.0, 16.0),
            Block.box(14.0, 8.0, 0.0, 16.0, 10.0, 16.0)
    );

    public LowerSplitAsphaltSlopeBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public static BlockBehaviour.Properties createProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_GRAY)
                .strength(1.5f)
                .requiresCorrectToolForDrops();
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return simpleCodec(LowerSplitAsphaltSlopeBlock::new);
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
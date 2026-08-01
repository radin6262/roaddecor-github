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

public class HigherSplitAsphaltSlopeBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    // Hitbox matching the Blockbench model exactly
    // Model has base from Y=0 to Y=11, then slope steps from Y=11 to Y=16
    private static final VoxelShape SHAPE_NORTH = Shapes.or(
            // Base block (matches from [0, 0, 0] to [16, 11, 16])
            Block.box(0.0, 0.0, 0.0, 16.0, 11.0, 16.0),
            // Slope step 1 (matches from [0, 11, 1] to [16, 12, 16])
            Block.box(0.0, 11.0, 1.0, 16.0, 12.0, 16.0),
            // Slope step 2 (matches from [0, 12, 3] to [16, 13, 16])
            Block.box(0.0, 12.0, 3.0, 16.0, 13.0, 16.0),
            // Slope step 3 (matches from [0, 13, 6] to [16, 14, 16])
            Block.box(0.0, 13.0, 6.0, 16.0, 14.0, 16.0),
            // Slope step 4 (matches from [0, 14, 9] to [16, 15, 16])
            Block.box(0.0, 14.0, 9.0, 16.0, 15.0, 16.0),
            // Slope step 5 (matches from [0, 15, 12] to [16, 16, 16])
            Block.box(0.0, 15.0, 12.0, 16.0, 16.0, 16.0)
    );

    private static final VoxelShape SHAPE_SOUTH = Shapes.or(
            Block.box(0.0, 0.0, 0.0, 16.0, 11.0, 16.0),
            Block.box(0.0, 11.0, 0.0, 16.0, 12.0, 15.0),
            Block.box(0.0, 12.0, 0.0, 16.0, 13.0, 13.0),
            Block.box(0.0, 13.0, 0.0, 16.0, 14.0, 10.0),
            Block.box(0.0, 14.0, 0.0, 16.0, 15.0, 7.0),
            Block.box(0.0, 15.0, 0.0, 16.0, 16.0, 4.0)
    );

    private static final VoxelShape SHAPE_EAST = Shapes.or(
            Block.box(0.0, 0.0, 0.0, 16.0, 11.0, 16.0),
            Block.box(0.0, 11.0, 0.0, 15.0, 12.0, 16.0),
            Block.box(0.0, 12.0, 0.0, 13.0, 13.0, 16.0),
            Block.box(0.0, 13.0, 0.0, 10.0, 14.0, 16.0),
            Block.box(0.0, 14.0, 0.0, 7.0, 15.0, 16.0),
            Block.box(0.0, 15.0, 0.0, 4.0, 16.0, 16.0)
    );

    private static final VoxelShape SHAPE_WEST = Shapes.or(
            Block.box(0.0, 0.0, 0.0, 16.0, 11.0, 16.0),
            Block.box(1.0, 11.0, 0.0, 16.0, 12.0, 16.0),
            Block.box(3.0, 12.0, 0.0, 16.0, 13.0, 16.0),
            Block.box(6.0, 13.0, 0.0, 16.0, 14.0, 16.0),
            Block.box(9.0, 14.0, 0.0, 16.0, 15.0, 16.0),
            Block.box(12.0, 15.0, 0.0, 16.0, 16.0, 16.0)
    );

    public HigherSplitAsphaltSlopeBlock(BlockBehaviour.Properties properties) {
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
        return simpleCodec(HigherSplitAsphaltSlopeBlock::new);
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
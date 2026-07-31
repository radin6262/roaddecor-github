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
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OneWaySignBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    // North-facing hitbox (centered)
    private static final VoxelShape SHAPE_NORTH = Shapes.or(
            // Pole
            Block.box(7.0, 0.0, 7.0, 9.0, 14.0, 9.0),
            // Main sign body
            Block.box(7.0, 14.0, 7.0, 9.0, 27.0, 9.0),
            // Right arm
            Block.box(9.0, 18.0, 7.0, 14.0, 23.0, 9.0),
            // Left arm
            Block.box(2.0, 18.0, 7.0, 7.0, 23.0, 9.0),
            // Top right corner
            Block.box(9.0, 23.0, 7.0, 12.0, 26.0, 9.0),
            // Middle right
            Block.box(9.0, 15.0, 7.0, 12.0, 18.0, 9.0),
            // Middle left
            Block.box(4.0, 15.0, 7.0, 7.0, 18.0, 9.0),
            // Top left corner
            Block.box(4.0, 23.0, 7.0, 7.0, 26.0, 9.0),
            // Arrow parts
            Block.box(7.0, 17.0, 9.0, 9.0, 23.0, 10.0),
            Block.box(7.0, 23.0, 9.0, 9.0, 25.0, 10.0),
            Block.box(6.0, 23.0, 9.0, 7.0, 24.0, 10.0),
            Block.box(9.0, 23.0, 9.0, 10.0, 24.0, 10.0),
            Block.box(10.0, 22.0, 9.0, 11.0, 23.0, 10.0),
            Block.box(11.0, 21.0, 9.0, 12.0, 22.0, 10.0),
            Block.box(5.0, 22.0, 9.0, 6.0, 23.0, 10.0),
            Block.box(4.0, 21.0, 9.0, 5.0, 22.0, 10.0)
    );

    // South-facing hitbox (rotated 180 degrees)
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(
            Block.box(7.0, 0.0, 7.0, 9.0, 14.0, 9.0),
            Block.box(7.0, 14.0, 7.0, 9.0, 27.0, 9.0),
            Block.box(2.0, 18.0, 7.0, 7.0, 23.0, 9.0),
            Block.box(9.0, 18.0, 7.0, 14.0, 23.0, 9.0),
            Block.box(4.0, 23.0, 7.0, 7.0, 26.0, 9.0),
            Block.box(4.0, 15.0, 7.0, 7.0, 18.0, 9.0),
            Block.box(9.0, 15.0, 7.0, 12.0, 18.0, 9.0),
            Block.box(9.0, 23.0, 7.0, 12.0, 26.0, 9.0),
            Block.box(7.0, 17.0, 6.0, 9.0, 23.0, 7.0),
            Block.box(7.0, 23.0, 6.0, 9.0, 25.0, 7.0),
            Block.box(9.0, 23.0, 6.0, 10.0, 24.0, 7.0),
            Block.box(6.0, 23.0, 6.0, 7.0, 24.0, 7.0),
            Block.box(5.0, 22.0, 6.0, 6.0, 23.0, 7.0),
            Block.box(4.0, 21.0, 6.0, 5.0, 22.0, 7.0),
            Block.box(10.0, 22.0, 6.0, 11.0, 23.0, 7.0),
            Block.box(11.0, 21.0, 6.0, 12.0, 22.0, 7.0)
    );

    // East-facing hitbox (rotated 90 degrees clockwise)
    private static final VoxelShape SHAPE_EAST = Shapes.or(
            Block.box(7.0, 0.0, 7.0, 9.0, 14.0, 9.0),
            Block.box(7.0, 14.0, 7.0, 9.0, 27.0, 9.0),
            Block.box(7.0, 18.0, 2.0, 9.0, 23.0, 7.0),
            Block.box(7.0, 18.0, 9.0, 9.0, 23.0, 14.0),
            Block.box(7.0, 23.0, 4.0, 9.0, 26.0, 7.0),
            Block.box(7.0, 15.0, 4.0, 9.0, 18.0, 7.0),
            Block.box(7.0, 15.0, 9.0, 9.0, 18.0, 12.0),
            Block.box(7.0, 23.0, 9.0, 9.0, 26.0, 12.0),
            Block.box(9.0, 17.0, 7.0, 10.0, 23.0, 9.0),
            Block.box(9.0, 23.0, 7.0, 10.0, 25.0, 9.0),
            Block.box(9.0, 23.0, 9.0, 10.0, 24.0, 10.0),
            Block.box(9.0, 23.0, 6.0, 10.0, 24.0, 7.0),
            Block.box(9.0, 22.0, 5.0, 10.0, 23.0, 6.0),
            Block.box(9.0, 21.0, 4.0, 10.0, 22.0, 5.0),
            Block.box(9.0, 22.0, 10.0, 10.0, 23.0, 11.0),
            Block.box(9.0, 21.0, 11.0, 10.0, 22.0, 12.0)
    );

    // West-facing hitbox (rotated 90 degrees counter-clockwise)
    private static final VoxelShape SHAPE_WEST = Shapes.or(
            Block.box(7.0, 0.0, 7.0, 9.0, 14.0, 9.0),
            Block.box(7.0, 14.0, 7.0, 9.0, 27.0, 9.0),
            Block.box(7.0, 18.0, 9.0, 9.0, 23.0, 14.0),
            Block.box(7.0, 18.0, 2.0, 9.0, 23.0, 7.0),
            Block.box(7.0, 23.0, 9.0, 9.0, 26.0, 12.0),
            Block.box(7.0, 15.0, 9.0, 9.0, 18.0, 12.0),
            Block.box(7.0, 15.0, 4.0, 9.0, 18.0, 7.0),
            Block.box(7.0, 23.0, 4.0, 9.0, 26.0, 7.0),
            Block.box(6.0, 17.0, 7.0, 7.0, 23.0, 9.0),
            Block.box(6.0, 23.0, 7.0, 7.0, 25.0, 9.0),
            Block.box(6.0, 23.0, 6.0, 7.0, 24.0, 7.0),
            Block.box(6.0, 23.0, 9.0, 7.0, 24.0, 10.0),
            Block.box(6.0, 22.0, 10.0, 7.0, 23.0, 11.0),
            Block.box(6.0, 21.0, 11.0, 7.0, 22.0, 12.0),
            Block.box(6.0, 22.0, 5.0, 7.0, 23.0, 6.0),
            Block.box(6.0, 21.0, 4.0, 7.0, 22.0, 5.0)
    );

    public OneWaySignBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public static BlockBehaviour.Properties createProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.METAL)
                .strength(2.0f)
                .noOcclusion()
                .requiresCorrectToolForDrops();
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return simpleCodec(OneWaySignBlock::new);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        return switch (facing) {
            // north and south are inverted cuz i messed up the model
            case NORTH -> SHAPE_SOUTH;
            case SOUTH -> SHAPE_NORTH;
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
package radin6262.road.decor.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;

public class TrafficConeBlock extends Block {
    // Hitbox matching the Blockbench model exactly
    private static final VoxelShape SHAPE = Shapes.or(
            // Bottom section (from [2, 0, 2] to [14, 3, 14])
            Block.box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0),
            // Middle-lower section (from [3, 3, 3] to [13, 6, 13])
            Block.box(3.0, 3.0, 3.0, 13.0, 6.0, 13.0),
            // White stripe section (from [4, 6, 4] to [12, 9, 12])
            Block.box(4.0, 6.0, 4.0, 12.0, 9.0, 12.0),
            // Upper section (from [5, 9, 5] to [11, 13, 11])
            Block.box(5.0, 9.0, 5.0, 11.0, 13.0, 11.0),
            // Top section (from [6, 13, 6] to [10, 16, 10])
            Block.box(6.0, 13.0, 6.0, 10.0, 16.0, 10.0)
    );

    public TrafficConeBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public static BlockBehaviour.Properties createProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_ORANGE)
                .strength(1.0f)
                .noOcclusion()
                .requiresCorrectToolForDrops();
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return simpleCodec(TrafficConeBlock::new);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
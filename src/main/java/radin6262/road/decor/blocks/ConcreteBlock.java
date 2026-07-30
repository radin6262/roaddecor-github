package radin6262.road.decor.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class ConcreteBlock extends Block {
    public ConcreteBlock() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .strength(2.0f)
                .requiresCorrectToolForDrops());
    }
}
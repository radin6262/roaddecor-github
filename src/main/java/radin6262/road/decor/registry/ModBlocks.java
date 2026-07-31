package radin6262.road.decor.registry;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import radin6262.road.decor.RoadDecor;
import radin6262.road.decor.blocks.*;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(RoadDecor.MODID);

    public static final DeferredBlock<AsphaltBlock> ASPHALT =
            BLOCKS.register("asphalt", () -> new AsphaltBlock(AsphaltBlock.createProperties()));

    public static final DeferredBlock<ConcreteBlock> CONCRETE =
            BLOCKS.register("concrete", ConcreteBlock::new);

    public static final DeferredBlock<PaintedAsphaltBlock> PAINTED_ASPHALT =
            BLOCKS.register("painted_asphalt", () -> new PaintedAsphaltBlock(PaintedAsphaltBlock.createProperties()));

    // Fixed: Use lambda with properties
    public static final DeferredBlock<StopSignBlock> STOP_SIGN =
            BLOCKS.register("stop_sign",
                    () -> new StopSignBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.METAL)
                            .strength(2.0f)
                            .noOcclusion()));

    public static final DeferredBlock<RoadBarrierBlock> ROAD_BARRIER =
            BLOCKS.register("road_barrier",
                    () -> new RoadBarrierBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0f)
                            .noOcclusion()
                            .requiresCorrectToolForDrops()));

    public static final DeferredBlock<OneWaySignBlock> ONE_WAY_SIGN =
            BLOCKS.register("one_way_sign", () -> new OneWaySignBlock(OneWaySignBlock.createProperties()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
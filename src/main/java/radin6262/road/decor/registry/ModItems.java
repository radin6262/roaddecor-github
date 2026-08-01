package radin6262.road.decor.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import radin6262.road.decor.RoadDecor;
import radin6262.road.decor.items.*;
import radin6262.road.decor.registry.ModBlocks;
public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(RoadDecor.MODID);

    public static final DeferredItem<AsphaltItem> ASPHALT =
            ITEMS.register("asphalt", () -> new AsphaltItem(ModBlocks.ASPHALT.get()));

    public static final DeferredItem<ConcreteItem> CONCRETE =
            ITEMS.register("concrete", () -> new ConcreteItem(ModBlocks.CONCRETE.get()));

    public static final DeferredItem<PaintedAsphaltItem> PAINTED_ASPHALT =
            ITEMS.register("painted_asphalt", () -> new PaintedAsphaltItem(ModBlocks.PAINTED_ASPHALT.get()));

    public static final DeferredItem<StopSignItem> STOP_SIGN =
            ITEMS.register("stop_sign", () -> new StopSignItem(ModBlocks.STOP_SIGN.get()));

    public static final DeferredItem<RoadBarrierItem> ROAD_BARRIER =
            ITEMS.register("road_barrier", () -> new RoadBarrierItem(ModBlocks.ROAD_BARRIER.get()));

    // Paint Roller - can have durability
    public static final DeferredItem<PaintRollerItem> PAINT_ROLLER =
            ITEMS.register("paint_roller", () -> new PaintRollerItem(new Item.Properties()
                    .durability(64) // Can be used 64 times
                    .stacksTo(1)));

    public static final DeferredItem<OneWaySignItem> ONE_WAY_SIGN =
            ITEMS.register("one_way_sign", () -> new OneWaySignItem(ModBlocks.ONE_WAY_SIGN.get()));

    public static final DeferredItem<BlockItem> ASPHALT_SLOPE =
            ITEMS.register("asphalt_slope", () -> new BlockItem(ModBlocks.ASPHALT_SLOPE.get(), new Item.Properties()));

    public static final DeferredItem<TrafficConeItem> TRAFFIC_CONE =
            ITEMS.register("traffic_cone", () -> new TrafficConeItem(ModBlocks.TRAFFIC_CONE.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
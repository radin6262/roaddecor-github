package radin6262.road.decor.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import radin6262.road.decor.RoadDecor;

public class ModTags {
    public static class Blocks {
        // Custom tags for your mod's internal use
        public static final TagKey<Block> ROAD_DECOR_BLOCKS =
                TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(RoadDecor.MODID, "road_decor_blocks"));

        public static final TagKey<Block> ASPHALT_BLOCKS =
                TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(RoadDecor.MODID, "asphalt_blocks"));
    }
}
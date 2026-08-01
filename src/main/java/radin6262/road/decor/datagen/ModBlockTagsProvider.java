package radin6262.road.decor.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import radin6262.road.decor.RoadDecor;
import radin6262.road.decor.registry.ModBlocks;
import radin6262.road.decor.tags.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RoadDecor.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        // Minecraft namespace - for vanilla tools
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.ASPHALT.get(),
                        ModBlocks.CONCRETE.get(),
                        ModBlocks.PAINTED_ASPHALT.get(),
                        ModBlocks.STOP_SIGN.get(),
                        ModBlocks.ROAD_BARRIER.get(),
                        ModBlocks.ONE_WAY_SIGN.get(),
                        ModBlocks.ASPHALT_SLOPE.get(),
                        ModBlocks.TRAFFIC_CONE.get()
                );

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(
                        ModBlocks.ASPHALT.get(),
                        ModBlocks.CONCRETE.get(),
                        ModBlocks.PAINTED_ASPHALT.get(),
                        ModBlocks.STOP_SIGN.get(),
                        ModBlocks.ROAD_BARRIER.get(),
                        ModBlocks.ONE_WAY_SIGN.get(),
                        ModBlocks.ASPHALT_SLOPE.get(),
                        ModBlocks.TRAFFIC_CONE.get()
                );

        // Custom tags for your mod only - in your mod's namespace
        tag(ModTags.Blocks.ROAD_DECOR_BLOCKS)
                .add(
                        ModBlocks.ASPHALT.get(),
                        ModBlocks.CONCRETE.get(),
                        ModBlocks.PAINTED_ASPHALT.get(),
                        ModBlocks.STOP_SIGN.get(),
                        ModBlocks.ROAD_BARRIER.get(),
                        ModBlocks.ONE_WAY_SIGN.get(),
                        ModBlocks.ASPHALT_SLOPE.get(),
                        ModBlocks.TRAFFIC_CONE.get()
                );

        tag(ModTags.Blocks.ASPHALT_BLOCKS)
                .add(
                        ModBlocks.ASPHALT.get(),
                        ModBlocks.PAINTED_ASPHALT.get(),
                        ModBlocks.ASPHALT_SLOPE.get()
                );
    }
}
package radin6262.road.decor.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import radin6262.road.decor.registry.ModBlocks;

import java.util.List;
import java.util.Set;

public class ModBlockLootSubProvider extends BlockLootSubProvider {
    public ModBlockLootSubProvider(HolderLookup.Provider lookupProvider) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        // Return a list directly - it's already an Iterable
        return List.of(
                ModBlocks.ASPHALT.get(),
                ModBlocks.CONCRETE.get(),
                ModBlocks.PAINTED_ASPHALT.get(),
                ModBlocks.STOP_SIGN.get(),
                ModBlocks.ROAD_BARRIER.get(),
                ModBlocks.ONE_WAY_SIGN.get()
        );
    }

    @Override
    protected void generate() {
        // Drop self for all blocks
        dropSelf(ModBlocks.ASPHALT.get());
        dropSelf(ModBlocks.CONCRETE.get());
        dropSelf(ModBlocks.PAINTED_ASPHALT.get());
        dropSelf(ModBlocks.STOP_SIGN.get());
        dropSelf(ModBlocks.ROAD_BARRIER.get());
        dropSelf(ModBlocks.ONE_WAY_SIGN.get());
    }
}
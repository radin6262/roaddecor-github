package radin6262.road.decor;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import radin6262.road.decor.datagen.ModBlockTagsProvider;
import radin6262.road.decor.datagen.ModLootTableProvider;
import radin6262.road.decor.datagen.ModRecipeProvider;
import radin6262.road.decor.registry.ModBlocks;
import radin6262.road.decor.registry.ModItems;

@Mod(RoadDecor.MODID)
public class RoadDecor {
    public static final String MODID = "roaddecor";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ROAD_DECOR_TAB =
            CREATIVE_MODE_TABS.register("road_decor_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + MODID + ".road_decor_tab"))
                    .icon(() -> new ItemStack(ModItems.ASPHALT.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.ASPHALT.get());
                        output.accept(ModItems.CONCRETE.get());
                        output.accept(ModItems.PAINTED_ASPHALT.get());
                        output.accept(ModItems.STOP_SIGN.get());
                        output.accept(ModItems.ROAD_BARRIER.get());
                        output.accept(ModItems.PAINT_ROLLER.get());
                    })
                    .build());

    public RoadDecor(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register datagen
        modEventBus.addListener(this::gatherData);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Road Decor is now loading...");
    }

    private void gatherData(GatherDataEvent event) {
        var output = event.getGenerator().getPackOutput();
        var lookupProvider = event.getLookupProvider();
        var existingFileHelper = event.getExistingFileHelper();

        // Block tags
        var blockTags = new ModBlockTagsProvider(output, lookupProvider, existingFileHelper);
        event.getGenerator().addProvider(event.includeServer(), blockTags);
        // Loot tables
        event.getGenerator().addProvider(event.includeServer(),
                new ModLootTableProvider(output, lookupProvider));

        // Recipes
        event.getGenerator().addProvider(event.includeServer(),
                new ModRecipeProvider(output, lookupProvider));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Road Decor is activated!");
    }
}
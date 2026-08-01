package radin6262.road.decor.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import radin6262.road.decor.registry.ModBlocks;
import radin6262.road.decor.registry.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        // Asphalt: 8 sand + 1 concrete (realistic: aggregate + binder)
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASPHALT.get(), 8)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .define('S', Blocks.SAND)
                .define('C', ModBlocks.CONCRETE.get())
                .unlockedBy("has_sand", has(Blocks.SAND))
                .save(output);

        // Concrete: 8 stone + 1 sand
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CONCRETE.get(), 8)
                .pattern("###")
                .pattern("#S#")
                .pattern("###")
                .define('#', Blocks.STONE)
                .define('S', Blocks.SAND)
                .unlockedBy("has_stone", has(Blocks.STONE))
                .save(output);


        // Stop Sign
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.STOP_SIGN.get(), 1)
                .pattern(" W ")
                .pattern("WRW")
                .pattern(" I ")
                .define('R', Blocks.RED_CONCRETE)
                .define('W', ModBlocks.CONCRETE.get())
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_red_concrete", has(Blocks.RED_CONCRETE))
                .save(output);

        // Road Barrier
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ROAD_BARRIER.get(), 3)
                .pattern(" C ")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModBlocks.CONCRETE.get())
                .unlockedBy("has_concrete", has(ModBlocks.CONCRETE.get()))
                .save(output);

        // Paint Roller: Yellow Wool on top, Iron ingot for casing, Stick for handle
        // Pattern:
        // W (Yellow Wool)
        // I (Iron Ingot)
        // S (Stick)
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PAINT_ROLLER.get(), 1)
                .pattern("W")
                .pattern("I")
                .pattern("S")
                .define('W', Blocks.YELLOW_WOOL)
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_wool", has(Blocks.YELLOW_WOOL))
                .save(output);

        // One Way Sign: 4 white concrete + 1 blue concrete (arrow shape)
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ONE_WAY_SIGN.get(), 1)
                .pattern(" B ")
                .pattern("BWB")
                .pattern(" W ")
                .define('W', ModBlocks.CONCRETE.get())
                .define('B', Blocks.BLUE_CONCRETE)
                .unlockedBy("has_white_concrete", has(Blocks.WHITE_CONCRETE))
                .save(output);

        // Asphalt Slope: 3 asphalt in a stair pattern
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASPHALT_SLOPE.get(), 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.ASPHALT.get())
                .unlockedBy("has_asphalt", has(ModBlocks.ASPHALT.get()))
                .save(output);

        // Traffic Cone: 1 orange concrete + 1 white concrete = 4 cones
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TRAFFIC_CONE.get(), 4)
                .pattern("O")
                .pattern("W")
                .pattern("O")
                .define('O', Blocks.ORANGE_CONCRETE)
                .define('W', Blocks.WHITE_CONCRETE)
                .unlockedBy("has_orange_concrete", has(Blocks.ORANGE_CONCRETE))
                .save(output);

        // Lower Split Asphalt Slope
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LOWER_SPLIT_ASPHALT_SLOPE.get(), 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.ASPHALT.get())
                .unlockedBy("has_asphalt", has(ModBlocks.ASPHALT.get()))
                .save(output);

        // Higher Split Asphalt Slope
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HIGHER_SPLIT_ASPHALT_SLOPE.get(), 4)
                .pattern("AAA")
                .pattern(" AA")
                .pattern("  A")
                .define('A', ModBlocks.ASPHALT.get())
                .unlockedBy("has_asphalt", has(ModBlocks.ASPHALT.get()))
                .save(output);
    }
}
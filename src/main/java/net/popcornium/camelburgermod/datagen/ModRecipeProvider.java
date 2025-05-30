package net.popcornium.camelburgermod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.popcornium.camelburgermod.CamelBurgerMod;
import net.popcornium.camelburgermod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItem(ModItems.RAW_CAMEL_MEAT), RecipeCategory.FOOD, ModItems.COOKED_CAMEL_MEAT, 0.35F, 200)
                        .criterion(hasItem(ModItems.RAW_CAMEL_MEAT), conditionsFromItem(ModItems.RAW_CAMEL_MEAT))
                        .offerTo(exporter, String.valueOf(Identifier.of(CamelBurgerMod.MOD_ID, "cooked_camel_meat_from_smelting")));
                CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItem(ModItems.RAW_CAMEL_MEAT), RecipeCategory.FOOD, ModItems.COOKED_CAMEL_MEAT, 0.35F, 100)
                        .criterion(hasItem(ModItems.RAW_CAMEL_MEAT), conditionsFromItem(ModItems.RAW_CAMEL_MEAT))
                        .offerTo(exporter, String.valueOf(Identifier.of(CamelBurgerMod.MOD_ID, "cooked_camel_meat_from_smoking")));
                CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.ofItem(ModItems.RAW_CAMEL_MEAT), RecipeCategory.FOOD, ModItems.COOKED_CAMEL_MEAT, 0.35F, 600)
                        .criterion(hasItem(ModItems.RAW_CAMEL_MEAT), conditionsFromItem(ModItems.RAW_CAMEL_MEAT))
                        .offerTo(exporter, String.valueOf(Identifier.of(CamelBurgerMod.MOD_ID, "cooked_camel_meat_from_campfire_cooking")));

                createShaped(RecipeCategory.FOOD, ModItems.CAMEL_BURGER)
                        .pattern(" R ")
                        .pattern("KCB")
                        .pattern(" R ")
                        .input('R', Items.BREAD)
                        .input('K', Items.KELP)
                        .input('C', ModItems.COOKED_CAMEL_MEAT)
                        .input('B', Items.BEETROOT)
                        .criterion(hasItem(ModItems.COOKED_CAMEL_MEAT), conditionsFromItem(ModItems.COOKED_CAMEL_MEAT))
                        .offerTo(exporter, String.valueOf(Identifier.of(CamelBurgerMod.MOD_ID, "camel_burger1")));
                createShaped(RecipeCategory.FOOD, ModItems.CAMEL_BURGER)
                        .pattern(" R ")
                        .pattern("BCK")
                        .pattern(" R ")
                        .input('R', Items.BREAD)
                        .input('K', Items.KELP)
                        .input('C', ModItems.COOKED_CAMEL_MEAT)
                        .input('B', Items.BEETROOT)
                        .criterion(hasItem(ModItems.COOKED_CAMEL_MEAT), conditionsFromItem(ModItems.COOKED_CAMEL_MEAT))
                        .offerTo(exporter, String.valueOf(Identifier.of(CamelBurgerMod.MOD_ID, "camel_burger2")));
            }
        };
    }

    @Override
    public String getName() {
        return "CamelBurgerMod Recipes";
    }
}

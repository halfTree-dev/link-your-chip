package com.halftree.linkyourchips.datagen;

import java.util.function.Consumer;

import com.halftree.linkyourchips.block.ModBlocks;
import com.halftree.linkyourchips.item.ModItems;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

// To gen /data/recipes

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder{

    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COPPER_CONDUCTOR_BLOCK.get())
            .pattern("CCC")
            .pattern("CBC")
            .pattern("CCC")
            .define('C', ModItems.COPPER_CONDUCTOR.get())
            .define('B', Items.COPPER_BLOCK)
            .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COPPER_BLOCK, 1)
            .requires(ModBlocks.COPPER_CONDUCTOR_BLOCK.get())
            .unlockedBy(getHasName(ModBlocks.COPPER_CONDUCTOR_BLOCK.get()), has(ModBlocks.COPPER_CONDUCTOR_BLOCK.get()))
            .save(consumer);
    }

}
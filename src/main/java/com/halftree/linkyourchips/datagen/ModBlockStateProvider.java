package com.halftree.linkyourchips.datagen;

import com.halftree.linkyourchips.LinkYourChipsMod;
import com.halftree.linkyourchips.block.ModBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

// To gen /assets/blockstates

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LinkYourChipsMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.COPPER_CONDUCTOR_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistry) {
        simpleBlockWithItem(blockRegistry.get(), cubeAll(blockRegistry.get()));
    }

}
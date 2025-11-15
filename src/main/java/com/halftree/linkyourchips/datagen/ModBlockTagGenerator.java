package com.halftree.linkyourchips.datagen;

import com.halftree.linkyourchips.LinkYourChipsMod;
import com.halftree.linkyourchips.block.ModBlocks;
import com.halftree.linkyourchips.util.ModTags;

import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

// To gen /data/tags/blocks

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<Provider> lookupProvider, @Nullable ExistingFileHelper exFileHelper) {
        super(output, lookupProvider, LinkYourChipsMod.MODID, exFileHelper);
    }

    @Override
    public void addTags(Provider provider) {
        this.tag(ModTags.Blocks.CONDUCTOR_BLOCKS)
            .add(ModBlocks.COPPER_CONDUCTOR_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.COPPER_CONDUCTOR_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.COPPER_CONDUCTOR_BLOCK.get());
    }

}
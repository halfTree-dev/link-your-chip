package com.halftree.linkyourchips.util;

import com.halftree.linkyourchips.LinkYourChipsMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> CONDUCTOR_BLOCKS = tag("conductor_blocks");

        private static final TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(LinkYourChipsMod.MODID, name));
        }
    }

    public static class Items {

        private static final TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(LinkYourChipsMod.MODID, name));
        }
    }
}

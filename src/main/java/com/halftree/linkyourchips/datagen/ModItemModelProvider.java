package com.halftree.linkyourchips.datagen;

import com.halftree.linkyourchips.LinkYourChipsMod;
import com.halftree.linkyourchips.item.ModItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

// To gen /assets/models/item

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LinkYourChipsMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.COPPER_CONDUCTOR);
        simpleItem(ModItems.SERIAL_CONNECTOR);
        simpleItem(ModItems.MULTIMETER);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(LinkYourChipsMod.MODID,
                "item/" + item.getId().getPath()));
    }

}
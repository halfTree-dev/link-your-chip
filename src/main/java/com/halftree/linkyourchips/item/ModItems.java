package com.halftree.linkyourchips.item;

import com.halftree.linkyourchips.LinkYourChipsMod;
import com.halftree.linkyourchips.item.custom.SerialConnectorItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LinkYourChipsMod.MODID);

    public static final RegistryObject<Item> COPPER_CONDUCTOR = ITEMS.register("copper_conductor",
        () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> SERIAL_CONNECTOR = ITEMS.register("serial_connector",
        () -> new SerialConnectorItem(new Item.Properties())
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

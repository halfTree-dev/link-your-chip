package com.halftree.linkyourchips.item;

import com.halftree.linkyourchips.LinkYourChipsMod;
import com.halftree.linkyourchips.block.ModBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LinkYourChipsMod.MODID);

    public static final RegistryObject<CreativeModeTab> LINK_YOUR_CHIPS_TAB = CREATIVE_MODE_TABS.register
        ("link_your_chip_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.SERIAL_CONNECTOR.get()))
            .title(Component.translatable("creativetab.linkyourchips_tab"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.COPPER_CONDUCTOR.get());
                output.accept(ModItems.SERIAL_CONNECTOR.get());
                output.accept(ModItems.MULTIMETER.get());
                output.accept(ModBlocks.COPPER_CONDUCTOR_BLOCK.get());
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}

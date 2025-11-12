package com.halftree.linkyourchips;

import com.halftree.linkyourchips.block.ModBlocks;
import com.halftree.linkyourchips.item.ModCreativeModeTab;
import com.halftree.linkyourchips.item.ModItems;
import com.mojang.logging.LogUtils;

// import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(LinkYourChipsMod.MODID)
public final class LinkYourChipsMod {

    public static final String MODID = "linkyourchips";

    private static final Logger LOGGER = LogUtils.getLogger();

    public LinkYourChipsMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modBus);
        ModBlocks.register(modBus);

        ModCreativeModeTab.register(modBus);

        MinecraftForge.EVENT_BUS.register(this);
        modBus.addListener(this::commonSetup);
        modBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        //     event.accept(ModItems.COPPER_CONDUCTOR);
        // if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
        //     event.accept(ModBlocks.COPPER_CONDUCTOR_BLOCK);
    }
}
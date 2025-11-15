package com.halftree.linkyourchips.item.custom;

import java.util.List;

import javax.annotation.Nullable;

import com.halftree.linkyourchips.util.SerialPortScanner;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;

public class SerialConnectorItem extends Item {

    public SerialConnectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getLevel().isClientSide()) {
            // 在客户端扫描串口并输出到聊天框
            Minecraft minecraft = Minecraft.getInstance();
            SerialPortScanner.sendPortInfoToChat(minecraft);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        super.appendHoverText(itemStack, level, tooltipComponents, isAdvanced);
        tooltipComponents.add(Component.translatable("item.linkyourchips.serial_connector.tooltip"));
    }
}
package com.halftree.linkyourchips.item.custom;

import com.halftree.linkyourchips.util.SerialPortScanner;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

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
}

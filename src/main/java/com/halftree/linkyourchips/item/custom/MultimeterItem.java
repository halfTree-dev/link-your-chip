package com.halftree.linkyourchips.item.custom;

import java.util.List;

import javax.annotation.Nullable;

import com.halftree.linkyourchips.util.ModTags;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class MultimeterItem extends Item {

    public MultimeterItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getLevel().isClientSide()) {
            Block block = context.getLevel().getBlockState(context.getClickedPos()).getBlock();
            Minecraft minecraft = Minecraft.getInstance();

            if (minecraft.player != null) {
                if (block.builtInRegistryHolder().is(ModTags.Blocks.CONDUCTOR_BLOCKS)) {
                    minecraft.player.sendSystemMessage(Component.translatable("message.linkyourchips.is_conductor"));
                } else {
                    minecraft.player.sendSystemMessage(Component.translatable("message.linkyourchips.not_conductor"));
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        super.appendHoverText(itemStack, level, tooltipComponents, isAdvanced);
        tooltipComponents.add(Component.translatable("item.linkyourchips.multimeter.tooltip"));
    }

}

package com.rslover521.airportassetsmod.menu;

import com.rslover521.airportassetsmod.registry.ModMenus;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class RunwaySignMenu extends AbstractContainerMenu {
    private final BlockPos pos;

    // Server-side constructor (when opened from server with pos)
    public RunwaySignMenu(int id, Inventory inv, BlockPos pos) {
        super(ModMenus.RUNWAY_SIGN.get(), id);
        this.pos = pos;
    }

    // Minimal constructor used by the MenuType factory (client)
    public RunwaySignMenu(int id, Inventory inv) {
        // client will later call fromNetwork when a FriendlyByteBuf is available
        super(ModMenus.RUNWAY_SIGN.get(), id);
        this.pos = BlockPos.ZERO;
    }

    // Factory used by network on client to reconstruct the menu with BlockPos
    public static RunwaySignMenu fromNetwork(int windowId, Inventory inv, FriendlyByteBuf data) {
        BlockPos pos = data.readBlockPos();
        return new RunwaySignMenu(windowId, inv, pos);
    }

    public BlockPos getPos() {
        return pos;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    // required by AbstractContainerMenu
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }
}

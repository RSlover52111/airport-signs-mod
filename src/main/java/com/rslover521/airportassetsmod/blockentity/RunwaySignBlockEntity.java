package com.rslover521.airportassetsmod.blockentity;

import com.rslover521.airportassetsmod.registry.ModBlockEntities;
import com.rslover521.airportassetsmod.menu.RunwaySignMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RunwaySignBlockEntity extends BlockEntity implements MenuProvider {
    private String runway = "";

    public RunwaySignBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RUNWAY_SIGN.get(), pos, state);
    }

    public void setRunway(String code) {
        this.runway = code == null ? "" : code;
        setChanged();
    }

    public String getRunway() {
        return runway == null ? "" : runway;
    }

    protected void saveAdditonal(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("Runway", getRunway());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.runway = tag.getString("Runway");
    }

    // MenuProvider
    @Override
    public Component getDisplayName() {
        return Component.translatable("container.airportassets.runway_sign");
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new RunwaySignMenu(id, inv, this.worldPosition);
    }
}

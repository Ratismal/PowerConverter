package io.github.ratismal.powerconverter.block.testRF;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerTestRFMachine extends Container {

    protected TileTestRFMachine tileEntity;

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }



}

package io.github.ratismal.felineutilities.tileentity;

import cofh.api.energy.EnergyStorage;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by Ratismal on 2015-09-08.
 */
public class BaseStorageTile extends BaseTileEntity {

    protected EnergyStorage energy;

    private static int currentCharge = 0;

    public BaseStorageTile(int maxCharge, int maxReceive) {

        energy = new EnergyStorage(maxCharge);
        energy.setMaxReceive(maxReceive);

    }

    public BaseStorageTile(int maxCharge, int maxReceive, int maxExtract) {

        energy = new EnergyStorage(maxCharge);
        energy.setMaxReceive(maxReceive);
        energy.setMaxExtract(maxExtract);

    }

    public void modifyEnergyStored(int energy) {
        this.energy.modifyEnergyStored(energy);
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
    }

    @Override
    public void readCustomNBT(NBTTagCompound tagCompound) {
        super.readCustomNBT(tagCompound);
        energy.readFromNBT(tagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
    }

    @Override
    public void writeCustomNBT(NBTTagCompound tagCompound) {
        super.writeCustomNBT(tagCompound);
        energy.writeToNBT(tagCompound);
    }

    public static int getCharge() {

        return currentCharge;

    }

    public static void setCharge(int charge) {
        currentCharge = charge;
    }

}

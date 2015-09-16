package io.github.ratismal.felineutilities.base.tiles;

import cofh.api.energy.IEnergyHandler;
import io.github.ratismal.felineutilities.power.CatStorage;
import net.minecraft.nbt.NBTTagCompound;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Reference implementation of {@link IEnergyHandler}. Use/extend this or implement your own.
 *
 * @author King Lemming
 *
 */
public class BaseStorageTile extends BaseTileEntity implements IEnergyHandler {

    protected CatStorage storage;

    public BaseStorageTile(int capacity, int transferLimit) {

        storage = new CatStorage();
        storage.setTransferRFMax(transferLimit);

    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {

        super.readFromNBT(nbt);
        storage.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {

        super.writeToNBT(nbt);
        storage.writeToNBT(nbt);
    }

    /* IEnergyConnection */
    @Override
    public boolean canConnectEnergy(ForgeDirection from) {

        return true;
    }

    /* IEnergyReceiver */
    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {

        return storage.receiveRF(maxReceive);
    }

    /* IEnergyProvider */
    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {

        return storage.extractRF(maxExtract);
    }

    /* IEnergyReceiver and IEnergyProvider */
    @Override
    public int getEnergyStored(ForgeDirection from) {

        return storage.getEnergy();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {

        return storage.getCapacity();
    }


}

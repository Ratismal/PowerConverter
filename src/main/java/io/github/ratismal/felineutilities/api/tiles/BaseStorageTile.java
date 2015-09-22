package io.github.ratismal.felineutilities.api.tiles;

import cofh.api.energy.IEnergyHandler;
import io.github.ratismal.felineutilities.common.power.CatStorage;
import net.minecraft.nbt.NBTTagCompound;
import io.github.ratismal.felineutilities.common.core.handler.ConfigHandler;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * RefInfo implementation of {@link IEnergyHandler}. Use/extend this or implement your own.
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

        return storage.receiveRF(maxReceive, simulate);
    }

    /* IEnergyProvider */
    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {

        return storage.extractRF(maxExtract, simulate);
    }

    /* IEnergyReceiver and IEnergyProvider */
    @Override
    public int getEnergyStored(ForgeDirection from) {

        return storage.convertCat(storage.getEnergy(), ConfigHandler.getRFValue());
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {

        return storage.convertCat(storage.getCapacity(), ConfigHandler.getRFValue());
    }


}

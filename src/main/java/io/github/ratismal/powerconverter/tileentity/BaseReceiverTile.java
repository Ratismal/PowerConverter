package io.github.ratismal.powerconverter.tileentity;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;
import net.minecraftforge.common.util.ForgeDirection;
import scala.xml.dtd.impl.Base;

/**
 * Created by Ratismal on 2015-09-08.
 */
public class BaseReceiverTile extends BaseStorageTile implements IEnergyReceiver {



    public BaseReceiverTile(int maxCharge, int maxReceive) {
        super(maxCharge, maxReceive);
    }

    public BaseReceiverTile(int maxCharge, int maxReceive, int maxExtract) {
        super(maxCharge, maxReceive, maxExtract);
    }

    public void consumeEnergy(int consume) {
        modifyEnergyStored(-consume);
    }

    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        return energy.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int getEnergyStored(ForgeDirection from) {
        return energy.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return energy.getMaxEnergyStored();
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return true;
    }
}

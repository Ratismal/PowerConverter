package io.github.ratismal.powerconverter.power;

import io.github.ratismal.powerconverter.handler.ConfigHandler;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by Ratismal on 2015-09-09.
 */
public class CatStorage implements ICatStorage {

    int transferRFMax;
    int transferEUMax;
    int energy;
    int capacity;
    int capacityRF;
    int capacityEU;

    public CatStorage() {

        this.capacityEU = 0;
        this.capacityRF = 0;
        this.transferEUMax = 0;
        this.transferRFMax = 0;
        calculateCapacity();

    }

    public CatStorage readFromNBT(NBTTagCompound nbt) {

        this.energy = nbt.getInteger("Energy");

        if (energy > capacity) {
            energy = capacity;
        }
        return this;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {

        if (energy < 0) {
            energy = 0;
        }
        nbt.setInteger("Energy", energy);
        return nbt;
    }

    public void setCapacityRF(int capacity) {
        this.capacityRF = capacity;
        calculateCapacity();
    }

    public void setCapacityEU(int capacity) {
        this.capacityEU = capacity;
        calculateCapacity();
    }

    public void calculateCapacity() {
        this.capacity = this.capacityEU + this.capacityRF;
    }

    public void setTransferRFMax(int transferMax) {
        this.transferRFMax = transferMax;
        setCapacityRF(transferMax);
    }

    public void setTransferEUMax(int transferMax) {
        this.transferEUMax = transferMax;
        setCapacityEU(transferMax);
    }

    public int convertRF(int convert) {
        return convert * ConfigHandler.getRFValue();
    }

    public int convertEU(int convert) {
        return convert * ConfigHandler.getEUValue();
    }

    public int convertCat(int convert, int factor) {
        return convert / factor;
    }

    @Override
    public void receiveCat(int receiveMax) {
        energy += receiveMax;
    }

    @Override
    public void extractCat(int extractMax) {
        energy -= extractMax;
    }

    @Override
    public int receiveRF(int receiveMax) {
        int energyReceived = Math.min(capacity - energy, convertRF(Math.min(this.transferRFMax, receiveMax)));
        receiveCat(energyReceived);

        return convertCat(energyReceived, ConfigHandler.getRFValue());
    }

    @Override
    public int extractRF(int extractMax) {
        int energyExtracted = Math.min(energy, convertRF(Math.min(this.transferRFMax, extractMax)));
        extractCat(energyExtracted);

        return convertCat(energyExtracted, ConfigHandler.getRFValue());
    }

    @Override
    public int receiveEU(int receiveMax) {
        int energyReceived = Math.min(capacity - energy, convertEU(Math.min(this.transferEUMax, receiveMax)));
        receiveCat(energyReceived);

        return convertCat(energyReceived, ConfigHandler.getEUValue());
    }

    @Override
    public int extractEU(int extractMax) {
        int energyExtracted = Math.min(energy, convertEU(Math.min(this.transferEUMax, extractMax)));
        extractCat(energyExtracted);

        return convertCat(energyExtracted, ConfigHandler.getEUValue());
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}

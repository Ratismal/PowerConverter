package io.github.ratismal.powerconverter.machines.test;

import io.github.ratismal.powerconverter.handler.ConfigHandler;
import io.github.ratismal.powerconverter.tileentity.BaseReceiverTile;

public class TileTestMachine extends BaseReceiverTile {

    public TileTestMachine() {
        super(ConfigHandler.getTestMachineCapacityRF(), ConfigHandler.getTestMachineReceiveRF());
    }

}

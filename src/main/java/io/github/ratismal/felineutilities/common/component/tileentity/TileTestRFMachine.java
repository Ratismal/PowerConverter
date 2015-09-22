package io.github.ratismal.felineutilities.common.component.tileentity;

import io.github.ratismal.felineutilities.api.tiles.BaseStorageTile;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Ratismal on 2015-09-09.
 */
public class TileTestRFMachine extends BaseStorageTile {

    public TileTestRFMachine(int capacity, int transferLimit) {
        super(capacity, transferLimit);
    }

    //@Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        if (worldObj == null)
        {
            return true;
        }
        if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        }
        return player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.4) < 64;
    }
}

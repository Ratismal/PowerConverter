package io.github.ratismal.powerconverter.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.util.UUID;

/**
 * Created by Ratismal on 2015-09-08.
 */

public class BaseTileEntity extends TileEntity {

    private String ownerName = "";
    private UUID ownerUUID = null;
    private boolean isLocked = false;

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        readCustomNBT(compound);
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        writeCustomNBT(compound);
    }

    public void readCustomNBT(NBTTagCompound compound) {

        ownerName = compound.getString("owner");
        if (compound.hasKey("ownerM")) {
            ownerUUID = new UUID(compound.getLong("ownerM"), compound.getLong("ownerL"));
        }
        else {
            ownerUUID = null;
        }

        isLocked = compound.getBoolean("locked");
    }

    public void writeCustomNBT(NBTTagCompound compound) {

        if (ownerUUID != null) {

            compound.setString("owner", ownerName);
            compound.setLong("ownerM", ownerUUID.getMostSignificantBits());
            compound.setLong("ownerL", ownerUUID.getLeastSignificantBits());

        }

        compound.setBoolean("locked", isLocked);

    }


    public boolean setOwner(EntityPlayer player) {
        if (ownerUUID != null) {
            // Already has an owner.
            return false;
        }
        ownerUUID = player.getPersistentID();
        ownerName = player.getDisplayName();
        markDirty();
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

        return true;
    }

    public void clearOwner() {
        ownerUUID = null;
        ownerName = "";
        markDirty();
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

}

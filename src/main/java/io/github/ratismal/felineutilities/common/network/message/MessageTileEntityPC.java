package io.github.ratismal.felineutilities.common.network.message;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.github.ratismal.felineutilities.api.tiles.BaseTileEntity;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Ratismal on 2015-09-05.
 */
public class MessageTileEntityPC implements IMessage, IMessageHandler<MessageTileEntityPC, IMessage> {

    public int x,y,z;
    public byte orientation;
    public String customName;

    public MessageTileEntityPC() {

    }

    public MessageTileEntityPC(BaseTileEntity tileEntityPC)
    {
        this.x = tileEntityPC.xCoord;
        this.y = tileEntityPC.yCoord;
        this.z = tileEntityPC.zCoord;

    }

    @Override
    public void fromBytes(ByteBuf buf) {

        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.orientation = buf.readByte();
        int customNameLength = buf.readInt();
        this.customName = new String(buf.readBytes(customNameLength).array());

    }

    @Override
    public void toBytes(ByteBuf buf) {

        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(orientation);
        buf.writeInt(customName.length());
        buf.writeBytes(customName.getBytes());

    }

    @Override
    public IMessage onMessage(MessageTileEntityPC message, MessageContext ctx) {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        return null;
    }
}

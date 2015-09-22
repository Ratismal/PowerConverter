package io.github.ratismal.felineutilities.common.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import io.github.ratismal.felineutilities.common.lib.RefInfo;
import io.github.ratismal.felineutilities.common.network.message.MessageTileEntityPC;

/**
 * Created by Ratismal on 2015-09-05.
 */
public class PacketHandler {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(RefInfo.MODID.toLowerCase());

    public static void init()
    {
        INSTANCE.registerMessage(MessageTileEntityPC.class, MessageTileEntityPC.class, 0, Side.CLIENT);

    }

}

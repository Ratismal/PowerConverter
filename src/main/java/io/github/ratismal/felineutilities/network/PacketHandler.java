package io.github.ratismal.felineutilities.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import io.github.ratismal.felineutilities.network.message.MessageTileEntityPC;
import io.github.ratismal.felineutilities.reference.Reference;

/**
 * Created by Ratismal on 2015-09-05.
 */
public class PacketHandler {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID.toLowerCase());

    public static void init()
    {
        INSTANCE.registerMessage(MessageTileEntityPC.class, MessageTileEntityPC.class, 0, Side.CLIENT);

    }

}

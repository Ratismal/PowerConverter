package io.github.ratismal.felineutilities.common.core.util;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratismal on 2015-09-17.
 */

public class Broadcaster {

    public static void broadcastMessage(String msg) {

        List<EntityPlayerMP> list = new ArrayList<EntityPlayerMP>();
        list = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
        for (EntityPlayerMP player : list) {

            player.addChatMessage(new ChatComponentText(msg));

        }

    }

}

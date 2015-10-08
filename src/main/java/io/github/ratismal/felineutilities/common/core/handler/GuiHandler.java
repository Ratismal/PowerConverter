package io.github.ratismal.felineutilities.common.core.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import io.github.ratismal.felineutilities.client.gui.guide.GuiGuide;
import io.github.ratismal.felineutilities.common.lib.RefGuiIds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Ratismal on 2015-09-22.
 */

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {


        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID) {
            case RefGuiIds.GUIDE :
                GuiGuide guide = GuiGuide.currentOpenGuide;
                return guide;
        }

        return null;
    }

}

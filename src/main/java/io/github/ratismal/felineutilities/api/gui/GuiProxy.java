package io.github.ratismal.felineutilities.api.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import io.github.ratismal.felineutilities.common.component.block.BlockTestRFMachine;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Ratismal on 2015-09-17.
 */

public class GuiProxy implements IGuiHandler {


    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        Block block = world.getBlock(x, y, z);
        if (block instanceof BlockTestRFMachine) {
            BlockTestRFMachine baseBlock = (BlockTestRFMachine) block;
            TileEntity te = world.getTileEntity(x, y, z);
            return baseBlock.createServerContainer(player, te);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        Block block = world.getBlock(x, y, z);
        if (block instanceof BlockTestRFMachine) {
            BlockTestRFMachine baseBlock = (BlockTestRFMachine) block;
            TileEntity te = world.getTileEntity(x, y, z);
            return baseBlock.createClientGui(player, te);
        }

        return null;
    }
}

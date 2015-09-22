package io.github.ratismal.felineutilities.common.component.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.ratismal.felineutilities.FelineUtilities;
import io.github.ratismal.felineutilities.api.blocks.BaseBlock;
import io.github.ratismal.felineutilities.common.component.container.ContainerTestRFMachine;
import io.github.ratismal.felineutilities.client.gui.GuiTestRFMachine;
import io.github.ratismal.felineutilities.common.component.tileentity.TileTestRFMachine;
import io.github.ratismal.felineutilities.common.lib.RefInfo;
import io.github.ratismal.felineutilities.common.lib.RefName;
import io.github.ratismal.felineutilities.common.tab.CreativeTabPC;
import io.github.ratismal.felineutilities.api.tiles.BaseStorageTile;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

public class BlockTestRFMachine extends BaseBlock {

    public IIcon[] icons = new IIcon[5];

    public BlockTestRFMachine() {

        super();
        this.setBlockName(RefName.Blocks.testMachineRF);
        this.setCreativeTab(CreativeTabPC.PC_TAB);

    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {

        this.icons[0] = reg.registerIcon(RefInfo.RESOURCE_PREFIX + "testMachineRF");
        this.icons[1] = reg.registerIcon(RefInfo.RESOURCE_PREFIX + "testMachineRFOut_0");
        this.icons[2] = reg.registerIcon(RefInfo.RESOURCE_PREFIX + "testMachineRFOut_1");
        this.icons[3] = reg.registerIcon(RefInfo.RESOURCE_PREFIX + "testMachineRFIn_0");
        this.icons[4] = reg.registerIcon(RefInfo.RESOURCE_PREFIX + "testMachineRFIn_1");

    }

    @Override
    public IIcon getIcon(int side, int meta) {
        //return this.icons[side];
        if (side == 1) {
            return this.icons[0];
        }
        else if (side == 2) {
            return this.icons[1];
        }
        else if (side == 3) {
            return this.icons[2];
        }
        else if (side == 4) {
            return this.icons[3];
        }
        else if (side == 5) {
            return this.icons[4];
        }
        else {
            return this.icons[0];
        }
    }

    @SideOnly(Side.CLIENT)
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {


        Block block = accessor.getBlock();
        TileEntity tileEntity = accessor.getTileEntity();
        if (tileEntity instanceof BaseStorageTile) {
            BaseStorageTile genericTileEntity = (BaseStorageTile) tileEntity;

                int energy = genericTileEntity.getEnergyStored(ForgeDirection.DOWN);
                int maxEnergy = genericTileEntity.getMaxEnergyStored(ForgeDirection.DOWN);
                currenttip.add(EnumChatFormatting.GREEN + "Energy: " + energy + "RF / " + maxEnergy + "RF");

        }
        return currenttip;

    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileTestRFMachine(1000000, 1000000);
    }

    //@Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileTestRFMachine(1000000, 1000000);
    }

    @SideOnly(Side.CLIENT)
    public GuiContainer createClientGui(EntityPlayer entityPlayer, TileEntity tileEntity) {
        TileTestRFMachine tileTestRFMachine = (TileTestRFMachine) tileEntity;
        ContainerTestRFMachine containerTestRFMachine = new ContainerTestRFMachine(entityPlayer, tileTestRFMachine);
        return new GuiTestRFMachine(tileTestRFMachine, containerTestRFMachine);
    }

    public Container createServerContainer(EntityPlayer entityPlayer, TileEntity tileEntity) {
        return new ContainerTestRFMachine(entityPlayer, (TileTestRFMachine) tileEntity);
    }

    //@Override
    public int getGuiID() {
        return FelineUtilities.GUI_TEST_MACHINE_RF;
    }



}

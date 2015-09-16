package io.github.ratismal.felineutilities.block.testRF;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.ratismal.felineutilities.base.blocks.BaseBlock;
import io.github.ratismal.felineutilities.reference.Names;
import io.github.ratismal.felineutilities.tab.CreativeTabPC;
import io.github.ratismal.felineutilities.base.tiles.BaseStorageTile;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

public class BlockTestRFMachine extends BaseBlock {

    public BlockTestRFMachine() {

        super();
        this.setBlockName(Names.Blocks.testMachineRF);
        this.setCreativeTab(CreativeTabPC.PC_TAB);

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
        return new BaseStorageTile(1000000, 1000000);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new BaseStorageTile(1000000, 1000000);
    }

}

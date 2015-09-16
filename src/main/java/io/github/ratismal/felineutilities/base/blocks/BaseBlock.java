package io.github.ratismal.felineutilities.base.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.ratismal.felineutilities.tab.CreativeTabPC;
import io.github.ratismal.felineutilities.reference.Reference;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class BaseBlock extends BlockContainer implements ITileEntityProvider {


	public BaseBlock(Material material) {

		super(material);
		this.setCreativeTab(CreativeTabPC.PC_TAB);


	}

	public BaseBlock(){
		super(Material.iron);
	}


    @SideOnly(Side.CLIENT)
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {

        /*
        Block block = accessor.getBlock();
        TileEntity tileEntity = accessor.getTileEntity();
        if (tileEntity instanceof BaseStorageTile) {
            BaseStorageTile genericTileEntity = (BaseStorageTile) tileEntity;

                int energy = genericTileEntity.getEnergyStored(ForgeDirection.DOWN);
                int maxEnergy = genericTileEntity.getMaxEnergyStored(ForgeDirection.DOWN);
                currenttip.add(EnumChatFormatting.GREEN + "Energy: " + energy + "RF / " + maxEnergy + "RF");

        }
        */
        return currenttip;

    }

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, List list, boolean whatIsThis) {
		NBTTagCompound tagCompound = itemStack.getTagCompound();
		if (tagCompound != null) {
			if (tagCompound.hasKey("Energy")) {
				int energy = tagCompound.getInteger("Energy");
				list.add(EnumChatFormatting.GREEN + "Energy: " + energy + " rf");
			}
		}
	}

	@Override
	public String getUnlocalizedName() {

		return String.format("tile.%s%s", Reference.MODID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return null;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return null;
    }

}

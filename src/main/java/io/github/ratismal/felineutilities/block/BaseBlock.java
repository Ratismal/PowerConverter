package io.github.ratismal.felineutilities.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.ratismal.felineutilities.tab.CreativeTabPC;
import io.github.ratismal.felineutilities.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class BaseBlock extends Block implements ITileEntityProvider {

    protected final Class<? extends TileEntity> tileEntityClass;

	public BaseBlock(Material material, Class<? extends TileEntity> tileEntityClass) {

		super(material);
		this.setCreativeTab(CreativeTabPC.PC_TAB);

        this.tileEntityClass = tileEntityClass;

	}

	public BaseBlock(Class<? extends TileEntity> tileEntityClass){
		super(Material.iron);
        this.tileEntityClass = tileEntityClass;
	}


	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean whatIsThis) {
		NBTTagCompound tagCompound = itemStack.getTagCompound();
		if (tagCompound != null) {
			if (tagCompound.hasKey("Energy")) {
				int energy = tagCompound.getInteger("Energy");
				list.add(EnumChatFormatting.GREEN + "Energy: " + energy + " rf");
			}
			if (tagCompound.hasKey("ownerM")) {
				String owner = tagCompound.getString("owner");
                list.add(EnumChatFormatting.YELLOW + "Owned by: " + owner);
			}
		}
	}

	@Override
	public String getUnlocalizedName() {

		return String.format("tile.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));

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
        try {
            return tileEntityClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}

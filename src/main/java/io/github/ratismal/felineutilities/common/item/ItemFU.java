package io.github.ratismal.felineutilities.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.ratismal.felineutilities.common.lib.RefInfo;
import io.github.ratismal.felineutilities.common.tab.CreativeTabPC;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemFU extends Item {

	public ItemFU() {

		super();

		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabPC.PC_TAB);

	}

	@Override
	public String getUnlocalizedName() {
		return String.format("item.%s%s", RefInfo.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	public String getUnlocalizedName(ItemStack item) {
		return String.format("item.%s%s", RefInfo.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

}

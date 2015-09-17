package io.github.ratismal.felineutilities.item;

import io.github.ratismal.felineutilities.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Ratismal on 2015-09-17.
 */

public class ItemFeatherHeavy extends ItemFU {

    public ItemFeatherHeavy() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(Names.Items.featherHeavy);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(EnumChatFormatting.DARK_RED + "Another incomplete ability...");
        list.add("How do you land?");

    }

}

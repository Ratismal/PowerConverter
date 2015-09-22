package io.github.ratismal.felineutilities.common.item;

import io.github.ratismal.felineutilities.common.lib.RefName;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Ratismal on 2015-09-18.
 */

public class ItemBowPlain extends ItemFU {

    public ItemBowPlain() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(RefName.Items.bowPlain);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(EnumChatFormatting.DARK_RED + "Another incomplete ability...");
        list.add("Have you seen my sister?");

    }

}

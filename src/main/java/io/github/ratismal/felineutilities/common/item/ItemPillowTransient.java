package io.github.ratismal.felineutilities.common.item;

import io.github.ratismal.felineutilities.common.lib.RefName;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Ratismal on 2015-09-17.
 */

public class ItemPillowTransient extends ItemFU {

    public ItemPillowTransient() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(RefName.Items.pillowTransient);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(EnumChatFormatting.DARK_RED + "Another incomplete ability...");
        list.add("Is this osmosis?");

    }

}

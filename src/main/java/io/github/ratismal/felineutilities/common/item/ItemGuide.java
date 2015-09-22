package io.github.ratismal.felineutilities.common.item;

import io.github.ratismal.felineutilities.FelineUtilities;
import io.github.ratismal.felineutilities.common.lib.RefGuiIds;
import io.github.ratismal.felineutilities.common.lib.RefName;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Ratismal on 2015-09-18.
 */

public class ItemGuide extends ItemFU {



    public ItemGuide() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(RefName.Items.guide);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

        player.openGui(FelineUtilities.instance, RefGuiIds.GUIDE, world, 0, 0, 0);

        return stack;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(EnumChatFormatting.GOLD + "A Logical Guide to Feline Utilities");

    }

}

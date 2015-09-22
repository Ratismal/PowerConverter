package io.github.ratismal.felineutilities.common.item;

import io.github.ratismal.felineutilities.common.lib.RefName;
import io.github.ratismal.felineutilities.common.core.util.Logger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Ratismal on 2015-09-17.
 */

public class ItemFeatherHeavy extends ItemFU {

    public ItemFeatherHeavy() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(RefName.Items.featherHeavy);
    }

    public void onUpdate(ItemStack stack, World world, Entity entity, int par1, boolean par2) {

        if (par2) {
            Logger.debug("par2 is true!");
            //(EntityPlayer) entity = (EntityPlayer) entity;
            if (!((EntityPlayer) entity).capabilities.allowFlying) {
                ((EntityPlayer) entity).capabilities.allowFlying = true;
            }
        } else {
            if (((EntityPlayer) entity).capabilities.allowFlying) {
                ((EntityPlayer) entity).capabilities.allowFlying = false;
            }
        }

    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(EnumChatFormatting.DARK_RED + "Another incomplete ability...");
        list.add("How do you land?");

    }

}

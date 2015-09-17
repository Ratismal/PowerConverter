package io.github.ratismal.felineutilities.item;

import io.github.ratismal.felineutilities.reference.Names;
import io.github.ratismal.felineutilities.util.Logger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Ratismal on 2015-09-15.
 */

public class ItemCameraBroken extends ItemFU {

    public ItemCameraBroken() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(Names.Items.cameraBroken);
    }

    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {

        //EntityPlayer player = (EntityPlayer) entity;
        //ItemStack boots = player.getCurrentArmor(0);
        if (stack.getTagCompound() == null) {
            NBTTagCompound nbt = stack.getTagCompound();
            Logger.Debug.info("NBTTAG NULL");
            stack.stackTagCompound = new NBTTagCompound();
            stack.stackTagCompound.setInteger("mode", 0);
            stack.setTagCompound(nbt);

        }


    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int par1, int par2, int par3, int side, float x, float y, float z) {

        if (!player.isSneaking()) {
            return false;
        }
        NBTTagCompound nbt = stack.getTagCompound();
        switch (nbt.getInteger("mode")) {
            case 0:
                nbt.setInteger("mode", 1);
                break;
            case 1:
                nbt.setInteger("mode", 0);
                break;
            default:
                nbt.setInteger("mode", 0);
                break;
        }
        stack.setTagCompound(nbt);

        return true;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(EnumChatFormatting.DARK_RED + "Another incomplete ability...");
        list.add("It's like I'm wearing nothing at all!");
        NBTTagCompound nbt = stack.getTagCompound();
        if (nbt != null) {
            switch (nbt.getInteger("mode")) {
                case 0:
                    list.add("Mode: Picture");
                    break;
                case 1:
                    list.add("Mode: Video");
                    break;
                default:
                    list.add("Mode: Picture");
                    break;
            }
        }
    }

}

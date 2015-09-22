package io.github.ratismal.felineutilities.common.item;

import io.github.ratismal.felineutilities.common.lib.RefName;
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
        this.setUnlocalizedName(RefName.Items.cameraBroken);
    }

    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
        /*
        //EntityPlayer player = (EntityPlayer) entity;
        //ItemStack boots = player.getCurrentArmor(0);
        if (stack.getTagCompound() == null) {
            NBTTagCompound nbt = stack.getTagCompound();
            Logger.Debug.info("NBTTAG NULL");
            stack.stackTagCompound = new NBTTagCompound();
            stack.stackTagCompound.setInteger("mode", 0);
            stack.setTagCompound(nbt);

        }
        */

    }


    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            if (!player.isSneaking()) {
                return super.onItemRightClick(stack, world, player);
            }
            NBTTagCompound tagCompound = stack.getTagCompound();
            if (tagCompound == null) {
                tagCompound = new NBTTagCompound();
                tagCompound.setInteger("mode", 0);
                stack.setTagCompound(tagCompound);
            } else {
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
            }
        }
        return super.onItemRightClick(stack, world, player);
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

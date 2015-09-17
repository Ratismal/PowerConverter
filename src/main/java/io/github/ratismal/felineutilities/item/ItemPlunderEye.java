package io.github.ratismal.felineutilities.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.ratismal.felineutilities.entity.EntityPlunderEye;
import io.github.ratismal.felineutilities.init.ModItems;
import io.github.ratismal.felineutilities.init.Whitelist;
import io.github.ratismal.felineutilities.reference.Names;
import io.github.ratismal.felineutilities.reference.Reference;
import io.github.ratismal.felineutilities.util.Logger;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ratismal on 2015-09-15.
 */

public class ItemPlunderEye extends ItemFU {

    private IIcon filledIcon;

    public ItemPlunderEye() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(Names.Items.plunderEye);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister IIconRegister) {
        itemIcon = IIconRegister.registerIcon(Reference.RESOURCE_PREFIX + "plunderEye_0");
        filledIcon = IIconRegister.registerIcon(Reference.RESOURCE_PREFIX + "plunderEye_1");
    }

    @Override
    public IIcon getIcon(ItemStack item, int arg1, EntityPlayer arg2, ItemStack arg3, int arg4) {
        if (isPlundered(item)) {
            return filledIcon;
        }
        return itemIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconIndex(ItemStack item) {
        if (isPlundered(item)) {
            return filledIcon;
        }
        return itemIcon;
    }

    public boolean isPlundered(ItemStack item) {
        if (item == null) {
            return false;
        }
        if (item.getItem() != this) {
            return false;
        }
        return item.stackTagCompound != null && item.stackTagCompound.hasKey("entity");
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack item, EntityPlayer player, EntityLivingBase entity) {
        //Logger.info("Doing checks");
        if (entity.worldObj.isRemote) {
            //Logger.info("Rejected - 1");
            return false;
        }
        if (isPlundered(item)) {
            //Logger.info("Rejected - 2");
            return false;
        }
        if (entity instanceof EntityPlayer) {
            //Logger.info("Rejected - 3");
            return false;
        }
        String entityId = EntityList.getEntityString(entity);
        if (!isWhiteListed(entityId)) {
            //Logger.info("Rejected - 4");
            return false;
        }
        if (entityId.toLowerCase().equals("ozelot")) {
            Logger.info("lol" + player.getDisplayName().toLowerCase() + "udungoofed");
            player.setHealth(0);
            if (player.isDead) {
                MinecraftServer.getServer().addChatMessage(new ChatComponentText(player.getDisplayName() + " had their soul reaped by Amanojaku!"));
            }
        }
        //Logger.info("Accepted");
        player.clearItemInUse();
        player.worldObj.spawnEntityInWorld(new EntityPlunderEye(player.worldObj, player, entity, item));
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(EnumChatFormatting.DARK_RED + "Another incomplete ability...");
        list.add("What could yuu possibly do with this?");
        if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("entity")) {
            //int duration = stack.stackTagCompound.getInteger("duration");
            //list.add("Duration used: " + duration);
            String entity = stack.stackTagCompound.getString("entity");
            list.add("Soul plundered: " + entity);
            /*
            String entity = stack.stackTagCompound.getString("entity");
            list.add("Entity plundered: " + entity);
            */
        }
    }

    public boolean isWhiteListed(String entityId) {
        return Whitelist.whitelist.contains(entityId.toLowerCase());
    }
}



package io.github.ratismal.felineutilities.item;

import com.sun.javafx.sg.prism.NodeEffectInput;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.ratismal.felineutilities.client.render.PlayerRenderBase;
import io.github.ratismal.felineutilities.init.ModItems;
import io.github.ratismal.felineutilities.reference.Names;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderPlayerEvent;
import org.lwjgl.opengl.GL11;

import java.util.List;

/**
 * Created by Ratismal on 2015-09-15.
 */

public class ItemBrokenCamera extends ItemFU {

    public ItemBrokenCamera() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(Names.Items.brokenCamera);
    }

    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {

        EntityPlayer player = (EntityPlayer) entity;
        ItemStack boots = player.getCurrentArmor(0);

    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(EnumChatFormatting.DARK_RED + "Another incomplete ability...");
        list.add("Let everyone see what's underneath.");
    }

}

package io.github.ratismal.felineutilities.client.render;

import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Ratismal on 2015-09-16.
 */

public class PlayerRenderBase extends RenderPlayer {

    public PlayerRenderBase() {
        super();
        super.modelBipedMain.bipedLeftArm.setTextureSize(0, 0);
    }


    public static ResourceLocation getArmorResource(Entity entity, ItemStack stack, int slot, String type)
    {
        ItemArmor item = (ItemArmor)stack.getItem();
        String path = "textures/models/armor/invisible.png";
        //String s1 = String.format("textures/models/armor/%s_layer_%d%s.png",
        ResourceLocation resourcelocation = new ResourceLocation("felineutilities", path);

        return resourcelocation;
    }



}

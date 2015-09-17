package io.github.ratismal.felineutilities.Listeners;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import io.github.ratismal.felineutilities.init.ModItems;
import io.github.ratismal.felineutilities.item.ItemBrokenCamera;
import io.github.ratismal.felineutilities.util.Logger;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.event.RenderPlayerEvent;

/**
 * Created by Ratismal on 2015-09-16.
 */

public class PlayerRenderListener {

    @SubscribeEvent
    public void pre(RenderPlayerEvent.Pre event) {
        //Logger.info("Doing something");
        if (event.entityPlayer.inventory.hasItem(ModItems.brokenCamera)) {

            //Logger.info("Someone thinks they're Nao!!");
            //ModelBiped model = new ModelBiped();
            //model.bipedBody.isHidden = true;
            //model.
            //event.renderer.modelBipedMain = model;
            //event.renderer.modelArmor.boxList.clear();

            event.renderer.modelArmor.bipedBody.isHidden = true;
            event.renderer.modelArmor.bipedLeftArm.isHidden = true;
            event.renderer.modelArmor.bipedHead.isHidden = true;
            event.renderer.modelArmor.bipedHeadwear.isHidden = true;
            event.renderer.modelArmor.bipedLeftLeg.isHidden = true;
            event.renderer.modelArmor.bipedRightArm.isHidden = true;
            event.renderer.modelArmor.bipedRightLeg.isHidden = true;
            event.renderer.modelArmor.bipedCloak.isHidden = true;
            event.renderer.modelArmor.bipedEars.isHidden = true;

            event.renderer.modelArmorChestplate.bipedBody.isHidden = true;
            event.renderer.modelArmorChestplate.bipedLeftArm.isHidden = true;
            event.renderer.modelArmorChestplate.bipedHead.isHidden = true;
            event.renderer.modelArmorChestplate.bipedHeadwear.isHidden = true;
            event.renderer.modelArmorChestplate.bipedLeftLeg.isHidden = true;
            event.renderer.modelArmorChestplate.bipedRightArm.isHidden = true;
            event.renderer.modelArmorChestplate.bipedRightLeg.isHidden = true;
            event.renderer.modelArmorChestplate.bipedCloak.isHidden = true;
            event.renderer.modelArmorChestplate.bipedEars.isHidden = true;
            //event.renderer.modelArmor.bipedBody.isHidden = true;
            //event.setCanceled(true);
        } else {
            if (event.renderer.modelArmor.bipedBody.isHidden == true) {
                event.renderer.modelArmor.bipedBody.isHidden = false;
                event.renderer.modelArmor.bipedLeftArm.isHidden = false;
                event.renderer.modelArmor.bipedHead.isHidden = false;
                event.renderer.modelArmor.bipedHeadwear.isHidden = false;
                event.renderer.modelArmor.bipedLeftLeg.isHidden = false;
                event.renderer.modelArmor.bipedRightArm.isHidden = false;
                event.renderer.modelArmor.bipedRightLeg.isHidden = false;
                event.renderer.modelArmor.bipedCloak.isHidden = false;
                event.renderer.modelArmor.bipedEars.isHidden = false;

                event.renderer.modelArmorChestplate.bipedBody.isHidden = false;
                event.renderer.modelArmorChestplate.bipedLeftArm.isHidden = false;
                event.renderer.modelArmorChestplate.bipedHead.isHidden = false;
                event.renderer.modelArmorChestplate.bipedHeadwear.isHidden = false;
                event.renderer.modelArmorChestplate.bipedLeftLeg.isHidden = false;
                event.renderer.modelArmorChestplate.bipedRightArm.isHidden = false;
                event.renderer.modelArmorChestplate.bipedRightLeg.isHidden = false;
                event.renderer.modelArmorChestplate.bipedCloak.isHidden = false;
                event.renderer.modelArmorChestplate.bipedEars.isHidden = false;
            }
        }
        //event.setCanceled(true);
    }

}

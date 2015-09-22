package io.github.ratismal.felineutilities.common.core.listener;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import io.github.ratismal.felineutilities.common.init.ModItems;
import io.github.ratismal.felineutilities.common.core.util.Logger;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;

/**
 * Created by Ratismal on 2015-09-18.
 */

public class PlayerFlyableFallListener {

    @SubscribeEvent
    public void flyingPlayerFell(PlayerFlyableFallEvent event) {

        Logger.Debug.info("Flying player fell");

        if (event.entityPlayer.inventory.hasItem(ModItems.featherHeavy)) {


            double damage = event.distance * 0.5 - 1.5;
            float damagef = (float) damage;
            if (damagef >= 1f) {
                event.entityPlayer.attackEntityFrom(DamageSource.fall, damagef);
            }

        }

    }

}

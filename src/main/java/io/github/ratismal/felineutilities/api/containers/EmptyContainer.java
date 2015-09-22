package io.github.ratismal.felineutilities.api.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Created by Ratismal on 2015-09-17.
 */

public class EmptyContainer extends BaseContainer {

    public EmptyContainer(EntityPlayer player) {
        super(EmptyContainerFactory.getInstance());
    }

    @Override
    public void putStackInSlot(int index, ItemStack stack) {
    }

}

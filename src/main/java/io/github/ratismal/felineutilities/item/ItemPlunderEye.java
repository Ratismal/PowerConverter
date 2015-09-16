package io.github.ratismal.felineutilities.item;

import io.github.ratismal.felineutilities.reference.Names;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by Ratismal on 2015-09-15.
 */

public class ItemPlunderEye extends ItemFU {

    public ItemPlunderEye() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(Names.Items.plunderEye);
    }

    public void addInformation(ItemStack itemStack, List list) {
        list.add("Another broken ability...");
    }

}

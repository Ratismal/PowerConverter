package io.github.ratismal.felineutilities.api.slots;

import io.github.ratismal.felineutilities.api.tiles.BaseTileEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Ratismal on 2015-09-10.
 */
public class BaseSlot extends Slot {

    public BaseSlot(IInventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public void putStack(ItemStack stack) {
        if (inventory instanceof BaseTileEntity) {
            BaseTileEntity genericTileEntity = (BaseTileEntity) inventory;
            genericTileEntity.onSlotChanged(getSlotIndex(), stack);
        }
        super.putStack(stack);

    }
}
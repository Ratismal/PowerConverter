package io.github.ratismal.felineutilities.base.slots;

import net.minecraft.item.ItemStack;

/**
 * Created by Ratismal on 2015-09-10.
 */
public class SlotData {

    private final SlotType type;
    private final ItemStack[] itemStacks;
    private final Class itemClass;

    public SlotData(SlotType type, ItemStack... itemStacks) {

        this.type = type;
        this.itemStacks = itemStacks;
        this.itemClass = null;

    }

    public SlotData(SlotType type, Class itemClass) {

        this.type = type;
        this.itemStacks = null;
        this.itemClass = itemClass;

    }

    public boolean isMatchingItem(ItemStack item) {

        for (ItemStack itemStack : itemStacks) {

            if (itemStack.getItem() == item.getItem()) {
                return true;
            }

        }
        return false;

    }

    public boolean isMatchingClass(Object o) {

        if (o.getClass() == itemClass) return true;

        return false;
    }

    public SlotType getSlotType() { return type; }


}

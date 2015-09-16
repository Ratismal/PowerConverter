package io.github.ratismal.felineutilities.base.containers;

import io.github.ratismal.felineutilities.base.slots.BaseSlot;
import io.github.ratismal.felineutilities.base.slots.SlotData;
import io.github.ratismal.felineutilities.base.slots.SlotFactory;
import io.github.ratismal.felineutilities.base.slots.SlotType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ratismal on 2015-09-09.
 */

public class BaseContainer extends Container {

    protected Map<String, IInventory> inventories = new HashMap<String, IInventory>();
    private ContainerFactory factory;

    public BaseContainer(ContainerFactory factory) {

        this.factory = factory;

    }

    public void addInventory(String name, IInventory inventory) {
        inventories.put(name, inventory);
    }

    public IInventory getInventory(String name) {
        return inventories.get(name);
    }

    public SlotType getSlotType(int index) {
        return factory.getSlotType(index);
    }

    public void generateSlots() {
        for (SlotFactory slotFactory : factory.getSlots()) {
            IInventory inventory = inventories.get(slotFactory.getInvName());
            int index = slotFactory.getIndex();
            int x = slotFactory.getX();
            int y = slotFactory.getY();
            SlotType slotType = slotFactory.getSlotType();
            Slot slot = createSlot(slotFactory, inventory, index, x, y, slotType);
            addSlotToContainer(slot);
        }
    }

    protected Slot createSlot(SlotFactory slotFactory, final IInventory inventory, final int index, final int x, final int y, SlotType slotType) {
        Slot slot;
        if (slotType == SlotType.SLOT_SPECIFICITEM) {
            final SlotData slotData = slotFactory.getSlotData();
            slot = new Slot(inventory, index, x, y) {
                @Override
                public boolean isItemValid(ItemStack stack) {
                    return slotData.isMatchingItem(stack);
                }
            };
        } else {
            slot = new BaseSlot(inventory, index, x, y);
        }
        return slot;
    }


    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }
}

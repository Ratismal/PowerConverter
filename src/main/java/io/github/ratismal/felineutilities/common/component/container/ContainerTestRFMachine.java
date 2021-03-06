package io.github.ratismal.felineutilities.common.component.container;

import io.github.ratismal.felineutilities.api.containers.BaseContainer;
import io.github.ratismal.felineutilities.api.containers.ContainerFactory;
import io.github.ratismal.felineutilities.api.slots.SlotData;
import io.github.ratismal.felineutilities.api.slots.SlotType;
import io.github.ratismal.felineutilities.common.component.tileentity.TileTestRFMachine;
import io.github.ratismal.felineutilities.common.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTestRFMachine extends BaseContainer {

    protected TileTestRFMachine tileEntity;

    public static final String CONTAINER_INVENTORY = "container";

    //public static final ItemStack[] items = new ;

    public static final ContainerFactory factory = new ContainerFactory() {

        @Override
        protected void initializeSlots() {


            addSlotBox(new SlotData(SlotType.SLOT_SPECIFICITEM, new ItemStack(ModItems.moduleBlank)), CONTAINER_INVENTORY, 0, 64, 24, 1, 18, 1, 18);
            addSlotBox(new SlotData(SlotType.SLOT_OUTPUT), CONTAINER_INVENTORY, 1, 118, 24, 1, 18, 1, 18);

            layoutPlayerInventorySlots(10, 70);
        }

    };

    public ContainerTestRFMachine(EntityPlayer player, TileTestRFMachine tileEntity) {
        super(factory);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int i) {

        Slot slot = getSlot(i);

        if (slot != null && slot.getHasStack()) {

            ItemStack stack = slot.getStack();
            ItemStack result = stack.copy();

        }

        return null;
    }

}

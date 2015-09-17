package io.github.ratismal.felineutilities.block.testRF;

import io.github.ratismal.felineutilities.base.containers.BaseContainer;
import io.github.ratismal.felineutilities.base.containers.ContainerFactory;
import io.github.ratismal.felineutilities.base.slots.SlotData;
import io.github.ratismal.felineutilities.base.slots.SlotType;
import io.github.ratismal.felineutilities.base.tiles.BaseStorageTile;
import io.github.ratismal.felineutilities.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
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

    public ContainerTestRFMachine(EntityPlayer player, BaseStorageTile containerinventory) {
        super(factory);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }



}

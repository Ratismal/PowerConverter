package io.github.ratismal.powerconverter.base.containers;

import io.github.ratismal.powerconverter.base.slots.SlotData;
import io.github.ratismal.powerconverter.base.slots.SlotFactory;
import io.github.ratismal.powerconverter.base.slots.SlotType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ratismal on 2015-09-10.
 */
public class ContainerFactory {

    private Map<Integer, SlotData> indexToType = new HashMap<Integer, SlotData>();
    private List<SlotFactory> slots = new ArrayList<SlotFactory>();

    public static final String CONTAINER_PLAYER = "player";

    public ContainerFactory() {

        initializeSlots();

    }

    public void initializeSlots() {

    }

    public void addSlot(SlotData slotData, String name, int index, int x, int y) {

        SlotFactory slotFactory = new SlotFactory(slotData, name, index, x, y);
        int slotsIndex = slots.size();
        slots.add(slotFactory);
        indexToType.put(slotsIndex, slotData);

    }

    public SlotType getSlotType(int index) {

        SlotData slotData = indexToType.get(index);

        if (slotData != null) {
            return slotData.getSlotType();
        }

        return SlotType.SLOT_UNKNOWN;

    }

    public Iterable<SlotFactory> getSlots() {
        return slots;
    }

    public int addSlotRange(SlotData slotData, String inventoryName, int index, int x, int y, int amount, int dx) {
        for (int i = 0 ; i < amount ; i++) {
            addSlot(slotData, inventoryName, index, x, y);
            x += dx;
            index++;
        }
        return index;
    }

    public int addSlotBox(SlotData slotData, String inventoryName, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0 ; j < verAmount ; j++) {
            index = addSlotRange(slotData, inventoryName, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }

    protected void layoutPlayerInventorySlots(int leftCol, int topRow) {
        // Player inventory
        addSlotBox(new SlotData(SlotType.SLOT_PLAYERINV), CONTAINER_PLAYER, 9, leftCol, topRow, 9, 18, 3, 18);

        // Hotbar
        topRow += 58;
        addSlotRange(new SlotData(SlotType.SLOT_PLAYERHOTBAR), CONTAINER_PLAYER, 0, leftCol, topRow, 9, 18);

    }

}

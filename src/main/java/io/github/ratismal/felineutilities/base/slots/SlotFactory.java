package io.github.ratismal.felineutilities.base.slots;

/**
 * Created by Ratismal on 2015-09-10.
 */
public class SlotFactory {

    private final SlotData slotData;
    private final int index;
    private final int y;
    private final int x;
    private final String name;

    public SlotFactory(SlotData slotData, String name, int index, int x, int y) {

        this.slotData = slotData;
        this.name = name;
        this.index = index;
        this.x = x;
        this.y = y;

    }

    public SlotData getSlotData() { return slotData; }

    public SlotType getSlotType() { return slotData.getSlotType(); }

    public String getInvName() { return name; }

    public int getIndex() { return index; }

    public int getX() { return x; }

    public int getY() { return y; }

}

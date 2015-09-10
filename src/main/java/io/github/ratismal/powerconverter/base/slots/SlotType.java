package io.github.ratismal.powerconverter.base.slots;

/**
 * Created by Ratismal on 2015-09-10.
 */
public enum SlotType {

    SLOT_UNKNOWN,
    SLOT_INPUT,             // Inventory slot that can accept items in sided inventories
    SLOT_OUTPUT,            // Inventory slot that can output items in sided inventories
    SLOT_CONTAINER,         // Inventory slot that cannot accept nor output items in sided inventories
    SLOT_SPECIFICITEM,      // Only a specific item fits in this slot
    SLOT_PLAYERINV,         // Player inventory slot
    SLOT_PLAYERHOTBAR,      // Player hotbar slot
    SLOT_CRAFTRESULT,       // Crafting result

}

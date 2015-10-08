package io.github.ratismal.felineutilities.common.init;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.ratismal.felineutilities.common.item.*;
import io.github.ratismal.felineutilities.common.lib.RefName;

public class ModItems {

	public static final ItemFU moduleTest = new ItemModuleBlank();
	public static final ItemFU moduleBlank = new ItemBlankModule();
    public static final ItemFU eyePlunder = new ItemEyePlunder();
    public static final ItemFU cameraBroken = new ItemCameraBroken();
    public static final ItemFU featherHeavy = new ItemFeatherHeavy();
    public static final ItemFU pillowTransient = new ItemPillowTransient();
    public static final ItemFU bowPlain = new ItemBowPlain();
    public static final ItemFU guide = new ItemGuide();

	public static void init() {

		/**
		 * Registering Items
		 */
		GameRegistry.registerItem(moduleTest, RefName.Items.testModule);
		GameRegistry.registerItem(moduleBlank, RefName.Items.moduleBlank);
        GameRegistry.registerItem(eyePlunder, RefName.Items.eyePlunder);
        GameRegistry.registerItem(cameraBroken, RefName.Items.cameraBroken);
        GameRegistry.registerItem(featherHeavy, RefName.Items.featherHeavy);
        GameRegistry.registerItem(pillowTransient, RefName.Items.pillowTransient);
        GameRegistry.registerItem(bowPlain, RefName.Items.bowPlain);
        GameRegistry.registerItem(guide, RefName.Items.guide);

	}

}

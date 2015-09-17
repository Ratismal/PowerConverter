package io.github.ratismal.felineutilities.init;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.ratismal.felineutilities.item.*;
import io.github.ratismal.felineutilities.reference.Names;

public class ModItems {

	public static final ItemFU moduleTest = new ItemModuleBlank();
	public static final ItemFU moduleBlank = new ItemBlankModule();
    public static final ItemFU eyePlunder = new ItemEyePlunder();
    public static final ItemFU cameraBroken = new ItemCameraBroken();
    public static final ItemFU featherHeavy = new ItemFeatherHeavy();
    public static final ItemFU pillowTransient = new ItemPillowTransient();

	public static void init() {

		/**
		 * Registering Items
		 */
		GameRegistry.registerItem(moduleTest, Names.Items.testModule);
		GameRegistry.registerItem(moduleBlank, Names.Items.moduleBlank);
        GameRegistry.registerItem(eyePlunder, Names.Items.eyePlunder);
        GameRegistry.registerItem(cameraBroken, Names.Items.cameraBroken);
        GameRegistry.registerItem(featherHeavy, Names.Items.featherHeavy);
        GameRegistry.registerItem(pillowTransient, Names.Items.pillowTransient);

	}

}

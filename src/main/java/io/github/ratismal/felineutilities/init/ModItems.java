package io.github.ratismal.felineutilities.init;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.ratismal.felineutilities.item.ItemBlankModule;
import io.github.ratismal.felineutilities.item.ItemFU;
import io.github.ratismal.felineutilities.item.ItemPlunderEye;
import io.github.ratismal.felineutilities.item.ItemTestModule;
import io.github.ratismal.felineutilities.reference.Names;

public class ModItems {

	public static final ItemFU testModule = new ItemTestModule();
	public static final ItemFU blankModule = new ItemBlankModule();
    public static final ItemFU plunderEye = new ItemPlunderEye();

	public static void init() {

		/**
		 * Registering Items
		 */
		GameRegistry.registerItem(testModule, Names.Items.testModule);
		GameRegistry.registerItem(blankModule, Names.Items.blankModule);
        GameRegistry.registerItem(plunderEye, Names.Items.plunderEye);

	}

}

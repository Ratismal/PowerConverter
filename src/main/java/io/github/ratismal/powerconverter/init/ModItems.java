package io.github.ratismal.powerconverter.init;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.ratismal.powerconverter.item.ItemBlankModule;
import io.github.ratismal.powerconverter.item.ItemPC;
import io.github.ratismal.powerconverter.item.ItemTestModule;
import io.github.ratismal.powerconverter.reference.Names;

public class ModItems {

	public static final ItemPC testModule = new ItemTestModule();
	public static final ItemPC blankModule = new ItemBlankModule();

	public static void init() {

		/**
		 * Registering Items
		 */
		GameRegistry.registerItem(testModule, Names.testModule);
		GameRegistry.registerItem(blankModule, Names.blankModule);

	}

}

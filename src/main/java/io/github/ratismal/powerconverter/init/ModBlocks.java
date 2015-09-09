package io.github.ratismal.powerconverter.init;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.ratismal.powerconverter.block.BaseBlock;
import io.github.ratismal.powerconverter.machines.test.BlockTestMachine;
import io.github.ratismal.powerconverter.machines.test.TileTestMachine;
import io.github.ratismal.powerconverter.reference.Names;

public class ModBlocks {

	public static BlockTestMachine testMachine;

	public static void init() {
		testMachine = new BlockTestMachine();
		GameRegistry.registerBlock(testMachine, Names.testMachine);
	}

}

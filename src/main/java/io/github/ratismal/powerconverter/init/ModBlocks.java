package io.github.ratismal.powerconverter.init;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.ratismal.powerconverter.block.BlockPC;
import io.github.ratismal.powerconverter.block.BlockTestMachine;
import io.github.ratismal.powerconverter.reference.Names;

public class ModBlocks {

	public static final BlockPC testMachine = new BlockTestMachine();

	public static void init() {
		GameRegistry.registerBlock(testMachine, Names.testMachine);
	}

}

package io.github.ratismal.powerconverter.init;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.ratismal.powerconverter.block.testRF.BlockTestRFMachine;
import io.github.ratismal.powerconverter.reference.Names;

public class ModBlocks {

	public static BlockTestRFMachine testMachineRF;

	public static void init() {
		testMachineRF = new BlockTestRFMachine();
		GameRegistry.registerBlock(testMachineRF, Names.testMachineRF);
	}

}

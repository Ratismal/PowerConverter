package io.github.ratismal.felineutilities.init;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.ratismal.felineutilities.block.testRF.BlockTestRFMachine;
import io.github.ratismal.felineutilities.reference.Names;

public class ModBlocks {

	public static BlockTestRFMachine testMachineRF;

	public static void init() {
		testMachineRF = new BlockTestRFMachine();
		GameRegistry.registerBlock(testMachineRF, Names.Blocks.testMachineRF);
	}

}

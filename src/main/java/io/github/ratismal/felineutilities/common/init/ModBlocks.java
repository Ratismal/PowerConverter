package io.github.ratismal.felineutilities.common.init;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.ratismal.felineutilities.common.component.block.BlockTestRFMachine;
import io.github.ratismal.felineutilities.common.lib.RefName;

public class ModBlocks {

	public static BlockTestRFMachine testMachineRF;

	public static void init() {
		testMachineRF = new BlockTestRFMachine();
		GameRegistry.registerBlock(testMachineRF, RefName.Blocks.testMachineRF);
	}

}

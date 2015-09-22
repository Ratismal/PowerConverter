package io.github.ratismal.felineutilities.common.lib;

public class RefName {


	public static final class Items {
        public static final String testModule = "moduleTest";
        public static final String moduleBlank = "moduleBlank";
        public static final String eyePlunder = "eyePlunder";
        public static final String cameraBroken = "cameraBroken";
        public static final String featherHeavy = "featherHeavy";
        public static final String pillowTransient = "pillowTransient";
        public static final String bowPlain = "bowPlain";
        public static final String guide = "guide";
    }

    public static final class Blocks {
        public static final String testMachineRF = "testMachineRF";
    }

	public static final class NBT {

		public static final String direction = "teDirection";

	}

    public static final class Containers {
        public static final String REFERENCE_CONTAINER = "container.felineutilities";
        public static final String VANILLA_INVENTORY = "container.inventory";
        public static final String TEST_RF_MACHINE = REFERENCE_CONTAINER + Blocks.testMachineRF;

    }
}

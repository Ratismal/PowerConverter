package io.github.ratismal.felineutilities.common.core.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import io.github.ratismal.felineutilities.common.lib.RefInfo;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

	private static int rfValue;
	private static int euValue;
	private static boolean rfEnabled;
	private static boolean euEnabled;
    private static boolean isDebug;

	//Machines
	private static int testMachineCapacityRF;
	private static int testMachineReceiveRF;


	public static Configuration config;

	public static void init(File configFile) {

		//create config file
		if (config == null) {
			config = new Configuration(configFile);
			loadConfig();
		}


	}

	@SubscribeEvent
	public void onConfigChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event) {

		if (event.modID.equalsIgnoreCase(RefInfo.MODID)) {

			loadConfig();

		}

	}

	private static void loadConfig() {


		//read properties
		//GENERAL
		rfEnabled = config.get(Configuration.CATEGORY_GENERAL, "rfEnabled", true, "Is RF conversion enabled").getBoolean();
		euEnabled = config.get(Configuration.CATEGORY_GENERAL, "euEnabled", true, "Is EU conversion enabled").getBoolean();
        isDebug = config.get(Configuration.CATEGORY_GENERAL, "isDebug", false, "If true, send debug messages to console").getBoolean();

		//CONVERSION
		rfValue = config.get("Conversion", "rfValue", 100, "How much 1 RF is worth in CATs").getInt(100);
		euValue = config.get("Conversion", "euValue", 25, "How much 1 EU is worth in CATs").getInt(25);

		//Machines
		testMachineCapacityRF = config.get("TestMachineCapacityRF", "Machines", 1000000,
				"How much a Test Machine can hold (RF)").getInt(1000000);
		testMachineReceiveRF = config.get("TestMachineReceiveRF", "Machines", 1000000,
				"How much a Test Machine can receive per tick (RF)").getInt(1000000);

		if (config.hasChanged()) {

			config.save();

		}

	}

	public static int getTestMachineCapacityRF() {
		return testMachineCapacityRF;
	}

	public static int getTestMachineReceiveRF() {
		return testMachineReceiveRF;
	}

    public static int getRFValue() { return rfValue;}

    public static int getEUValue() { return euValue;}

    public static boolean isIsDebug() { return isDebug; }

}

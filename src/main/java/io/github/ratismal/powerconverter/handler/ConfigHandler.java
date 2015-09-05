package io.github.ratismal.powerconverter.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import io.github.ratismal.powerconverter.reference.Reference;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

	private static int rfValue;
	private static int euValue;
	private static boolean rfEnabled;
	private static boolean euEnabled;

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

		if (event.modID.equalsIgnoreCase(Reference.MODID)) {

			loadConfig();

		}

	}

	private static void loadConfig() {


		//read properties
		//GENERAL
		rfEnabled = config.get(Configuration.CATEGORY_GENERAL, "rfEnabled", true, "Is RF conversion enabled").getBoolean(true);
		euEnabled = config.get(Configuration.CATEGORY_GENERAL, "euEnabled", true, "Is EU conversion enabled").getBoolean(true);

		//CONVERSION
		rfValue = config.get("Conversion", "rfValue", 100, "How much 1 RF is worth in CATs").getInt(100);
		euValue = config.get("Conversion", "euValue", 25, "How much 1 EU is worth in CATs").getInt(25);

		if (config.hasChanged()) {

			config.save();

		}

	}

}

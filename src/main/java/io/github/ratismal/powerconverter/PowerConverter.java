package io.github.ratismal.powerconverter;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

/**
 * PowerConverter Mod
 * - By Ratismal
 */

@Mod(modid = PowerConverter.MODID, name = PowerConverter.NAME, version = PowerConverter.VERSION)
public class PowerConverter {
	public static final String MODID = "PowerConverter";
	public static final String VERSION = "1.7.10-1.0";
	public static final String NAME = "PowerConverter";

	@Mod.Instance(MODID)
	public static PowerConverter instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}

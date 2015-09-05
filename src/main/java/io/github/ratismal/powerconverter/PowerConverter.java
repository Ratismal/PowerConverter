package io.github.ratismal.powerconverter;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import io.github.ratismal.powerconverter.handler.ConfigHandler;
import io.github.ratismal.powerconverter.init.ModBlocks;
import io.github.ratismal.powerconverter.init.ModItems;
import io.github.ratismal.powerconverter.proxy.IProxy;
import io.github.ratismal.powerconverter.reference.Reference;
import io.github.ratismal.powerconverter.util.Logger;


/**
 * PowerConverter Mod
 * - By Ratismal
 */

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class PowerConverter {

	@Mod.Instance(Reference.MODID)
	public static PowerConverter instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,
			serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigHandler());

		ModItems.init();
		ModBlocks.init();

		Logger.info("Pre-Init Complete");

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		Logger.info("Init Complete");

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		Logger.info("Post-Init Complete");

	}
}

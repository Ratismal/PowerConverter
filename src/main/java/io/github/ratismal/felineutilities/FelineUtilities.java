package io.github.ratismal.felineutilities;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import io.github.ratismal.felineutilities.handler.ConfigHandler;
import io.github.ratismal.felineutilities.init.ModBlocks;
import io.github.ratismal.felineutilities.init.ModItems;
import io.github.ratismal.felineutilities.proxy.IProxy;
import io.github.ratismal.felineutilities.reference.Reference;
import io.github.ratismal.felineutilities.util.Logger;


/**
 * FelineUtilities Mod
 * - By Ratismal
 */

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class FelineUtilities {

	@Mod.Instance(Reference.MODID)
	public static FelineUtilities instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,
			serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigHandler());

		ModItems.init();
		ModBlocks.init();
        FMLInterModComms.sendMessage("Waila", "register", "io.github.ratismal.felineutilities.waila.WailaSupport.load");
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

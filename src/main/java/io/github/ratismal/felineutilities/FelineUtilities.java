package io.github.ratismal.felineutilities;

import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import io.github.ratismal.felineutilities.common.core.proxy.IProxy;
import io.github.ratismal.felineutilities.common.lib.RefInfo;
import io.github.ratismal.felineutilities.common.core.util.Logger;


/**
 * FelineUtilities RefInfo
 * - By Ratismal
 */

@cpw.mods.fml.common.Mod(modid = RefInfo.MODID, name = RefInfo.NAME, version = RefInfo.VERSION, guiFactory = RefInfo.GUI_FACTORY_CLASS)
public class FelineUtilities {

    private static int modGuiIndex = 0;

    public static final int GUI_BASE_BLOCK = modGuiIndex++;
    public static final int GUI_TEST_MACHINE_RF = modGuiIndex++;

	@cpw.mods.fml.common.Mod.Instance(RefInfo.MODID)
	public static FelineUtilities instance;

	@SidedProxy(clientSide = RefInfo.CLIENT_PROXY_CLASS,
			serverSide = RefInfo.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {


        proxy.preInit(event);


		Logger.info("Pre-Init Complete");

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
        proxy.init(event);
       // EntityRegistry.registerModEntity(EntityEyePlunder.class, "Plunder Eye Item", 5, FelineUtilities.instance, 32, 5, true);
        //FMLCommonHandler.instance().bus().register(new PlayerRenderListener());
		Logger.info("Init Complete");

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
		Logger.info("Post-Init Complete");

	}
}

package io.github.ratismal.felineutilities.common.core.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import io.github.ratismal.felineutilities.FelineUtilities;
import io.github.ratismal.felineutilities.common.core.listener.PlayerFlyableFallListener;
import io.github.ratismal.felineutilities.common.core.listener.PlayerRenderListener;
import io.github.ratismal.felineutilities.api.gui.GuiProxy;
import io.github.ratismal.felineutilities.common.component.tileentity.TileTestRFMachine;
import io.github.ratismal.felineutilities.common.core.handler.ConfigHandler;
import io.github.ratismal.felineutilities.common.init.ModBlocks;
import io.github.ratismal.felineutilities.common.init.ModItems;
import io.github.ratismal.felineutilities.common.init.Whitelist;
import net.minecraftforge.common.MinecraftForge;

public abstract class CommonProxy implements IProxy {


    @Override
    public void preInit(FMLPreInitializationEvent event) {
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
        ModItems.init();
        ModBlocks.init();
        registerTileEntities();

        Whitelist.init();
        FMLInterModComms.sendMessage("Waila", "register", "io.github.ratismal.felineutilities.common.core.waila.WailaSupport.load");
    }

    @Override
    public void init(FMLInitializationEvent event) {

        NetworkRegistry.INSTANCE.registerGuiHandler(FelineUtilities.instance, new GuiProxy());
        registerEventListeners();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileTestRFMachine.class, "TileTestRFMachine");
    }

    public void registerEventListeners() {
        MinecraftForge.EVENT_BUS.register(new PlayerRenderListener());
        MinecraftForge.EVENT_BUS.register(new PlayerFlyableFallListener());

    }
}

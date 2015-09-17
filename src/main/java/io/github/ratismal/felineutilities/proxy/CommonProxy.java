package io.github.ratismal.felineutilities.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import io.github.ratismal.felineutilities.Listeners.PlayerRenderListener;
import io.github.ratismal.felineutilities.handler.ConfigHandler;
import io.github.ratismal.felineutilities.init.ModBlocks;
import io.github.ratismal.felineutilities.init.ModItems;
import io.github.ratismal.felineutilities.init.Whitelist;
import net.minecraftforge.common.MinecraftForge;

public abstract class CommonProxy implements IProxy {


    @Override
    public void preInit(FMLPreInitializationEvent event) {
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
        ModItems.init();
        ModBlocks.init();
        Whitelist.init();
        FMLInterModComms.sendMessage("Waila", "register", "io.github.ratismal.felineutilities.waila.WailaSupport.load");
    }

    @Override
    public void init(FMLInitializationEvent event) {
        registerEventListeners();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerEventListeners() {
        MinecraftForge.EVENT_BUS.register(new PlayerRenderListener());

    }
}

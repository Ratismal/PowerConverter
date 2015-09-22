package io.github.ratismal.felineutilities.client.core.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import io.github.ratismal.felineutilities.client.render.RenderEyePlunder;
import io.github.ratismal.felineutilities.common.entity.EntityEyePlunder;
import io.github.ratismal.felineutilities.common.core.proxy.CommonProxy;

public class ClientProxy extends CommonProxy {


    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        registerRendering();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);

    }

    public void registerRendering() {

        RenderingRegistry.registerEntityRenderingHandler(EntityEyePlunder.class, new RenderEyePlunder());


    }
}

package io.github.ratismal.felineutilities.init;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import io.github.ratismal.felineutilities.client.render.PlayerRenderBase;
import io.github.ratismal.felineutilities.item.*;
import io.github.ratismal.felineutilities.reference.Names;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.player.EntityPlayer;

public class ModItems {

	public static final ItemFU testModule = new ItemTestModule();
	public static final ItemFU blankModule = new ItemBlankModule();
    public static final ItemFU plunderEye = new ItemPlunderEye();
    public static final ItemFU brokenCamera = new ItemBrokenCamera();

	public static void init() {

		/**
		 * Registering Items
		 */
		GameRegistry.registerItem(testModule, Names.Items.testModule);
		GameRegistry.registerItem(blankModule, Names.Items.blankModule);
        GameRegistry.registerItem(plunderEye, Names.Items.plunderEye);
        GameRegistry.registerItem(brokenCamera, Names.Items.brokenCamera);

	}

}

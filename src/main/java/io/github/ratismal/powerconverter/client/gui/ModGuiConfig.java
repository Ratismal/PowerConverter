package io.github.ratismal.powerconverter.client.gui;

import cpw.mods.fml.client.config.GuiConfig;
import io.github.ratismal.powerconverter.handler.ConfigHandler;
import io.github.ratismal.powerconverter.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

import net.minecraftforge.common.config.Configuration;
public class ModGuiConfig extends GuiConfig {

	public ModGuiConfig(GuiScreen guiScreen) {

		super(guiScreen,
				new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
				Reference.MODID,
				false,
				false,
				GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString())
				);

	}

}

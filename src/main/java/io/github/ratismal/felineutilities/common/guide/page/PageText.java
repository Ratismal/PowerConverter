package io.github.ratismal.felineutilities.common.guide.page;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.ratismal.felineutilities.api.guide.GuidePage;
import io.github.ratismal.felineutilities.client.gui.guide.IGuiGuideEntry;

/**
 * Created by Ratismal on 2015-09-22.
 */

public class PageText extends GuidePage {

    public PageText(String unlocalizedName) {
        super(unlocalizedName);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderScreen(IGuiGuideEntry gui, int mx, int my) {

        int width = gui.getWidth() - 30;
        int x = gui.getLeft() + 16;
        int y = gui.getTop() + 2;

        renderText(x, y, width, gui.getHeight(), getUnlocalizedName());

    }

    public void renderText(int x, int y, int width, int height, String unlocalizedText) {
        renderText(x, y, width, height, 10, unlocalizedText);
    }

    @SideOnly(Side.CLIENT)
    public void renderText(int x, int y, int width, int height, int paragraphSize, String unlocalizedText) {

    }



}

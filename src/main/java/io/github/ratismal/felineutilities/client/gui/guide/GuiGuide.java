package io.github.ratismal.felineutilities.client.gui.guide;

import io.github.ratismal.felineutilities.api.guide.Guide;
import io.github.ratismal.felineutilities.api.guide.GuideCategory;
import io.github.ratismal.felineutilities.client.gui.guide.button.GuiButtonCategory;
import io.github.ratismal.felineutilities.client.lib.RefResource;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ratismal on 2015-09-22.
 */

public class GuiGuide extends GuiScreen {

    public static final ResourceLocation texture = new ResourceLocation(RefResource.GUIDE.GUI_GUIDE);

    //Categories
    List<GuideCategory> categories;

    int guiWidth = 146;
    int guiHeight = 180;
    int left,top;

    @Override
    public final void initGui() {
        super.initGui();

        categories = Guide.getCategories();
        Collections.sort(categories);

        buttonList.clear();
        int categoriesSize = categories.size();
        for (int i = 0; i < categoriesSize; i++) {
            GuideCategory category = null;
            category = i >= categoriesSize ? null : categories.get(i);

            int x = i % 4;
            int y = i / 4;

            int size = 27;

            GuiButtonCategory button = new GuiButtonCategory(i, left + 18 + x, top + 37 + y, category);
            buttonList.add(button);
        }
    }

    @Override
    public void drawScreen(int par1, int par2, float par3) {


        GL11.glColor4f(1F, 1F, 1F, 1F);
        mc.renderEngine.bindTexture(texture);
        drawTexturedModalRect(left, top, 0, 0, guiWidth, guiHeight);

        super.drawScreen(par1, par2, par3);

    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }



}

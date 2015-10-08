package io.github.ratismal.felineutilities.client.gui.guide;

import io.github.ratismal.felineutilities.api.guide.Guide;
import io.github.ratismal.felineutilities.api.guide.GuideCategory;
import io.github.ratismal.felineutilities.client.gui.guide.button.GuiButtonCategory;
import io.github.ratismal.felineutilities.client.gui.guide.button.GuiButtonEntry;
import io.github.ratismal.felineutilities.client.lib.RefResource;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ratismal on 2015-09-22.
 */

public class GuiGuide extends GuiScreen {

    public static GuiGuide currentOpenGuide = new GuiGuide();

    public static final ResourceLocation texture = new ResourceLocation(RefResource.GUIDE.GUI_GUIDE);

    //Categories
    List<GuideCategory> categories;

    int guiWidth = 146;
    int guiHeight = 180;
    int left, top;

    @Override
    public final void initGui() {
        super.initGui();
        onInitGui();
    }

    public void onInitGui() {

        categories = Guide.getCategories();
        Collections.sort(categories);

        buttonList.clear();
        currentOpenGuide = this;

        left = width / 2 - guiWidth / 2;
        top = height / 2 - guiHeight / 2;
        if (isCategoryList()) {
            int categoriesSize = categories.size();

            for (int i = 0; i < categoriesSize; i++) {
                GuideCategory category = null;
                category = i >= categoriesSize ? null : categories.get(i);
                System.out.println(category.getUnlocalizedName());
                int x = i % 4;
                int y = i / 4;

                int size = 27;

                GuiButtonCategory button = new GuiButtonCategory(i, left + 18 + x * size, top + 37 + y * size, category);
                buttonList.add(button);
            }
        }
        if (isEntryList()) {
            int x = 18;
            for (int i = 0; i < 12; i++) {
                int y = 16 + i * 12;
                buttonList.add(new GuiButtonEntry(i, left + x, top + y, 110, 10, ""));
            }
            populateIndex();
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

    @Override
    protected void actionPerformed(GuiButton button) {

        if (button instanceof GuiButtonCategory) {
            button = (GuiButtonCategory) button;
            GuideCategory category = ((GuiButtonCategory) button).getCategory();
            mc.displayGuiScreen(new GuiCategory(category));
        }
    }

    void populateIndex() {
        List<GuideCategory> categoryList = Guide.getCategories();
        int shift = 2;
        for (int i = shift; i < 12; i++) {
            int i_ = i - shift;
            GuiButtonEntry button = (GuiButtonEntry) buttonList.get(i);
            GuideCategory category = i_ >= categoryList.size() ? null : categoryList.get(i_);

            button.displayString = StatCollector.translateToLocal(category.getUnlocalizedName());

        }
    }

    boolean isCategoryList() {
        return true;
    }

    boolean isEntryList() {
        return false;
    }


}

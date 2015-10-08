package io.github.ratismal.felineutilities.api.guide;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.ratismal.felineutilities.client.gui.guide.IGuiGuideEntry;
import io.github.ratismal.felineutilities.client.gui.guide.button.GuiButtonCategory;
import net.minecraft.client.gui.GuiButton;

/**
 * Created by Ratismal on 2015-09-22.
 */

public abstract class GuidePage {

    public String unlocalizedName;
    public boolean skipRegistry;

    public GuidePage(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
    }

    @SideOnly(Side.CLIENT)
    public abstract void renderScreen(IGuiGuideEntry gui, int mx, int my);

    @SideOnly(Side.CLIENT)
    public void updateScreen() {}

    @SideOnly(Side.CLIENT)
    public void updateScreen(IGuiGuideEntry gui) {}

    @SideOnly(Side.CLIENT)
    public void onOpened(IGuiGuideEntry gui) {}

    @SideOnly(Side.CLIENT)
    public void onClosed(IGuiGuideEntry gui) {}

    @SideOnly(Side.CLIENT)
    public void onActionPerformed(IGuiGuideEntry gui, GuiButton button) {}

    @SideOnly(Side.CLIENT)
    public void onKeyPressed(char c, int index) {}

    @SideOnly(Side.CLIENT)
    public void onPageAdded(GuideEntry entry, int index) {}

    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    public GuidePage setSkipRegistry() {
        skipRegistry = true;
        return this;
    }

}

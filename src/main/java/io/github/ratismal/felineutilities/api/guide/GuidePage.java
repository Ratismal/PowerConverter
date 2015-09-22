package io.github.ratismal.felineutilities.api.guide;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.ratismal.felineutilities.client.gui.guide.IGuiGuideEntry;

/**
 * Created by Ratismal on 2015-09-22.
 */

public abstract class GuidePage {

    public String unlocalizedName;

    @SideOnly(Side.CLIENT)
    public void renderScreen(IGuiGuideEntry gui, int mx, int my) {

    }


    public GuidePage(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
    }

    public String getUnlocalizedName() {
        return unlocalizedName;
    }



}

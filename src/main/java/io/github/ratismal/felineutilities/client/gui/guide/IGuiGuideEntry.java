package io.github.ratismal.felineutilities.client.gui.guide;

import io.github.ratismal.felineutilities.api.guide.GuideEntry;

/**
 * Created by Ratismal on 2015-09-22.
 */

public interface IGuiGuideEntry {

    public GuideEntry getEntry();

    public int getPageOn();

    public int getLeft();

    public int getRight();

    public int getTop();

    public int getWidth();

    public int getHeight();

    public float getZLevel();

}

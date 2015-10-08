package io.github.ratismal.felineutilities.client.gui.guide;

import io.github.ratismal.felineutilities.api.guide.Guide;
import io.github.ratismal.felineutilities.api.guide.GuideCategory;
import io.github.ratismal.felineutilities.api.guide.GuideEntry;
import io.github.ratismal.felineutilities.client.gui.guide.button.GuiButtonBack;
import io.github.ratismal.felineutilities.client.gui.guide.button.GuiButtonEntry;
import io.github.ratismal.felineutilities.client.gui.guide.button.GuiButtonPage;
import io.github.ratismal.felineutilities.common.core.util.Logger;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ratismal on 2015-09-22.
 */

public class GuiCategory extends GuiGuide {

    GuideCategory category;
    GuiGuide parent;
    int page = 0;
    String title;

    GuiButton backButton, nextButton, prevButton;

    List<GuideEntry> queuedEntries = new ArrayList();

    public GuiCategory(GuideCategory category) {
        this.category = category;
        parent = new GuiGuide();
        setTitle();
    }

    public void setTitle() {
        title = category.getUnlocalizedName();
    }

    @Override
    public void onInitGui() {
        super.onInitGui();

        buttonList.add(backButton = new GuiButtonBack(12, left + guiWidth / 2 - 8, top + guiHeight + 2));
        buttonList.add(prevButton = new GuiButtonPage(13, left, top + guiHeight - 10, false));
        buttonList.add(nextButton = new GuiButtonPage(14, left + guiWidth - 18, top + guiHeight - 10, true));
        updatePageButton();
        update();
    }

    void update() {
        getEntries();
        addButtons();
    }

    void getEntries() {
        queuedEntries.clear();
        for (GuideEntry entry : category == null ? Guide.getEntries() : category.entries) {
            queuedEntries.add(entry);
        }
        Collections.sort(queuedEntries);

    }

    void addButtons() {
        for (int i = page * 12; i < (page + 1) * 12; i++) {
            GuiButtonEntry button = (GuiButtonEntry) buttonList.get(i - page * 12);
            GuideEntry entry = i >= queuedEntries.size() ? null : queuedEntries.get(i);
            if (entry != null) {
                button.displayString = StatCollector.translateToLocal(entry.getUnlocalizedName());
                button.displayStack = entry.getIcon();
            } else button.displayString = "";
        }
    }

    @Override
    public void drawScreen(int par1, int par2, float par3) {

        super.drawScreen(par1, par2, par3);

    }

    @Override
    boolean isCategoryList() {
        return false;
    }

    @Override
    boolean isEntryList() {
        return true;
    }

    @Override
    protected void mouseClicked(int par1, int par2, int par3) {
        super.mouseClicked(par1, par2, par3);
        switch (par3) {
            case 1:
                if (backButton.enabled) {
                    actionPerformed(backButton);
                }
                break;
            case 3:
                if (nextButton.enabled) {
                    actionPerformed(nextButton);
                }
                break;
            case 4:
                if (prevButton.enabled) {
                    actionPerformed(prevButton);
                }
                break;
        }
    }

    @Override
    protected void actionPerformed(GuiButton button) {

        switch (button.id) {
            case 12:
                mc.displayGuiScreen(parent);
                break;
            case 13:

                if (page > 0) {
                    page--;
                }
                update();
                break;
            case 14:
                int maxPage = queuedEntries.size() / 12;
                if (page < maxPage) {
                    page++;
                }
                update();
                break;
            default:
                int index = button.id + page * 12;
                openEntry(index);
        }
    }

    public void updatePageButton() {
        prevButton.enabled = page != 0;
        nextButton.enabled = page < queuedEntries.size() / 12 ;
    }

    void openEntry(int index) {
        if(index >= queuedEntries.size())
            return;

        GuideEntry entry = queuedEntries.get(index);
        mc.displayGuiScreen(new GuiEntry(entry, this));
    }

}

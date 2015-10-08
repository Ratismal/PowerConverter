package io.github.ratismal.felineutilities.client.gui.guide;

import io.github.ratismal.felineutilities.api.guide.GuideEntry;
import io.github.ratismal.felineutilities.api.guide.GuidePage;
import io.github.ratismal.felineutilities.client.gui.guide.button.GuiButtonBack;
import io.github.ratismal.felineutilities.client.gui.guide.button.GuiButtonPage;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

/**
 * Created by Ratismal on 2015-10-01.
 */

public class GuiEntry extends GuiGuide implements IGuiGuideEntry{

    public int page = 0;

    GuiScreen parent;
    GuideEntry entry;
    String title;
    //String subtitle;

    GuiButton nextButton, prevButton, backButton;

    public GuiEntry() {
        parent = new GuiGuide();
        setTitle();
    }

    public GuiEntry(GuideEntry entry, GuiScreen parent) {
        this.parent = parent;
        this.entry = entry;
        setTitle();
    }

    public void setTitle() {
        if(entry == null) {
            title = "(null)";
            return;
        }
        title = StatCollector.translateToLocal(entry.getUnlocalizedName());
    }

    @Override
    public void onInitGui() {
        super.onInitGui();

        buttonList.add(backButton = new GuiButtonBack(0, left + guiWidth / 2 - 8, top + guiHeight + 2));
        buttonList.add(prevButton = new GuiButtonPage(1, left, top + guiHeight - 10, false));
        buttonList.add(nextButton = new GuiButtonPage(2, left + guiWidth - 18, top + guiHeight - 10, true));
        updatePageButton();

    }

    String getTitle() {
        return String.format("%s " + EnumChatFormatting.ITALIC + "(%s/%s)", title, page + 1, entry.pages.size());
    }

    @Override
    protected void actionPerformed(GuiButton button) {

        System.out.println(page);
        GuidePage currentPage = entry.pages.get(page);
        GuidePage newPage;

        switch(button.id) {
            case 0:
                currentPage.onClosed(this);
                mc.displayGuiScreen(parent);
                break;
            case 1:
                currentPage.onClosed(this);
                if (page > 0) {
                    page--;
                }
                newPage = entry.pages.get(page);
                newPage.onOpened(this);
                break;
            case 2:
                currentPage.onClosed(this);
                int maxPage = entry.pages.size() - 1;
                if (page < maxPage) {
                    page++;
                }
                newPage = entry.pages.get(page);
                newPage.onOpened(this);
                break;
        }
        System.out.println(page);

        updatePageButton();
        currentPage.onActionPerformed(this, button);
    }

    @Override
    public void drawScreen(int par1, int par2, float par3) {
        super.drawScreen(par1, par2, par3);

        GuidePage page = entry.pages.get(this.page);
        page.renderScreen(this, par1, par2);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();

        GuidePage page = entry.pages.get(this.page);
        page.updateScreen(this);
    }

    public void updatePageButton() {
        prevButton.enabled = page != 0;
        nextButton.enabled = page + 1 < entry.pages.size();
    }

    @Override
    public GuideEntry getEntry() {
        return entry;
    }

    @Override
    public int getPageOn() {
        return page;
    }

    @Override
    public int getLeft() {
        return left;
    }

    @Override
    public int getTop() {
        return top;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public float getZLevel() {
        return zLevel;
    }

    @Override
    boolean isCategoryList() {
        return false;
    }

    @Override
    boolean isEntryList() {
        return false;
    }

    public void setParent(GuiScreen gui) {
        this.parent = gui;
    }

    @Override
    protected void mouseClicked(int par1, int par2, int par3) {
        super.mouseClicked(par1, par2, par3);

        //fx = par1;
        switch(par3) {
            case 1:
                back();
                break;
            case 3:
                nextPage();
                break;
            case 4:
                prevPage();
                break;
        }
    }

    @Override
    protected void keyTyped(char par1, int par2) {

        GuidePage page = entry.pages.get(this.page);
        page.onKeyPressed(par1, par2);

        if(par2 == 1) {
            mc.displayGuiScreen((GuiScreen)null);
            mc.setIngameFocus();
        } else if(par2 == 203 || par2 == 200 || par2 == 201) // Left, Up, Page Up
            prevPage();
        else if(par2 == 205 || par2 == 208 || par2 == 209) // Right, Down Page Down
            nextPage();
        if(par2 == 14) // Backspace
            back();
        else if(par2 == 199) { // Home
            mc.displayGuiScreen(new GuiGuide());
        }
    }

    void prevPage() {
        actionPerformed(prevButton);
    }

    void nextPage() {
        actionPerformed(nextButton);
    }

    void back() {
        actionPerformed(backButton);
    }




}

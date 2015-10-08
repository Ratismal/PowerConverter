package io.github.ratismal.felineutilities.client.gui.guide.button;

import io.github.ratismal.felineutilities.api.guide.GuideCategory;
import mcp.mobius.waila.gui.truetyper.FontHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

/**
 * Created by Ratismal on 2015-09-22.
 */

public class GuiButtonEntry extends GuiButton {

    public ItemStack displayStack = null;

    public GuiButtonEntry(int id, int x, int y, int width, int height, String displayString) {
        super(id, x, y, width, height, displayString);
    }

    public GuiButtonEntry(int id, int x, int y, int width, int height, String displayString, ItemStack displayStack) {
        super(id, x, y, width, height, displayString);
        this.displayStack = displayStack;
    }

    @Override
    public void drawButton(Minecraft client, int x, int y) {

        boolean showStack = displayStack != null && !displayString.isEmpty();
        int k = getHoverState(field_146123_n);
        //GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        GL11.glDisable(GL11.GL_ALPHA_TEST);
        if (k==2) {
            drawRect(xPosition - 5, yPosition, (int) (xPosition - 5 + width), yPosition + height, 24);
        } else {
            drawRect(xPosition - 5, yPosition, (int) (xPosition - 5 + width), yPosition + height, 0);
        }
        GL11.glEnable(GL11.GL_ALPHA_TEST);

        boolean unicode = client.fontRenderer.getUnicodeFlag();
        client.fontRenderer.setUnicodeFlag(true);
        client.fontRenderer.drawString(displayString, xPosition + (showStack ? 7 : 0), yPosition + (height - 8) / 2, 0);
        client.fontRenderer.setUnicodeFlag(unicode);

        if (showStack) {
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            RenderHelper.enableGUIStandardItemLighting();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            RenderItem.getInstance().renderItemIntoGUI(client.fontRenderer, client.renderEngine, displayStack, xPosition * 2 - 6, yPosition * 2 + 4);
            RenderHelper.disableStandardItemLighting();
            GL11.glEnable(GL11.GL_BLEND);
        }

    }

}

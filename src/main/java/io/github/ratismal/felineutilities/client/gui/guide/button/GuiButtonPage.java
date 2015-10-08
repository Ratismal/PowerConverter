package io.github.ratismal.felineutilities.client.gui.guide.button;

import io.github.ratismal.felineutilities.client.core.helper.RenderHelper;
import io.github.ratismal.felineutilities.client.gui.guide.GuiGuide;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.Arrays;

/**
 * Created by Ratismal on 2015-10-01.
 */

public class GuiButtonPage extends GuiButton {

    boolean next;

    public GuiButtonPage(int par1, int par2, int par3, boolean next) {
        super(par1, par2, par3, 18, 10, "");
        this.next = next;
    }

    @Override
    public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
        if(enabled) {
            field_146123_n = par2 >= xPosition && par3 >= yPosition && par2 < xPosition + width && par3 < yPosition + height;
            int k = getHoverState(field_146123_n);

            par1Minecraft.renderEngine.bindTexture(GuiGuide.texture);
            GL11.glColor4f(1F, 1F, 1F, 1F);
            drawTexturedModalRect(xPosition, yPosition, k == 2 ? 18 : 0, next ? 180 : 190, 18, 10);

        }
    }

}

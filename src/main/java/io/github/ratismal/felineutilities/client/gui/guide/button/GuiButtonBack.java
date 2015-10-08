package io.github.ratismal.felineutilities.client.gui.guide.button;

import io.github.ratismal.felineutilities.client.gui.guide.GuiGuide;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

/**
 * Created by Ratismal on 2015-10-01.
 */

public class GuiButtonBack extends GuiButton {


    public GuiButtonBack(int par1, int par2, int par3) {
        super(par1, par2, par3, 18, 9, "");
    }

    @Override
    public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
        field_146123_n = par2 >= xPosition && par3 >= yPosition && par2 < xPosition + width && par3 < yPosition + height;
        int k = getHoverState(field_146123_n);

        par1Minecraft.renderEngine.bindTexture(GuiGuide.texture);
        GL11.glColor4f(1F, 1F, 1F, 1F);
        drawTexturedModalRect(xPosition, yPosition, 36, k == 2 ? 189 : 180, 18, 9);

    }




}

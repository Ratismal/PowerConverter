package io.github.ratismal.felineutilities.client.gui.guide.button;

import io.github.ratismal.felineutilities.api.guide.GuideCategory;
import io.github.ratismal.felineutilities.client.core.helper.RenderHelper;
import io.github.ratismal.felineutilities.client.lib.RefResource;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.Arrays;

/**
 * Created by Ratismal on 2015-09-22.
 */

public class GuiButtonCategory extends GuiButton {

    private static final ResourceLocation defaultTexture = new ResourceLocation(RefResource.GUIDE.CATEGORY_BASIC);

    GuideCategory category;


    public GuiButtonCategory(int id, int xPosition, int yPosition, GuideCategory category) {
        super(id, xPosition, yPosition, 24, 24, StatCollector.translateToLocal(category.getUnlocalizedName()));
        this.category = category;
    }

    public GuideCategory getCategory() { return category; }

    @Override
    public void drawButton(Minecraft client, int x, int y) {
        float s = 1F / 48F;
        int k = getHoverState(field_146123_n);

        ResourceLocation resource;
        if (category != null) {
            resource = category.getIcon();
        } else {
            resource = defaultTexture;
        }
        if (resource == null) {
            resource = defaultTexture;
        }
        client.getTextureManager().bindTexture(resource);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);


        //this.drawTexturedModalRect(x, y, 0, 0, 24, 24);
        float alpha = 1F;
        if (k==2) {
            alpha = 0.3F;
        }

        GL11.glPushMatrix();
        GL11.glColor4f(1F, 1F, 1F, alpha);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        RenderHelper.drawTexturedModalRect(xPosition * 2, yPosition * 2, zLevel * 2, 0, 0, 48, 48, s, s);
        GL11.glPopMatrix();

    }

}

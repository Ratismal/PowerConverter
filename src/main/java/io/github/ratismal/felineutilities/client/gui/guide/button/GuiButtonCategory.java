package io.github.ratismal.felineutilities.client.gui.guide.button;

import io.github.ratismal.felineutilities.api.guide.GuideCategory;
import io.github.ratismal.felineutilities.client.lib.RefResource;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Ratismal on 2015-09-22.
 */

public class GuiButtonCategory extends GuiButton {

    private static final ResourceLocation defaultTexture = new ResourceLocation(RefResource.GUIDE.CATEGORY_BASIC);

    GuideCategory category;


    public GuiButtonCategory(int id, int xPosition, int yPosition, GuideCategory category) {
        super(id, xPosition, yPosition, 24, 24, "");
        this.category = category;
    }

    @Override
    public void drawButton(Minecraft client, int x, int y) {

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

        this.drawTexturedModalRect(x, y, 0, 0, 24, 24);

    }

}

package io.github.ratismal.felineutilities.block.testRF;

import io.github.ratismal.felineutilities.base.tiles.BaseStorageTile;
import io.github.ratismal.felineutilities.reference.Names;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiTestMachine extends GuiContainer {

    protected BaseStorageTile baseStorageTile;

    public GuiTestMachine(EntityPlayer player, BaseStorageTile storageTile) {
        super(new ContainerTestRFMachine(player, storageTile));
        baseStorageTile = storageTile;

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {

        fontRendererObj.drawString(StatCollector.translateToLocal(Names.Containers.TEST_RF_MACHINE), 8, 6, Integer.parseInt("ffffff", 16));
        fontRendererObj.drawString(StatCollector.translateToLocal(Names.Containers.VANILLA_INVENTORY), 35, ySize - 95 + 2, Integer.parseInt("ffffff", 16));

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

    }
}

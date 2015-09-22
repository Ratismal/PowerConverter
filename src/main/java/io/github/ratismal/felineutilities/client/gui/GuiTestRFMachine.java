package io.github.ratismal.felineutilities.client.gui;

import io.github.ratismal.felineutilities.api.tiles.BaseStorageTile;
import io.github.ratismal.felineutilities.common.component.tileentity.TileTestRFMachine;
import io.github.ratismal.felineutilities.common.component.container.ContainerTestRFMachine;
import io.github.ratismal.felineutilities.common.lib.RefName;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiTestRFMachine extends GuiContainer {

    protected BaseStorageTile baseStorageTile;

    public GuiTestRFMachine(TileTestRFMachine tileTestRFMachine, ContainerTestRFMachine containerTestRFMachine) {
        super(containerTestRFMachine);
        baseStorageTile = tileTestRFMachine;

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {

        fontRendererObj.drawString(StatCollector.translateToLocal(RefName.Containers.TEST_RF_MACHINE), 8, 6, Integer.parseInt("ffffff", 16));
        fontRendererObj.drawString(StatCollector.translateToLocal(RefName.Containers.VANILLA_INVENTORY), 35, ySize - 95 + 2, Integer.parseInt("ffffff", 16));

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

    }
}

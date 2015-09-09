package io.github.ratismal.powerconverter.block.testRF;

import io.github.ratismal.powerconverter.block.BaseBlock;
import io.github.ratismal.powerconverter.reference.Names;
import io.github.ratismal.powerconverter.tab.CreativeTabPC;
import io.github.ratismal.powerconverter.tileentity.BaseStorageTile;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTestMachine extends BaseBlock {

    public BlockTestMachine() {

        super();
        this.setBlockName(Names.testMachine);
        this.setCreativeTab(CreativeTabPC.PC_TAB);

    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new BaseStorageTile(1000000, 1000000, 1000000);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new BaseStorageTile(1000000, 1000000, 1000000);
    }

}

package io.github.ratismal.powerconverter.machines.test;

import io.github.ratismal.powerconverter.block.BaseBlock;
import io.github.ratismal.powerconverter.reference.Names;
import io.github.ratismal.powerconverter.machines.test.TileTestMachine;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTestMachine extends BaseBlock {

	public BlockTestMachine() {

		super();
		this.setBlockName(Names.testMachine);

	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
			return new io.github.ratismal.powerconverter.machines.test.TileTestMachine();
	}

}

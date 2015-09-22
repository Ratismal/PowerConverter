package io.github.ratismal.felineutilities.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Ratismal on 2015-09-17.
 */

public class BaseBlockContainer extends BaseBlock implements ITileEntityProvider {

    public BaseBlockContainer(Material material) {
        super(material);
        this.isBlockContainer = true;
    }

    public BaseBlockContainer() {
        super(Material.rock);
        this.isBlockContainer = true;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return null;
    }

    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        super.breakBlock(world, x, y, z, block, meta);
    }

    public boolean onBlockEventReceved(World world, int x, int y, int z, int par1, int par2) {
        super.onBlockEventReceived(world, x, y, z, par1, par2);
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        return tileEntity != null && tileEntity.receiveClientEvent(par1, par2);
    }
}

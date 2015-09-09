package io.github.ratismal.powerconverter;

import java.util.List;

import io.github.ratismal.powerconverter.block.testRF.BlockTestMachine;
import net.minecraft.block.BlockContainer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import cpw.mods.fml.common.Optional;

/**
 * The Optional.Interface allows for an interface to be stripped from a class if the related mod is not
 * installed. Since we are using Waila the modid is Waila and the interface is IWailaDataProvider. Since
 * we can't directly reference the interface as it may not be installed, the first parameter is a string
 * which represents the class path for this interface.
 */
@Optional.Interface(iface = "mcp.mobius.waila.api.IWailaDataProvider", modid = "Waila")
public class WailaSupport implements IWailaDataProvider {

    /**
     * Although this is likely not necessary, you can also use the Optional.Method interface to mark a
     * method to be stripped if a mod is not detected. In this case we're doing this for all methods
     * which relate to Waila, so the modid is Waila.
     *
     * The callbackRegister method is used by Waila to register this data provider. Note that inside this
     * method we initialize a new instance of this class, this instance is used for a lot of the
     * IWailaRegistrar methods require an instance of the data provider to work. This will also call the
     * constructor of this class, which can be used to help initialize other things. Alternatively you
     * can initialize things within this method as well.
     */
    @Optional.Method(modid = "Waila")
    public static void callbackRegister(IWailaRegistrar register) {

        WailaSupport instance = new WailaSupport();


        register.registerBodyProvider(instance, BlockTestMachine.class);

        register.registerNBTProvider(instance, BlockContainer.class);
        register.registerBodyProvider(instance, BlockContainer.class);

    }

    @Override
    @Optional.Method(modid = "Waila")
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {

        return accessor.getStack();
    }

    @Override
    @Optional.Method(modid = "Waila")
    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {

        return currenttip;
    }

    @Override
    @Optional.Method(modid = "Waila")
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {

       return currenttip;
    }

    @Override
    @Optional.Method(modid = "Waila")
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {

        return currenttip;
    }

    @Override
    public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z) {

        if (te != null)
            te.writeToNBT(tag);

        return tag;
    }
}
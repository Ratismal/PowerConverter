package io.github.ratismal.felineutilities.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.ratismal.felineutilities.init.ModItems;
import io.github.ratismal.felineutilities.item.ItemPlunderEye;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 * Created by Ratismal on 2015-09-16.
 */

public class EntityPlunderEye extends Entity {

    public float rotation = 0f;
    public float rotationInc = 0.5f;
    public int phase = 0;
    private int tick = 0;
    private double yStop;
    private EntityLivingBase entity;
    private double eX;
    private double eY;
    private double eZ;
    private EntityPlayer player;
    private ItemStack item;

    public EntityPlunderEye(World world, EntityPlayer player, EntityLivingBase entity, ItemStack item) {
        super(world);
        this.setSize(0.25f, 0.25f);
        this.entity = entity;
        eX = entity.posX;
        eY = entity.posY;
        eZ = entity.posZ;
        this.player = player;
        this.item = item;
        this.setPosition(player.posX, player.posY + 1, player.posZ);
    }

    @Override
    protected void entityInit() {

        renderDistanceWeight = 10;
        getDataWatcher().addObject(11, (float) yStop);
        getDataWatcher().addObject(12, rotationInc);
        getDataWatcher().addObject(13, phase);

    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float dmg) {
        return false;
    }

    @Override
    public void onUpdate() {

        getDataWatcher().updateObject(11, (float) yStop);
        getDataWatcher().updateObject(12, rotationInc);
        getDataWatcher().updateObject(13, phase);
        phase = getDataWatcher().getWatchableObjectInt(13);

        tick++;
        rotation += rotationInc;
        super.onUpdate();

        switch (phase) {
            case 0:
                //tick++;
                rotationInc += 0.1f;
                if (tick == 100) {
                    phase = 1;
                }
                //spawnParticles();
                /*
                worldObj.spawnParticle("portal", entity.posX + (rand.nextDouble() - 0.5D) *
                                (double) entity.width, entity.posY + rand.nextDouble() * (double) entity.height - 0.25D,
                        entity.posZ + (rand.nextDouble() - 0.5D) * (double) entity.width, (rand.nextDouble() - 0.5D)
                                * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D);
                */
                entity.setPosition(eX, eY, eZ);

                break;
            case 1:
                if (checkIfValid()) {
                    returnItem();
                }
                this.setDead();
                break;
        }
        if (worldObj.isRemote) spawnParticles();
    }

    @SideOnly(Side.CLIENT)
    private void spawnParticles() {

        if (phase == 0) {
            /*
            for (int k = 0; k < 4; ++k) {
                entity.worldObj.spawnParticle("portal", entity.posX + (rand.nextDouble() - 0.5D) *
                                (double) entity.width, entity.posY + rand.nextDouble() * (double) entity.height - 0.25D,
                        entity.posZ + (rand.nextDouble() - 0.5D) * (double) entity.width, (rand.nextDouble() - 0.5D)
                                * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D);

            }
            */
            double motionX = rand.nextGaussian() * 0.02D;
            double motionY = rand.nextGaussian() * 0.02D;
            double motionZ = rand.nextGaussian() * 0.02D;
            worldObj.spawnParticle(
                    "happyVillager",
                    entity.posX + rand.nextFloat() * width * 2.0F - entity.width,
                    entity.posY + 0.5D + rand.nextFloat() * entity.height,
                    entity.posZ + rand.nextFloat() * width * 2.0F - entity.width,
                    motionX,
                    motionY,
                    motionZ);
        }

    }

    public void returnSame() {
        ItemStack plunderedEye = new ItemStack(ModItems.plunderEye);
        player.setCurrentItemOrArmor(0, plunderedEye);
        ((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
    }

    public void returnItem() {
        String entityId = EntityList.getEntityString(entity);

        NBTTagCompound root = new NBTTagCompound();
        root.setString("entity", entityId);
        entity.writeToNBT(root);

        ItemStack plunderedEye = new ItemStack(ModItems.plunderEye);
        plunderedEye.setTagCompound(root);
        /*
        if (item.stackTagCompound == null) {
            Logger.info("Creating stack compound");
            item.stackTagCompound = new NBTTagCompound();
        }
        item.stackTagCompound.setString("entity", entityId);
        */
        player.swingItem();


        entity.setDead();
        if (entity.isDead) {
            //item.stackSize--;
            //if (!player.inventory.addItemStackToInventory(plunderedEye))
            //{
            //    entity.worldObj.spawnEntityInWorld(new EntityItem(entity.worldObj,entity.posX, entity.posY, entity.posZ, plunderedEye));
            //}
            //player.setCurrentItemOrArmor(0, item);
            player.setCurrentItemOrArmor(0, plunderedEye);
            ((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
        }

    }


    public boolean checkIfValid() {
        if (!entity.isEntityAlive()) {
            return false;
        }

        double playerX = player.posX;
        double playerY = player.posY;
        double playerZ = player.posZ;
        double entityX = entity.posX;
        double entityY = entity.posY;
        double entityZ = entity.posZ;

        if ((playerX >= entityX - 5 || playerX <= entityX + 5) &&
                (playerY >= entityY - 5 || playerY <= entityY + 5) &&
                (playerZ >= entityZ - 5 || playerZ <= entityZ + 5) &&
                player.worldObj == entity.worldObj) {

            return true;

        }

        return false;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player) {
    }


    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        compound.setInteger("Tick", tick);
        compound.setInteger("Phase", phase);
        compound.setFloat("RotationSpeed", rotationInc);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        tick = compound.getInteger("Tick");
        phase = compound.getInteger("Phase");
        rotationInc = compound.getFloat("RotationSpeed");
    }
}

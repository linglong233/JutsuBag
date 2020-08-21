package linglong.kim.jutsubag.items;

import java.util.UUID;

import linglong.kim.jutsubag.creativetabs.CreativeTabsLoader;
import linglong.kim.jutsubag.gui.GuiBagLoader;
import linglong.kim.jutsubag.iinventory.Bag;
import linglong.kim.jutsubag.nbt.ExtendedPlayer;
import linglong.kim.jutsubag.JutsuBag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.play.server.S2DPacketOpenWindow;
import net.minecraft.world.World;
import net.minecraft.item.Item;

public class ItemJutsuBag extends Item {
	public static EntityPlayerMP epm;

	public ItemJutsuBag() {
		this.maxStackSize = 1;
		setUnlocalizedName("jutsubag");
		setTextureName("jutsubag:jutsubag");
		setCreativeTab(CreativeTabsLoader.tabjutsubag);
	}

	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {

	}

	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.rare;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if (!worldIn.isRemote) {
			int id = GuiBagLoader.GUI_DEMO;
		    epm = (EntityPlayerMP) playerIn;
			playerIn.openGui(JutsuBag.instance, id, worldIn, playerIn.serverPosX , playerIn.serverPosY, playerIn.serverPosZ);
		}
		return itemStackIn;
	}
}

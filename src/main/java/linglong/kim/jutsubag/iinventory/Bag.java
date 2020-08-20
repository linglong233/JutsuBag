package linglong.kim.jutsubag.iinventory;

import alcoholmod.Mathioks.Final.JutsuItem;
import linglong.kim.jutsubag.JutsuBag;
import linglong.kim.jutsubag.items.ItemJutsuBag;
import linglong.kim.jutsubag.nbt.ExtendedPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class Bag extends InventoryBasic {
	private EntityPlayer player;

	public Bag() {
		super("container.bag", false, 54);
	}

	public void loadInventoryFromNBT(NBTTagList p_70486_1_) {
		int i;
		for (i = 0; i < this.getSizeInventory(); ++i) {
			this.setInventorySlotContents(i, (ItemStack) null);
		}
		for (i = 0; i < p_70486_1_.tagCount(); ++i) {
			NBTTagCompound nbttagcompound = p_70486_1_.getCompoundTagAt(i);
			int j = nbttagcompound.getByte("Slot") & 255;

			if (j >= 0 && j < this.getSizeInventory()) {
				this.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound));
			}
		}
	}

	public NBTTagList saveInventoryToNBT() {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < this.getSizeInventory(); ++i) {
			ItemStack itemstack = this.getStackInSlot(i);
			if (itemstack != null) {
				NBTTagCompound c = new NBTTagCompound();
				c.setByte("Slot", (byte) i);
				itemstack.writeToNBT(c);
				nbttaglist.appendTag(c);
			}
		}
		return nbttaglist;
	}

	public void openInventory() {
		super.openInventory();
	}

	public void closeInventory() {
		super.closeInventory();
	}
}
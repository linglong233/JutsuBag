package linglong.kim.jutsubag.iinventory;

import java.util.List;

import alcoholmod.Mathioks.Final.JutsuItem;
import linglong.kim.jutsubag.JutsuBag;
import linglong.kim.jutsubag.items.ItemJutsuBag;
import linglong.kim.jutsubag.nbt.ExtendedPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInvBasic;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class Bag implements IInventory {
    private ItemStack[] inventoryContents;
	public Bag() {
        this.inventoryContents = new ItemStack[54];
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
//		super.openInventory();
	}

	public void closeInventory() {
//		super.closeInventory();
	}

	@Override
	public int getSizeInventory() {
		return 54;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		return p_70301_1_ >= 0 && p_70301_1_ < this.inventoryContents.length ? this.inventoryContents[p_70301_1_] : null;
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        if (this.inventoryContents[p_70298_1_] != null)
        {
            ItemStack itemstack;

            if (this.inventoryContents[p_70298_1_].stackSize <= p_70298_2_)
            {
                itemstack = this.inventoryContents[p_70298_1_];
                this.inventoryContents[p_70298_1_] = null;
                this.markDirty();
                return itemstack;
            }
            else
            {
                itemstack = this.inventoryContents[p_70298_1_].splitStack(p_70298_2_);

                if (this.inventoryContents[p_70298_1_].stackSize == 0)
                {
                    this.inventoryContents[p_70298_1_] = null;
                }

                this.markDirty();
                return itemstack;
            }
        }
        else
        {
            return null;
        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        if (this.inventoryContents[p_70304_1_] != null)
        {
            ItemStack itemstack = this.inventoryContents[p_70304_1_];
            this.inventoryContents[p_70304_1_] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
        this.inventoryContents[p_70299_1_] = p_70299_2_;

        if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
        {
            p_70299_2_.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
	}

	@Override
	public String getInventoryName() {
		return "container.bag";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void markDirty() {
//        if (this.field_70480_d != null)
//        {
//            for (int i = 0; i < this.field_70480_d.size(); ++i)
//            {
//                ((IInvBasic)this.field_70480_d.get(i)).onInventoryChanged(this);
//            }
//        }
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return true;
	}
}
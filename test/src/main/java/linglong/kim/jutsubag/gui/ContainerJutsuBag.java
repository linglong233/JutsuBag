package linglong.kim.jutsubag.gui;

import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

import alcoholmod.Mathioks.Final.JutsuItem;
import linglong.kim.jutsubag.JutsuBag;
import linglong.kim.jutsubag.items.ItemJutsuBag;
import linglong.kim.jutsubag.nbt.ExtendedPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.server.S2DPacketOpenWindow;

public class ContainerJutsuBag extends Container {
	private IInventory lowerChestInventory;
	private int numRows;

	public ContainerJutsuBag(EntityPlayer player) {
		this.lowerChestInventory = player.inventory;
		ExtendedPlayer props = ExtendedPlayer.get(player);
		this.numRows = props.getBag().getSizeInventory() / 15;

		int i = (this.numRows - 4) * 18;
		int j;
		int k;
		for (j = 0; j < this.numRows; ++j) {
			for (k = 0; k < 15; ++k) {
				this.addSlotToContainer(new Slot(props.getBag(), k + j * 9, (8 + k * 18) - (3 * 18 + 8), (18 + j * 18)) {
					@Override
					public boolean isItemValid(ItemStack stack) {
						return stack != null && stack.getItem() instanceof JutsuItem && super.isItemValid(stack);
					}
				});
			}
		}
		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				this.addSlotToContainer(new Slot(player.inventory, k + j * 9 + 9, 8 + k * 18, (103 + j * 18 + i)));
			}
		}
        for (int a = 0; a < 9; ++a)
        {
            this.addSlotToContainer(new Slot(player.inventory, a, 8 + a * 18, 150));
        }
	}

	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return this.lowerChestInventory.isUseableByPlayer(p_75145_1_);
	}

	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(p_82846_2_);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (p_82846_2_ < this.numRows * 9) {
				if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}
}
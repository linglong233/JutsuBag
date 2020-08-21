package linglong.kim.jutsubag.gui;

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
		this.numRows = props.getBag().getSizeInventory() / 9;
//		ItemJutsuBag.epm.playerNetServerHandler.sendPacket(new S2DPacketOpenWindow(ItemJutsuBag.epm.currentWindowId, 0, props.getBag().getInventoryName(), props.getBag().getSizeInventory(), props.getBag().hasCustomInventoryName()));
		
		int i = (this.numRows - 4) * 18;
		int j;
		int k;
		for (j = 0; j < this.numRows; ++j) {
			for (k = 0; k < 9; ++k) {
				this.addSlotToContainer(new Slot(props.getBag(), k + j * 9, 8 + k * 18, 18 + j * 18){
		            @Override
		            public boolean isItemValid(ItemStack stack)
		            {
		                return stack != null && stack.getItem() instanceof JutsuItem && super.isItemValid(stack);
		            }
		        });
			}
		}
		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				this.addSlotToContainer(new Slot(player.inventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
			}
		}

		for (j = 0; j < 9; ++j) {
			this.addSlotToContainer(new Slot(player.inventory, j, 8 + j * 18, 161 + i));
		}
		for(int a = 1;a < 55;a++) {
			if(props.getBag().getStackInSlot(a) != null) {
			this.putStackInSlot(a, props.getBag().getStackInSlot(a));
			Slot slot = (Slot) inventorySlots.get(a);
			ItemStack newStack = slot.getStack();
			}
		}
	}
	
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return this.lowerChestInventory.isUseableByPlayer(p_75145_1_);
	}
    
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		Slot slot = (Slot) inventorySlots.get(index);
		if (slot == null || !slot.getHasStack()) {
			return null;
		}
		
		ItemStack newStack = slot.getStack(), oldStack = newStack.copy();
		boolean isMerged = false;
		
		if (!isMerged) {
			return null;
		}

		if (newStack.stackSize == 0) {
			slot.putStack(null);
		} else {
			slot.onSlotChanged();
		}

		slot.onPickupFromSlot(playerIn, newStack);

		return oldStack;
	}

	public void onContainerClosed(EntityPlayer p_75134_1_) {
		super.onContainerClosed(p_75134_1_);
		this.lowerChestInventory.closeInventory();
	}

	public IInventory getLowerChestInventory() {
		return this.lowerChestInventory;
	}
}
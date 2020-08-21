package linglong.kim.jutsubag.nbt;

import linglong.kim.jutsubag.iinventory.Bag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties {
	public Bag bag = new Bag();

	public ExtendedPlayer(EntityPlayer player) {

	}

	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties("JutsuBag", new ExtendedPlayer(player));
	}

	public static final ExtendedPlayer get(EntityPlayer player) {
		return (ExtendedPlayer) player.getExtendedProperties("JutsuBag");
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		compound.setTag("JustuBagItem", getBag().saveInventoryToNBT());
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagList nbttaglist1 = compound.getTagList("JustuBagItem", 10);
		getBag().loadInventoryFromNBT(nbttaglist1);
	}

	@Override
	public void init(Entity entity, World world) {

	}

	public Bag getBag() {
		return bag;
	}
}

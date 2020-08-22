package linglong.kim.jutsubag.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import linglong.kim.jutsubag.nbt.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class EventLoader {
	public EventLoader() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onEntityConstructing(EntityEvent.EntityConstructing event) {
		if (((event.entity instanceof EntityPlayer)) && (ExtendedPlayer.get((EntityPlayer) event.entity) == null)) {
			ExtendedPlayer.register((EntityPlayer) event.entity);
		}
	}

}

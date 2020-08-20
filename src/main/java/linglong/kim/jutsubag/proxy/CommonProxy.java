package linglong.kim.jutsubag.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import linglong.kim.jutsubag.creativetabs.CreativeTabsLoader;
import linglong.kim.jutsubag.event.EventLoader;
import linglong.kim.jutsubag.gui.GuiBagLoader;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		new CreativeTabsLoader(event);
	}

	public void init(FMLInitializationEvent event) {
		new GuiBagLoader();
		new EventLoader();
	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}
package linglong.kim.jutsubag.creativetabs;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabsLoader {
	public static CreativeTabsJutsuBag tabjutsubag;

	public CreativeTabsLoader(FMLPreInitializationEvent event) {
		tabjutsubag = new CreativeTabsJutsuBag();
	}
}
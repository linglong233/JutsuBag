package linglong.kim.jutsubag.creativetabs;

import linglong.kim.jutsubag.JutsuBag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsJutsuBag extends CreativeTabs {
	public CreativeTabsJutsuBag() {
		super("itemJutsuBag");
	}

	@Override
	public Item getTabIconItem() {
		return JutsuBag.jutsubag;
	}
}
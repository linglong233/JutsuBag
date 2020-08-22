package linglong.kim.jutsubag;

import alcoholmod.Mathioks.AlcoholMod;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import linglong.kim.jutsubag.items.*;
import linglong.kim.jutsubag.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

@Mod(modid = JutsuBag.MODID, name = JutsuBag.NAME, version = JutsuBag.VERSION, dependencies="required-after:AM;", acceptedMinecraftVersions = "1.7.10")
public class JutsuBag {
    public static final String MODID = "jutsubag";
    public static final String NAME = "JutsuBag";
    public static final String VERSION = "0.0.1";
    public static Item jutsubag;
    
    @SidedProxy(clientSide = "linglong.kim.jutsubag.proxy.ClientProxy", 
            serverSide = "linglong.kim.jutsubag.proxy.CommonProxy")
    public static CommonProxy proxy;
    @Instance(JutsuBag.MODID)
    public static JutsuBag instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
        jutsubag = new ItemJutsuBag();
        GameRegistry.registerItem(jutsubag, "jutsubag");
        
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);

        GameRegistry.addRecipe(new ItemStack(jutsubag, 1), new Object[] { 
        		"ABA",
        		"BCB", 
        		"ABA", 
        		Character.valueOf('A'), AlcoholMod.ChakraRestoreItem, 
        		Character.valueOf('B'), Items.leather, 
        		Character.valueOf('C'), Blocks.chest });
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}

package linglong.kim.jutsubag.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import linglong.kim.jutsubag.JutsuBag;
import linglong.kim.jutsubag.nbt.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiBagLoader implements IGuiHandler
{
    public static final int GUI_DEMO = 1;

    public GuiBagLoader()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(JutsuBag.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
        case GUI_DEMO:
            return new ContainerDemo(player);
        default:
            return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
        case GUI_DEMO:
            return new GuiContainerDemo(new ContainerDemo(player));
        default:
            return null;
        }
    }
}
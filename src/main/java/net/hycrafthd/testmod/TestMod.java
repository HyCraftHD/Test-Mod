package net.hycrafthd.testmod;

import static net.hycrafthd.testmod.TestConstants.*;

import net.hycrafthd.testmod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MODID, name = NAME, version = VERSION, acceptedMinecraftVersions = MCVERSION)
public class TestMod {

    @Mod.Instance
    private static TestMod instance;


    @SidedProxy(serverSide = COMMONPROXY, clientSide = CLIENTPROXY)
    private static CommonProxy proxy;

    public static TestMod getInstance() {
        return instance;
    }

    public CommonProxy getProxy() {
        return proxy;
    }

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event){
        proxy.preinit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event){
        proxy.postinit(event);
    }


}

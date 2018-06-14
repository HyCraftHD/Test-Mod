package net.hycrafthd.testmod.proxy;

import net.hycrafthd.testmod.init.TestModelRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

    @Override
    public void preinit(FMLPreInitializationEvent event){
        super.preinit(event);
        TestModelRegistry.init();
    }
    @Override
    public void init(FMLInitializationEvent event){
        super.init(event);
    }
    @Override
    public void postinit(FMLPostInitializationEvent event){
        super.postinit(event);
    }
}

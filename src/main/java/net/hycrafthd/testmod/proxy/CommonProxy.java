package net.hycrafthd.testmod.proxy;

import net.hycrafthd.testmod.init.TestItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preinit(FMLPreInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(TestItems.getInstance());
    }

    public void init(FMLInitializationEvent event){

    }

    public void postinit(FMLPostInitializationEvent event){

    }
}

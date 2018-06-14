package net.hycrafthd.testmod.proxy;

import net.hycrafthd.testmod.item.TestItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preinit(FMLPreInitializationEvent event){
        TestItems.init();
    }

    public void init(FMLInitializationEvent event){

    }

    public void postinit(FMLPostInitializationEvent event){

    }
}

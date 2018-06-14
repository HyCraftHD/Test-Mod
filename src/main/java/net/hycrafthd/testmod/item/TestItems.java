package net.hycrafthd.testmod.item;

import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TestItems {

    public static ItemTest test1;


    private static boolean isinit = false;

    public static void init(){
        if(isinit){
            return;
        }
        isinit = true;

        test1 = new ItemTest();

        ForgeRegistries.ITEMS.register(test1);
    }

}

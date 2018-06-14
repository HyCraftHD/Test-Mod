package net.hycrafthd.testmod.init;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class TestModelRegistry {

    private static boolean isinit = false;

    public static void init(){
        if(isinit){
            return;
        }
        isinit = true;

        ModelLoader.setCustomModelResourceLocation(TestItems.test1, 0, new ModelResourceLocation(TestItems.test1.getRegistryName(), "inventory"));

    }
}

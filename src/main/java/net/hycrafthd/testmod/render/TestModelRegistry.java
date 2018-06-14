package net.hycrafthd.testmod.render;

import net.hycrafthd.testmod.item.TestItems;
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

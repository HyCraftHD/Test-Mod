package net.hycrafthd.testmod.render;

import net.hycrafthd.testmod.TestConstants;
import net.hycrafthd.testmod.init.TestBlocks;
import net.hycrafthd.testmod.init.TestItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = TestConstants.MODID)
@SideOnly(Side.CLIENT)
public class TestModelRegistry {

    @SubscribeEvent
    public static void register(ModelRegistryEvent event) {
        TestItems.Registry.items.forEach(ModelRegistryUtil::register);
        TestBlocks.Registry.blocks.forEach(ModelRegistryUtil::register);
    }

}
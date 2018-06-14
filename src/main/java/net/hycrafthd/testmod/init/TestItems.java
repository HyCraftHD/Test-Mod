package net.hycrafthd.testmod.init;

import net.hycrafthd.testmod.TestConstants;
import net.hycrafthd.testmod.TestMod;
import net.hycrafthd.testmod.item.ItemTest;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Set;

@GameRegistry.ObjectHolder(TestConstants.MODID)
public class TestItems {

    public static final ItemTest test1 = new ItemTest();

    @Mod.EventBusSubscriber(modid = TestConstants.MODID)
    public static class Registry {
        @SubscribeEvent
        public static void register(RegistryEvent.Register<Item> event) {
            IForgeRegistry<Item> registry = event.getRegistry();

            Set<Item> items = InitUtil.getRegistryEntries(Item.class, TestItems.class);

            items.forEach(registry::register);
        }
    }

}

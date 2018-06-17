package net.hycrafthd.testmod.init;

import net.hycrafthd.testmod.TestConstants;
import net.hycrafthd.testmod.item.ItemTest;
import net.hycrafthd.testmod.item.ItemTestPickaxe;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Set;

public class TestItems {

    public static final Item.ToolMaterial testtoolmaterial1 = EnumHelper.addToolMaterial("test", 3, 5, 100, 4, 100);

    public static final ItemTest test1 = new ItemTest();
    public static final ItemTestPickaxe testpickaxe1 = new ItemTestPickaxe(testtoolmaterial1);

    @Mod.EventBusSubscriber(modid = TestConstants.MODID)
    public static class Registry {

        public static Set<Item> items;

        @SubscribeEvent
        public static void register(RegistryEvent.Register<Item> event) {
            IForgeRegistry<Item> registry = event.getRegistry();
            items = InitUtil.getRegistryEntries(Item.class, TestItems.class);
            items.forEach(registry::register);
        }
    }

}

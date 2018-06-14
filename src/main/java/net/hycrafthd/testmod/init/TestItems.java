package net.hycrafthd.testmod.init;

import net.hycrafthd.testmod.item.ItemTest;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class TestItems {

    private static TestItems instance = new TestItems();

    public static final TestItems getInstance() {
        return instance;
    }

    public static final ItemTest test1 = new ItemTest();

    public TestItems() {

    }

    @SubscribeEvent
    public void register(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(test1);
    }


}

package net.hycrafthd.testmod.init;

import net.hycrafthd.testmod.TestConstants;
import net.hycrafthd.testmod.block.BlockTest;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Set;

public class TestBlocks {

    public static final BlockTest blocktest1 = new BlockTest();

    @Mod.EventBusSubscriber(modid = TestConstants.MODID)
    public static class Registry {

        public static Set<Block> blocks = InitUtil.getRegistryEntries(Block.class, TestBlocks.class);

        @SubscribeEvent
        public static void register(RegistryEvent.Register<Block> event) {
            IForgeRegistry<Block> registry = event.getRegistry();
            blocks.forEach(registry::register);
        }

        @SubscribeEvent
        public static void registeritem(RegistryEvent.Register<Item> event){
            IForgeRegistry<Item> registry = event.getRegistry();
            blocks.forEach(block->{
                ItemBlock item = new ItemBlock(block);
                item.setRegistryName(block.getRegistryName());
                item.setUnlocalizedName(block.getUnlocalizedName());
                registry.register(item);
            });
        }
    }
}

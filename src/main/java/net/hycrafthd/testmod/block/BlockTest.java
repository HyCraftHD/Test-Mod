package net.hycrafthd.testmod.block;

import net.hycrafthd.testmod.TestConstants;
import net.hycrafthd.testmod.init.TestTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockTest extends Block {


    public BlockTest() {
        super(Material.ROCK);
        setUnlocalizedName("blocktest1");
        setRegistryName(new ResourceLocation(TestConstants.MODID, "blocktest1"));
        setCreativeTab(TestTabs.tab1);
    }
}

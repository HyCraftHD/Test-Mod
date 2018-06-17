package net.hycrafthd.testmod.item;

import net.hycrafthd.testmod.TestConstants;
import net.hycrafthd.testmod.init.TestTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.ResourceLocation;

public class ItemTestPickaxe extends ItemPickaxe {

    public ItemTestPickaxe(ToolMaterial material) {
        super(material);
        setUnlocalizedName("itemtestpickaxe1");
        setRegistryName(new ResourceLocation(TestConstants.MODID, "itemtestpickaxe1"));
        setCreativeTab(TestTabs.tab1);
        attackSpeed = 16;
    }
}

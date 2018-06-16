package net.hycrafthd.testmod.tab;

import net.hycrafthd.testmod.init.TestItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabTest extends CreativeTabs {

    public CreativeTabTest() {
        super("test");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(TestItems.test1);
    }
}

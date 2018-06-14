package net.hycrafthd.testmod.item;

import net.hycrafthd.testmod.TestConstants;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemTest extends Item {

    public ItemTest() {
        super();
        setUnlocalizedName("itemtest1");
        setRegistryName(new ResourceLocation(TestConstants.MODID, "itemtest1"));
    }
}

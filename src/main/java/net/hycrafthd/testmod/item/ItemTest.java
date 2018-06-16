package net.hycrafthd.testmod.item;

import net.hycrafthd.testmod.TestConstants;
import net.hycrafthd.testmod.block.BlockTest;
import net.hycrafthd.testmod.init.TestBlocks;
import net.hycrafthd.testmod.init.TestTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemTest extends Item {

    public ItemTest() {
        super();
        setUnlocalizedName("itemtest1");
        setRegistryName(new ResourceLocation(TestConstants.MODID, "itemtest1"));
        setCreativeTab(TestTabs.tab1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!(world.getBlockState(pos).getBlock() instanceof BlockTest)){
            if(!world.isRemote) {
                world.setBlockState(pos, TestBlocks.blocktest1.getDefaultState());
                player.sendMessage(new TextComponentString("§5 Test baum ich bin dum"));
            }
            player.motionY =(player.motionY + 1) *1.25;
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }
}

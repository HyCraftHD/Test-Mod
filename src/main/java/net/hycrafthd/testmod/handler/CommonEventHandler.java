package net.hycrafthd.testmod.handler;

import net.hycrafthd.testmod.init.TestItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonEventHandler {

    @SubscribeEvent
    public void onEvent(BlockEvent.BreakEvent event){
        Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
        if(!(event.getPlayer().getHeldItemMainhand().getItem() == TestItems.testpickaxe1)){
            return;
        }
        if(isBlock(block)){
            event.getPlayer().sendMessage(new TextComponentString("" + (recursiveBlockTest(event.getWorld(), event.getPos(), block) + 1) ));
        }
    }

    private boolean isBlock(Block block){
        if(block instanceof BlockOre || block instanceof BlockRedstoneOre){
            return true;
        }
        return false;
    }

    private int recursiveBlockTest(World world, BlockPos pos, Block prevblock){
        int dammage = 0;

        world.setBlockToAir(pos);

       for(EnumFacing facing : EnumFacing.VALUES){
           BlockPos position = pos.offset(facing);

           Block block = world.getBlockState(position).getBlock();

           if(prevblock == block){
               dammage += recursiveBlockTest(world, position, prevblock) +1;
           }
       }
       return dammage;
    }
}

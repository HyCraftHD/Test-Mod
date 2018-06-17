package net.hycrafthd.testmod.handler;

import net.hycrafthd.testmod.init.TestItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Enchantments;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonEventHandler {

    @SubscribeEvent
    public void onEvent(BlockEvent.BreakEvent event) {
        if (!(event.getPlayer() instanceof EntityPlayerMP)) {
            return;
        }
        if (!(event.getPlayer().getHeldItemMainhand().getItem() == TestItems.testpickaxe1)) {
            return;
        }
        Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
        if (isBlock(block)) {
            event.getPlayer().sendMessage(new TextComponentString("" + (recursiveBlockTest((EntityPlayerMP) event.getPlayer(), event.getWorld(), event.getPos(), block) + 1)));
        }
    }

    private boolean isBlock(Block block) {
        if (block instanceof BlockOre || block instanceof BlockRedstoneOre) {
            return true;
        }
        return false;
    }

    private int recursiveBlockTest(EntityPlayerMP player, World world, BlockPos pos, Block prevblock) {
        int dammage = 0;

        breakBlock(player, pos);

        for (EnumFacing facing : EnumFacing.VALUES) {
            BlockPos position = pos.offset(facing);

            Block block = world.getBlockState(position).getBlock();

            if (prevblock == block) {
                dammage += recursiveBlockTest(player, world, position, prevblock) + 1;
            }
        }
        return dammage;
    }

    private void breakBlock(EntityPlayerMP player, BlockPos pos) {

        World world = player.world;
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        if (!world.isAirBlock(pos)) {
            block.onBlockHarvested(world, pos, state, player);
            if (block.removedByPlayer(state, world, pos, player, true)) {
                block.onBlockDestroyedByPlayer(world, pos, state);
                if (!player.capabilities.isCreativeMode) {
                    block.harvestBlock(world, player, pos, state, world.getTileEntity(pos), player.getHeldItemMainhand());
                    block.dropXpOnBlockBreak(world, pos, block.getExpDrop(state, world, pos, EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, player.getHeldItemMainhand())));
                    player.getHeldItemMainhand().damageItem(1, player);
                }
            }
            player.connection.sendPacket(new SPacketBlockChange(world, pos));
        }
    }
}

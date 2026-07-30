package radin6262.road.decor.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import radin6262.road.decor.registry.ModBlocks;

public class PaintRollerItem extends Item {
    public PaintRollerItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (block == ModBlocks.ASPHALT.get()) {
            if (!level.isClientSide()) {
                // Get the current facing direction from asphalt
                Direction facing = state.getValue(HorizontalDirectionalBlock.FACING);

                // Transform to painted asphalt with the same rotation
                level.setBlock(pos, ModBlocks.PAINTED_ASPHALT.get().defaultBlockState()
                        .setValue(HorizontalDirectionalBlock.FACING, facing), 3);

                level.playSound(null, pos, SoundEvents.GENERIC_SPLASH, SoundSource.BLOCKS, 1.0f, 1.0f);

                if (player != null && !player.getAbilities().instabuild) {
                    // Damage the item
                    stack.setDamageValue(stack.getDamageValue() + 1);
                    if (stack.getDamageValue() >= stack.getMaxDamage()) {
                        stack.shrink(1);
                    }
                }
            }
            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        return InteractionResult.PASS;
    }
}
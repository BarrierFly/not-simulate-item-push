package com.ccswitch.notsimulateitempush.mixin;

import com.ccswitch.notsimulateitempush.config.ModConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Makes {@link PistonBaseBlock} and {@link PistonHeadBlock} report empty collision
 * when {@link ModConfig#disablePistonCollision} is enabled.
 * <p>
 * These two blocks don't override {@code getCollisionShape}, so injecting into
 * {@link BlockBehaviour} is the right insertion point.
 */
@Mixin(BlockBehaviour.class)
@Environment(EnvType.CLIENT)
public abstract class PistonBaseCollisionMixin {

    @Inject(
        method = "getCollisionShape(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/phys/shapes/CollisionContext;)Lnet/minecraft/world/phys/shapes/VoxelShape;",
        at = @At("HEAD"),
        cancellable = true
    )
    private void removePistonCollision(BlockState state, BlockGetter level, BlockPos pos,
                                        CollisionContext context, CallbackInfoReturnable<VoxelShape> cir) {
        if (!ModConfig.get().disablePistonCollision) {
            return;
        }
        if (state.getBlock() instanceof PistonBaseBlock || state.getBlock() instanceof PistonHeadBlock) {
            cir.setReturnValue(Shapes.empty());
        }
    }
}

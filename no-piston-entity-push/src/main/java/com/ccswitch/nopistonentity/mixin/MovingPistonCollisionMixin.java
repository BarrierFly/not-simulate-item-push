package com.ccswitch.nopistonentity.mixin;

import com.ccswitch.nopistonentity.config.ModConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Makes {@link MovingPistonBlock} report empty collision when
 * {@link ModConfig#disablePistonCollision} is enabled.
 * <p>
 * Moving piston blocks override {@code getCollisionShape} themselves (they delegate to
 * {@code PistonMovingBlockEntity}), so this needs its own mixin independent of
 * {@link PistonBlockCollisionMixin}.
 */
@Mixin(MovingPistonBlock.class)
@Environment(EnvType.CLIENT)
public abstract class MovingPistonCollisionMixin {

    @Inject(
        method = "getCollisionShape(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/phys/shapes/CollisionContext;)Lnet/minecraft/world/phys/shapes/VoxelShape;",
        at = @At("HEAD"),
        cancellable = true
    )
    private void removeMovingPistonCollision(BlockState state, BlockGetter level, BlockPos pos,
                                              CollisionContext context, CallbackInfoReturnable<VoxelShape> cir) {
        if (ModConfig.get().disablePistonCollision) {
            cir.setReturnValue(Shapes.empty());
        }
    }
}

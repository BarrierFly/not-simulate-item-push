package com.ccswitch.notsimulateitempush.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import com.ccswitch.notsimulateitempush.config.ModConfig;
import net.minecraft.world.level.block.piston.PistonMovingBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Skips client-side piston entity pushing for item entities (掉落物).
 *
 * <p>Injected at {@link PistonMovingBlockEntity#moveEntityByPiston} HEAD rather than
 * {@code Entity.move()}, so the {@code instanceof} check only runs when a piston
 * actually pushes an entity — not on every entity movement tick.</p>
 *
 * <p>Also checks {@link ModConfig#enabled} so the feature can be toggled in-game
 * via Mod Menu without restarting.</p>
 */
@Mixin(PistonMovingBlockEntity.class)
@Environment(EnvType.CLIENT)
public abstract class ItemEntityPushMixin {

    @Inject(
        method = "moveEntityByPiston(Lnet/minecraft/core/Direction;Lnet/minecraft/world/entity/Entity;DLnet/minecraft/core/Direction;)V",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void cancelItemEntityPush(Direction direction, Entity entity, double d, Direction direction2, CallbackInfo ci) {
        if (ModConfig.get().enabled && entity instanceof ItemEntity) {
            ci.cancel();
        }
    }
}

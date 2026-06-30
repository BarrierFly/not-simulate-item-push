package com.ccswitch.notsimulateitempush.mixin;

import com.ccswitch.notsimulateitempush.config.ModConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Prevents block destruction particles (方块破坏粒子 / TerrainParticle) from
 * spawning on the client when {@link ModConfig#disableDestroyParticles} is enabled.
 *
 * <p>Injected at {@link ClientLevel#addDestroyBlockEffect} HEAD, which is the
 * most specific method responsible for spawning block fragment particles when
 * a block is broken.</p>
 */
@Mixin(ClientLevel.class)
@Environment(EnvType.CLIENT)
public abstract class DestroyParticleMixin {

    @Inject(
        method = "addDestroyBlockEffect(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V",
        at = @At("HEAD"),
        cancellable = true
    )
    private void cancelDestroyParticles(BlockPos pos, BlockState state, CallbackInfo ci) {
        if (ModConfig.get().disableDestroyParticles) {
            ci.cancel();
        }
    }
}

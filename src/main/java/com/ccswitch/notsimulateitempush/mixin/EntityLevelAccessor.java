package com.ccswitch.notsimulateitempush.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * Exposes the private {@code Entity.level} field so other mixins can read it
 * without needing an access widener.
 */
@Mixin(Entity.class)
public interface EntityLevelAccessor {

    @Accessor("level")
    Level getLevel();
}

package com.ccswitch.notsimulateitempush.config;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/**
 * Minimal config screen with two toggle buttons. No Cloth Config needed.
 */
public class ConfigScreen extends Screen {

    private final Screen parent;

    public ConfigScreen(Screen parent) {
        super(Component.literal("Not Simulate Item Push"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        ModConfig config = ModConfig.get();
        int cx = this.width / 2;

        // Toggle 1: disable item push
        this.addRenderableWidget(
            Button.builder(
                toggleLabel("Not Simulate Item Push", config.enabled),
                btn -> {
                    config.enabled = !config.enabled;
                    ModConfig.save();
                    btn.setMessage(toggleLabel("Not Simulate Item Push", config.enabled));
                }
            ).pos(cx - 150, this.height / 2 - 30).size(300, 20).build()
        );

        // Toggle 2: disable piston block collision
        this.addRenderableWidget(
            Button.builder(
                toggleLabel("Piston Block Collision", config.disablePistonCollision),
                btn -> {
                    config.disablePistonCollision = !config.disablePistonCollision;
                    ModConfig.save();
                    btn.setMessage(toggleLabel("Piston Block Collision", config.disablePistonCollision));
                }
            ).pos(cx - 150, this.height / 2).size(300, 20).build()
        );

        // Done button
        this.addRenderableWidget(
            Button.builder(
                Component.literal("Done"),
                btn -> this.onClose()
            ).pos(cx - 75, this.height / 2 + 30).size(150, 20).build()
        );
    }

    @Override
    public void onClose() {
        if (this.minecraft != null) {
            this.minecraft.setScreen(parent);
        }
    }

    private static Component toggleLabel(String name, boolean enabled) {
        return Component.literal(name + ": " + (enabled ? "ON" : "OFF"));
    }
}

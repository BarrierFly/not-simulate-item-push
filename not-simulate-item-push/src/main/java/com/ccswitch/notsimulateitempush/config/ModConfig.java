package com.ccswitch.notsimulateitempush.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Simple JSON-backed config. Stored in {@code config/nopistonentity.json}.
 */
public class ModConfig {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = FabricLoader.getInstance().getConfigDir().resolve("notsimulateitempush.json");

    private static ModConfig instance;

    public boolean enabled = true;
    public boolean disablePistonCollision = false;

    public static ModConfig get() {
        if (instance == null) {
            load();
        }
        return instance;
    }

    private static void load() {
        if (Files.exists(PATH)) {
            try {
                instance = GSON.fromJson(Files.readString(PATH), ModConfig.class);
            } catch (Exception e) {
                instance = new ModConfig();
                save();
            }
        } else {
            instance = new ModConfig();
            save();
        }
    }

    public static void save() {
        try {
            Files.createDirectories(PATH.getParent());
            Files.writeString(PATH, GSON.toJson(instance != null ? instance : new ModConfig()));
        } catch (IOException ignored) {
            // silently ignore IO errors in config saving
        }
    }
}

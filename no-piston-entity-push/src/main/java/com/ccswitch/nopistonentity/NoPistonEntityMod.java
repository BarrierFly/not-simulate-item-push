package com.ccswitch.nopistonentity;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoPistonEntityMod implements ClientModInitializer {
    public static final String MOD_ID = "nopistonentity";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("[NoPistonEntity] Loaded! Client-side piston push for item entities is disabled.");
    }
}

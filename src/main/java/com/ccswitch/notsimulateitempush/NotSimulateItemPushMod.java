package com.ccswitch.notsimulateitempush;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotSimulateItemPushMod implements ClientModInitializer {
    public static final String MOD_ID = "notsimulateitempush";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("[NotSimulateItemPush] Loaded! Client will not simulate piston pushing of item entities.");
    }
}

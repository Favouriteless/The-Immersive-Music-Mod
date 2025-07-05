package com.github.charlyb01.common;

import com.github.charlyb01.Timm;
import com.github.charlyb01.client.ClientConfig;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraftforge.fml.config.ModConfig.Type;

public class TimmFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Timm.LOG.info("Hello Fabric world!");
        ForgeConfigRegistry.INSTANCE.register(Timm.MOD_ID, Type.CLIENT, ClientConfig.SPEC);
        Timm.init();
    }

}

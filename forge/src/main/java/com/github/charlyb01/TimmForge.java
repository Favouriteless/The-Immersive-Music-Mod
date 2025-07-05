package com.github.charlyb01;

import com.github.charlyb01.client.ClientConfig;
import com.github.charlyb01.platform.ForgeCommonRegistryHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Timm.MOD_ID)
public class TimmForge {
    
    public TimmForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ForgeCommonRegistryHelper.SOUND_EVENT_REGISTER.register(bus);
        ModLoadingContext.get().registerConfig(Type.CLIENT, ClientConfig.SPEC);

        Timm.init();
    }

}
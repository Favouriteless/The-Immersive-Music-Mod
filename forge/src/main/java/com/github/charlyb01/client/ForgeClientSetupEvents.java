package com.github.charlyb01.client;

import com.github.charlyb01.Timm;
import com.github.charlyb01.client.music.BiomePlaylist;
import com.github.charlyb01.client.music.Songs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Timm.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ForgeClientSetupEvents {

    @SubscribeEvent
    public static void onRegisterResourceListeners(final RegisterClientReloadListenersEvent event) {
        event.registerReloadListener(new BiomePlaylist());
        event.registerReloadListener(new Songs());
    }

}

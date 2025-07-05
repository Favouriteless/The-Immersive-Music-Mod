package com.github.charlyb01.client;

import com.github.charlyb01.Timm;
import com.github.charlyb01.client.command.HelpCmd;
import com.github.charlyb01.client.command.NowPlayingCmd;
import com.github.charlyb01.client.command.SkipCmd;
import com.github.charlyb01.client.command.StopCmd;
import com.github.charlyb01.client.music.BiomePlaylist;
import com.github.charlyb01.client.music.Songs;
import com.github.charlyb01.platform.FabricCommandContext;
import com.github.charlyb01.platform.FabricReloadListenerWrapper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.server.packs.PackType;

public class TimmClientFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, context) -> {

            dispatcher.register(ClientCommandManager.literal("nowplaying").executes(ctx -> NowPlayingCmd.run(new FabricCommandContext(ctx.getSource()))));
            dispatcher.register(ClientCommandManager.literal("np").executes(ctx -> NowPlayingCmd.run(new FabricCommandContext(ctx.getSource()))));
            dispatcher.register(ClientCommandManager.literal("timmhelp").executes(ctx -> HelpCmd.run(new FabricCommandContext(ctx.getSource()))));
            dispatcher.register(ClientCommandManager.literal("skip").executes(ctx -> SkipCmd.run(new FabricCommandContext(ctx.getSource()))));
            dispatcher.register(ClientCommandManager.literal("next").executes(ctx -> SkipCmd.run(new FabricCommandContext(ctx.getSource()))));
            dispatcher.register(ClientCommandManager.literal("timmstop").executes(ctx -> StopCmd.run(new FabricCommandContext(ctx.getSource()))));
            dispatcher.register(ClientCommandManager.literal("stp").executes(ctx -> StopCmd.run(new FabricCommandContext(ctx.getSource()))));

        });

        ResourceManagerHelper.get(PackType.CLIENT_RESOURCES).registerReloadListener(new FabricReloadListenerWrapper(Timm.id("biome_playlists"), new BiomePlaylist()));
        ResourceManagerHelper.get(PackType.CLIENT_RESOURCES).registerReloadListener(new FabricReloadListenerWrapper(Timm.id("biome_playlists"), new Songs()));
    }

}

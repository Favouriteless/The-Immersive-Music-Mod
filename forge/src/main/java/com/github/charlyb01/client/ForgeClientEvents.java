package com.github.charlyb01.client;

import com.github.charlyb01.Timm;
import com.github.charlyb01.client.command.HelpCmd;
import com.github.charlyb01.client.command.NowPlayingCmd;
import com.github.charlyb01.client.command.SkipCmd;
import com.github.charlyb01.client.command.StopCmd;
import com.github.charlyb01.client.music.BiomePlaylist;
import com.github.charlyb01.client.music.Songs;
import com.github.charlyb01.platform.ForgeCommandContext;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Timm.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class ForgeClientEvents {

    @SubscribeEvent
    public static void onRegisterCommands(final RegisterClientCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("nowplaying").executes(ctx -> NowPlayingCmd.run(new ForgeCommandContext(ctx.getSource()))));
        dispatcher.register(Commands.literal("np").executes(ctx -> NowPlayingCmd.run(new ForgeCommandContext(ctx.getSource()))));
        dispatcher.register(Commands.literal("timmhelp").executes(ctx -> HelpCmd.run(new ForgeCommandContext(ctx.getSource()))));
        dispatcher.register(Commands.literal("skip").executes(ctx -> SkipCmd.run(new ForgeCommandContext(ctx.getSource()))));
        dispatcher.register(Commands.literal("next").executes(ctx -> SkipCmd.run(new ForgeCommandContext(ctx.getSource()))));
        dispatcher.register(Commands.literal("timmstop").executes(ctx -> StopCmd.run(new ForgeCommandContext(ctx.getSource()))));
        dispatcher.register(Commands.literal("stp").executes(ctx -> StopCmd.run(new ForgeCommandContext(ctx.getSource()))));
    }
    
}

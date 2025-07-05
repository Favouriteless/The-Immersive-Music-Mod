package com.github.charlyb01.client.command;

import com.github.charlyb01.platform.CommonCommandContext;
import com.mojang.brigadier.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;


public class StopCmd {

    public static int run(CommonCommandContext context) {
        if(NowPlayingCmd.SONG_ID == null) {
            context.sendSuccess(Component.translatable("cmd.stop.none"));
        } else {
            context.sendSuccess(Component.translatable("cmd.stop"));
            Minecraft.getInstance().getMusicManager().stopPlaying();
        }
        return Command.SINGLE_SUCCESS;
    }

}

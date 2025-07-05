package com.github.charlyb01.client.command;

import com.github.charlyb01.client.music.Songs;
import com.github.charlyb01.platform.CommonCommandContext;
import com.mojang.brigadier.Command;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class NowPlayingCmd {

    public static ResourceLocation SONG_ID;

    public static int run(CommonCommandContext context) {
        Component song = Songs.getSongText(NowPlayingCmd.SONG_ID);
        Component text = song == null ? Component.translatable("cmd.nowPlaying.none") : Component.translatable("record.nowPlaying", song);
        context.sendSuccess(text);
        return Command.SINGLE_SUCCESS;
    }

}

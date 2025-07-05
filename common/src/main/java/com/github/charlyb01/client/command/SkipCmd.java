package com.github.charlyb01.client.command;

import com.github.charlyb01.client.ClientConfig;
import com.github.charlyb01.platform.CommonCommandContext;
import com.mojang.brigadier.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.client.sounds.MusicManager;

public class SkipCmd {

    public static int run(CommonCommandContext context ) {
        MusicManager manager = Minecraft.getInstance().getMusicManager();

        manager.stopPlaying();
        manager.startPlaying(Minecraft.getInstance().getSituationalMusic());

        if(ClientConfig.PRINT_ON_SKIP.get()) {
            NowPlayingCmd.run(context);
        }

        return Command.SINGLE_SUCCESS;
    }

}

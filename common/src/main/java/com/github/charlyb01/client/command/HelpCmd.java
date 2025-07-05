package com.github.charlyb01.client.command;

import com.github.charlyb01.platform.CommonCommandContext;
import com.mojang.brigadier.Command;
import net.minecraft.network.chat.Component;

public class HelpCmd {

    public static int run(CommonCommandContext context) {
        Component cfg = Component.literal("\n/cfg ").append(Component.translatable("cmd.help.cfg"));
        Component np = Component.literal("\n/nowplaying /np ").append(Component.translatable("cmd.help.nowPlaying"));
        Component skip = Component.literal("\n/skip /next ").append(Component.translatable("cmd.help.skip"));
        Component stop = Component.literal("\n/timmstop /stp ").append(Component.translatable("cmd.help.stop"));

        Component help = Component.translatable("cmd.help")
                .append(cfg)
                .append(np)
                .append(skip)
                .append(stop);

        context.sendSuccess(help);
        return Command.SINGLE_SUCCESS;
    }

}

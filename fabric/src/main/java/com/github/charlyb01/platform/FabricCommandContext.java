package com.github.charlyb01.platform;

import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.network.chat.Component;

public class FabricCommandContext implements CommonCommandContext {

    private final FabricClientCommandSource source;

    public FabricCommandContext(FabricClientCommandSource source) {
        this.source = source;
    }

    @Override
    public void sendSuccess(Component message) {
        source.sendFeedback(message);
    }

    @Override
    public void sendFailure(Component message) {
        source.sendError(message);
    }

}

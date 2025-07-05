package com.github.charlyb01.platform;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;

public class ForgeCommandContext implements CommonCommandContext {

    private final CommandSourceStack stack;

    public ForgeCommandContext(CommandSourceStack stack) {
        this.stack = stack;
    }

    @Override
    public void sendSuccess(Component message) {
        stack.sendSuccess(() -> message, false);
    }

    @Override
    public void sendFailure(Component message) {
        stack.sendFailure(message);
    }

}

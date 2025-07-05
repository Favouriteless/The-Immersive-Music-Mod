package com.github.charlyb01.platform;

import net.minecraft.network.chat.Component;

// RE: Fabric's client commands are horrible to work with :(
public interface CommonCommandContext {

    void sendSuccess(Component message);

    void sendFailure(Component message);

}

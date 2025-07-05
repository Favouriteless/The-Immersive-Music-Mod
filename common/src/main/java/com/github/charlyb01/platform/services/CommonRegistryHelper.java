package com.github.charlyb01.platform.services;

import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public interface CommonRegistryHelper {

    <T extends SoundEvent> Supplier<T> register(String name, Supplier<T> supplier);

}

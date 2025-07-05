package com.github.charlyb01.platform;

import com.github.charlyb01.Timm;
import com.github.charlyb01.platform.services.CommonRegistryHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class FabricCommonRegistryHelper implements CommonRegistryHelper {

    @Override
    public <T extends SoundEvent> Supplier<T> register(String name, Supplier<T> supplier) {
        T value = supplier.get();
        Registry.register(BuiltInRegistries.SOUND_EVENT, Timm.id(name), value);
        return () -> value;
    }

}

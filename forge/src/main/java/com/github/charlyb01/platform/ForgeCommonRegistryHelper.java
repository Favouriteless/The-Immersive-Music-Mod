package com.github.charlyb01.platform;

import com.github.charlyb01.Timm;
import com.github.charlyb01.platform.services.CommonRegistryHelper;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ForgeCommonRegistryHelper implements CommonRegistryHelper {

    public static final DeferredRegister<SoundEvent> SOUND_EVENT_REGISTER = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Timm.MOD_ID);

    @Override
    public <T extends SoundEvent> Supplier<T> register(String name, Supplier<T> supplier) {
        return SOUND_EVENT_REGISTER.register(name, supplier);
    }

}

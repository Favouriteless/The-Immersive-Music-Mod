package com.github.charlyb01;

import com.github.charlyb01.common.init.TimmSoundEvents;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

public class Timm {

    public static final String MOD_ID = "timm";
    public static final Logger LOG = LogUtils.getLogger();

    public static void init() {
        TimmSoundEvents.load();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

}
package com.github.charlyb01.platform;

import com.github.charlyb01.Timm;
import com.github.charlyb01.platform.services.CommonRegistryHelper;
import com.github.charlyb01.platform.services.PlatformHelper;

import java.util.ServiceLoader;


public class Services {

    public static final PlatformHelper PLATFORM = load(PlatformHelper.class);
    public static final CommonRegistryHelper COMMON_REGISTRY = load(CommonRegistryHelper.class);

    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        Timm.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }

}
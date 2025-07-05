package com.github.charlyb01.platform.services;

import java.nio.file.Path;

public interface PlatformHelper {

    boolean isModLoaded(String modId);

    Path getConfigPath();

}
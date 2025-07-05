package com.github.charlyb01.platform;

import com.github.charlyb01.platform.services.PlatformHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

import java.nio.file.Path;

public class ForgePlatformHelper implements PlatformHelper {

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public Path getConfigPath() {
        return FMLLoader.getGamePath().resolve("config");
    }

}
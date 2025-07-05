package com.github.charlyb01.client;

import com.github.charlyb01.Timm;
import com.github.charlyb01.platform.Services;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map.Entry;

public abstract class ConfigSingleFileReloadListener extends SimplePreparableReloadListener<JsonElement> {

    private final Gson gson;
    private final String file;

    /**
     * @param file Name of the file being searched for (without file extension)
     */
    public ConfigSingleFileReloadListener(Gson gson, String file) {
        this.gson = gson;
        this.file = file;
    }

    @Override
    protected JsonElement prepare(ResourceManager manager, ProfilerFiller profiler) {
        FileToIdConverter converter = FileToIdConverter.json("timm");

        // First we try to resolve the file from the config directory. If this fails, default to "standard" ReloadListener behaviour
        Path path = Services.PLATFORM.getConfigPath()
                .resolve(Timm.MOD_ID)
                .resolve(file + ".json");

        if(Files.exists(path)) {
            try(Reader reader = Files.newBufferedReader(path)) {
                return GsonHelper.fromJson(gson, reader, JsonObject.class);
            }
            catch(IOException e) {
                Timm.LOG.error("Error loading config resource: ", e);
            }
        }

        for(Entry<ResourceLocation, Resource> entry : converter.listMatchingResources(manager).entrySet()) {
            ResourceLocation id = converter.fileToId(entry.getKey());

            if(!id.getNamespace().equals(Timm.MOD_ID) || !id.getPath().equals(file))
                continue;

            try(Reader reader = entry.getValue().openAsReader()) {
                return GsonHelper.fromJson(gson, reader, JsonElement.class);
            }
            catch(IOException e) {
                Timm.LOG.error("Error loading resource: ", e);
            }
        }

        Timm.LOG.error("No valid resource found for: {}", file);
        return null;
    }

}

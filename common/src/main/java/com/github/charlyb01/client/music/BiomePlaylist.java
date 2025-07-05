package com.github.charlyb01.client.music;

import com.github.charlyb01.client.ClientConfig;
import com.github.charlyb01.client.ConfigSingleFileReloadListener;
import com.github.charlyb01.common.init.TimmSoundEvents;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BiomePlaylist extends ConfigSingleFileReloadListener {

    public static final Map<ResourceLocation, List<ResourceLocation>> EVENTS_BY_BIOME = new HashMap<>();

    private static final ResourceLocation CREATIVE_ID = new ResourceLocation("creative");
    private static final ResourceLocation MENU_ID = new ResourceLocation("menu");

    public BiomePlaylist() {
        super(new Gson(), "biome_playlists");
    }

    @Override
    protected void apply(JsonElement object, ResourceManager manager, ProfilerFiller profiler) {
        EVENTS_BY_BIOME.clear();

        if(object == null)
            return;
        JsonObject json = object.getAsJsonObject();
        for(String key : json.keySet()) {
            ResourceLocation biomeId = new ResourceLocation(key);
            List<ResourceLocation> musics = new ArrayList<>();

            for(JsonElement element : json.getAsJsonArray(key)) {
                musics.add(new ResourceLocation(element.getAsString()));
            }

            EVENTS_BY_BIOME.put(biomeId, musics);
        }
    }

    public static Music getMusic(ResourceLocation biomeId, RandomSource random) {
        List<ResourceLocation> musics = EVENTS_BY_BIOME.get(biomeId);
        if(musics == null || musics.isEmpty())
            return null;

        ResourceLocation id = musics.get(random.nextInt(musics.size()));
        Holder<SoundEvent> event = TimmSoundEvents.getHolder(id);
        if(event == null)
            return null;

        return new Music(event, ClientConfig.MIN_DELAY.get() * 20, ClientConfig.MAX_DELAY.get() * 20, false);
    }

    public static Music getCreativeMusic(RandomSource random) {
        List<ResourceLocation> musics = EVENTS_BY_BIOME.get(CREATIVE_ID);
        if (musics == null || musics.isEmpty()) return null;

        ResourceLocation id = musics.get(random.nextInt(musics.size()));
        Holder<SoundEvent> event = TimmSoundEvents.getHolder(id);
        if(event == null)
            return null;

//        return new Music(event, ModConfig.get().general.minDelay * 20, ModConfig.get().general.maxDelay * 20, false);
        return new Music(event, 20, 60, false);
    }

    public static Music getMenuMusic() {
        List<ResourceLocation> musics = EVENTS_BY_BIOME.get(MENU_ID);
        if(musics == null || musics.isEmpty())
            return null;

        ResourceLocation id = musics.get(0);
        Holder<SoundEvent> event = TimmSoundEvents.getHolder(id);
        if(event == null)
            return null;

        return new Music(event, 20, 60, false);
    }

}
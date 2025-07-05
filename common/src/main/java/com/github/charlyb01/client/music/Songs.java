package com.github.charlyb01.client.music;

import com.github.charlyb01.client.ConfigSingleFileReloadListener;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.HashMap;
import java.util.Map;

public class Songs extends ConfigSingleFileReloadListener {

    private static final Map<ResourceLocation, Component> SONG_TEXT_BY_SONG_ID = new HashMap<>();

    public Songs() {
        super(new Gson(), "songs");
    }

    @Override
    protected void apply(JsonElement object, ResourceManager resourceManager, ProfilerFiller profiler) {
        SONG_TEXT_BY_SONG_ID.clear();

        if(object == null)
            return;
        JsonObject json = object.getAsJsonObject();
        for(String key : json.keySet()) {
            JsonObject song = json.getAsJsonObject(key);

            ResourceLocation id = new ResourceLocation(key);
            String name = song.get("name").getAsString();
            String url = song.get("link").getAsString();

            SONG_TEXT_BY_SONG_ID.put(id, makeSongText(id, name, url));
        }
    }

    public static Component getSongText(ResourceLocation id) {
        if(id == null)
            return null;
        return SONG_TEXT_BY_SONG_ID.getOrDefault(id, Component.literal(id.toString()));
    }

    private static Component makeSongText(ResourceLocation id, String name, String url) {
        MutableComponent text = Component.literal(name == null ? id.toString() : name);
        if(url != null) {
            text.setStyle(Style.EMPTY.withColor(ChatFormatting.GREEN)
                    .withUnderlined(true)
                    .withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url)));
        }
        return text;
    }

}


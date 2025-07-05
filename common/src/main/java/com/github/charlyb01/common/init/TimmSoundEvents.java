package com.github.charlyb01.common.init;

import com.github.charlyb01.Timm;
import com.github.charlyb01.platform.Services;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class TimmSoundEvents {

    public static final Supplier<SoundEvent> MENU = register("menu");

    public static final Supplier<SoundEvent> BADLANDS = register("badlands");
    public static final Supplier<SoundEvent> BAMBOO_JUNGLE = register("bamboo_jungle");
    public static final Supplier<SoundEvent> BEACH = register("beach");
    public static final Supplier<SoundEvent> BIRCH_FOREST = register("birch_forest");
    public static final Supplier<SoundEvent> CHERRY_GROVE = register("cherry_grove");
    public static final Supplier<SoundEvent> COLD_OCEAN = register("cold_ocean");
    public static final Supplier<SoundEvent> DARK_FOREST = register("dark_forest");
    public static final Supplier<SoundEvent> DEEP_DARK = register("deep_dark");
    public static final Supplier<SoundEvent> DESERT = register("desert");
    public static final Supplier<SoundEvent> DRIPSTONE_CAVES = register("dripstone_caves");
    public static final Supplier<SoundEvent> FLOWER_FOREST = register("flower_forest");
    public static final Supplier<SoundEvent> FOREST = register("forest");
    public static final Supplier<SoundEvent> ICE_SPIKES = register("ice_spikes");
    public static final Supplier<SoundEvent> JUNGLE = register("jungle");
    public static final Supplier<SoundEvent> LUSH_CAVES = register("lush_caves");
    public static final Supplier<SoundEvent> MEADOW = register("meadow");
    public static final Supplier<SoundEvent> MOUNTAINS = register("mountains");
    public static final Supplier<SoundEvent> MUSHROOM_FIELDS = register("mushroom_fields");
    public static final Supplier<SoundEvent> OCEAN = register("ocean");
    public static final Supplier<SoundEvent> PLAINS = register("plains");
    public static final Supplier<SoundEvent> RIVER = register("river");
    public static final Supplier<SoundEvent> SAVANNA = register("savanna");
    public static final Supplier<SoundEvent> SNOW_PLAINS = register("snow_plains");
    public static final Supplier<SoundEvent> SWAMP = register("swamp");
    public static final Supplier<SoundEvent> TAIGA = register("taiga");
    public static final Supplier<SoundEvent> WARM_OCEAN = register("warm_ocean");
    public static final Supplier<SoundEvent> WINDY_HILLS = register("windy_hills");

    public static final Supplier<SoundEvent> BASALT_DELTAS = register("basalt_deltas");
    public static final Supplier<SoundEvent> CRIMSON_FOREST = register("crimson_forest");
    public static final Supplier<SoundEvent> NETHER_WASTES = register("nether_wastes");
    public static final Supplier<SoundEvent> SOUL_SAND_VALLEY = register("soul_sand_valley");

    public static Supplier<SoundEvent> register(String name) {
        return Services.COMMON_REGISTRY.register(name, () -> SoundEvent.createVariableRangeEvent(Timm.id(name)));
    }

    public static Holder<SoundEvent> getHolder(ResourceLocation id) {
        return BuiltInRegistries.SOUND_EVENT.getHolder(ResourceKey.create(Registries.SOUND_EVENT, id)).orElse(null);
    }

    public static void load() {} // Bootstrap method

}

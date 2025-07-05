package com.github.charlyb01.mixin.client;

import com.github.charlyb01.Timm;
import com.github.charlyb01.client.music.BiomePlaylist;
import com.github.charlyb01.client.music.Songs;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Music;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Shadow public LocalPlayer player;

    @ModifyExpressionValue(method = "getSituationalMusic", at = @At(value = "FIELD", target = "Lnet/minecraft/sounds/Musics;MENU:Lnet/minecraft/sounds/Music;"))
    private Music updateMenuMusic(Music original) {
        Music music = BiomePlaylist.getMenuMusic();
        return music != null ? music : original;
    }

    @ModifyExpressionValue(method = "getSituationalMusic", at = @At(value = "FIELD", target = "Lnet/minecraft/sounds/Musics;END:Lnet/minecraft/sounds/Music;"))
    private Music updateEndMusic(Music original) {
        if(player == null)
            return original;

        Holder<Biome> biome = player.level().getBiome(player.blockPosition());
        Optional<ResourceKey<Biome>> key = biome.unwrapKey();
        if(key.isEmpty())
            return original;

        Music music = BiomePlaylist.getMusic(key.get().location(), player.getRandom());
        return music != null ? music : original;
    }

    @ModifyExpressionValue(method = "getSituationalMusic", at = @At(value = "FIELD", target = "Lnet/minecraft/sounds/Musics;CREATIVE:Lnet/minecraft/sounds/Music;"))
    private Music updateCreativeMusic(Music original) {
        if(player == null)
            return original;

        Music music = BiomePlaylist.getCreativeMusic(player.getRandom());
        return music != null ? music : original;
    }

    @ModifyExpressionValue(method = "getSituationalMusic", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/biome/Biome;getBackgroundMusic()Ljava/util/Optional;"))
    private Optional<Music> updateBiomeMusic(Optional<Music> original) {
        if(player == null)
            return original;

        Holder<Biome> biome = player.level().getBiome(player.blockPosition());
        Optional<ResourceKey<Biome>> key = biome.unwrapKey();
        if(key.isEmpty())
            return original;

        Music music = BiomePlaylist.getMusic(key.get().location(), player.getRandom());
        return music != null ? Optional.of(music) : original;
    }

}

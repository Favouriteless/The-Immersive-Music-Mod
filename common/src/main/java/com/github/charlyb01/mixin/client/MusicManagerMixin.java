package com.github.charlyb01.mixin.client;

import com.github.charlyb01.client.command.NowPlayingCmd;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.sounds.Music;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MusicManager.class)
public class MusicManagerMixin {

    @Shadow @Nullable private SoundInstance currentMusic;

    @Inject(method = "startPlaying", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sounds/SoundManager;play(Lnet/minecraft/client/resources/sounds/SoundInstance;)V", shift = Shift.AFTER))
    private void saveMusic(Music music, CallbackInfo ci) {
        if(currentMusic == null)
            return;
        NowPlayingCmd.SONG_ID = currentMusic.getSound().getLocation();
    }

    // 181 is PUTFIELD. I have no idea why the Opcodes class isn't visible here.
    @Inject(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/client/sounds/MusicManager;currentMusic:Lnet/minecraft/client/resources/sounds/SoundInstance;", opcode = 181))
    private void resetMusicOnNull(CallbackInfo ci) {
        NowPlayingCmd.SONG_ID = null;
    }

    @Inject(method = "stopPlaying()V", at = @At(value = "HEAD"))
    private void resetMusicOnStop(CallbackInfo ci) {
        NowPlayingCmd.SONG_ID = null;
    }

}

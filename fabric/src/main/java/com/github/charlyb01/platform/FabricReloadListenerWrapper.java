package com.github.charlyb01.platform;

import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class FabricReloadListenerWrapper implements IdentifiableResourceReloadListener {

    private final ResourceLocation id;
    private final PreparableReloadListener dataLoader;

    public FabricReloadListenerWrapper(ResourceLocation id, PreparableReloadListener dataLoader) {
        this.id = id;
        this.dataLoader = dataLoader;
    }

    @Override
    public ResourceLocation getFabricId() {
        return id;
    }

    @Override
    public CompletableFuture<Void> reload(PreparationBarrier barrier, ResourceManager manager, ProfilerFiller prepProfiler, ProfilerFiller reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
        return dataLoader.reload(barrier, manager, prepProfiler, reloadProfiler, backgroundExecutor, gameExecutor);
    }

}
package com.github.charlyb01.client;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class ClientConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final IntValue MIN_DELAY;
    public static final IntValue MAX_DELAY;

    public static final BooleanValue PRINT_ON_SKIP;

    static {
        MIN_DELAY = BUILDER.comment("Minimum delay between songs (in seconds).").defineInRange("min_delay", 120, 0, Integer.MAX_VALUE);
        MAX_DELAY = BUILDER.comment("Maximum delay between songs (in seconds).").defineInRange("max_delay", 300, 0, Integer.MAX_VALUE);
        PRINT_ON_SKIP = BUILDER.comment("If true, print the name of the current song when skipping.").define("print_on_skip", true);
        SPEC = BUILDER.build();
    }

}

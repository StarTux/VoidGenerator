package com.cavetale.voidgenerator;

import java.util.logging.Level;
import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class VoidGeneratorPlugin extends JavaPlugin {
    protected static final VoidGenerator GENERATOR = new VoidGenerator();
    protected static final VoidBiomeProvider BIOME_PROVIDER = new VoidBiomeProvider(Biome.THE_VOID);

    @Override
    public VoidGenerator getDefaultWorldGenerator(String worldName, String id) {
        return GENERATOR;
    }

    @Override
    public BiomeProvider getDefaultBiomeProvider(String worldName, String id) {
        if (id == null) return BIOME_PROVIDER;
        try {
            return new VoidBiomeProvider(Biome.valueOf(id.toUpperCase()));
        } catch (IllegalArgumentException iae) {
            getLogger().log(Level.SEVERE, "world=" + worldName + " id=" + id, iae);
            return BIOME_PROVIDER;
        }
    }
}

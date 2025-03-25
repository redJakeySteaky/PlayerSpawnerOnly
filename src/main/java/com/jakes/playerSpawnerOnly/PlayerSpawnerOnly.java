package com.jakes.playerSpawnerOnly;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerSpawnerOnly extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public static boolean isPlayerPlaced(CreatureSpawner b) {
        if(b.getPersistentDataContainer().has(Keys.PLAYER_PLACED)) {
            return Boolean.TRUE.equals(b.getPersistentDataContainer().get(Keys.PLAYER_PLACED, PersistentDataType.BOOLEAN));
        }
        return false;
    }
}

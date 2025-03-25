package com.jakes.playerSpawnerOnly;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.TileState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class EventListener implements Listener {

    @EventHandler
    public static void spawnerSpawn(SpawnerSpawnEvent event) {
        // if spawner is not player placed
        if(!PlayerSpawnerOnly.isPlayerPlaced(Objects.requireNonNull(event.getSpawner()))) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void blockPlace(BlockPlaceEvent event){
        if(event.getBlockPlaced().getType()==Material.SPAWNER) {
            Block b = event.getBlockPlaced();

            if(b.getState() instanceof TileState state) {
                state.getPersistentDataContainer().set(Keys.PLAYER_PLACED, PersistentDataType.BOOLEAN, true);
                state.update();
            }
        }
    }
}

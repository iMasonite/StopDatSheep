package com.keneti.misc;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/** @author Michael Mason */
public class StopDatSheep extends JavaPlugin implements Listener {
  
  @Override
  public void onEnable() {
    this.getServer().getPluginManager().registerEvents(this, this);
  }
  
  @EventHandler
  public void onSheepEatGrass(EntityChangeBlockEvent event) {
    
    if(event.getEntity().getType() == EntityType.SHEEP) {
      
      // WARNING: If you do this, sheep don't re-grow wool...
      // event.setCancelled(true);
      
      // Do this instead...
      final Location loc = event.getBlock().getLocation();
      
      if(event.getBlock().getType().equals(Material.GRASS) && event.getTo().equals(Material.DIRT)) {
        
        new BukkitRunnable() {
          @Override
          public void run() {
            loc.getBlock().setType(Material.GRASS);
          }
        }.runTaskLater(this, 20L);
      }
    }
  }
}

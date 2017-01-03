package com.keneti.misc;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.plugin.java.JavaPlugin;

/** @author Michael Mason */
public class StopDatSheep extends JavaPlugin implements Listener {
  
  @Override
  public void onEnable() {
    this.getServer().getPluginManager().registerEvents(this, this);
  }
  
  @EventHandler
  public void onSheepEatGrass(EntityChangeBlockEvent event) {
    
    if(event.getEntity().getType() == EntityType.SHEEP) {
      event.setCancelled(true);
    }
  }
}

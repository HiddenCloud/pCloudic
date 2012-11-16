package src;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityListener implements Listener {
private Plugin pl;

public EntityListener(Plugin plugin){
	pl = plugin;
}

@EventHandler(priority = EventPriority.MONITOR)
public void onEntityDeath(EntityDeathEvent event) {
	Entity e = event.getEntity();
	

}
}

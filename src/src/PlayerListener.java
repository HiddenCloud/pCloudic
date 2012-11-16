package src;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;



public class PlayerListener implements Listener {
	
	private Plugin pl;
	
	public PlayerListener(Plugin plugin){
		pl = plugin;
	}
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerLogin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        
        p.sendMessage(ChatColor.DARK_GRAY+ Plugin.wMsg + ChatColor.WHITE + Plugin.ServerName);
        p.sendMessage(Plugin.wMsg2);
	}
	@EventHandler(priority = EventPriority.MONITOR)
	public void onEnityDeath(PlayerDeathEvent event){
		Player p = event.getEntity();
		
	}


}

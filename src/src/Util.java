package src;

import org.bukkit.ChatColor;
import org.bukkit.Server;

public class Util{
	public static Server l;
	public static Plugin p;

	public Util(Server server, Plugin plugin) {
		l = server;
		p = plugin;
	}
	public static void broadcast(String string) {
	l.broadcastMessage(ChatColor.GOLD +
			"[" + ChatColor.BOLD +
			"Server" + ChatColor.GOLD +
			"]: " + ChatColor.WHITE + string);	
	}

	
	
}
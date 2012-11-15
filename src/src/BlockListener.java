package src;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;


public class BlockListener implements Listener{
	private Plugin pl;
	public Material[] blocksList= {Material.BEDROCK};
	
	public BlockListener(Plugin plugin){
		pl = plugin;
	}
	@EventHandler(priority = EventPriority.MONITOR)
	public void onBlockBreak(BlockBreakEvent event) {
		
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onBlockPlace(BlockPlaceEvent event){
		Material block = event.getBlock().getType();
		Player p = event.getPlayer();
		Block b = event.getBlockPlaced();
		if(p.isOp()){
			return;
		}
			for(Material blocked : blocksList){
				if(blocked == block){
					if(!p.isOp()){
						event.getBlock().setType(Material.AIR);
					Util.broadcast(ChatColor.RED + p.getName() +" has placed " + ChatColor.GRAY+ block.name());	
					 p.getInventory().remove(Material.BEDROCK);
					 p.kickPlayer(ChatColor.RED+"Seems like you're gonna have a bad time.");
					}
					
				}
			}
	}

}

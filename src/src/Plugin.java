package src;

import net.minecraft.server.NetServerHandler;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Plugin extends JavaPlugin {
	private AutoAnnouncer AA;
	static boolean hasBeenEnabled;
    static boolean aquaman;
    static boolean aquaman2;
    static boolean vanish;
    static String ServerName = "CloudCraft";
	static String wMsg = "Welcome to ";
	static String wMsg2 = "";

    
public Plugin(){

}
	
	public void onEnable() {
		hasBeenEnabled = true;
	getLogger().info("pCloudic has been enabled.");	
	getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
	getServer().getPluginManager().registerEvents(new BlockListener(this), this);
	getServer().getPluginManager().registerEvents(new EntityListener(this), this);
	Util u = new Util(super.getServer(), this);
	Thread r = new Thread(new AutoAnnouncer(this));
	r.start();
	


	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		String s = cmd.getName();
		//String l2 = commandLabel.toLowerCase();
		 
		 
		if(s.equalsIgnoreCase("ckick"))
{ 
			if (args.length < 1)
		        {
		          
		           return false;
		        }

			String p = args[0];
			Player p2 = getServer().getPlayer(p);
			if(p2 == null)
			      {
				        sender.sendMessage(ChatColor.RED + "Player not found.");
			       }
			
	
				p2.sendMessage(ChatColor.RED + "Think before you act.");

		
                   CraftPlayer p3 = (CraftPlayer) p2;
                    NetServerHandler l = p3.getHandle().netServerHandler;
                      l.sendPacket(new net.minecraft.server.Packet103SetSlot(0, -1, null));
			            return true;
		           } 
		
		if(s.equalsIgnoreCase("poke")){

			if(args.length == 0){
				Player p3 = (Player) sender;
				p3.sendMessage(ChatColor.BLUE + sender.getName()+" poked you.");
			}

			if(args.length == 1){
				String p = args[0];
				Player p2 = getServer().getPlayer(p);
				if(!p2.isOnline()){
					sender.sendMessage(ChatColor.RED + args[0] + " is not online!");
				}
				
				p2.sendMessage(ChatColor.BLUE + sender.getName()+" poked you.");
			}
			
			return true;
			
		}
	
		
		if(s.equalsIgnoreCase("list")) {
			Player[] pls = getServer().getOnlinePlayers();
			sender.sendMessage(pls.toString());
			return true;
		}
		
		if(s.equalsIgnoreCase("tpto")){
			if(args.length < 1)
				sender.sendMessage("Wrong format. Use /tpto playername");
			String p = args[0];
			Player p2 = getServer().getPlayer(p);
			if(p2 == null){
				sender.sendMessage(ChatColor.RED + args[0] + " is not online!");
				return false;
			}
			p2.teleport(p2);
			sender.sendMessage("Teleported to " + p2.getDisplayName());
			return true;
		}
		if(s.equalsIgnoreCase("aquaman")){
			Player theSender = (Player) sender;
			if(args.length == 0) {
				theSender.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 9999, 999));
			sender.sendMessage(ChatColor.AQUA + "You can now breath underwater");
			return true;
			}
			else if(args.length == 1) {
				String p = args[0];
				Player theTarget = getServer().getPlayer(p);
				if(!theTarget.isOnline()){
					sender.sendMessage("Player is not online.");
				}
			theTarget.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999, 999));
			theTarget.sendMessage(ChatColor.AQUA + "You can now breath underwater");
					return true;
			}
					
				
		}
		if(s.equalsIgnoreCase("Ping")){
			sender.sendMessage("Pong");
			return true;
		}
	    /*if(s.equalsIgnoreCase("spy"))
        {
            vanish = !vanish;
            Player p2 = (Player)sender;
            CraftPlayer p3 = (CraftPlayer)p2;
            NetServerHandler l = p3.getHandle().netServerHandler;
            if(vanish)
            {
                l.sendPacket(new Packet29DestroyEntity(p3.getEntityId()));
                sender.sendMessage((new StringBuilder()).append(ChatColor.RED).append("You are now invisible.").toString());
            } else
            {
                l.sendPacket(new Packet29DestroyEntity(p3.getEntityId()));
                l.sendPacket(new Packet20NamedEntitySpawn(p3.getHandle()));
                sender.sendMessage((new StringBuilder()).append(ChatColor.GREEN).append("You are now visible.").toString());
            }
            return true;
        }*/
		
		 
		
		return false;
}
	
	public void onDisable() {
		hasBeenEnabled = false;
		getLogger().info("pCloudic has been disabled.");
	}



}

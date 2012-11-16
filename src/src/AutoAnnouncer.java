package src;

import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;

public class AutoAnnouncer implements Runnable {
	private Plugin pl;
	static boolean isEnabled = true;
	static String Msg1 = ChatColor.ITALIC + "For the rules check /rules";
	static String Msg2 = ChatColor.ITALIC + "If you break the rules you'll risk a ban.";
	static String Msg3 = ChatColor.ITALIC + "Hi there, have fun!";
	int MsgNumber = 0;
	
	public AutoAnnouncer(Plugin plugin){
		pl = plugin;
	}

	@Override
	public void run() {
		while(isEnabled){
		if(MsgNumber > 3)
			MsgNumber = 0;
MsgNumber++;
Util.broadcast(getMessage(MsgNumber));
		try{
			Thread.sleep(TimeUnit.MINUTES.toMillis(10));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	}
	public String getMessage(int i){
		if(i == 1)
			return Msg1;
		else if(i == 2)
			return Msg2;
		else if(i == 3)
			return Msg3;
		else
			return "Error, message not found";
	}

}

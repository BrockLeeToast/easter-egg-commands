package strudel2010.EEC;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MyPlayerListener implements Listener {
	public static EEC plugin;

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		
		if(event.getMessage().toLowerCase().contains("fox")){
			player.sendMessage(ChatColor.RED + "WA-PA-PA-PA-PA-PA-POW!");
		}
	}
}

package strudel2010.EEC;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MyPlayerListener implements Listener {
	private EEC plugin;
	
	public MyPlayerListener(EEC plugin) {
		this.plugin = plugin;
	}
	
	
	private static int getRandomNumber(int begin, int end) {
		Random generator = new Random();
		return generator.nextInt(end - begin + 1) + begin;
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		final String[] fox = new String[8];
		fox[0] = "Ring-ding-ding-ding-dingeringeding!";
		fox[1] = "Wa-pa-pa-pa-pa-pa-pow!";
		fox[2] = "Hatee-hatee-hatee-ho!";
		fox[3] = "Joff-tchoff-tchoffo-tchoffo-tchoff!";
		fox[4] = "Jacha-chacha-chacha-chow!";
		fox[5] = "Fraka-kaka-kaka-kaka-kow!";
		fox[6] = "A-hee-ahee ha-hee!";
		fox[7] = "A-oo-oo-oo-ooo!";
		
		final Player[] players = Bukkit.getOnlinePlayers();
		
		if(event.getMessage().toLowerCase().contains("fox")){
			Bukkit.getScheduler().runTaskLater(this.plugin,  new Runnable() {
				@Override
				public void run()
				{
					Bukkit.broadcastMessage(ChatColor.GREEN + fox[getRandomNumber(0, fox.length - 1)]);
					for(int i = 0; i < players.length; i++) {
						players[i].playSound(players[i].getLocation(), Sound.WOLF_HOWL, 0.5F, getRandomNumber(0, fox.length - 1));
					}
				}
			}, 1);
		}
		if(event.getMessage().toLowerCase().contains("broken") || event.getMessage().toLowerCase().contains("bug")) {
			Bukkit.getScheduler().runTaskLater(this.plugin,  new Runnable() {
				@Override
				public void run()
				{
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "#BlameEndain");
					for(int i = 0; i < players.length; i++) {
						players[i].playSound(players[i].getLocation(), Sound.ITEM_BREAK, 0.5F, 1F);
					}
				}
			}, 1);
		}
		for(int i = 0; i < players.length; i++) {
			if(event.getMessage().contains(players[i].getName())) {
				players[i].playSound(players[i].getLocation(), Sound.LEVEL_UP, 1F, 1F);
			}
		}
	}
}

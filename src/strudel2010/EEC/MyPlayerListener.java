package strudel2010.EEC;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MyPlayerListener implements Listener {
	public static EEC plugin;
	
	private static int getRandomNumber(int begin, int end) {
		Random generator = new Random();
		return generator.nextInt(end - begin + 1) + begin;
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		String[] fox = new String[8];
		fox[0] = "Ring-ding-ding-ding-dingeringeding!";
		fox[1] = "Wa-pa-pa-pa-pa-pa-pow!";
		fox[2] = "Hatee-hatee-hatee-ho!";
		fox[3] = "Joff-tchoff-tchoffo-tchoffo-tchoff!";
		fox[4] = "Jacha-chacha-chacha-chow!";
		fox[5] = "Fraka-kaka-kaka-kaka-kow!";
		fox[6] = "A-hee-ahee ha-hee!";
		fox[7] = "A-oo-oo-oo-ooo!";
		Player player = event.getPlayer();
		Location loc = player.getLocation();
		
		if(event.getMessage().toLowerCase().contains("fox")){
			player.sendMessage(ChatColor.GREEN + fox[getRandomNumber(0, fox.length - 1)]);
			player.playSound(loc, Sound.WOLF_HOWL, 0.5F, getRandomNumber(0, fox.length - 1));
		}
		if(event.getMessage().toLowerCase().contains("broken") || event.getMessage().toLowerCase().contains("bug")) {
			player.sendMessage(ChatColor.RED + "#BlameEndain");
			player.playSound(loc, Sound.ITEM_BREAK, 0.5F, 1F);
		}
	}
}

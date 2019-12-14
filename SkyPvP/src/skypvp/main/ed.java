package skypvp.main;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class ed implements Listener{
	public static int hearty;
	public static int heart = 6;
	
	public ed(skypvp.main.main main){
		this.pl = main;
	}
	private skypvp.main.main pl;
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e){
		final Player p = e.getPlayer();

		e.setResult(Result.KICK_OTHER);
		e.setKickMessage("§cBitte warte noch §45§c Sekunden, bis du erneut joinen kannst!");
		e.disallow(Result.KICK_OTHER, "§cBitte warte noch §45§c Sekunden, bis du erneut joinen kannst!");
		p.kickPlayer("");
	}
}
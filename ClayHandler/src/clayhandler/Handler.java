package clayhandler;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.MrCodex.MySQLCloud.SQL.CoinsAPI;

public class Handler implements Listener {

	public static HashMap<String, Integer> clays = new HashMap<>();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		clays.put(p.getName(), 0);
		return;
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		if(k != null){
			clays.put(k.getName(), clays.get(k.getName()) + Data.CurrentClays);
			Data.ServerClays = Data.ServerClays + clays.get(k.getName());
		}
		return;
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		CoinsAPI.addCoins(p.getName(), clays.get(p.getName()));
		return;
	}
}

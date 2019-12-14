package servercore.boardmanager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ScoreboardManager implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		for(Player all : Bukkit.getOnlinePlayers()){
		Scoreboard.setScoreboard(all);
		}
	}

}

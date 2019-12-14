package skypvp.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;


public class sb implements Listener{
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		updateScoreboard(p);
		for(Player all : Bukkit.getOnlinePlayers()){
			updateScoreboard(all);
		}
		
	}

	public void updateScoreboard(Player p){
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("aaa", "aas");
		obj.setDisplayName("§6§lDrUnterhose.de");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		Score a = obj.getScore(Bukkit.getOfflinePlayer("§7------------------>"));
		Score b = obj.getScore(Bukkit.getOfflinePlayer("§eDein Server:"));
		Score c = obj.getScore(Bukkit.getOfflinePlayer("§bSkyPvP"));
		Score d2 = obj.getScore(Bukkit.getOfflinePlayer("§b" + Bukkit.getOnlinePlayers().size()));
		Score d = obj.getScore(Bukkit.getOfflinePlayer("§eAktuelle Spieler:"));
		Score e = obj.getScore(Bukkit.getOfflinePlayer("§7------------------->"));
		Score f = obj.getScore(Bukkit.getOfflinePlayer("§eStatus:"));
		Score g = obj.getScore(Bukkit.getOfflinePlayer("§aÖffentlich"));
		Score h = obj.getScore(Bukkit.getOfflinePlayer("§7----------------->"));
		Score i = obj.getScore(Bukkit.getOfflinePlayer("§eTeamspeak Server:"));
		Score j = obj.getScore(Bukkit.getOfflinePlayer("§bDrUnterhose.de"));
		

		j.setScore(1);
		i.setScore(2);
		h.setScore(3);
		g.setScore(4);
		f.setScore(5);
		a.setScore(6);
		b.setScore(8);
		c.setScore(7);
		d2.setScore(9);
		d.setScore(10);
		e.setScore(11);
		
		p.setScoreboard(board);
		


	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		for(Player all : Bukkit.getOnlinePlayers()){
			updateScoreboard(all);
		}
	}
}



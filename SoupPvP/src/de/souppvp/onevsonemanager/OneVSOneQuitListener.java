package de.souppvp.onevsonemanager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.souppvp.data.Data;
import de.souppvp.data.Scoreboard;
import de.souppvp.listener.PlayerJoinListener;
import de.souppvp.spawnmanager.SpawnManager;

public class OneVSOneQuitListener implements Listener{
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		if(Data.INOneVSOneJoin.contains(p)){
			if(FightManager.PlayerO.containsKey(p.getName())){
				Player t = Bukkit.getPlayer(FightManager.PlayerO.get(p.getName()));
				t.sendMessage(Data.Prefix + "§eDu hast den Kampf gegen §6" + p.getName() + "§e gewonnen!");
				t.sendTitle("§aGewonnen", "§7Ursache: §eRagequit");
				FightManager.onevsone.remove(t);
				OneVSOneLobby.setOneVSOneInventory(t);
				SpawnManager.teleportToSpawn(t, "1vs1");
				Data.INOneVSOneJoin.remove(t);
				Data.OneVSOneJoin.add(t);
				Data.OneVSOneWarteschlange.remove(t);
				Scoreboard.setScoreboard(t);
				for(Player all : Bukkit.getOnlinePlayers()){
	    			t.showPlayer(all);
	    			}
			}
			if(FightManager.PlayerT.containsKey(p.getName())){
				Player t = Bukkit.getPlayer(FightManager.PlayerT.get(p.getName()));
				t.sendMessage(Data.Prefix + "§eDu hast den Kampf gegen §6" + p.getName() + "§e gewonnen!");
				t.sendTitle("§aGewonnen", "§7Ursache: §eRagequit");
				FightManager.onevsone.remove(t);
				OneVSOneLobby.setOneVSOneInventory(t);
				SpawnManager.teleportToSpawn(t, "1vs1");
				Data.INOneVSOneJoin.remove(t);
				Data.OneVSOneJoin.add(t);
				Data.OneVSOneWarteschlange.remove(t);
				Scoreboard.setScoreboard(t);
				for(Player all : Bukkit.getOnlinePlayers()){
    			t.showPlayer(all);
				}
			}
		}
	}

}

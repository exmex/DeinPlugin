package de.souppvp.onevsonemanager;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.souppvp.data.Data;
import de.souppvp.data.Scoreboard;
import de.souppvp.spawnmanager.SpawnManager;

public class OneVSOneDeath implements Listener{
	public OneVSOneDeath(de.souppvp.main.Main Main){
		this.pl = Main;
	}
	private de.souppvp.main.Main pl;

	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		if(FightManager.onevsone.contains(p)){
			for(Player all : Bukkit.getOnlinePlayers()){
				all.showPlayer(all);
			}
			p.setHealth(20);
			p.setHealth(20);
			p.setHealth(20);
			p.setHealth(20);
			p.setFireTicks(0);
			if(k != null){
				p.setHealth(20);
				k.setHealth(20);
				SpawnManager.teleportToSpawn(p, "1vs1");
				Data.firstJoin.remove(p);
				Data.FeastJoin.remove(p);
				Data.INOneVSOneJoin.remove(p);
				Data.OneVSOneJoin.add(p);
				OneVSOneLobby.setOneVSOneInventory(p);
				
				SpawnManager.teleportToSpawn(k, "1vs1");
				Data.firstJoin.remove(k);
				Data.FeastJoin.remove(k);
				Data.INOneVSOneJoin.remove(k);
				Data.OneVSOneJoin.add(k);
				OneVSOneLobby.setOneVSOneInventory(k);
			}else{
				p.setHealth(20);
				if(FightManager.PlayerO.containsKey(p.getName())){
					Player target = Bukkit.getPlayer(FightManager.PlayerO.get(p.getName()));
					SpawnManager.teleportToSpawn(p, "1vs1");
					Data.firstJoin.remove(p);
					Data.FeastJoin.remove(p);
					Data.INOneVSOneJoin.remove(p);
					Data.OneVSOneJoin.add(p);
					OneVSOneLobby.setOneVSOneInventory(p);
					OneVSOneWarteschlange.warteschlange.remove(p);
					OneVSOneWarteschlange.warteschlange.remove(k);

					SpawnManager.teleportToSpawn(k, "1vs1");
					Data.firstJoin.remove(k);
					Data.FeastJoin.remove(k);
					Data.INOneVSOneJoin.remove(k);
					Data.OneVSOneJoin.add(k);
					OneVSOneLobby.setOneVSOneInventory(k);
					target.setHealth(20);	
					
				}
				if(FightManager.PlayerT.containsKey(p.getName())){
					Player target = Bukkit.getPlayer(FightManager.PlayerT.get(p.getName()));
					SpawnManager.teleportToSpawn(p, "1vs1");
					Data.firstJoin.remove(p);
					Data.FeastJoin.remove(p);
					Data.INOneVSOneJoin.remove(p);
					Data.OneVSOneJoin.add(p);
					OneVSOneLobby.setOneVSOneInventory(p);
					OneVSOneWarteschlange.warteschlange.remove(p);
					OneVSOneWarteschlange.warteschlange.remove(k);

					SpawnManager.teleportToSpawn(k, "1vs1");
					Data.firstJoin.remove(k);
					Data.FeastJoin.remove(k);
					Data.INOneVSOneJoin.remove(k);
					Data.OneVSOneJoin.add(k);
					OneVSOneLobby.setOneVSOneInventory(k);				
					target.setHealth(20);
				}
			}
			p.setHealth(20);
			if(k != null){
			OneVSOneLobby.setOneVSOneInventory(k);			
			k.setHealth(20);
			SpawnManager.teleportToSpawn(k, "1vs1");
			OneVSOneWarteschlange.warteschlange.remove(k);
			}
			SpawnManager.teleportToSpawn(p, "1vs1");
			OneVSOneLobby.setOneVSOneInventory(p);
			Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable()
	          {
	            public void run()
	            {
	    			p.setFireTicks(0);
	    			p.setFireTicks(0);
	    			p.setFireTicks(0);
	    			p.setHealth(20);

	    			for(Player all : Bukkit.getOnlinePlayers()){
	    			p.showPlayer(all);
	    			}
	            	OneVSOneWarteschlange.warteschlange.remove(p);
	            	OneVSOneLobby.setOneVSOneInventory(p);  
	            	Scoreboard.setScoreboard(p);
	            	if(k != null){
	            		for(Player all : Bukkit.getOnlinePlayers()){
	    	    		k.showPlayer(all);
	    	    		}
		            	p.sendTitle("§cVerloren", "§7Gegner: §e" + k.getName());
		            	k.sendTitle("§aGewonnen", "§7Gegner: §e" + p.getName());
		            	Scoreboard.setScoreboard(k);
		    			k.setFireTicks(0);
		    			k.setFireTicks(0);
		    			k.setFireTicks(0);
		    			k.setHealth(20);

	            	}else{
	            	p.sendTitle("§cVerloren", "§7Gegner: §eUnbekannt");
	            }
	            }
	          }, 1L);
		
		}
	}

}

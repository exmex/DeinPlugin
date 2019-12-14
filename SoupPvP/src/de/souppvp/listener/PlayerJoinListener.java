package de.souppvp.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.inventivetalent.bossbar.BossBarAPI;

import de.souppvp.data.Data;
import de.souppvp.data.ItemCreator;
import de.souppvp.data.Scoreboard;
import de.souppvp.levelsystem.LevelData;
import de.souppvp.main.Main;
import de.souppvp.onevsonemanager.FightManager;
import de.souppvp.spawnmanager.SpawnManager;
import de.souppvp.statssystem.StatsSystem;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerJoinListener implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		SpawnManager.teleportToSpawn(p, "Spawn");
		LevelData.Level.put(p.getName(), 0);
		StatsSystem.loadStatsFormConfigIntoHashMap(p);
		LevelData.Level.put(p.getName(), LevelData.getLevelToINT(p));
		Data.firstJoin.add(p);
		for(Player all : Bukkit.getOnlinePlayers()){
			Scoreboard.setScoreboard(all);
		}
		e.setJoinMessage(null);
		
		String name = "§7" + p.getName();
	    if(PermissionsEx.getUser(p).inGroup("Owner")){
	    	name = "§4" + p.getName();
	    }
	    if(PermissionsEx.getUser(p).inGroup("Admin")){
	    	name = "§c" + p.getName();
	    }
	    if(PermissionsEx.getUser(p).inGroup("Developer")){
	    	name = "§b" + p.getName();
	    }
	    if(PermissionsEx.getUser(p).inGroup("SrModerator")){
	    	name = "§c" + p.getName();
	    }
	    if(PermissionsEx.getUser(p).inGroup("Moderator")){
	    	name = "§c" + p.getName();
	    }
	    if(PermissionsEx.getUser(p).inGroup("Supporter")){
	    	name = "§9" + p.getName();
	    }
	    if(PermissionsEx.getUser(p).inGroup("Builder")){
	    	name = "§e" + p.getName();
	    }
	    if(PermissionsEx.getUser(p).inGroup("YouTube")){
	    	name = "§5" + p.getName();
	    }
	    if(PermissionsEx.getUser(p).inGroup("JrYouTuber")){
	    	name = "§5" + p.getName();
	    }
	    if(PermissionsEx.getUser(p).inGroup("Legend")){
	    	name = "§d" + p.getName();
	    }
	    if(PermissionsEx.getUser(p).inGroup("Ultra")){
	    	name = "§a" + p.getName();
	    }
	    if(PermissionsEx.getUser(p).inGroup("Hero")){
	    	name = "§3" + p.getName();
	    }
	    if(PermissionsEx.getUser(p).inGroup("Gold")){
	    	name = "§6" + p.getName();
	    }
		
	    p.setDisplayName(name);
		
	    
	    
	    
		p.getInventory().clear();
		p.setHealth(20);
		p.setFoodLevel(20);
		p.setFireTicks(0);
		p.getInventory().setArmorContents(null);
		p.updateInventory();
		
		
		
		getLobbyItems(p);
		
		
		
		Data.firstJoin.add(p);
		
		
		
		
	      for (PotionEffect effects : p.getActivePotionEffects()) {
	          p.removePotionEffect(effects.getType());
	        }
		
	    
	      
	      
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          
	        	Bukkit.broadcastMessage(Data.Prefix + "§7" + p.getDisplayName() + " §7hat den Server betreten§8.");
	        	
	        }
	      }, 1L);
	      
	      
	      
	      
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          
	        	p.setGameMode(GameMode.ADVENTURE);
	        	
	        }
	      }, 40L);
	      
	      
	    
	}

	   
	public static void getLobbyItems(Player p){
		FightManager.onevsone.remove(p);
		FightManager.onevsone.remove(p);
		FightManager.onevsone.remove(p);
		Data.OneVSOneJoin.remove(p);
		Data.FeastJoin.remove(p);
		Data.FeastNoKit.remove(p);
		Data.firstJoin.add(p);
		Data.INOneVSOneJoin.remove(p);
		Data.OneVSOneJoin.remove(p);
		Data.OneVSOneWarteschlange.remove(p);
		p.getInventory().clear();
		p.getInventory().setItem(2, ItemCreator.CreateItemwhitMaterial(Material.COMPASS, 0, 1, "§8§l➤ §3§lNavigator§r §8[§7Rechtsklick§8]", null));
		p.getInventory().setItem(8, ItemCreator.CreateItemwhitMaterial(Material.SLIME_BALL, 0, 1, "§8§l➤ §c§lVerlassen§r §8[§7Rechtsklick§8]", null));
		ItemStack skull = new ItemStack(397, 1, (short) 3);
		ItemMeta sm = skull.getItemMeta();
		sm.setDisplayName("§8§l➤ §a§lProfil§r §8[§7Rechtsklick§8]");
		skull.setItemMeta(sm);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner(p.getName());
		skull.setItemMeta(meta);
		p.getInventory().setItem(7, skull);
		
		
	}

}

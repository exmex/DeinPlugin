package de.community.manager;

import java.util.concurrent.CopyOnWriteArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.inventivetalent.bossbar.BossBarAPI;

import com.sk89q.worldguard.blacklist.event.BlockBreakBlacklistEvent;

import de.community.utils.Data;
import de.community.utils.Scoreboard;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class MainListener implements Listener{
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		BossBarAPI.setMessage(e.getPlayer(), "§8| §a§lC§b§lL§c§lA§5§lY§3§lUnity§8 » ");
		for(Player all : Bukkit.getOnlinePlayers()){
			Scoreboard.setScoreboard(all);
		}
		
		ItemStack Navigator = new ItemStack(Material.COMPASS);
		ItemMeta nm = Navigator.getItemMeta();
		nm.setDisplayName("§6Navigator");
		Navigator.setItemMeta(nm);
		
		ItemStack Navigator1 = new ItemStack(Material.BLAZE_ROD);
		ItemMeta nm1 = Navigator1.getItemMeta();
		nm1.setDisplayName("§6Player-Hider");
		Navigator1.setItemMeta(nm1);
		
		
		Player p = e.getPlayer();
		p.setHealthScale(2);
		p.setHealth(2);
		double x = Data.cfg.getDouble("Spawn.X");
		double y = Data.cfg.getDouble("Spawn.Y");
		double z = Data.cfg.getDouble("Spawn.Z");
		double pitch = Data.cfg.getDouble("Spawn.Pitch");
		double yaw = Data.cfg.getDouble("Spawn.Yaw");
		String weltname = Data.cfg.getString("Spawn.WeltName");
		Location loc = new Location(Bukkit.getWorld(weltname), x, y, z);
		loc.setYaw((float) yaw);
		loc.setPitch((float) pitch);
		p.teleport(loc);
		p.setHealth(1.0);
		p.setFoodLevel(20);
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.getInventory().setItem(0, Navigator);
		p.getInventory().setItem(8, Navigator1);
		e.setJoinMessage(null);
	}
	
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		e.setQuitMessage(null);
		for(Player all : Bukkit.getOnlinePlayers()){
			Scoreboard.setScoreboard(all);
		}
	}
	@EventHandler
	public void on(PlayerInteractAtEntityEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void ona(PlayerInteractEntityEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void onDa(EntityDamageEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void onDaass(EntityDamageByBlockEvent e){
		e.setCancelled(true);
	}
	@EventHandler
    public void onWeizen(PlayerInteractEvent e) {
		
        if(e.getAction().equals(Action.PHYSICAL) && e.getClickedBlock().getType().equals(Material.SOIL)){

            e.setCancelled(true);

        }

    }
	@EventHandler
	public void onF(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void onIn(InventoryClickEvent e){
		try{
			if(e.getWhoClicked().getGameMode() == GameMode.CREATIVE){
				e.setCancelled(false);
			}else{
				e.setCancelled(true);
			}
		}catch(Exception e1){}
	}
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		Player p = e.getPlayer();
		e.setCancelled(true);
	}
	@EventHandler
	public void onBuild(BlockBreakEvent e){
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE && e.getPlayer().hasPermission("claymc.admin")){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onBuild(BlockPlaceEvent e){
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE && e.getPlayer().hasPermission("claymc.admin")){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onEn(EntityRegainHealthEvent e){
		e.setCancelled(true);
	}
	 @EventHandler
	    public void on(AsyncPlayerChatEvent e) {
	        Player p = e.getPlayer();
	        String Message = e.getMessage().replace("%", "Prozent");
	        Message.replace("%", "Prozenzt");
	        if (p.hasPermission("ClayMC.Hero") || p.hasPermission("ClayMC.Ultra")) {
	            e.setMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)Message));
	        }
	        if(PermissionsEx.getUser(p).inGroup("Owner")){
	        	e.setCancelled(false);
	        	e.setFormat("§4Owner §8• §4" + p.getName() + "§8 » §6" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Admin")){
	        	e.setCancelled(false);
	        	e.setFormat("§cAdmin §8• §c" + p.getName() + "§8 » §6" + Message);
	        }else
		        if(PermissionsEx.getUser(p).inGroup("SrModerator")){
		        	e.setCancelled(false);
		        	e.setFormat("§cSrModerator §8• §c" + p.getName() + "§8 » §6" + Message);
		    }else
		        if(PermissionsEx.getUser(p).inGroup("Developer")){
		        	e.setCancelled(false);
		        	e.setFormat("§bDeveloper §8• §b" + p.getName() + "§8 » §b" + Message);
		    }else
		        if(PermissionsEx.getUser(p).inGroup("Legend")){
		        	e.setCancelled(false);
		        	e.setFormat("§a§lL§b§lE§c§lG§d§lE§e§lN§6§lD §8• §d" + p.getName() + "§8 » §f§l" + Message);
		    }else
	        if(PermissionsEx.getUser(p).inGroup("Moderator")){
	        	e.setCancelled(false);
	        	e.setFormat("§cModerator §8• §c" + p.getName() + "§8 » §f" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Supporter")){
	        	e.setCancelled(false);
	        	e.setFormat("§9Supporter §8• §9" + p.getName() + "§8 » §f" + Message);
	        }else if(PermissionsEx.getUser(p).inGroup("Builder")){
	        	e.setCancelled(false);
	        	e.setFormat("§eBuilder §8• §e" + p.getName() + "§8 » §f" + Message);
	        	
	        }else
	        
	        if(PermissionsEx.getUser(p).inGroup("JrYoutuber")){
	        	e.setCancelled(false);
	        	e.setFormat("§5JrYouTuber §8• §5" + p.getName() + "§8 » §f" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Youtuber")){
	        	e.setCancelled(false);
	        	e.setFormat("§5YouTuber §8• §5" + p.getName() + "§8 » §f" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Ultra")){
	        	e.setCancelled(false);
	        	e.setFormat("§aUltra §8• §a" + p.getName() + "§8 » §f" + Message);
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Hero")){
	        	e.setCancelled(false);
	        	e.setFormat("§3Hero §8• §3" + p.getName() + "§8 » §f" + Message);
	        }else 
	        if(PermissionsEx.getUser(p).inGroup("Gold")){
	        	e.setCancelled(false);
	        	e.setFormat("§6Gold §8• §6" + p.getName() + "§8 » §f" + Message);
	    }else{
	    	e.setCancelled(false);
	    	e.setFormat("§7" + e.getPlayer().getName() + "§8 » §f" + Message);
	    }
	 }
}

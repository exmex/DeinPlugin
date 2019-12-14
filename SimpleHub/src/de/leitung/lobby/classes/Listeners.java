package de.leitung.lobby.classes;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;


public class Listeners implements Listener{
	
	
	public ArrayList<Player>globallist = new ArrayList<Player>();
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		for(Player all : Bukkit.getOnlinePlayers()){
		Scoreboard.setScoreboard(all);
		}
		Player p = e.getPlayer();
		if(p.getInventory().getBoots() != null){
			p.getInventory().setBoots(null);
		}
		for(int i = 0 ; i < 7 ; i++){
			p.sendMessage("");
		}
		p.sendMessage("§7§m-------------------------------------------");
		p.sendMessage("");
		p.sendMessage("§8» §9ClayMC §eServernetzwerk §8«");
		p.sendMessage("");
		p.sendMessage("§8» §6Follow §7on §9Facebook§7: §ehttps://www.facebook.com/ClayMCnet/");
		p.sendMessage("§8» §6Follow §7on §bTwitter§7: §e@ClayMCNetwork");
		p.sendMessage("");
		p.sendMessage("§7§m-------------------------------------------");
		p.setWalkSpeed(0.2F);
		p.setHealth(20);
		p.setFoodLevel(20);
		e.setJoinMessage(null);
		Method.getStart(p);
		File file = new File("plugins//Lobby//spawns.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        String w = cfg.getString("Spawn.WeltName");
        double x = cfg.getDouble("Spawn.X");
        double y = cfg.getDouble("Spawn.Y");
        double z = cfg.getDouble("Spawn.Z");
        double yaw = cfg.getDouble("Spawn.Yaw");
        double pitch = cfg.getDouble("Spawn.Pitch");
        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
        p.teleport(loc);
        Method.getStart(p);
        if(!p.hasPlayedBefore()){
            p.teleport(loc);
        }
	}
	@EventHandler
	public void onRe(PlayerRespawnEvent e){
		Player p = e.getPlayer();
		File file = new File("plugins//Lobby//spawns.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        String w = cfg.getString("Spawn.WeltName");
        double x = cfg.getDouble("Spawn.X");
        double y = cfg.getDouble("Spawn.Y");
        double z = cfg.getDouble("Spawn.Z");
        double yaw = cfg.getDouble("Spawn.Yaw");
        double pitch = cfg.getDouble("Spawn.Pitch");
        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
        loc.setYaw((float)yaw);
        loc.setPitch((float)pitch);
        e.setRespawnLocation(loc);
        Method.getStart(p);
	}
	@EventHandler
	public void onEn(EntityDamageByEntityEvent e){
		e.setCancelled(true);
	}
	 @EventHandler
	 public void onDeath(PlayerDeathEvent e){
		 e.setDeathMessage(null);
	 }	
	 @EventHandler
	 public void onBreak(BlockBreakEvent e){
		 Player p = e.getPlayer();
		 if(p.getGameMode() == GameMode.CREATIVE){
			 e.setCancelled(false);
		 }else{
			 e.setCancelled(true);
		 }
	 }
	 @EventHandler
	 public void onBreaak(BlockPlaceEvent e){
		 Player p = e.getPlayer();
		 if(p.getGameMode() == GameMode.CREATIVE){
			 e.setCancelled(false);
		 }else{
			 e.setCancelled(true);
		 }
	 }
	 @EventHandler
	 public void onHunger(FoodLevelChangeEvent e){
		 e.setCancelled(true);
	 }
	 @EventHandler
	 public void i(InventoryClickEvent e){
		 Player p = (Player)e.getWhoClicked();
		 if(p.getGameMode() == GameMode.CREATIVE){
			 e.setCancelled(false);
		 }else{
			 e.setCancelled(true);
		 }
	 }
	 @EventHandler
	 public void ond(PlayerDropItemEvent e){
		 Player p = e.getPlayer();
		 if(p.getGameMode() == GameMode.CREATIVE){
			 e.setCancelled(false);
		 }else{
			 e.setCancelled(true);
		 }
	 }
	 @EventHandler
	 public void onQuit(PlayerQuitEvent e){
		 e.setQuitMessage("");
	 }
	 @EventHandler
	    public void on(AsyncPlayerChatEvent e) {
	        Player p = e.getPlayer();
	        
	        if(globallist.isEmpty()){
	        if (p.hasPermission("ClayMC.Hero") || p.hasPermission("ClayMC.Ultra") || p.hasPermission("ClayMC.Legend")) {
	            e.setMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)e.getMessage()));
	        }
	        if(PermissionsEx.getUser(p).inGroup("Owner")){
	        	e.setCancelled(false);
	        	e.setFormat("§4Owner §8• §4" + p.getName() + "§8 » §6" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Admin")){
	        	e.setCancelled(false);
	        	e.setFormat("§cAdmin §8• §c" + p.getName() + "§8 » §6" + e.getMessage());
	        }else
		        if(PermissionsEx.getUser(p).inGroup("SrModerator")){
		        	e.setCancelled(false);
		        	e.setFormat("§cSrModerator §8• §c" + p.getName() + "§8 » §6" + e.getMessage());
		    }else
		        if(PermissionsEx.getUser(p).inGroup("Developer")){
		        	e.setCancelled(false);
		        	e.setFormat("§bDeveloper §8• §b" + p.getName() + "§8 » §b" + e.getMessage());
		    }else
		        if(PermissionsEx.getUser(p).inGroup("Legend")){
		        	e.setCancelled(false);
		        	e.setFormat("§a§lL§b§lE§c§lG§d§lE§e§lN§6§lD §8• §d" + p.getName() + "§8 » §f§l" + e.getMessage());
		    }else
	        if(PermissionsEx.getUser(p).inGroup("Moderator")){
	        	e.setCancelled(false);
	        	e.setFormat("§cModerator §8• §c" + p.getName() + "§8 » §f" + e.getMessage());
	        }else if(PermissionsEx.getUser(p).inGroup("Builder")){
	        	e.setCancelled(false);
	        	e.setFormat("§eBuilder §8• §e" + p.getName() + "§8 » §f" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Supporter")){
	        	e.setCancelled(false);
	        	e.setFormat("§9Supporter §8• §9" + p.getName() + "§8 » §f" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("JrYoutuber")){
	        	e.setCancelled(false);
	        	e.setFormat("§5JrYouTuber §8• §5" + p.getName() + "§8 » §f" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Youtuber")){
	        	e.setCancelled(false);
	        	e.setFormat("§5YouTuber §8• §5" + p.getName() + "§8 » §f" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Ultra")){
	        	e.setCancelled(false);
	        	e.setFormat("§aUltra §8• §a" + p.getName() + "§8 » §f" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Hero")){
	        	e.setCancelled(false);
	        	e.setFormat("§3Hero §8• §3" + p.getName() + "§8 » §f" + e.getMessage());
	        }else 
	        if(PermissionsEx.getUser(p).inGroup("Gold")){
	        	e.setCancelled(false);
	        	e.setFormat("§6Gold §8• §6" + p.getName() + "§8 » §f" + e.getMessage());
	        }else{
	        	e.setCancelled(true);
	        	p.sendMessage(Main.Prefix + "§cDu benötigst mindestens den §6Gold §cRang, um in der Lobby schreiben zu können.");
	        }
	        }else{
	        	e.setCancelled(true);
	        	p.sendMessage("");
	        	p.sendMessage("§cDer Zugang zum §6Chat §cwird dir derzeit untersagt.");
	        	p.sendMessage("§3Grund: §eGlobalMute ist aktiviert!");
	        	p.sendMessage("");

	        }
	    }
	 @EventHandler
	 public void Move(PlayerMoveEvent e){
		 Player p = e.getPlayer();
		 File file = new File("plugins//Lobby//spawns.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			if(p.getLocation().getY() < 0){
	        String w = cfg.getString("Spawn.WeltName");
	        double x = cfg.getDouble("Spawn.X");
	        double y = cfg.getDouble("Spawn.Y");
	        double z = cfg.getDouble("Spawn.Z");
	        double yaw = cfg.getDouble("Spawn.Yaw");
	        double pitch = cfg.getDouble("Spawn.Pitch");
	        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
	        loc.setYaw((float)yaw);
	        loc.setPitch((float)pitch);
	        p.teleport(loc);
	        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
		 
			}
	 }
	 @EventHandler
	 public void onPr(PlayerCommandPreprocessEvent e){
		 Player p = e.getPlayer();
		 if(e.getMessage().equalsIgnoreCase("/globalmute")){
			 if(p.hasPermission("claymc.globalmute")){
				 if(!globallist.isEmpty()){
					 globallist.clear();
					 p.sendMessage(Main.Prefix + "§6Du hast den Globalmute §cAusgeschaltet§6!");
				 }else{
					 globallist.add(p);
					 p.sendMessage(Main.Prefix + "§6Du hast den Globalmute §eEingeschaltet§6!");
				 }
			 }
			 
		 }
	 }

	 @EventHandler
	 public void onINteract(PlayerInteractEvent e){
		 try {
			 if(e.getPlayer().getGameMode() != GameMode.CREATIVE){
				 e.setCancelled(true);
			 }else{
				 e.setCancelled(false);
			 }
		 }catch(Exception e1){}
	 }
}

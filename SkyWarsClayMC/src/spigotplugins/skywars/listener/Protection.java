package spigotplugins.skywars.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import NickSystem.Manager.NickManager;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import spigotplugins.skywars.main.DeathListener;
import spigotplugins.skywars.storage.Data;
import spigotplugins.skywars.storage.GameState;

public class Protection implements Listener{
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent e){
		if(Data.gs == GameState.LOBBY || Data.gs == GameState.ENDING){
		e.setCancelled(true);
	}
	}
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		if(Data.gs == GameState.INGAME && Data.runmovecountdown == false){
			if(e.getBlock().getType() == Material.CHEST || e.getBlock().getType() == Material.TRAPPED_CHEST){
				e.setCancelled(true);
				e.getPlayer().sendMessage(Data.Prefix + "§cIn diesem SkyWars darfst du leider keine Truhen abbauen.");
				}else{
					e.setCancelled(false);
			}
		}else{
			e.setCancelled(true);
		
		}
	}
	@EventHandler
	public void onBlockBreak(BlockPlaceEvent e){
		if(e.getBlock().getType() == Material.CHEST || e.getBlock().getType() == Material.TRAPPED_CHEST){
			e.getPlayer().sendMessage(Data.Prefix + "§c§lNetter Versuch! §eNur leider wurde dieser §cFehler §ebehoben §a:)"); 
			e.setBuild(false);
			e.setCancelled(true);
		}
		if(Data.gs == GameState.INGAME && Data.runmovecountdown == false){
			e.setCancelled(false);
			}
			if(Data.gs == GameState.LOBBY || Data.gs == GameState.ENDING){
				e.setCancelled(true);
			}
	}
	@EventHandler(ignoreCancelled = true)
	public void onBlockBreak(EntityDamageEvent e){
		
		if(Data.gs == GameState.INGAME && Data.runmovecountdown){
			e.setCancelled(false);
		}
		if(Data.gs == GameState.LOBBY || Data.gs == GameState.ENDING){
			e.setCancelled(true);
		}
		
	}
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		
		if(Data.gs == GameState.INGAME && Data.runmovecountdown == false){
			e.setCancelled(false);
		}
		if(Data.gs == GameState.LOBBY || Data.gs == GameState.ENDING){
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onDrop(InventoryClickEvent e){
		
		if(Data.gs == GameState.INGAME && Data.runmovecountdown == false){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
		if(Data.gs == GameState.ENDING) {
			e.setCancelled(true);
		}
	}
	@EventHandler
    public void on(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String Message = e.getMessage().replaceAll("%", "Prozent");
        Message.replaceAll("%", "Prozent");
        if(Data.gs != GameState.ENDING){
        if(!DeathListener.INGAME.contains(p)){
        	if(Data.gs != GameState.LOBBY || Data.gs == GameState.ENDING){
        	p.sendMessage(Data.Prefix + "§7Als §bSpectator §7wird dir der §eChat §cverwehrt.");
        	e.setCancelled(true);
        		return;	
        	}
        	}
        }
        if (p.hasPermission("ClayMC.Hero") || p.hasPermission("ClayMC.Ultra") || p.hasPermission("ClayMC.Legend")) {
            e.setMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)Message));
        }
        if(NickManager.isNicked(p)){
        	e.setFormat("§7" + p.getName() + "§8 » §f" + Message);
        	return;
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
	    }
	        else if(PermissionsEx.getUser(p).inGroup("Script")){
	        	e.setCancelled(false);
	        	e.setFormat("§3Script §8• §3" + p.getName() + "§8 » §6" + Message);

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
        }else if(PermissionsEx.getUser(p).inGroup("Builder")){
        	e.setCancelled(false);
        	e.setFormat("§eBuilder §8• §e" + p.getName() + "§8 » §f" + Message);
        }else
        if(PermissionsEx.getUser(p).inGroup("Supporter")){
        	e.setCancelled(false);
        	e.setFormat("§9Supporter §8• §9" + p.getName() + "§8 » §f" + Message);
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
        	e.setFormat("§7" + p.getName() + "§8 » §f" + Message);

        }
      
    }
}

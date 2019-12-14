package souppvp.listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

import souppvp.data.Data;
import souppvp.methods.ItemCreator;
import souppvp.methods.Sounds;

public class Archievements implements Listener{
	
	public static File file = new File("plugins//SoupPvP//achievements.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
		Player p = e.getPlayer();
		if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §aAchievements§7 «")){
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
				Inventory inv = Bukkit.createInventory(null, 9, "§aAchievements");
				if(ArchievementsData.firstkill.contains(p)){
					inv.setItem(0, ItemCreator.CreateItemwhitMaterial(Material.INK_SACK, 2, 1, "§aFirst-Kill", "§7Töte deinen ersten Gegner"));
				}else{
					inv.setItem(0, ItemCreator.CreateItemwhitMaterial(Material.INK_SACK, 1, 1, "§7First-Kill", "§7? ? ?"));
				}
				if(ArchievementsData.firstdeath.contains(p)){
					inv.setItem(1, ItemCreator.CreateItemwhitMaterial(Material.INK_SACK, 2, 1, "§aFirst-Death", "§7Sterbe zum ersten Mal"));
				}else{
					inv.setItem(1, ItemCreator.CreateItemwhitMaterial(Material.INK_SACK, 1, 1, "§7First-Death", "§7? ? ?"));
				}
				p.openInventory(inv);
				Sounds.playAdminAcceptSound(p);
				return;
			}
		}
		}catch(Exception e1){}
	}
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(Data.eventmodus == true){
			p.sendMessage(Data.Prefix + "§c§lUpps! §eDer §dEventmodus§e ist aktiviert! Aus dem §6Grund §esind die §aAchievements §eausgeschaltet!");
			return;
		}else{
			if(cfg.getBoolean(p.getUniqueId() + "Firstkill") == true){
				ArchievementsData.firstkill.add(p);
			}
			if(cfg.getBoolean(p.getUniqueId() + "Firstdeath") == true){
				ArchievementsData.firstdeath.add(p);
			}
		}
	}
	
	 @EventHandler
	 public void onQuit(PlayerQuitEvent e){
		 Player p = e.getPlayer();
		 if(Data.eventmodus == true){
			 return;
		 }
		 if(ArchievementsData.firstkill.contains(p)){
				Archievements.cfg.set(p.getUniqueId() + ".Firstkill", true);
				try {
					Archievements.cfg.save(Archievements.file);
				} catch (IOException ep) {
					// TODO Auto-generated catch block
					ep.printStackTrace();
				}
			}
			if(ArchievementsData.firstdeath.contains(p)){
				Archievements.cfg.set(p.getUniqueId() + "Firstdeath", true);
				try {
					Archievements.cfg.save(Archievements.file);
				} catch (IOException ep) {
					// TODO Auto-generated catch block
					ep.printStackTrace();
				}
			}
	 }
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		if(ArchievementsData.firstdeath.contains(p)){
			return;
		}else{
			p.sendMessage("§8[§aAchievement§8] §eDu hast das §aAchievement §6First-Death §eerhalten!");
			ArchievementsData.firstdeath.add(p);
			Sounds.playAdminAcceptSound(p);
		}
		
	}
	@EventHandler
	public void onDeath2(PlayerDeathEvent e){
		Player k = e.getEntity().getKiller();
		if(k != null){
			if(ArchievementsData.firstkill.contains(k)){
				return;
			}else{
				k.sendMessage("§8[§aAchievement§8] §eDu hast das §aAchievement §6First-Kill §eerhalten!");
				ArchievementsData.firstkill.add(k);
				Sounds.playAdminAcceptSound(k);
			}
		}
	}
	@EventHandler
	public void onc(InventoryClickEvent e){
		if(e.getInventory().getName().equalsIgnoreCase("§aAchievements")){
			e.setCancelled(true);
			return;
		}
		return;
	}
}

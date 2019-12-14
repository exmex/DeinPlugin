package de.community.items;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.community.utils.Data;


public class Navigator implements Listener{
	public static CopyOnWriteArrayList<Player> in = new CopyOnWriteArrayList<>();

	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
				if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Navigator")){
					if(in.contains(e.getPlayer())){
						e.getPlayer().sendMessage(Data.Prefix + "§cBitte warte einen Moment, bis du den Kompass erneut nutzen kannst!");
						return;
					}
					in.add(e.getPlayer());
					Inventory inv = Bukkit.createInventory(null, 9, "§6Navigator");
					ItemStack spawn = new ItemStack(Material.FIREBALL);
					ItemMeta sm = spawn.getItemMeta();
					sm.setDisplayName("§6Spawn");
					ArrayList<String>list = new ArrayList<String>();
					list.add("§7Teleportiere dich zum §eSpawn§7!");
					sm.setLore(list);
					spawn.setItemMeta(sm);
					
					ItemStack spawn1 = new ItemStack(Material.FEATHER);
					ItemMeta sm1 = spawn1.getItemMeta();
					sm1.setDisplayName("§6JumpAndRun");
					ArrayList<String>list1 = new ArrayList<String>();
					list1.add("§7Teleportiere dich zum §eJumpAndRun§7!");
					sm1.setLore(list1);
					spawn1.setItemMeta(sm1);
					
					ItemStack spawn12 = new ItemStack(Material.NOTE_BLOCK);
					ItemMeta sm12 = spawn12.getItemMeta();
					sm12.setDisplayName("§6YouTuber-Bühne");
					ArrayList<String>list12 = new ArrayList<String>();
					list12.add("§7Teleportiere dich zur §eBühne§7!");
					sm12.setLore(list12);
					spawn12.setItemMeta(sm12);
					
					ItemStack p = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
					ItemMeta pm = p.getItemMeta();
					pm.setDisplayName(" ");
					p.setItemMeta(pm);
					
					inv.setItem(0, p);
					inv.setItem(1, p);
					inv.setItem(2, spawn12);
					inv.setItem(3, p);
					inv.setItem(4, spawn);
					inv.setItem(5, p);
					inv.setItem(6, spawn1);
					inv.setItem(7, p);
					inv.setItem(8, p);
					
					Player p2 = e.getPlayer();
					p2.openInventory(inv);
					
				}
					
				
			}
		}catch(Exception e1){}
	}

	@EventHandler
	public void onClick(InventoryClickEvent e){
		try{
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§6Navigator")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.FIREBALL){
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
				p.sendMessage(Data.Prefix + "§7Du wurdest zum §eSpawn§7 teleportiert!");
				p.playSound(p.getLocation(), Sound.BAT_LOOP, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 7, 4);
				p.playSound(p.getLocation(), Sound.CREEPER_HISS, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 7, 4);	

				return;
			}
			if(e.getCurrentItem().getType() == Material.FEATHER){
				double x = Data.cfg.getDouble("JumpAndRun.X");
				double y = Data.cfg.getDouble("JumpAndRun.Y");
				double z = Data.cfg.getDouble("JumpAndRun.Z");
				double pitch = Data.cfg.getDouble("JumpAndRun.Pitch");
				double yaw = Data.cfg.getDouble("JumpAndRun.Yaw");
				String weltname = Data.cfg.getString("JumpAndRun.WeltName");
				Location loc = new Location(Bukkit.getWorld(weltname), x, y, z);
				loc.setYaw((float) yaw);
				loc.setPitch((float) pitch);
				p.teleport(loc);
				p.sendMessage(Data.Prefix + "§7Du wurdest zum §eJumpAndRun§7 teleportiert!");
				p.playSound(p.getLocation(), Sound.BAT_LOOP, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 7, 4);			
				p.playSound(p.getLocation(), Sound.CREEPER_HISS, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 7, 4);	


				return;
	}
			if(e.getCurrentItem().getType() == Material.NOTE_BLOCK){
				double x = Data.cfg.getDouble("Buehne.X");
				double y = Data.cfg.getDouble("Buehne.Y");
				double z = Data.cfg.getDouble("Buehne.Z");
				double pitch = Data.cfg.getDouble("Buehne.Pitch");
				double yaw = Data.cfg.getDouble("Buehne.Yaw");
				String weltname = Data.cfg.getString("Buehne.WeltName");
				Location loc = new Location(Bukkit.getWorld(weltname), x, y, z);
				loc.setYaw((float) yaw);
				loc.setPitch((float) pitch);
				p.teleport(loc);
				p.sendMessage(Data.Prefix + "§7Du wurdest zur §eBühne§7 teleportiert!");
				p.playSound(p.getLocation(), Sound.BAT_LOOP, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 7, 4);
				p.playSound(p.getLocation(), Sound.NOTE_BASS_DRUM, 7, 4);	
				p.playSound(p.getLocation(), Sound.CREEPER_HISS, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 7, 4);	
				p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 7, 4);	

				return;
		}
	}
		}catch(Exception e1){}
	}
}

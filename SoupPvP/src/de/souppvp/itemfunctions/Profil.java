package de.souppvp.itemfunctions;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.souppvp.data.Data;
import de.souppvp.levelsystem.LevelData;
import de.souppvp.statssystem.StatsSystem;
import io.netty.util.ResourceLeakDetector.Level;

public class Profil implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			Player p = e.getPlayer();
			if(e.getItem().getType() == Material.SKULL_ITEM){
				if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					if(Data.firstJoin.contains(p)){
						Inventory inv = Bukkit.createInventory(null, 18, "§9" + p.getName());
						
						ItemStack i = new ItemStack(Material.DIAMOND_SWORD, 1);
						ItemMeta im = i.getItemMeta();
						im.setDisplayName("§eKills §7» §3" + StatsSystem.kills.get(p.getUniqueId().toString()));
						im.addEnchant(Enchantment.DURABILITY, 1, false);
						i.setItemMeta(im);
						
						ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
						ItemMeta i2m = i2.getItemMeta();
						i2m.setDisplayName("§eTode §7» §3" + StatsSystem.deaths.get(p.getUniqueId().toString()));
						i2m.addEnchant(Enchantment.DURABILITY, 1, false);
						i2.setItemMeta(i2m);
						
						ItemStack l = new ItemStack(Material.GOLD_INGOT, LevelData.getLevelToINT(p));
						ItemMeta lm = l.getItemMeta();
						lm.setDisplayName("§eLevel §7» " + LevelData.getLevel(p));
						lm.addEnchant(Enchantment.DURABILITY, 1, false);
						l.setItemMeta(lm);
						
						
						int total = 0;
						if(LevelData.getLevelToINT(p) == 1){
							total = 20;
						}
						if(LevelData.getLevelToINT(p) == 2){
							total = 40;
						}
						if(LevelData.getLevelToINT(p) == 3){
							total = 60;
						}
						if(LevelData.getLevelToINT(p) == 4){
							total = 80;
						}
						if(LevelData.getLevelToINT(p) == 5){
							total = 100;
						}
						if(LevelData.getLevelToINT(p) == 6){
							total = 120;
						}
						if(LevelData.getLevelToINT(p) == 7){
							total = 140;
						}
						if(LevelData.getLevelToINT(p) == 8){
							total = 160;
						}
						if(LevelData.getLevelToINT(p) == 9){
							total = 180;
						}
						if(LevelData.getLevelToINT(p) == 10){
							total = 200;
						}
						if(LevelData.getLevelToINT(p) == 11){
							total = 220;
						}
						if(LevelData.getLevelToINT(p) == 12){
							total = 240;
						}
						if(LevelData.getLevelToINT(p) == 13){
							total = 260;
						}
						if(LevelData.getLevelToINT(p) == 14){
							total = 280;
						}
						if(LevelData.getLevelToINT(p) == 15){
							total = 300;
						}
						if(LevelData.getLevelToINT(p) == 16){
							total = 320;
						}
						if(LevelData.getLevelToINT(p) == 17){
							total = 340;
						}
						if(LevelData.getLevelToINT(p) == 18){
							total = 360;
						}
						if(LevelData.getLevelToINT(p) == 19){
							total = 280;
						}
						if(LevelData.getLevelToINT(p) == 20){
							total = 300;
						}
						int f;
						f = total - StatsSystem.kills.get(p.getUniqueId().toString());
						if(f == 0){
							f= 20;
						}
						ItemStack l3 = new ItemStack(Material.DIAMOND, f);
						ItemMeta lm3 = l3.getItemMeta();
						lm3.setDisplayName("§eFehlende Kills zum nächstem Level §7» " + f);
						l3.setItemMeta(lm3);
						
						ItemStack a = new ItemStack(Material.BARRIER);
						ItemMeta am = a.getItemMeta();
						am.setDisplayName("§cZurück...");
						a.setItemMeta(am);
						
						
						inv.setItem(0, i);
						inv.setItem(1, i2);
						inv.setItem(4, l);
						inv.setItem(13, l3);
						inv.setItem(17, a);
						p.openInventory(inv);
						
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
					}
				}
			}
		}catch(Exception e1){}
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		try{
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§9" + p.getName())){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.BARRIER){
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 10, 10);
				p.sendMessage(Data.Prefix + "§cDein Profil wurde geschlossen!");
			}
		}
	}catch(Exception e1){}
	}
}

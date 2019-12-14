package knockpvp.listener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.EnderChest;

import knockpvp.main.Main;
import knockpvp.utils.Data;
import knockpvp.utils.Scoreboard;
import knockpvp.utils.Stats;

public class Shop implements Listener{
	public static boolean MapSwitch;
	public static ArrayList<Player> deathregeneration = new ArrayList<>();
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			Player p = e.getPlayer();
			if(e.getItem().getType() == Material.GOLD_INGOT){
				if(Main.high < e.getPlayer().getLocation().getY()){
					
					Inventory inv = Bukkit.createInventory(null, 9, "§6Shop");
					
					ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
					ItemMeta gm = glas.getItemMeta();
					gm.setDisplayName(" ");
					glas.setItemMeta(gm);
					inv.setItem(0, glas);
					
					ItemStack schwert = new ItemStack(Material.DIAMOND_SWORD);
					ItemMeta sm = schwert.getItemMeta();
					sm.setDisplayName("§3Waffen");
					ArrayList<String> list = new ArrayList<>();
					list.add("§7Kaufe dir spezielle §eWaffen");
					sm.setLore(list);
					schwert.setItemMeta(sm);
					inv.setItem(1, schwert);
					ItemStack brust = new ItemStack(Material.DIAMOND_CHESTPLATE);
					ItemMeta bm = brust.getItemMeta();
					bm.setDisplayName("§3Rüstung");
					ArrayList<String> bl = new ArrayList<>();
					bl.add("§7Kaufe dir spezielle §eRüstung");
					bm.setLore(bl);
					brust.setItemMeta(bm);
					inv.setItem(2, brust);
					
					inv.setItem(3, glas);
					
					ItemStack upgrade = new ItemStack(Material.GOLD_NUGGET);
					ItemMeta um = upgrade.getItemMeta();
					um.setDisplayName("§6Persönliche Updates");
					ArrayList<String> bb = new ArrayList<>();
					bb.add("§7Kaufe dir §eUpdates§7, welche auf §edich §7abgestimmt sind");
					upgrade.setItemMeta(um);
					
					inv.setItem(4, upgrade);
					
					ItemStack ec = new ItemStack(Material.ENDER_CHEST);
					ItemMeta e3 = ec.getItemMeta();
					e3.setDisplayName("§3Items speichern");
					ArrayList<String> hh = new ArrayList<>();
					hh.add("§7Speichere deine Items. §6Gold §7benötigt!");
					e3.setLore(hh);
					ec.setItemMeta(e3);
					inv.setItem(5, glas);
					inv.setItem(6, ec);
					
					ItemStack pap = new ItemStack(Material.PAPER);
					ItemMeta pa = pap.getItemMeta();
					pa.setDisplayName("§eMap§7+§eKitSwitch§7 Zeit §everlängern §7» §380 Coins");
					ArrayList<String> aa = new ArrayList<>();
					aa.add("§7Verlängere die Kit+Map Zeit um §e30 §7Sekunden!");
					pa.setLore(aa);
					pap.setItemMeta(pa);

					inv.setItem(7, pap);
					
					ItemStack bar = new ItemStack(Material.BARRIER);
					ItemMeta bma = bar.getItemMeta();
					bma.setDisplayName("§eZeit verlängern§7, §cverhindern §7» §3100 Coins");
					ArrayList<String> aff = new ArrayList<>();
					aff.add("§7Verhindere, dass andere Spieler den");
					aff.add("§eKit+Map §7Switch Countdown §everlängern §7können");
					bma.setLore(aff);
					bar.setItemMeta(bma);
					inv.setItem(8, bar);
					
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 6, 3);

					p.openInventory(inv);
				}else{
					p.sendMessage(Data.Prefix + "§cDu darfst den §6Shop §cnur am Spawn verwenden!");
				}
			}
		}catch(Exception e1){}
	}
	
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		ArrayList<String> dl = new ArrayList<>();
		dl.add(" ");
		dl.add("§7«§8§m-------------------§7»");
		dl.add("§7Effiziente §eNahkampfwaffe");
		dl.add("§7«§8§m-------------------§7»");
		dl.add(" ");
		if(e.getInventory().getName().equalsIgnoreCase("§6Shop")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD){
				Inventory inv = Bukkit.createInventory(null, 9, "§3Diaschwert");
				ItemStack eisen1 = new ItemStack(Material.IRON_SWORD);
				ItemMeta e1m = eisen1.getItemMeta();
				e1m.setDisplayName("§3Eisenschwert §7» §332 Coins");
				e1m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				e1m.setLore(dl);
				eisen1.setItemMeta(e1m);
				
				ItemStack eisen2 = new ItemStack(Material.IRON_SWORD);
				ItemMeta e2m = eisen2.getItemMeta();
				e2m.setDisplayName("§3Eisenschwert §7» §357 Coins");
				e2m.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
				e2m.setLore(dl);
				eisen2.setItemMeta(e2m);
				
				ItemStack dia1 = new ItemStack(Material.DIAMOND_SWORD);
				ItemMeta d1m = dia1.getItemMeta();
				d1m.setDisplayName("§3Diamantschwert §7» §384 Coins");
				d1m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				d1m.setLore(dl);
				dia1.setItemMeta(d1m);
				
				ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
				ItemMeta gm = glas.getItemMeta();
				gm.setDisplayName(" ");
				glas.setItemMeta(gm);
				
				ItemStack k = new ItemStack(Material.CARROT_ITEM);
				ItemMeta km = k.getItemMeta();
				km.setDisplayName("§4» §cZurück");
				ArrayList<String> back = new ArrayList<>();
				back.add("§7Kehre zum §eHauptmenü §7zurück");
				km.setLore(back);
				k.setItemMeta(km);
				
				inv.setItem(0, glas);
				inv.setItem(1, eisen1);
				inv.setItem(2, eisen2);
				inv.setItem(3, dia1);
				inv.setItem(4, glas);
				inv.setItem(5, glas);
				inv.setItem(6, glas);
				inv.setItem(7, glas);
				inv.setItem(8, k);
				p.openInventory(inv);
				PlaySound(p);



				return;
			}else if(e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE){
				Inventory inv = Bukkit.createInventory(null, 18, "§3Rüstung");
				ArrayList<String> eisenteile = new ArrayList<>();
				
				
				ArrayList<String> diateile = new ArrayList<>();
				ItemStack eisenhelm = new ItemStack(Material.IRON_HELMET);
				ItemMeta eh = eisenhelm.getItemMeta();
				eh.setDisplayName("§eE§7isenhelm §7» §324 Coins");
				eh.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				eh.setLore(eisenteile);
				eisenhelm.setItemMeta(eh);
				
				ItemStack eisenchest = new ItemStack(Material.IRON_CHESTPLATE);
				ItemMeta cm = eisenchest.getItemMeta();
				cm.setDisplayName("§eE§7isenbrustpanzer §7» §342 Coins");
				cm.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				cm.setLore(eisenteile);
				eisenchest.setItemMeta(cm);
				
				ItemStack eisenhose = new ItemStack(Material.IRON_LEGGINGS);
				ItemMeta eha = eisenhose.getItemMeta();
				eha.setDisplayName("§eE§7isenhose §7» §337 Coins");
				eha.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				eha.setLore(eisenteile);
				eisenhose.setItemMeta(eha);
				
				ItemStack eisenschuh = new ItemStack(Material.IRON_BOOTS);
				ItemMeta esch = eisenschuh.getItemMeta();
				esch.setDisplayName("§eE§7iseschuhe §7» §325 Coins");
				esch.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				esch.setLore(eisenteile);
				eisenschuh.setItemMeta(esch);
			
				ItemStack diahelm = new ItemStack(Material.DIAMOND_HELMET);
				ItemMeta dh = diahelm.getItemMeta();
				dh.setDisplayName("§bD§7iamanthelm §7» §354 Coins");
				dh.setLore(diateile);
				dh.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				diahelm.setItemMeta(dh);

				ItemStack diachest = new ItemStack(Material.DIAMOND_CHESTPLATE);
				ItemMeta dc = diachest.getItemMeta();
				dc.setDisplayName("§bD§7iamantbrustpanzer §7» §386 Coins");
				dc.setLore(diateile);
				dc.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				diachest.setItemMeta(dc);
				
				ItemStack dialeg = new ItemStack(Material.DIAMOND_LEGGINGS);
				ItemMeta diam = dialeg.getItemMeta();
				diam.setDisplayName("§bD§7iamanthose §7» §382 Coins");
				diam.setLore(diateile);
				diam.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				dialeg.setItemMeta(diam);
				
				ItemStack diaboots = new ItemStack(Material.DIAMOND_BOOTS);
				ItemMeta diabo = diaboots.getItemMeta();
				diabo.setDisplayName("§bD§7iamantschuhe §7» §357 Coins");
				diabo.setLore(diateile);
				diabo.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				diaboots.setItemMeta(diabo);
				
				ItemStack k = new ItemStack(Material.CARROT_ITEM);
				ItemMeta km = k.getItemMeta();
				km.setDisplayName("§4» §cZurück");
				ArrayList<String> back = new ArrayList<>();
				back.add("§7Kehre zum §eHauptmenü §7zurück");
				km.setLore(back);
				k.setItemMeta(km);
				
				ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
				ItemMeta gm = glas.getItemMeta();
				gm.setDisplayName(" ");
				glas.setItemMeta(gm);
				
				inv.setItem(0, eisenhelm);
				inv.setItem(1, eisenchest);
				inv.setItem(2, eisenhose);
				inv.setItem(3, eisenschuh);
				inv.setItem(9, diahelm);
				inv.setItem(10, diachest);
				inv.setItem(11, dialeg);
				inv.setItem(12, diaboots);
				inv.setItem(4, glas);
				inv.setItem(5, glas);
				inv.setItem(6, glas);
				inv.setItem(7, glas);
				inv.setItem(8, glas);
				inv.setItem(13, glas);
				inv.setItem(14, glas);
				inv.setItem(15, glas);
				inv.setItem(16, glas);
				inv.setItem(17, k);
				
				PlaySound(p);
				p.openInventory(inv);
			}else if(e.getCurrentItem().getType() == Material.GOLD_NUGGET){
				Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§6Spezielles");
				ItemStack heart = new ItemStack(Material.APPLE);
				ItemMeta ha = heart.getItemMeta();
				ha.setDisplayName("§3Kill-Regeneration §7» §ePERMANENT §7» §3560 Coins");
				ha.addEnchant(Enchantment.DURABILITY, 1, true);
				ArrayList<String> aaa = new ArrayList<>();
				aaa.add(" ");
				aaa.add("§7«§8§m------------------------------§7»");
				aaa.add("§7Erhalte nach jedem §eKill §7Regeneration!");
				aaa.add("§7«§8§m------------------------------§7»");
				aaa.add(" ");
				ha.setLore(aaa);
				heart.setItemMeta(ha);
				
				ItemStack k = new ItemStack(Material.CARROT_ITEM);
				ItemMeta km = k.getItemMeta();
				km.setDisplayName("§4» §cZurück");
				ArrayList<String> back = new ArrayList<>();
				back.add("§7Kehre zum §eHauptmenü §7zurück");
				km.setLore(back);
				k.setItemMeta(km);
				
				ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
				ItemMeta gm = glas.getItemMeta();
				gm.setDisplayName(" ");
				glas.setItemMeta(gm);
				inv.setItem(0, glas);
				
				inv.setItem(0, glas);
				inv.setItem(1, glas);
				inv.setItem(2, heart);
				inv.setItem(3, glas);
				inv.setItem(4, k);
				p.openInventory(inv);
				PlaySound(p);
			}else if(e.getCurrentItem().getType() == Material.ENDER_CHEST){
				
				Inventory inv = p.getEnderChest();
				ItemStack legend = createItemWithLore(Material.STAINED_GLASS_PANE, 2, "§cNicht verfügbar!", "§7Erst ab dem §5Legend §7Rang");
				ItemStack ultra = createItemWithLore(Material.STAINED_GLASS_PANE, 3, "§cNicht verfügbar!", "§7Erst ab dem §bUltra §7Rang");
				ItemStack gold = createItemWithLore(Material.STAINED_GLASS_PANE, 11, "§cNicht verfügbar!", "§7Erst ab dem §3Hero §7Rang");
				ItemStack gold1 = createItemWithLore(Material.STAINED_GLASS_PANE, 1, "§cNicht verfügbar!", "§7Erst ab dem §6Gold §7Rang");
				PlaySound(p);
				if(p.hasPermission("claymc.legend")){
					p.openInventory(inv);
					return;
				}else
				if(p.hasPermission("claymc.ultra")){
					inv.setItem(18, legend);
					inv.setItem(19, legend);
					inv.setItem(20, legend);
					inv.setItem(21, legend);
					inv.setItem(22, legend);
					inv.setItem(23, legend);
					inv.setItem(24, legend);
					inv.setItem(25, legend);
					inv.setItem(26, legend);
					p.openInventory(inv);
					return;
				}else
				if(p.hasPermission("claymc.hero")){
					inv.setItem(14, ultra);
					inv.setItem(15, ultra);
					inv.setItem(16, ultra);
					inv.setItem(17, ultra);
					inv.setItem(18, legend);
					inv.setItem(19, legend);
					inv.setItem(20, legend);
					inv.setItem(21, legend);
					inv.setItem(22, legend);
					inv.setItem(23, legend);
					inv.setItem(24, legend);
					inv.setItem(25, legend);
					inv.setItem(26, legend);
					p.openInventory(inv);
					return;
				}else
				if(p.hasPermission("claymc.gold")){
					inv.setItem(9, gold);
					inv.setItem(10, gold);
					inv.setItem(11, gold);
					inv.setItem(12, gold);
					inv.setItem(13, gold);
					inv.setItem(14, ultra);
					inv.setItem(15, ultra);
					inv.setItem(16, ultra);
					inv.setItem(17, ultra);
					inv.setItem(18, legend);
					inv.setItem(19, legend);
					inv.setItem(20, legend);
					inv.setItem(21, legend);
					inv.setItem(22, legend);
					inv.setItem(23, legend);
					inv.setItem(24, legend);
					inv.setItem(25, legend);
					inv.setItem(26, legend);
					p.openInventory(inv);
					return;
					
				}else{
					inv.setItem(5, gold1);
					inv.setItem(6, gold1);
					inv.setItem(7, gold1);
					inv.setItem(8, gold1);
					inv.setItem(9, gold);
					inv.setItem(10, gold);
					inv.setItem(11, gold);
					inv.setItem(12, gold);
					inv.setItem(13, gold);
					inv.setItem(14, ultra);
					inv.setItem(15, ultra);
					inv.setItem(16, ultra);
					inv.setItem(17, ultra);
					inv.setItem(18, legend);
					inv.setItem(19, legend);
					inv.setItem(20, legend);
					inv.setItem(21, legend);
					inv.setItem(22, legend);
					inv.setItem(23, legend);
					inv.setItem(24, legend);
					inv.setItem(25, legend);
					inv.setItem(26, legend);
					p.openInventory(inv);
					return;
				}
			}else if(e.getCurrentItem().getType() == Material.PAPER){
				if(MapSwitch == false){
					
					if(Stats.coins.get(p.getUniqueId().toString()) > 79){
						if(Main.min > 5){
							p.sendMessage(Data.Prefix + "§cDie Zeit lässt sich nicht mehr §everlängern§c!");
							return;
						}
						if(Main.cdd < 30){
						Main.cdd = Main.cdd + 31;
						}else{
							int fin = Main.cdd - 30;
							Main.min++;
							Main.cdd = fin;
						}
						Bukkit.broadcastMessage(Data.Prefix + "§7Der Spieler §e" + p.getName() + "§7 hat den §eKit+Map Switch §7um §e30 Sekunden §7verlängert!");
						Stats.removeCoins(p, 80);
						PlaySound(p);
						Scoreboard.setScoreboard(p);
					}else{
						p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Coins um diese Aktion durchzuführen!");
						PlayNoSound(p);
						return;
					}
				}else{
					p.sendMessage(Data.Prefix + "§cEin Spieler hat durch ein Item im Shop §everhindert§c, dass du die Zeit §everlängern §ckannst!");
					PlayNoSound(p);
				}
				
			}else if(e.getCurrentItem().getType() == Material.BARRIER){
				if(MapSwitch == false){
					if(Stats.coins.get(p.getUniqueId().toString()) > 99){
						MapSwitch = true;
						Bukkit.broadcastMessage(Data.Prefix + "§7Die §eWartezeit §7kann nun nicht mehr verlängert werden, da §e" + p.getName() + "§7das §eentsprechende Item §7gekauft hat!");
						PlaySound(p);
						Stats.removeCoins(p, 100);
						
						
					}else{
						p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Coins um diese Aktion durchzuführen!");
						PlayNoSound(p);
						return;
					}
				}else{
					p.sendMessage(Data.Prefix + "§cDie Map wird bereits geändert!");
					PlayNoSound(p);
				}
			}
			
		}else if(e.getInventory().getName().equalsIgnoreCase("§3Diaschwert")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.CARROT_ITEM){
				setMainInv(p);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Eisenschwert §7» §332 Coins")){
				if(Stats.coins.get(p.getUniqueId().toString()) > 31){
					ItemStack eisen1 = new ItemStack(Material.IRON_SWORD);
					ItemMeta e1m = eisen1.getItemMeta();
					e1m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
					eisen1.setItemMeta(e1m);
					p.getInventory().addItem(eisen1);
					PlaySound(p);
					p.sendMessage(Data.Prefix + "§eDu hast dir dieses §6Item §eerfolgreich erworben!");
					Stats.removeCoins(p, 32);
					Scoreboard.setScoreboard(p);
					return;
				}else{
					p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Coins um diese Aktion durchzuführen!");
					PlayNoSound(p);
					return;
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Eisenschwert §7» §357 Coins")){
				if(Stats.coins.get(p.getUniqueId().toString()) > 56){
					ItemStack eisen1 = new ItemStack(Material.IRON_SWORD);
					ItemMeta e1m = eisen1.getItemMeta();
					e1m.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
					eisen1.setItemMeta(e1m);
					p.getInventory().addItem(eisen1);
					PlaySound(p);
					p.sendMessage(Data.Prefix + "§eDu hast dir dieses §6Item §eerfolgreich erworben!");
					Stats.removeCoins(p, 57);
					Scoreboard.setScoreboard(p);
					return;
				}else{
					p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Coins um diese Aktion durchzuführen!");
					PlayNoSound(p);
					return;
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Diamantschwert §7» §384 Coins")){
				if(Stats.coins.get(p.getUniqueId().toString()) > 83){
					ItemStack eisen1 = new ItemStack(Material.DIAMOND_SWORD);
					ItemMeta e1m = eisen1.getItemMeta();
					e1m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
					eisen1.setItemMeta(e1m);
					p.getInventory().addItem(eisen1);
					PlaySound(p);
					p.sendMessage(Data.Prefix + "§eDu hast dir dieses §6Item §eerfolgreich erworben!");
					Stats.removeCoins(p, 84);
					Scoreboard.setScoreboard(p);
					return;
				}else{
					p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Coins um diese Aktion durchzuführen!");
					PlayNoSound(p);
					return;
				}
			}
		}else if(e.getInventory().getName().equalsIgnoreCase("§3Rüstung")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.IRON_HELMET){
			if(Stats.coins.get(p.getUniqueId().toString()) > 23){
				ItemStack eisenhelm = new ItemStack(Material.IRON_HELMET);
				ItemMeta eh = eisenhelm.getItemMeta();
				eh.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				eisenhelm.setItemMeta(eh);
				p.getInventory().addItem(eisenhelm);
				PlaySound(p);
				p.sendMessage(Data.Prefix + "§eDu hast dir dieses §6Item §eerfolgreich erworben!");
				Stats.removeCoins(p, 24);
				Scoreboard.setScoreboard(p);
				return;
			}else{
				p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Coins um diese Aktion durchzuführen!");
				PlayNoSound(p);
				return;
			}
		}
			if(e.getCurrentItem().getType() == Material.IRON_CHESTPLATE){
			if(Stats.coins.get(p.getUniqueId().toString()) > 41){
				ItemStack eisenchest = new ItemStack(Material.IRON_CHESTPLATE);
				ItemMeta cm = eisenchest.getItemMeta();
				cm.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				eisenchest.setItemMeta(cm);
				p.getInventory().addItem(eisenchest);
				PlaySound(p);
				p.sendMessage(Data.Prefix + "§eDu hast dir dieses §6Item §eerfolgreich erworben!");
				Stats.removeCoins(p, 42);
				Scoreboard.setScoreboard(p);
				return;
			}else{
				p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Coins um diese Aktion durchzuführen!");
				PlayNoSound(p);
				return;
			}
		}
			if(e.getCurrentItem().getType() == Material.IRON_LEGGINGS){
				if(Stats.coins.get(p.getUniqueId().toString()) > 36){
					ItemStack eisenhose = new ItemStack(Material.IRON_LEGGINGS);
					ItemMeta eha = eisenhose.getItemMeta();
					eha.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
					eisenhose.setItemMeta(eha);
					p.getInventory().addItem(eisenhose);
					PlaySound(p);
					p.sendMessage(Data.Prefix + "§eDu hast dir dieses §6Item §eerfolgreich erworben!");
					Stats.removeCoins(p, 37);
					Scoreboard.setScoreboard(p);
					return;
				}else{
					p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Coins um diese Aktion durchzuführen!");
					PlayNoSound(p);
					return;
				}
			}
			if(e.getCurrentItem().getType() == Material.IRON_BOOTS){
				if(Stats.coins.get(p.getUniqueId().toString()) > 24){
					ItemStack eisenschuh = new ItemStack(Material.IRON_BOOTS);
					ItemMeta esch = eisenschuh.getItemMeta();
					esch.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
					eisenschuh.setItemMeta(esch);
					p.getInventory().addItem(eisenschuh);
					PlaySound(p);
					p.sendMessage(Data.Prefix + "§eDu hast dir dieses §6Item §eerfolgreich erworben!");
					Stats.removeCoins(p, 25);
					Scoreboard.setScoreboard(p);
					return;
				}else{
					p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Coins um diese Aktion durchzuführen!");
					PlayNoSound(p);
					return;
				}
			}
			if(e.getCurrentItem().getType() == Material.DIAMOND_HELMET){
				if(Stats.coins.get(p.getUniqueId().toString()) > 53){
					ItemStack diahelm = new ItemStack(Material.DIAMOND_HELMET);
					ItemMeta dh = diahelm.getItemMeta();
					dh.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
					diahelm.setItemMeta(dh);
					p.getInventory().addItem(diahelm);
					PlaySound(p);
					p.sendMessage(Data.Prefix + "§eDu hast dir dieses §6Item §eerfolgreich erworben!");
					Stats.removeCoins(p, 54);
					Scoreboard.setScoreboard(p);
					return;
				}else{
					p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Coins um diese Aktion durchzuführen!");
					PlayNoSound(p);
					return;
				}
			}
			if(e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE){
				if(Stats.coins.get(p.getUniqueId().toString()) > 85){
					ItemStack diachest = new ItemStack(Material.DIAMOND_CHESTPLATE);
					ItemMeta dc = diachest.getItemMeta();
					dc.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
					diachest.setItemMeta(dc);
					p.getInventory().addItem(diachest);
					PlaySound(p);
					p.sendMessage(Data.Prefix + "§eDu hast dir dieses §6Item §eerfolgreich erworben!");
					Stats.removeCoins(p, 86);
					Scoreboard.setScoreboard(p);
					return;
				}else{
					p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Coins um diese Aktion durchzuführen!");
					PlayNoSound(p);
					return;
				}
			}
			if(e.getCurrentItem().getType() == Material.DIAMOND_LEGGINGS){
				if(Stats.coins.get(p.getUniqueId().toString()) > 81){
					ItemStack dialeg = new ItemStack(Material.DIAMOND_LEGGINGS);
					ItemMeta diam = dialeg.getItemMeta();
					diam.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
					dialeg.setItemMeta(diam);
					p.getInventory().addItem(dialeg);
					PlaySound(p);
					p.sendMessage(Data.Prefix + "§eDu hast dir dieses §6Item §eerfolgreich erworben!");
					Stats.removeCoins(p, 82);
					Scoreboard.setScoreboard(p);
					return;
				}else{
					p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Coins um diese Aktion durchzuführen!");
					PlayNoSound(p);
					return;
				}
			}
			if(e.getCurrentItem().getType() == Material.DIAMOND_BOOTS){
				if(Stats.coins.get(p.getUniqueId().toString()) > 56){
					ItemStack diaboots = new ItemStack(Material.DIAMOND_BOOTS);
					ItemMeta diabo = diaboots.getItemMeta();
					diabo.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
					diaboots.setItemMeta(diabo);
					p.getInventory().addItem(diaboots);
					PlaySound(p);
					p.sendMessage(Data.Prefix + "§eDu hast dir dieses §6Item §eerfolgreich erworben!");
					Stats.removeCoins(p, 57);
					Scoreboard.setScoreboard(p);
					return;
				}else{
					p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Coins um diese Aktion durchzuführen!");
					PlayNoSound(p);
					return;
				}
			}
			if(e.getCurrentItem().getType() == Material.CARROT_ITEM){
				setMainInv(p);
				return;
			}
		}else if(e.getInventory().getName().equalsIgnoreCase("§6Spezielles")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.APPLE){
				if(!deathregeneration.contains(p)){
					if(Stats.coins.get(p.getUniqueId().toString()) > 559){
						File file = new File("plugins//KnockPvP//shop.yml");
						YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
						cfg.set(p.getUniqueId() + "", true);
						try {
							cfg.save(file);
						} catch (IOException e1) {
							p.sendMessage(Data.Prefix + "§cEs gab einen Fehler beim Speichern...");
						}
						Stats.removeCoins(p, 560);
						deathregeneration.add(p);
						p.sendMessage(Data.Prefix + "§7Du hast diese §eFunktion §7freigeschaltet!");
						p.closeInventory();
						PlaySound(p);
						return;
					}else{
						p.sendMessage(Data.Prefix + "§cLeider hast du nicht genügend Coins um diese Aktion durchzuführen!");
						PlayNoSound(p);
						return;
					}
				}else{
					p.sendMessage(Data.Prefix + "§cDu hast bereits diese Funktion freigeschaltet!");
					PlayNoSound(p);
					return;
				}
			}
			if(e.getCurrentItem().getType() == Material.CARROT_ITEM){
				setMainInv(p);
				return;
			}
		}else{
				if(e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE){
					e.setCancelled(true);
					p.sendMessage(Data.Prefix + "§cDu benötigst einen höhreren Rang um diesen Inventarslot nutzen zu dürfen!");
					PlaySound(p);
				}
				}
		
		
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		File file = new File("plugins//KnockPvP//shop.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(cfg.get(p.getUniqueId() + "") != null){
			deathregeneration.add(p);
		}
	}
	@EventHandler
	public void onInteracta(PlayerInteractEvent e){
		try{
			Player p = e.getPlayer();
			if(e.getClickedBlock().getType() == Material.ENDER_CHEST){
				e.setCancelled(true);
			Inventory inv = p.getEnderChest();
			ItemStack legend = createItemWithLore(Material.STAINED_GLASS_PANE, 2, "§cNicht verfügbar!", "§7Erst ab dem §5Legend §7Rang");
			ItemStack ultra = createItemWithLore(Material.STAINED_GLASS_PANE, 3, "§cNicht verfügbar!", "§7Erst ab dem §bUltra §7Rang");
			ItemStack gold = createItemWithLore(Material.STAINED_GLASS_PANE, 11, "§cNicht verfügbar!", "§7Erst ab dem §3Hero §7Rang");
			ItemStack gold1 = createItemWithLore(Material.STAINED_GLASS_PANE, 1, "§cNicht verfügbar!", "§7Erst ab dem §6Gold §7Rang");
			PlaySound(p);
			if(p.hasPermission("claymc.legend")){
				p.openInventory(inv);
				
				return;
			}else
			if(p.hasPermission("claymc.ultra")){
				inv.setItem(18, legend);
				inv.setItem(19, legend);
				inv.setItem(20, legend);
				inv.setItem(21, legend);
				inv.setItem(22, legend);
				inv.setItem(23, legend);
				inv.setItem(24, legend);
				inv.setItem(25, legend);
				inv.setItem(26, legend);
				p.openInventory(inv);
				return;
			}else
			if(p.hasPermission("claymc.hero")){
				inv.setItem(14, ultra);
				inv.setItem(15, ultra);
				inv.setItem(16, ultra);
				inv.setItem(17, ultra);
				inv.setItem(18, legend);
				inv.setItem(19, legend);
				inv.setItem(20, legend);
				inv.setItem(21, legend);
				inv.setItem(22, legend);
				inv.setItem(23, legend);
				inv.setItem(24, legend);
				inv.setItem(25, legend);
				inv.setItem(26, legend);
				p.openInventory(inv);
				return;
			}else
			if(p.hasPermission("claymc.gold")){
				inv.setItem(9, gold);
				inv.setItem(10, gold);
				inv.setItem(11, gold);
				inv.setItem(12, gold);
				inv.setItem(13, gold);
				inv.setItem(14, ultra);
				inv.setItem(15, ultra);
				inv.setItem(16, ultra);
				inv.setItem(17, ultra);
				inv.setItem(18, legend);
				inv.setItem(19, legend);
				inv.setItem(20, legend);
				inv.setItem(21, legend);
				inv.setItem(22, legend);
				inv.setItem(23, legend);
				inv.setItem(24, legend);
				inv.setItem(25, legend);
				inv.setItem(26, legend);
				p.openInventory(inv);
				return;
				
			}else{
				inv.setItem(5, gold1);
				inv.setItem(6, gold1);
				inv.setItem(7, gold1);
				inv.setItem(8, gold1);
				inv.setItem(9, gold);
				inv.setItem(10, gold);
				inv.setItem(11, gold);
				inv.setItem(12, gold);
				inv.setItem(13, gold);
				inv.setItem(14, ultra);
				inv.setItem(15, ultra);
				inv.setItem(16, ultra);
				inv.setItem(17, ultra);
				inv.setItem(18, legend);
				inv.setItem(19, legend);
				inv.setItem(20, legend);
				inv.setItem(21, legend);
				inv.setItem(22, legend);
				inv.setItem(23, legend);
				inv.setItem(24, legend);
				inv.setItem(25, legend);
				inv.setItem(26, legend);
				p.openInventory(inv);
				return;
			}
			}
		}catch(Exception e1){}
	}
	public static void PlaySound(Player p){
		p.playSound(p.getLocation(), Sound.DIG_STONE, 6, 3);
		p.playSound(p.getLocation(), Sound.NOTE_BASS_GUITAR, 4, 2);
		p.playSound(p.getLocation(), Sound.EAT, 6, 3);
		p.playSound(p.getLocation(), Sound.DOOR_OPEN, 6, 3);
	}
	public void setMainInv(Player p){
		Inventory inv = Bukkit.createInventory(null, 9, "§6Shop");
		
		ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		ItemMeta gm = glas.getItemMeta();
		gm.setDisplayName(" ");
		glas.setItemMeta(gm);
		inv.setItem(0, glas);
		
		ItemStack schwert = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta sm = schwert.getItemMeta();
		sm.setDisplayName("§3Waffen");
		ArrayList<String> list = new ArrayList<>();
		list.add("§7Kaufe dir spezielle §eWaffen");
		sm.setLore(list);
		schwert.setItemMeta(sm);
		inv.setItem(1, schwert);
		ItemStack brust = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta bm = brust.getItemMeta();
		bm.setDisplayName("§3Rüstung");
		ArrayList<String> bl = new ArrayList<>();
		bl.add("§7Kaufe dir spezielle §eRüstung");
		bm.setLore(bl);
		brust.setItemMeta(bm);
		inv.setItem(2, brust);
		
		inv.setItem(3, glas);
		
		ItemStack upgrade = new ItemStack(Material.GOLD_NUGGET);
		ItemMeta um = upgrade.getItemMeta();
		um.setDisplayName("§6Persönliche Updates");
		ArrayList<String> bb = new ArrayList<>();
		bb.add("§7Kaufe dir §eUpdates§7, welche auf §edich §7abgestimmt sind");
		upgrade.setItemMeta(um);
		
		inv.setItem(4, upgrade);
		
		ItemStack ec = new ItemStack(Material.ENDER_CHEST);
		ItemMeta e3 = ec.getItemMeta();
		e3.setDisplayName("§3Items speichern");
		ArrayList<String> hh = new ArrayList<>();
		hh.add("§7Speichere deine Items. §6Gold §7benötigt!");
		e3.setLore(hh);
		ec.setItemMeta(e3);
		inv.setItem(5, glas);
		inv.setItem(6, ec);
		
		ItemStack pap = new ItemStack(Material.PAPER);
		ItemMeta pa = pap.getItemMeta();
		pa.setDisplayName("§3Map + Kit - Switch Zeit verlängern");
		ArrayList<String> aa = new ArrayList<>();
		aa.add("§7Verlängere die Kit+Map Zeit um §e30 §7Sekunden!");
		pap.setItemMeta(pa);

		inv.setItem(7, pap);
		
		ItemStack bar = new ItemStack(Material.BARRIER);
		ItemMeta bma = bar.getItemMeta();
		bma.setDisplayName("§3Verhindere das Verlängern der Zeit");
		ArrayList<String> aff = new ArrayList<>();
		aff.add("§7Verhindere, dass andere Spieler den §eKit+Map §7Switch Countdown §everlängern §7können");
		bma.setLore(aff);
		bar.setItemMeta(bma);
		inv.setItem(8, bar);
		
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 6, 3);

		p.openInventory(inv);
	}
	public static void PlayNoSound(Player p) {
		p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 6, 3);
		p.playSound(p.getLocation(), Sound.DONKEY_ANGRY, 10, 10);
		p.playSound(p.getLocation(), Sound.DONKEY_HIT, 10, 10);

	}
	
public static ItemStack createItemWithEnchantmentAndLore(Material mat, int subid,String displayname, ArrayList lore, Enchantment Enchant, int staerke) {
		
		ItemStack item = new ItemStack(mat, 1, (short) subid );
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(displayname);
		itemmeta.setLore(lore);
		itemmeta.addEnchant(Enchant, staerke, true);
		item.setItemMeta(itemmeta);
		return item;
		
		
	}
public static ItemStack createItem(Material mat, int subid,String displayname) {
	
	ItemStack item = new ItemStack(mat, 1, (short) subid );
	ItemMeta itemmeta = item.getItemMeta();
	itemmeta.setDisplayName(displayname);
	item.setItemMeta(itemmeta);
	return item;
	
	
}
public static ItemStack createItemWithLore(Material mat, int subid,String displayname, String lore) {
	ArrayList<String> a = new ArrayList<>();
	a.add(lore);
	ItemStack item = new ItemStack(mat, 1, (short) subid );
	ItemMeta itemmeta = item.getItemMeta();
	itemmeta.setDisplayName(displayname);
	itemmeta.setLore(a);
	item.setItemMeta(itemmeta);
	return item;
}

}
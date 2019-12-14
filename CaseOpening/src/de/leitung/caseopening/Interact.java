package de.leitung.caseopening;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Interact implements Listener{
	final List<ItemStack> items = new ArrayList<ItemStack>();
	ArrayList<Player> firsta = new ArrayList<Player>();
	ArrayList<Player> seca = new ArrayList<Player>();

	int cd;
	int cd2;
	int oben;
	int unten;
	int cd3;
	int invz;
	int werte;
	int first;
	int loong;
	public Interact(de.leitung.caseopening.Main Main){
		this.pl = Main;
	}
	private de.leitung.caseopening.Main pl;
	@EventHandler
	public void onInt(PlayerInteractEvent e){
	try{
	if(e.getClickedBlock().getType() == Material.CHEST){
		final Player p = e.getPlayer();
		e.setCancelled(true);
		if(firsta.isEmpty()){
		firsta.add(p);
		Inventory inv = Bukkit.createInventory(null, 9, "§6CaseOpening");
		ItemStack glas = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
		ItemStack gold = new ItemStack(Material.GOLD_INGOT);
		ItemMeta gm = gold.getItemMeta();
		gm.setDisplayName("§6Case kaufen §8| §3120 Clays");
		gm.addEnchant(Enchantment.DURABILITY, 1, true);
		gold.setItemMeta(gm);
		first = 0;
		p.openInventory(inv);
		cd = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable(){	
			@Override
			public void run() {
				if(first < 9){
					p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
					inv.setItem(first, glas);
					first++;
				}else{
					firsta.remove(p);
					firsta.clear();
					Bukkit.getScheduler().cancelTask(cd);
					inv.setItem(4, gold);
					p.playSound(p.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
					double x = 2.0;
					double y = 2.0;
					double z = 2.0;
					Location loc = new Location(Bukkit.getWorld("welt"), 1, 2, 3);
					p.teleport(loc);
					
				}
			}
			
		}, 1, 1);
	}else{
		p.sendMessage(Main.Prefix + "§cBitte warte einen Moment...");
	}
	}
	}catch(Exception e1){
		
	}
	}
	@EventHandler
	public void oni(InventoryClickEvent e){
		if(e.getInventory().getName().equalsIgnoreCase("§6CaseOpening")){
			e.setCancelled(true);
			final Player p = (Player)e.getWhoClicked();
			
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Case kaufen §8| §3120 Clays")){
				Inventory inv = Bukkit.createInventory(null,27, "§6CaseOpening");
				if(seca.isEmpty()){
				invz = 9;
			    p.openInventory(inv);
				seca.add(p);	

				cd2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable(){

					@Override
					public void run() {
						ItemStack ch = null;
						
						int wert = (int) ((Math.random()*14)+1);
							
						
						switch(wert){
						case 1:
							ItemStack a = new ItemStack(Material.BARRIER);
							ItemMeta am = a.getItemMeta();
							am.setDisplayName("§cNiete");
							a.setItemMeta(am);
							ch = a;
							break;
						case 2:
						ItemStack a1 = new ItemStack(Material.GOLD_INGOT);
						ItemMeta am1 = a1.getItemMeta();
						int werta = (int) ((Math.random()*1000)+1);
						am1.setDisplayName("§6Clays: §3" + werta);
						a1.setItemMeta(am1);
						ch = a1;
						break;
						case 3:
							ItemStack a11 = new ItemStack(Material.BARRIER);
							ItemMeta am11 = a11.getItemMeta();
							
							int werta1 = (int) ((Math.random()*7000)+1);
							am11.setDisplayName("§cNiete");
							a11.setItemMeta(am11);
							ch = a11;
							break;
						case 4: 
							ItemStack a111 = new ItemStack(Material.GOLD_HELMET);
							ItemMeta am111 = a111.getItemMeta();
							int werta11 = (int) ((Math.random()*36)+1);
							am111.setDisplayName("§6Gold-Rang ("+ werta11 + " Stunden)");
							a111.setItemMeta(am111);
							ch = a111;
							break;
						case 5:
							ItemStack a1111 = new ItemStack(Material.IRON_HELMET);
							ItemMeta am1111 = a1111.getItemMeta();
							int werta111 = (int) ((Math.random()*36)+1);
							am1111.setDisplayName("§3Hero-Rang ("+ werta111 + " Stunden)");
							a1111.setItemMeta(am1111);
							ch = a1111;
							break;
						case 6:
							ItemStack a11111 = new ItemStack(Material.DIAMOND_HELMET);
							ItemMeta am11111 = a11111.getItemMeta();
							int werta1111 = (int) ((Math.random()*36)+1);
							am11111.setDisplayName("§bUltra-Rang ("+ werta1111 + " Stunden)");
							a11111.setItemMeta(am11111);
							ch = a11111;
							break;
						case 7:
							ItemStack a111111 = new ItemStack(Material.DIAMOND_HELMET);
							ItemMeta am111111 = a111111.getItemMeta();
							int werta11111 = (int) ((Math.random()*36)+1);
							am111111.setDisplayName("§bUltra-Rang ("+ werta11111 + " Stunden)");
							a111111.setItemMeta(am111111);
							ch = a111111;
							break;
						case 8:
							ItemStack a1111111 = new ItemStack(Material.EMERALD);
							ItemMeta am1111111 = a1111111.getItemMeta();
							am1111111.setDisplayName("§6KitBattle Kit: §3§lNinja");
							a1111111.setItemMeta(am1111111);
							ch = a1111111;
							break;
						case 9:
							ItemStack a11111111 = new ItemStack(Material.EMERALD);
							ItemMeta am11111111 = a11111111.getItemMeta();
							am11111111.setDisplayName("§6KitBattle Kit: §3§lOpa");
							a11111111.setItemMeta(am11111111);
							ch = a11111111;
							break;
						case 10:
							ItemStack a111111111 = new ItemStack(Material.EMERALD);
							ItemMeta am111111111 = a111111111.getItemMeta();
							am111111111.setDisplayName("§6KitBattle Kit: §3§lClimber");
							a111111111.setItemMeta(am111111111);
							ch = a111111111;
							break;
						case 11:
							ItemStack a1111111111 = new ItemStack(Material.EMERALD);
							ItemMeta am1111111111 = a1111111111.getItemMeta();
							am1111111111.setDisplayName("§6KitBattle Kit: §3§lPanzer");
							a1111111111.setItemMeta(am1111111111);
							ch = a1111111111;
							break;
						case 12:
							ItemStack a12 = new ItemStack(Material.GOLD_INGOT);
							ItemMeta am12 = a12.getItemMeta();
							int werta2 = (int) ((Math.random()*1000)+1);
							am12.setDisplayName("§6Clays: §3" + werta2);
							a12.setItemMeta(am12);
							ch = a12;
							break;
						case 13:
							ItemStack a121 = new ItemStack(Material.GOLD_INGOT);
							ItemMeta am121 = a121.getItemMeta();
							int werta21 = (int) ((Math.random()*1000)+1);
							am121.setDisplayName("§6Clays: §3" + werta21);
							a121.setItemMeta(am121);
							ch = a121;
							break;
						case 14:
							ItemStack aa = new ItemStack(Material.BARRIER);
							ItemMeta ama = aa.getItemMeta();
							ama.setDisplayName("§cNiete");
							aa.setItemMeta(ama);
							ch = aa;
							break;
						}
						
					if(invz < 18){
						p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);

						inv.setItem(invz, ch);
						invz++;
					}else{
						Bukkit.getScheduler().cancelTask(cd2);
						oben = 4;
						unten = 22;
						
						werte = (int) ((Math.random()*36)+7);			
						if(werte > 30){
							loong = 1;
						}else if(werte > 15){
							loong = 4;
						}else if(werte < 15 && werte < 25){
							loong = 5;
						}else{
							loong = 8;
						}
						ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)5);
						ItemStack air = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
						
						cd3 = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable(){

							@Override
							public void run() {
								ItemStack r = new ItemStack(Material.DIAMOND, werte);
								ItemMeta rm = r.getItemMeta();
								rm.setDisplayName("");
								r.setItemMeta(rm);
								if(werte > 0){
									if(oben == 0){
										oben = 8;
										unten = 26;
										p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);
										inv.setItem(8, glass);
										inv.setItem(26, glass);
										inv.setItem(0, air);
										inv.setItem(18, air);
										werte--;
										p.getInventory().setItem(13, r);

										return;
									}
									p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);
									inv.setItem(unten, air);
									inv.setItem(oben, air);
									unten--;
									oben--;
									inv.setItem(unten, glass);
									inv.setItem(oben, glass);
									werte--;
									p.getInventory().setItem(13, r);
								}else{
									ItemStack i = new ItemStack(Material.DIAMOND);
									p.getInventory().removeItem(i);
									Bukkit.getScheduler().cancelTask(cd3);
									seca.clear();
									int ia = oben + 8;
									int hi = ia;
									ItemStack aaa = e.getInventory().getItem(hi);
									if(aaa.getItemMeta().getDisplayName().equalsIgnoreCase("Hi")){
										
									}else{
										p.sendMessage("es geht");
									}
									
						
									

								}

							}
							
						}, 8L, loong);
						
					}
						
					}
					
				}, 1, 4);
			}else{
				p.sendMessage(Main.Prefix + "§cBitte warte einen Moment. Ein anderer Spieler macht gerade das CaseOpening!");
			}
		}
		}
	}
	@EventHandler
	public void onC(InventoryCloseEvent e){
		Player p = (Player)e.getPlayer();
		if(firsta.contains(p) || seca.contains(p)){
			p.sendMessage(Main.Prefix + "§cDu hast das CaseOpening abgebrochen!");
			Bukkit.getScheduler().cancelTask(cd);
			Bukkit.getScheduler().cancelTask(cd3);
			Bukkit.getScheduler().cancelTask(cd2);
			seca.clear();
			firsta.clear();

		}
	}
}

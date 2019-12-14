package spigotplugins.skywars.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

import me.eder.statsapi.manager.Manager;
import spigotplugins.skywars.main.Boards;
import spigotplugins.skywars.main.StatsManager;
import spigotplugins.skywars.manager.Inventorys;
import spigotplugins.skywars.storage.Data;
import spigotplugins.skywars.storage.GameState;

public class KitListener implements Listener{
	
	public static HashMap<String, String> Kits = new HashMap<>();
	
	public static ArrayList<Player> BAUARBEITER = new ArrayList<>();
	public static ArrayList<Player> BOGENSCHUETZE = new ArrayList<>();
	public static ArrayList<Player> TANK = new ArrayList<>();
	public static ArrayList<Player> ASSASSINE = new ArrayList<>();
	public static ArrayList<Player> MLG = new ArrayList<>();

	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
				if(e.getItem().getType() == Material.ENDER_CHEST){
					if(Data.gs == GameState.LOBBY){
						Inventory inv = Bukkit.createInventory(null, 9, "§6Kits");
						if(BAUARBEITER.contains(e.getPlayer())){
						inv.setItem(0, Inventorys.createKit(Material.BRICK, 0, "Bauarbeiter", true, 200, "Starte mit Blöcken um dich", "sofort zu den Gegnern zu bauen"));
						}else{
						inv.setItem(0, Inventorys.createKit(Material.BRICK, 0, "Bauarbeiter", false, 200, "Starte mit Blöcken um dich", "sofort zu den Gegnern zu bauen"));
						}
						if(BOGENSCHUETZE.contains(e.getPlayer())){
						inv.setItem(1, Inventorys.createKit(Material.BOW, 0, "Bogenschütze", true, 250, "Du hast einen Bogen womit", "sich Gegner vom weiten töten lassen"));
						}else{
						inv.setItem(1, Inventorys.createKit(Material.BOW, 0, "Bogenschütze", false, 250, "Du hast einen Bogen womit", "sich Gegner vom weiten töten lassen"));
						}
						if(TANK.contains(e.getPlayer())){
						inv.setItem(2, Inventorys.createKit(Material.IRON_CHESTPLATE, 0, "Tank", true, 870, "Starte mit einer vollen Eisenrüstung", "um sich auf anderes zu konzentrieren"));
						}else{
							inv.setItem(2, Inventorys.createKit(Material.IRON_CHESTPLATE, 0, "Tank", false, 870, "Starte mit einer vollen Eisenrüstung", "um sich auf anderes zu konzentrieren"));
						}
						if(ASSASSINE.contains(e.getPlayer())){
						inv.setItem(3, Inventorys.createKit(Material.DIAMOND_SWORD, 0, "Assassine", true, 630, "Starte mit einem Diamantschwert", "welches Schärfe 2 besitzt"));
						}else{
							inv.setItem(3, Inventorys.createKit(Material.DIAMOND_SWORD, 0, "Assassine", false, 630, "Starte mit einem Diamantschwert", "welches Schärfe 2 besitzt"));
						}
						if(MLG.contains(e.getPlayer())){
						inv.setItem(4, Inventorys.createKit(Material.TNT, 0, "MLG", true, 330, "Du hast eine Menge TNT", "und andere MLG Items"));
						}else{
							inv.setItem(4, Inventorys.createKit(Material.TNT, 0, "MLG", false, 330, "Du hast eine Menge TNT", "und andere MLG Items"));
						}
						e.getPlayer().openInventory(inv);
						e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.CHEST_OPEN, 10, 10);
					}
				}
			}
		}catch(Exception e1){
		}
	}
	@EventHandler
	public void onClick(InventoryClickEvent e){
		try{
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§6Kits")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.BRICK){
				if(e.getCurrentItem().getEnchantments().size() > 0){
					p.sendMessage(Data.Prefix + "§eDu hast das Kit §6Bauarbeiter §eausgewählt!");
					KitListener.Kits.put(p.getName(), "§a§lBauarbeiter");
					p.getInventory().setItem(7, Inventorys.createItem(Material.BRICK, 1, 0, "§aBauarbeiter", ""));
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.EXPLODE, 10, 10);
				
					return;
				}else{
					if(StatsManager.Coins.get(p.getName()) >= 200){
						new Manager().setInt(p.getUniqueId(), "SKYWARS", "BAUARBEITER", 1);
						p.sendMessage(Data.Prefix + "§aDu hast dir das Kit §bBauarbeiter §aerfolgreich gekauft!");
						p.sendMessage(Data.Prefix + "§eBitte wähle dieses Kit erneut aus!");
						new Manager().removeInt(p.getUniqueId(), p.getName(), "SKYWARS", "COINS", 200);
						StatsManager.Coins.put(p.getName(), StatsManager.Coins.get(p.getName()) -200);
						Boards.setBoard(p);
						p.closeInventory();
						BAUARBEITER.add(p);
					}else{
						int i = 200 - StatsManager.Coins.get(p.getName());
						p.sendMessage(Data.Prefix + "§cDu hast nicht genügend Coins! Dir §4fehlen §cnoch: §6" + i + " Coins");
						p.closeInventory();
					}
				}
			}
			if(e.getCurrentItem().getType() == Material.BOW){
				if(e.getCurrentItem().getEnchantments().size() > 0){
					p.sendMessage(Data.Prefix + "§eDu hast das Kit §6Bogenschütze §eausgewählt!");
					KitListener.Kits.put(p.getName(), "§a§lBogenschütze");
					p.getInventory().setItem(7, Inventorys.createItem(Material.BOW, 1, 0, "§aBogenschütze", ""));
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.EXPLODE, 10, 10);
					return;
				}else{
					if(StatsManager.Coins.get(p.getName()) >= 250){
						new Manager().setInt(p.getUniqueId(), "SKYWARS", "BOGENSCHUETZE", 1);
						p.sendMessage(Data.Prefix + "§aDu hast dir das Kit §bBogenschütze §aerfolgreich gekauft!");
						p.sendMessage(Data.Prefix + "§eBitte wähle dieses Kit erneut aus!");
						new Manager().removeInt(p.getUniqueId(), p.getName(), "SKYWARS", "COINS", 250);
						StatsManager.Coins.put(p.getName(), StatsManager.Coins.get(p.getName()) -250);
						Boards.setBoard(p);
						p.closeInventory();
						BOGENSCHUETZE.add(p);
						p.closeInventory();
					}else{
						int i = 250 - StatsManager.Coins.get(p.getName());
						p.sendMessage(Data.Prefix + "§cDu hast nicht genügend Coins! Dir §4fehlen §cnoch: §6" + i + " Coins");
					}
				}
			}
			if(e.getCurrentItem().getType() == Material.IRON_CHESTPLATE){
				if(e.getCurrentItem().getEnchantments().size() > 0){
					p.sendMessage(Data.Prefix + "§eDu hast das Kit §6Tank §eausgewählt!");
					KitListener.Kits.put(p.getName(), "§a§lTank");
					p.getInventory().setItem(7, Inventorys.createItem(Material.IRON_CHESTPLATE, 1, 0, "§aTank", ""));
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.EXPLODE, 10, 10);
					return;
				}else{
					if(StatsManager.Coins.get(p.getName()) >= 870){
						new Manager().setInt(p.getUniqueId(), "SKYWARS", "TANK", 1);
						p.sendMessage(Data.Prefix + "§aDu hast dir das Kit §bTank §aerfolgreich gekauft!");
						p.sendMessage(Data.Prefix + "§eBitte wähle dieses Kit erneut aus!");
						new Manager().removeInt(p.getUniqueId(), p.getName(), "SKYWARS", "COINS", 870);
						StatsManager.Coins.put(p.getName(), StatsManager.Coins.get(p.getName()) -870);
						Boards.setBoard(p);
						p.closeInventory();
						TANK.add(p);
					}else{
						int i = 870 - StatsManager.Coins.get(p.getName());
						p.sendMessage(Data.Prefix + "§cDu hast nicht genügend Coins! Dir §4fehlen §cnoch: §6" + i + " Coins");
						p.closeInventory();

					}
				}
			}
			if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD){
				if(e.getCurrentItem().getEnchantments().size() > 0){
					p.sendMessage(Data.Prefix + "§eDu hast das Kit §6Assassine §eausgewählt!");
					KitListener.Kits.put(p.getName(), "§a§lAssassine");
					p.getInventory().setItem(7, Inventorys.createItem(Material.DIAMOND_SWORD, 1, 0, "§aAssassine", ""));
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.EXPLODE, 10, 10);
					return;
				}else{
					if(StatsManager.Coins.get(p.getName()) >= 630){
						new Manager().setInt(p.getUniqueId(), "SKYWARS", "ASSASSINE", 1);
						p.sendMessage(Data.Prefix + "§aDu hast dir das Kit §bAssassine §aerfolgreich gekauft!");
						p.sendMessage(Data.Prefix + "§eBitte wähle dieses Kit erneut aus!");
						new Manager().removeInt(p.getUniqueId(), p.getName(), "SKYWARS", "COINS", 630);
						StatsManager.Coins.put(p.getName(), StatsManager.Coins.get(p.getName()) -630);
						Boards.setBoard(p);
						p.closeInventory();
						ASSASSINE.add(p);
					}else{
						int i = 630 - StatsManager.Coins.get(p.getName());
						p.sendMessage(Data.Prefix + "§cDu hast nicht genügend Coins! Dir §4fehlen §cnoch: §6" + i + " Coins");
						p.closeInventory();
					}
				}
			}
			if(e.getCurrentItem().getType() == Material.TNT){
				if(e.getCurrentItem().getEnchantments().size() > 0){
					p.sendMessage(Data.Prefix + "§eDu hast das Kit §6MLG §eausgewählt!");
					KitListener.Kits.put(p.getName(), "§a§lMLG");
					p.getInventory().setItem(7, Inventorys.createItem(Material.TNT, 1, 0, "§aMLG", ""));
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.EXPLODE, 10, 10);
					return;
				}else{
					if(StatsManager.Coins.get(p.getName()) >= 330){
						new Manager().setInt(p.getUniqueId(), "SKYWARS", "MLG", 1);
						p.sendMessage(Data.Prefix + "§aDu hast dir das Kit §bMLG §aerfolgreich gekauft!");
						p.sendMessage(Data.Prefix + "§eBitte wähle dieses Kit erneut aus!");
						new Manager().removeInt(p.getUniqueId(), p.getName(), "SKYWARS", "COINS", 330);
						StatsManager.Coins.put(p.getName(), StatsManager.Coins.get(p.getName()) -300);
						Boards.setBoard(p);
						p.closeInventory();
						MLG.add(p);
					}else{
						int i = 330 - StatsManager.Coins.get(p.getName());
						p.sendMessage(Data.Prefix + "§cDu hast nicht genügend Coins! Dir §4fehlen §cnoch: §6" + i + " Coins");
						p.closeInventory();
					}
				}
			}
		}
		}catch(Exception e1){}
	}
	public static void setKits(Player p){
		if(Kits.containsKey(p.getName())){
			if(Kits.get(p.getName()).equals("§a§lBauarbeiter")){
				ItemStack i = new ItemStack(Material.BRICK, 64);
				p.getInventory().setItem(0, i);
				p.getInventory().setItem(1, i);
				p.getInventory().setItem(2, i);
				p.updateInventory();
				return;
			}
			if(Kits.get(p.getName()).equals("§a§lBogenschütze")){
				ItemStack i = new ItemStack(Material.BOW);
				ItemStack a = new ItemStack(Material.ARROW, 6);
				p.getInventory().setItem(0, i);
				p.getInventory().setItem(8, a);
				p.updateInventory();
				return;
			}
			if(Kits.get(p.getName()).equals("§a§lTank")){
				ItemStack i = new ItemStack(Material.IRON_HELMET);
				ItemStack a = new ItemStack(Material.IRON_CHESTPLATE);
				ItemStack x = new ItemStack(Material.IRON_LEGGINGS);
				ItemStack q = new ItemStack(Material.IRON_BOOTS);
				ItemStack c = new ItemStack(Material.STONE_SWORD);
				p.getInventory().setItem(0, c);
				p.getInventory().setHelmet(i);
				p.getInventory().setChestplate(a);
				p.getInventory().setLeggings(x);
				p.getInventory().setBoots(q);
				p.updateInventory();
				return;
			}
			if(Kits.get(p.getName()).equals("§a§lAssassine")){
				ItemStack a = new ItemStack(Material.DIAMOND_SWORD);
				ItemMeta am = a.getItemMeta();
				am.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				a.setItemMeta(am);
				p.getInventory().setItem(0, a);
				p.updateInventory();
				return;
			}
			if(Kits.get(p.getName()).equals("§a§lMLG")){
				ItemStack i = new ItemStack(Material.TNT, 12);
				ItemStack a = new ItemStack(Material.WATER_BUCKET, 1);
				ItemStack x = new ItemStack(Material.FLINT_AND_STEEL);
				ItemStack q = new ItemStack(Material.WOOD, 32);
				p.getInventory().setItem(0, i);
				p.getInventory().setItem(1, a);
				p.getInventory().setItem(2, x);
				p.getInventory().setItem(3, q);
				p.updateInventory();
				return;
			}
		}
	}
	
}

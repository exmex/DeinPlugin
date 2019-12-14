package souppvp.kitmenu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scoreboard.Score;

import souppvp.data.Data;
import souppvp.listener.DeathListener;
import souppvp.main.Main;
import souppvp.manager.LevelManager;
import souppvp.manager.StatsManager;
import souppvp.methods.ItemCreator;
import souppvp.methods.Scoreboard;
import souppvp.methods.Sounds;

public class KitListener implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		try{
			Main.ma = Main.ma+1;
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §eKits §7«")){
				if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					e.setCancelled(true);
					setInventory(p);
					return;
				}
			
			}
			
		}catch(Exception e1){}
		return;
	}
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§6Kits")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.IRON_CHESTPLATE){
				KitData.removeFromAllArrayList(p);
				KitData.USE_standartkit.add(p);
				Kits.getStandartKit(p);
				Sounds.playKitPickSound(p);
				p.closeInventory();
				Data.nopickedkit.remove(p);
				Scoreboard.setScoreboard(p);
				return;
			}
			if(e.getCurrentItem().getType() == Material.BOW){
				if(e.getCurrentItem().getItemMeta().hasEnchant(Enchantment.DURABILITY)){
				KitData.removeFromAllArrayList(p);
				KitData.bogenschütze.add(p);
				Kits.getBogenschütze(p);
				Sounds.playKitPickSound(p);
				p.closeInventory();
				KitData.USE_bogenschütze.add(p);
				Data.nopickedkit.remove(p);
				Scoreboard.setScoreboard(p);
				}else{
					setShop(p, e);
					Sounds.playAdminFailureSound(p);
					return;
				}
				return;
			}
				if(e.getCurrentItem().getType() == Material.FISHING_ROD){
					if(e.getCurrentItem().getItemMeta().hasEnchant(Enchantment.DURABILITY)){
					KitData.removeFromAllArrayList(p);
					KitData.rodpvp.add(p);
					Kits.getRodPvPKit(p);
					Sounds.playKitPickSound(p);
					p.closeInventory();
					KitData.USE_rodpvp.add(p);
					Data.nopickedkit.remove(p);
					Scoreboard.setScoreboard(p);
					return;
					}else{
						setShop(p, e);
						Sounds.playAdminFailureSound(p);
						return;
					}
			
		}
				if(e.getCurrentItem().getType() == Material.CACTUS){
					if(e.getCurrentItem().getItemMeta().hasEnchant(Enchantment.DURABILITY)){
					KitData.removeFromAllArrayList(p);
					KitData.kaktus.add(p);
					Kits.getKaktusKit(p);
					Sounds.playKitPickSound(p);
					p.closeInventory();
					KitData.USE_kaktus.add(p);
					Data.nopickedkit.remove(p);
					Scoreboard.setScoreboard(p);
					return;
					}else{
						setShop(p, e);
						Sounds.playAdminFailureSound(p);
						return;
					}
			
		}
				return;
	}
		return;
	}
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent e){
		Player p = e.getPlayer();
		if(e.isSneaking()){
			if(DeathListener.canswitchkit.contains(p)){
				DeathListener.canswitchkit.remove(p);
				return;
			}
		}
	}
	@EventHandler
	public void onShop(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§aEinkaufen")){
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§l✔ §aKaufen")){
				if(e.getClickedInventory().contains(Material.BOW)){
					if(StatsManager.coins.get(p.getUniqueId().toString()) > 99){
						if(LevelManager.getLevelToINT(p) > 0){
							KitData.bogenschütze.add(p);
							StatsManager.removeCoins(p, 100);
							Sounds.playKitPickSound(p);
							p.sendMessage(Data.Prefix + "§aDu hast dir das Kit gekauft! Wähle es nun in der §eKitauswahl §aaus!");
							p.closeInventory();
							Scoreboard.setScoreboard(p);
							return;
						}else{
							p.sendMessage(Data.Prefix + "§cDu hast nicht genügend Level um dir dieses Kit freizuschalten!");
							p.sendMessage(Data.Prefix + "§7Keine Lust zu §ewarten§7? §6http://shop.claymc.net");
							Sounds.playAdminFailureSound(p);
							return;
						}
					}else{
						p.sendMessage(Data.Prefix + "§cDu hast nicht genügend Coins um dieses Kit freizuschalten!");
						p.sendMessage(Data.Prefix + "§7Keine Lust zu §ewarten§7? §6http://shop.claymc.net");
						Sounds.playAdminFailureSound(p);
						return;

					}
				}
				if(e.getClickedInventory().contains(Material.FISHING_ROD)){
					if(StatsManager.coins.get(p.getUniqueId().toString()) > 199){
						if(LevelManager.getLevelToINT(p) > 0){
							KitData.rodpvp.add(p);
							StatsManager.removeCoins(p, 200);
							Sounds.playKitPickSound(p);
							p.sendMessage(Data.Prefix + "§aDu hast dir das Kit gekauft! Wähle es nun in der §eKitauswahl §aaus!");
							p.closeInventory();
							Scoreboard.setScoreboard(p);
							return;

						}else{
							p.sendMessage(Data.Prefix + "§cDu hast nicht genügend Level um dir dieses Kit freizuschalten!");
							p.sendMessage(Data.Prefix + "§7Keine Lust zu §ewarten§7? §6http://shop.claymc.net");
							Sounds.playAdminFailureSound(p);
							return;

						}
					}else{
						p.sendMessage(Data.Prefix + "§cDu hast nicht genügend Coins um dieses Kit freizuschalten!");
						p.sendMessage(Data.Prefix + "§7Keine Lust zu §ewarten§7? §6http://shop.claymc.net");
						Sounds.playAdminFailureSound(p);
						return;

					}
				}
				if(e.getClickedInventory().contains(Material.CACTUS)){
					if(StatsManager.coins.get(p.getUniqueId().toString()) > 299){
						if(LevelManager.getLevelToINT(p) > 0){
							KitData.kaktus.add(p);
							StatsManager.removeCoins(p, 300);
							Sounds.playKitPickSound(p);
							p.sendMessage(Data.Prefix + "§aDu hast dir das Kit gekauft! Wähle es nun in der §eKitauswahl §aaus!");
							p.closeInventory();
							Scoreboard.setScoreboard(p);
							return;

						}else{
							p.sendMessage(Data.Prefix + "§cDu hast nicht genügend Level um dir dieses Kit freizuschalten!");
							p.sendMessage(Data.Prefix + "§7Keine Lust zu §ewarten§7? §6http://shop.claymc.net");
							Sounds.playAdminFailureSound(p);
							return;

						}
					}else{
						p.sendMessage(Data.Prefix + "§cDu hast nicht genügend Coins um dieses Kit freizuschalten!");
						p.sendMessage(Data.Prefix + "§7Keine Lust zu §ewarten§7? §6http://shop.claymc.net");
						Sounds.playAdminFailureSound(p);
						return;

					}
				}
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§l✖ §cAbbrechen")){
				p.closeInventory();
				Sounds.playAdminFailureSound(p);
				return;

			}
		}
		return;
	}
	public static void setShop(Player p, InventoryClickEvent e){
		Inventory inv = Bukkit.createInventory(null, 9, "§aEinkaufen");
		inv.setItem(2, ItemCreator.CreateItemwhitMaterial(Material.INK_SACK, 10, 1, "§a§l✔ §aKaufen", "§7Kaufe das ausgewählte Kit"));
		inv.setItem(4, ItemCreator.CreateItemwhitMaterial(e.getCurrentItem().getType(), 0, 1, e.getCurrentItem().getItemMeta().getDisplayName(), "§7Schalte dir dieses Kit frei"));
		inv.setItem(6, ItemCreator.CreateItemwhitMaterial(Material.INK_SACK, 1, 1, "§c§l✖ §cAbbrechen", "§7Den kauf abbrechen"));
		p.openInventory(inv);
		return;
	}
	
}

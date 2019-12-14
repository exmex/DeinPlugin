package de.anweisung.classes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class Interact implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			Player p = e.getPlayer();
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Schuhe")){
				Inventory inv = Bukkit.createInventory(null, 4*9, "§6Schuhe");
			
			ItemStack grass = new ItemStack(Material.DOUBLE_PLANT, 1, (short) 2);
			ItemMeta grassmeta = grass.getItemMeta();
			grassmeta.setDisplayName(" ");
			grass.setItemMeta(grassmeta);
			
			ItemStack cookie = new ItemStack(Material.COOKIE);
			ItemMeta cm = cookie.getItemMeta();
			cm.setDisplayName("§6Cookie-Boots");
			if(!p.hasPermission("claymc.gold")){
				cm.addEnchant(Enchantment.DURABILITY, 1, true);
			}
			cookie.setItemMeta(cm);
			
			ItemStack cookie1 = new ItemStack(Material.GOLD_INGOT);
			ItemMeta cm1 = cookie1.getItemMeta();
			cm1.setDisplayName("§6Gold-Boots");
			if(!p.hasPermission("claymc.gold")){
				cm1.addEnchant(Enchantment.DURABILITY, 1, true);
			}
			cookie1.setItemMeta(cm1);
			
			ItemStack cookie2 = new ItemStack(Material.IRON_INGOT);
			ItemMeta cm2 = cookie2.getItemMeta();
			cm2.setDisplayName("§8Iron-Boots");
			if(!p.hasPermission("claymc.hero")){
				cm2.addEnchant(Enchantment.DURABILITY, 1, true);
			}
			cookie2.setItemMeta(cm2);
			
			ItemStack cookie3 = new ItemStack(Material.PRISMARINE_SHARD);
			ItemMeta cm3 = cookie3.getItemMeta();
			cm3.setDisplayName("§bScherben-Boots");
			if(!p.hasPermission("claymc.ultra")){
				cm3.addEnchant(Enchantment.DURABILITY, 1, true);
			}
			cookie3.setItemMeta(cm3);
			
			ItemStack cookie4 = new ItemStack(Material.EMERALD);
			ItemMeta cm4 = cookie4.getItemMeta();
			cm4.setDisplayName("§aEmerald-Boots");
			if(!p.hasPermission("claymc.ultra")){
				cm4.addEnchant(Enchantment.DURABILITY, 1, true);
			}
			cookie4.setItemMeta(cm4);
			
			ItemStack cookie5 = new ItemStack(Material.DIAMOND);
			ItemMeta cm5 = cookie5.getItemMeta();
			cm5.setDisplayName("§5Diamond-Boots");
			if(!p.hasPermission("claymc.legend")){
				cm5.addEnchant(Enchantment.DURABILITY, 1, true);
			}
			cookie5.setItemMeta(cm5);
			

			ItemStack cookie51 = new ItemStack(Material.ENCHANTMENT_TABLE);
			ItemMeta cm51 = cookie51.getItemMeta();
			cm51.setDisplayName("§5§kA §b§lSchuhe Zusammenstellen §5§kA");
			if(!p.hasPermission("claymc.legend")){
				cm51.addEnchant(Enchantment.DURABILITY, 1, true);
			}
			cookie51.setItemMeta(cm51);
			
			ItemStack PremiumGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
			ItemMeta pg = PremiumGlass.getItemMeta();
			if(p.hasPermission("claymc.gold")){
				pg.setDisplayName("§6Wähl mich aus!");
			}else{
				pg.setDisplayName("§cAb dem §6Gold §cRang!");
			}
			PremiumGlass.setItemMeta(pg);
			
			ItemStack PremiumGlass2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 9);
			ItemMeta pg2 = PremiumGlass2.getItemMeta();
			if(p.hasPermission("claymc.hero")){
				pg2.setDisplayName("§3Wähl mich aus!");
			}else{
				pg2.setDisplayName("§cAb dem §3Hero §cRang!");
			}
			PremiumGlass2.setItemMeta(pg2);
			
			ItemStack PremiumGlass3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
			ItemMeta pg3 = PremiumGlass3.getItemMeta();
			if(p.hasPermission("claymc.ultra")){
				pg3.setDisplayName("§bWähl mich aus!");
			}else{
				pg3.setDisplayName("§cAb dem §bUltra §cRang!");
			}
			PremiumGlass3.setItemMeta(pg3);
			
			ItemStack PremiumGlass4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 2);
			ItemMeta pg4 = PremiumGlass4.getItemMeta();
			if(p.hasPermission("claymc.legend")){
				pg4.setDisplayName("§5Wähl mich aus!");
			}else{
				pg4.setDisplayName("§cAb dem §5Legend §cRang!");
			}
			PremiumGlass4.setItemMeta(pg4);
			
			
			for(int i = 0 ; i < 10 ; i++){
				inv.setItem(i, grass);
			}
			
			inv.setItem(10, cookie);
			inv.setItem(11, cookie1);
			inv.setItem(12, cookie2);
			inv.setItem(13, cookie3);
			inv.setItem(14, cookie4);
			inv.setItem(15, cookie5);
			inv.setItem(16, cookie51);
			inv.setItem(17, grass);
			inv.setItem(18, grass);
			inv.setItem(19, PremiumGlass);
			inv.setItem(20, PremiumGlass);
			inv.setItem(21, PremiumGlass2);
			inv.setItem(22, PremiumGlass3);
			inv.setItem(23, PremiumGlass3);
			inv.setItem(24, PremiumGlass4);
			inv.setItem(25, PremiumGlass4);
			
			for(int i = 26 ; i < 35 ; i++){
				inv.setItem(i, grass);
			}
			
			ItemStack ba = new ItemStack(Material.BARRIER);
			ItemMeta b = ba.getItemMeta();
			b.setDisplayName("§cSchuhe Deaktivieren");
			ba.setItemMeta(b);
			
			inv.setItem(35, ba);
			p.openInventory(inv);

		
			
			}	
		
		
	}catch(Exception e1){}
	}

	@EventHandler
	public void onClick(InventoryClickEvent e){
		try{
			Player p = (Player)e.getWhoClicked();
			if(e.getInventory().getName().equalsIgnoreCase("§6Schuhe")){
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
			if(e.getCurrentItem().getType() == Material.COOKIE){
			if(p.hasPermission("claymc.gold")){
				Utils.setCookies(p);
			}else{
				p.sendMessage(Main.Gold);
			}
			}
			if(e.getCurrentItem().getType() == Material.GOLD_INGOT){
				if(p.hasPermission("claymc.gold")){
					Utils.setGold(p);
				}else{
					p.sendMessage(Main.Gold);
				}
			}
				if(e.getCurrentItem().getType() == Material.IRON_INGOT){
					if(p.hasPermission("claymc.hero")){
						Utils.setIron(p);
					}else{
						p.sendMessage(Main.Hero);
					}
				}
				if(e.getCurrentItem().getType() == Material.PRISMARINE_SHARD){
					if(p.hasPermission("claymc.ultra")){
						Utils.setScherben(p);
					}else{
						p.sendMessage(Main.Ultra);
					}
				}
				if(e.getCurrentItem().getType() == Material.EMERALD){
					if(p.hasPermission("claymc.ultra")){
						Utils.setSmaragt(p);
					}else{
						p.sendMessage(Main.Ultra);
					}
				}
				if(e.getCurrentItem().getType() == Material.DIAMOND){
					if(p.hasPermission("claymc.legend")){
						Utils.setDiamant(p);
					}else{
						p.sendMessage(Main.Legend);
					}
				}
				if(e.getCurrentItem().getType() == Material.ENCHANTMENT_TABLE){
					if(p.hasPermission("claymc.legend")){
						p.closeInventory();
						p.sendMessage(Main.Prefix + "§cDerzeit ist diese Funktion noch nicht verfügbar!");
					}else{
						p.sendMessage(Main.Legend);
					}
				
			
			}
				if(e.getCurrentItem().getType() == Material.BARRIER){
					if(p.hasPermission("claymc.gold")){
						Utils.removeFromAll(p);
						p.sendMessage(Main.Prefix + "§2Du hast alle Schuhe von dir entfernt!");
					}else{
						p.sendMessage(Main.Prefix + "§cDu darfst diese Funktion nicht nutzen!");
					}
				}
			}
		}catch(Exception e1){}
	}
}

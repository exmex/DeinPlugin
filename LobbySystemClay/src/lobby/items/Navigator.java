package lobby.items;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import lobby.data.Data;
import lobby.methods.ItemCreator;
import lobby.methods.Sounds;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class Navigator implements Listener{
	public Navigator(lobby.main.Main Main){
		this.pl = Main;
	}
	private lobby.main.Main pl;
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			Player p = e.getPlayer();
			if(e.getItem().getType() == Material.COMPASS){
				if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
					Sounds.playOpenInventorySound(p);
					Inventory inv = Bukkit.createInventory(null, 54, "§bNavigator");
					ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
					ItemMeta im = i.getItemMeta();
					im.setDisplayName(" ");
					i.setItemMeta(im);
					inv.setItem(0, ItemCreator.CreateItemwhitTwoLore(Material.MUSHROOM_SOUP, 0, Data.KitBattle, "§7➥ §bKitBattle", "§8» §eSpiele §bKitBattle", "§8● §7Versuche dich mit Kits zu verteidigen", "§8● §7und andere Spieler zu vernichten"));
					inv.setItem(0, ItemCreator.CreateItemwhitTwoLore(Material.WOOD_SWORD, 0, Data.KnockPVP, "§7➥ §eKnockPvP", "§8» §eSpiele §eKnockPvP", "§8● §7Eine KnockIT abwechslung mit FFA Kits", "§8● §7Jede 2 Minuten ändert sich das Kit und die Map"));
					inv.setItem(0, ItemCreator.CreateItemwhitOneLore(Material.FIREWORK_CHARGE, 0, Data.Lobby01 + Data.Lobby02, "§7➥ §7Spawn", "§8» §eGelange zum §aSpawn", "§8● §7Teleportiere dich zum §8Spawn"));
					ItemStack skull = new ItemStack(397, Data.Community, (short) 3);
					ItemMeta sm = skull.getItemMeta();
					sm.setDisplayName("§7➤ §6Community");
					skull.setItemMeta(sm);
					SkullMeta meta = (SkullMeta) skull.getItemMeta();
					meta.setOwner(p.getName());
					ArrayList<String> list = new ArrayList<>();
					list.add("§7Schaue dir die §6Community §7an");
					meta.setLore(list);
					skull.setItemMeta(meta);
					
					inv.setItem(0, i);
					inv.setItem(1, i);
					inv.setItem(2, i);
					inv.setItem(3, i);
					inv.setItem(4, i);
					inv.setItem(5, i);
					inv.setItem(6, i);
					inv.setItem(7, i);
					inv.setItem(8, i);
					inv.setItem(9, i);
					inv.setItem(10, i);
					inv.setItem(11, ItemCreator.CreateItemwhitTwoLore(Material.CHEST, 0, Data.TTT, "§7➢ §bTTT", "§8» §eSpiele §bTTT", "§8● §7Suche Truhen, Rüste dich aus", "§8● §7und Elimimiere die Traitor"));
					inv.setItem(12, i);
					inv.setItem(13, skull);
					inv.setItem(14, i);
					inv.setItem(15, ItemCreator.CreateItemwhitTwoLore(Material.NETHER_STAR, 0, Data.KnockTime, "§7➢ §e§lKnockTime", "§8» §eSpiele §bKnockTime", "§8● §7Kämpfe auf einer BedWars Style Map", "§8● §7und töte die Gegner"));
					inv.setItem(16, i);
					inv.setItem(17, i);
					inv.setItem(18, i);
					inv.setItem(19, ItemCreator.CreateItemwhitTwoLore(Material.DIAMOND_SWORD, 0, Data.SkyWars, "§7➢ §3SkyWars", "§8» §eSpiele §3SkyWars", "§8● §7Starte auf deiner eigenen Insel und", "§8● §7versuche der letzte Überlebende zu sein"));
					inv.setItem(20, i);
					inv.setItem(21, i);
					inv.setItem(22, i);
					inv.setItem(23, i);
					inv.setItem(24, i);
					inv.setItem(25, ItemCreator.CreateItemwhitTwoLore(Material.STICK, 0, Data.KnockbackFFA, "§7➢ §bKnockbackFFA", "§8» §eSpiele §bKnockbackFFA", "§8● §7Versuche mit verschiedenen Kits", "§8● §7die Gegner zu besiegen!"));
					inv.setItem(26, i);
					inv.setItem(27, i);
					inv.setItem(28, ItemCreator.CreateItemwhitTwoLore(Material.FISHING_ROD, 0, Data.FFA, "§7➢ §9FFA", "§8» §eSpiele §3FFA", "§8● §7Spiele FFA in einer von uns", "§8● §7abgewandelten Version"));
					inv.setItem(29, i);
					inv.setItem(30, i);
					inv.setItem(31, ItemCreator.CreateItemwhitOneLore(Material.FIREWORK_CHARGE, 0, Data.Lobby01 + Data.Lobby02 + Data.Lobby03, "§7➢ §7Spawn", "§8» §eGelange zum §aSpawn", "§8● §7Teleportiere dich zum §8Spawn"));
					inv.setItem(32, i);
					inv.setItem(33, i);
					inv.setItem(34, ItemCreator.CreateItemwhitTwoLore(Material.MUSHROOM_SOUP, 0, Data.KitBattle, "§7➢ §bKitBattle", "§8» §eSpiele §bKitBattle", "§8● §7Versuche dich mit Kits zu verteidigen", "§8● §7und andere Spieler zu vernichten"));
					inv.setItem(35, i);
					inv.setItem(36, i);
					inv.setItem(37, i);
					inv.setItem(38, ItemCreator.CreateItemwhitTwoLore(Material.GOLD_BLOCK, 7, Data.DeathTime, "§7➥ §aDeathTime", "§8» §eSpiele §aDeathTime", "§8● §7Kämpfe 180 Sekunden gegen Gegner und sammle Level,", "§8● §7um dich für den Endkampf vorzubereiten!"));
					inv.setItem(39, i);
					inv.setItem(40, i);
					inv.setItem(41, i);
					inv.setItem(42, ItemCreator.CreateItemwhitTwoLore(Material.WOOD_SWORD, 0, Data.KnockPVP, "§7➢ §eKnockPvP", "§8» §eSpiele §eKnockPvP", "§8● §7Eine KnockIT abwechslung mit FFA Kits", "§8● §7Jede 2 Minuten ändert sich das Kit und die Map"));
					inv.setItem(43, i);
					inv.setItem(44, i);
					inv.setItem(45, i);
					inv.setItem(46, i);
					inv.setItem(47, i);
					inv.setItem(48, i);
					inv.setItem(49, ItemCreator.CreateItemwhitTwoLore(Material.DOUBLE_PLANT, 0, 1, "§7➢ §6§lCoins-Shop", "§8» §eKaufe im §6Coins-Shop §eein", "§8● §7Kaufe dir für Clays viele Coole", "§8● §7Gadgets und andere Sachen"));
					inv.setItem(50, i);
					inv.setItem(51, i);
					inv.setItem(52, i);
					inv.setItem(53, i);

					p.openInventory(inv);

				}
			}
		}catch(Exception e1){}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§bNavigator")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(1.4D).setY(1.0D);
			      p.setVelocity(v);
			      p.sendTitle("§7» §6Spielmodus", "");
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						 p.teleport(Data.skywars);
					      Sounds.playTeleportSound(p);
					      World w = p.getWorld();
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_BREAK, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_SWIRL, 10);
					      w.playEffect(p.getLocation(), Effect.PORTAL, 10);
					      w.playEffect(p.getLocation(), Effect.SPLASH, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.EXPLOSION, 10);
					      w.playEffect(p.getLocation(), Effect.SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      sendTitle(p, "§8» §aSkyWars");
					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.WOOD_SWORD){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				p.setHealth(1);
				 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(1.4D).setY(1.0D);
			      p.setVelocity(v);
			      p.sendTitle("§7» §6Spielmodus", "");
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						 p.teleport(Data.knockpvp);
					      Sounds.playTeleportSound(p);
					      World w = p.getWorld();
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);

					      w.playEffect(p.getLocation(), Effect.POTION_BREAK, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_SWIRL, 10);
					      w.playEffect(p.getLocation(), Effect.PORTAL, 10);
					      w.playEffect(p.getLocation(), Effect.SPLASH, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.EXPLOSION, 10);
					      w.playEffect(p.getLocation(), Effect.SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 20));

					      sendTitle(p, "§8» §aKnockPvP");
					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.CHEST){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(1.4D).setY(1.0D);
			      p.setVelocity(v);
			      p.sendTitle("§7» §6Spielmodus", "");
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						 p.teleport(Data.jumpwars);
					      Sounds.playTeleportSound(p);
					      World w = p.getWorld();
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);

					      w.playEffect(p.getLocation(), Effect.POTION_BREAK, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_SWIRL, 10);
					      w.playEffect(p.getLocation(), Effect.PORTAL, 10);
					      w.playEffect(p.getLocation(), Effect.SPLASH, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.EXPLOSION, 10);
					      w.playEffect(p.getLocation(), Effect.SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);

					      sendTitle(p, "§8» §aTTT");
					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.MUSHROOM_SOUP){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				p.setHealth(1);
				 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(1.4D).setY(1.0D);
			      p.setVelocity(v);
			      p.sendTitle("§7» §6Spielmodus", "");
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						 p.teleport(Data.kitbattle);
					      Sounds.playTeleportSound(p);
					      World w = p.getWorld();
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_BREAK, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_SWIRL, 10);
					      w.playEffect(p.getLocation(), Effect.PORTAL, 10);
					      w.playEffect(p.getLocation(), Effect.SPLASH, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.EXPLOSION, 10);
					      w.playEffect(p.getLocation(), Effect.SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 20));
					      sendTitle(p, "§8» §aKitBattle");
					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.GOLD_BLOCK){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				p.setHealth(1);
				 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(1.4D).setY(1.0D);
			      p.setVelocity(v);
			      p.sendTitle("§7» §6Spielmodus", "");
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						 p.teleport(Data.claywars);
					      Sounds.playTeleportSound(p);
					      World w = p.getWorld();
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);

					      w.playEffect(p.getLocation(), Effect.POTION_BREAK, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_SWIRL, 10);
					      w.playEffect(p.getLocation(), Effect.PORTAL, 10);
					      w.playEffect(p.getLocation(), Effect.SPLASH, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.EXPLOSION, 10);
					      w.playEffect(p.getLocation(), Effect.SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 20));

					      sendTitle(p, "§8» §aDeathTime");
					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.STICK){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(1.4D).setY(1.0D);
			      p.setVelocity(v);
			      p.setHealth(1);
			      p.sendTitle("§7» §6Spielmodus", "");
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						 p.teleport(Data.knockbackffa);
					      Sounds.playTeleportSound(p);
					      World w = p.getWorld();
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);

					      w.playEffect(p.getLocation(), Effect.POTION_BREAK, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_SWIRL, 10);
					      w.playEffect(p.getLocation(), Effect.PORTAL, 10);
					      w.playEffect(p.getLocation(), Effect.SPLASH, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.EXPLOSION, 10);
					      w.playEffect(p.getLocation(), Effect.SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 20));

					      sendTitle(p, "§8» §aKnockbackFFA");
					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.FIREWORK_CHARGE){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(1.4D).setY(1.0D);
			      p.setVelocity(v);
			      p.setHealth(1);
			      p.sendTitle("§7» §6Teleportpunkt", "");
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						 p.teleport(Data.spawn);
					      Sounds.playTeleportSound(p);
					      World w = p.getWorld();
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 20));

					      w.playEffect(p.getLocation(), Effect.POTION_BREAK, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_SWIRL, 10);
					      w.playEffect(p.getLocation(), Effect.PORTAL, 10);
					      w.playEffect(p.getLocation(), Effect.SPLASH, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.EXPLOSION, 10);
					      w.playEffect(p.getLocation(), Effect.SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);

					      sendTitle(p, "§8» §aSpawn");
					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.SKULL_ITEM){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				p.setHealth(1);
				 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(1.4D).setY(1.0D);
			      p.setVelocity(v);
			      p.sendTitle("§7» §6Teleportpunkt", "");
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						 p.teleport(Data.community);
					      Sounds.playTeleportSound(p);
					      World w = p.getWorld();
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_BREAK, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_SWIRL, 10);
					      w.playEffect(p.getLocation(), Effect.PORTAL, 10);
					      w.playEffect(p.getLocation(), Effect.SPLASH, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.EXPLOSION, 10);
					      w.playEffect(p.getLocation(), Effect.SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      sendTitle(p, "§8» §aCommunity");
					      p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 20));

					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.FISHING_ROD){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(1.4D).setY(1.0D);
			      p.setVelocity(v);
			      p.sendTitle("§7» §6Spielmodus", "");
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						 p.teleport(Data.ffa);
					      Sounds.playTeleportSound(p);
					      World w = p.getWorld();
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_BREAK, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_SWIRL, 10);
					      w.playEffect(p.getLocation(), Effect.PORTAL, 10);
					      w.playEffect(p.getLocation(), Effect.SPLASH, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.EXPLOSION, 10);
					      w.playEffect(p.getLocation(), Effect.SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      sendTitle(p, "§8» §aFFA");
					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.GRASS){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(1.4D).setY(1.0D);
			      p.setVelocity(v);
			      p.setHealth(1);
			      p.sendTitle("§7» §6Spielmodus", "");
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						 p.teleport(Data.freebuild);
					      Sounds.playTeleportSound(p);
					      World w = p.getWorld();
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_BREAK, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_SWIRL, 10);
					      w.playEffect(p.getLocation(), Effect.PORTAL, 10);
					      w.playEffect(p.getLocation(), Effect.SPLASH, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.EXPLOSION, 10);
					      w.playEffect(p.getLocation(), Effect.SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      sendTitle(p, "§8» §aFreebuild");
					      p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 20));

					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.DOUBLE_PLANT){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(1.4D).setY(1.0D);
			      p.setVelocity(v);
			      p.setHealth(1);
			      p.sendTitle("§7» §6ClayMC", "");
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						 p.teleport(Data.coinsshop);
					      Sounds.playTeleportSound(p);
					      World w = p.getWorld();
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_BREAK, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_SWIRL, 10);
					      w.playEffect(p.getLocation(), Effect.PORTAL, 10);
					      w.playEffect(p.getLocation(), Effect.SPLASH, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.EXPLOSION, 10);
					      w.playEffect(p.getLocation(), Effect.SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      sendTitle(p, "§8» §aCoins-Shop");
					      p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 20));

					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.NETHER_STAR){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(1.4D).setY(1.0D);
			      p.setVelocity(v);
			      p.setHealth(1);
			      p.sendTitle("§7» §6ClayMC", "");
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						 p.teleport(Data.knocktime);
					      Sounds.playTeleportSound(p);
					      World w = p.getWorld();
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_BREAK, 10);
					      w.playEffect(p.getLocation(), Effect.POTION_SWIRL, 10);
					      w.playEffect(p.getLocation(), Effect.PORTAL, 10);
					      w.playEffect(p.getLocation(), Effect.SPLASH, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.CLOUD, 10);
					      w.playEffect(p.getLocation(), Effect.EXPLOSION, 10);
					      w.playEffect(p.getLocation(), Effect.SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 10);
					      w.playEffect(p.getLocation(), Effect.WITCH_MAGIC, 10);
					      sendTitle(p, "§8» §e§lKnockTime");
					      p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 20));

					}
				},14L);
			}
		}
	}
	@EventHandler(ignoreCancelled = true)
	public void onCl(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(p.getGameMode() == GameMode.CREATIVE){
			e.setCancelled(false);
		}
	}
	@EventHandler(ignoreCancelled = true)
	public void onCla(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(p.getGameMode() == GameMode.CREATIVE){
			e.setCancelled(false);
		}
	}
	public void sendTitle(Player p, String Nachricht){
		IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + Nachricht + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");
		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
		PacketPlayOutTitle length = new PacketPlayOutTitle(1, 13, 1);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);
	}
}

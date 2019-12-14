package de.leitung.lobby.classes;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class ItemFunctions implements Listener{
	public static int state;
	public static int cd;
	public ItemFunctions(de.leitung.lobby.classes.Main Main){
		this.pl = Main;
	}
	private de.leitung.lobby.classes.Main pl;
	@EventHandler
	public void onInt(PlayerInteractEvent e){
		try{
			Player p = e.getPlayer();
			if(e.getItem().getType() == Material.COMPASS){
				if(Main.effect.isEmpty()){
					Main.effect.add(p);
					state = 0;
					Bukkit.getScheduler().cancelTask(cd);
				Inventory inv = Bukkit.createInventory(null, 36, "§3§nNavigator");
				ItemStack n = new ItemStack(Material.FIREBALL, Main.Lobby1 + Main.Lobby2);
				ItemMeta nm = n.getItemMeta();
				nm.setDisplayName("§dSpawn");
				n.setItemMeta(nm);
				
				ItemStack n1 = new ItemStack(Material.STICK, Main.knockbackffa);
				ItemMeta nm1 = n1.getItemMeta();
				nm1.setDisplayName("§bKnockbackFFA");
				n1.setItemMeta(nm1);
				
				ItemStack n13 = new ItemStack(Material.BOW, Main.BashIT);
				ItemMeta nm13 = n13.getItemMeta();
				nm13.setDisplayName("§3BashIT");
				n13.setItemMeta(nm13);
				
				ItemStack n12 = new ItemStack(Material.DIAMOND_SWORD, Main.kitbattle);
				ItemMeta nm12 = n12.getItemMeta();
				nm12.setDisplayName("§6KitBattle");
				n12.setItemMeta(nm12);
				
				ItemStack n122 = new ItemStack(Material.DIAMOND_SWORD, Main.SkyWars1vs1);
				ItemMeta nm122 = n122.getItemMeta();
				nm122.setDisplayName("§6SkyWars1vs1");
				nm122.addEnchant(Enchantment.DURABILITY, 1, true);
				ArrayList<String> list = new ArrayList<String>();
				list.add("§8§m-------------");
				list.add("§6Programmiert von: §3Splexter");
				list.add("§8§m-------------");
				nm122.setLore(list);
				n122.setItemMeta(nm122);
								
				ItemStack n123 = new ItemStack(Material.IRON_SWORD, Main.SkyWars);
				ItemMeta nm123 = n123.getItemMeta();
				nm123.setDisplayName("§cSkyWars");
				n123.setItemMeta(nm123);
			
				ItemStack n1231 = new ItemStack(Material.BED, Main.ClayWars);
				ItemMeta nm1231 = n1231.getItemMeta();
				nm1231.setDisplayName("§9ClayWars");
				n1231.setItemMeta(nm1231);
				
				ItemStack n12315 = new ItemStack(Material.MUSHROOM_SOUP, Main.SoupPvP);
				ItemMeta nm12315 = n12315.getItemMeta();
				nm12315.setDisplayName("§6SoupPvP §8» §7[§4OFFLINE §7- §cUPDATE§7]");
				n12315.setItemMeta(nm12315);
				
				ItemStack n1231a = new ItemStack(Material.GOLD_INGOT, 0);
				ItemMeta nm1231a = n1231a.getItemMeta();
				nm1231a.setDisplayName("§eGadgets §8[Folgt]");
				n1231a.setItemMeta(nm1231a);
				
				ItemStack a = new ItemStack(Material.WOOD_SWORD, Main.KnockPvP);
				ItemMeta aa = a.getItemMeta();
				aa.setDisplayName("§eKnockPvP");
				a.setItemMeta(aa);
				
				ItemStack skull = new ItemStack(397, Main.Community, (short) 3);
				ItemMeta sm = skull.getItemMeta();
				sm.setDisplayName("§6§lCOMMUNITY");
				skull.setItemMeta(sm);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("EJDAR");
				skull.setItemMeta(meta);
				
				ItemStack ia = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)7);
				ItemMeta im = ia.getItemMeta();
				im.setDisplayName(" ");
				ia.setItemMeta(im);
				p.openInventory(inv);
				
				
				
				
				cd = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable() {
					
					@Override
					public void run() {
						state++;
						p.playSound(p.getLocation(), Sound.NOTE_STICKS, 1, 1);
						if(state == 1){
							inv.setItem(0, ia);
							inv.setItem(1, ia);
							inv.setItem(2, ia);
							inv.setItem(3, ia);
							inv.setItem(4, ia);
							inv.setItem(5, ia);
							inv.setItem(6, ia);
							inv.setItem(7, ia);
							inv.setItem(8, ia);
							inv.setItem(9, ia);
							inv.setItem(10, ia);
							inv.setItem(11, ia);
							inv.setItem(12, ia);
							inv.setItem(13, ia);
							inv.setItem(14, ia);
							inv.setItem(15, ia);
							inv.setItem(16, ia);
							inv.setItem(17, ia);
							inv.setItem(18, ia);
							inv.setItem(19, ia);
							inv.setItem(20, ia);
							inv.setItem(21, ia);
							inv.setItem(22, ia);
							inv.setItem(23, ia);
							inv.setItem(24, ia);
							inv.setItem(25, ia);
							inv.setItem(26, ia);
							inv.setItem(27, ia);
							inv.setItem(28, ia);
							inv.setItem(29, ia);
							inv.setItem(30, ia);
							inv.setItem(31, ia);
							inv.setItem(32, ia);
							inv.setItem(33, ia);
							inv.setItem(34, ia);
							inv.setItem(35, ia);
							inv.setItem(18, n1);
							return;
						}
						if(state == 2){
							inv.setItem(18, ia);
							inv.setItem(19, n1);
							inv.setItem(9, n1231);
							return;
						}
						if(state == 3){
							inv.setItem(19, ia);
							inv.setItem(9, ia);
							inv.setItem(20, n1);
							inv.setItem(10, n1231);
							inv.setItem(9, n123);
							inv.setItem(0, n12315);
							inv.setItem(18, n);
							inv.setItem(27, skull);
							return;
						}
						if(state == 4){
							inv.setItem(20, ia);
							inv.setItem(10, ia);
							inv.setItem(9, ia);
							inv.setItem(18, ia);
							inv.setItem(27, ia);
							inv.setItem(0, ia);
							inv.setItem(1, n12315);
							inv.setItem(21, n1);
							inv.setItem(11, n1231);
							inv.setItem(10, n123);
							inv.setItem(19, n);
							inv.setItem(28, skull);
							inv.setItem(9, a);
							return;
						}
						if(state == 5){
							inv.setItem(21, ia);
							inv.setItem(11, ia);
							inv.setItem(10, ia);
							inv.setItem(19, ia);
							inv.setItem(28, ia);
							inv.setItem(9, ia);
							inv.setItem(1, ia);
							inv.setItem(2, n12315);
							inv.setItem(22, n1);
							inv.setItem(12, n1231);
							inv.setItem(11, n123);
							inv.setItem(20, n);
							inv.setItem(29, skull);
							inv.setItem(10, a);
							inv.setItem(18, n12);
							return;
							
						}
						if(state == 6){
							inv.setItem(22, ia);
							inv.setItem(12, ia);
							inv.setItem(11, ia);
							inv.setItem(20, ia);
							inv.setItem(29, ia);
							inv.setItem(10, ia);
							inv.setItem(18, ia);
							inv.setItem(2, ia);
							inv.setItem(3, n12315);
							inv.setItem(23, n1);
							inv.setItem(13, n1231);
							inv.setItem(12, n123);
							inv.setItem(21, n);
							inv.setItem(30, skull);
							inv.setItem(11, a);
							inv.setItem(19, n12);
							return;
							
						}
						if(state == 7){
							inv.setItem(23, ia);
							inv.setItem(13, ia);
							inv.setItem(12, ia);
							inv.setItem(21, ia);
							inv.setItem(30, ia);
							inv.setItem(11, ia);
							inv.setItem(19, ia);
							inv.setItem(3, ia);
							inv.setItem(4, n12315);
							inv.setItem(24, n1);
							inv.setItem(14, n1231);
							inv.setItem(13, n123);
							inv.setItem(22, n);
							inv.setItem(31, skull);
							inv.setItem(12, a);
							inv.setItem(20, n12);
							Bukkit.getScheduler().cancelTask(cd);
							if(Bukkit.getScheduler().isCurrentlyRunning(cd)){
								Bukkit.getScheduler().cancelTask(cd);
							}
							Main.effect.clear();
							Main.effect.remove(p);
							Main.effect.clear();
							return;
						}
						
					
					
					
						
					}
				}, 1, 1);

			}else{
				p.sendMessage(Main.Prefix + "§cBitte warte einen Augenblick. Zu viele Spieler verwenden dieses Item in diesem Moment!");
			}
			}
			}catch(Exception e1){
				
			}
		
		}
	
				
				
	@EventHandler
	public void onClic(InventoryClickEvent e){
		try{
			Player p = (Player)e.getWhoClicked();

		if(e.getInventory().getName().equalsIgnoreCase("§3§nNavigator")){
			if(e.getCurrentItem().getType() ==Material.DIAMOND_SWORD){
				File file = new File("plugins//Lobby//spawns.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		        String w = cfg.getString("Spawn1.WeltName");
		        double x = cfg.getDouble("Spawn1.X");
		        double y = cfg.getDouble("Spawn1.Y");
		        double z = cfg.getDouble("Spawn1.Z");
		        double yaw = cfg.getDouble("Spawn1.Yaw");
		        double pitch = cfg.getDouble("Spawn1.Pitch");
		        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
		        loc.setYaw((float)yaw);
		        loc.setPitch((float)pitch);
		        p.teleport(loc);
		        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
		        p.closeInventory();
		        sendTitle(p, "§aModus §7» §6KitBattle");
			}
		
		if(e.getCurrentItem().getType() ==Material.STICK){
			File file = new File("plugins//Lobby//spawns.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        String w = cfg.getString("Spawn2.WeltName");
	        double x = cfg.getDouble("Spawn2.X");
	        double y = cfg.getDouble("Spawn2.Y");
	        double z = cfg.getDouble("Spawn2.Z");
	        double yaw = cfg.getDouble("Spawn2.Yaw");
	        double pitch = cfg.getDouble("Spawn2.Pitch");
	        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
	        loc.setYaw((float)yaw);
	        loc.setPitch((float)pitch);
	        p.teleport(loc);
	        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
	        p.closeInventory();
	        sendTitle(p, "§aModus §7» §eKnockbackFFA");

		}
		if(e.getCurrentItem().getType() ==Material.FIREBALL){
			File file = new File("plugins//Lobby//spawns.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        String w = cfg.getString("Spawn.WeltName");
	        double x = cfg.getDouble("Spawn.X");
	        double y = cfg.getDouble("Spawn.Y");
	        double z = cfg.getDouble("Spawn.Z");
	        double yaw = cfg.getDouble("Spawn.Yaw");
	        double pitch = cfg.getDouble("Spawn.Pitch");
	        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
	        loc.setYaw((float)yaw);
	        loc.setPitch((float)pitch);
	        p.teleport(loc);
	        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
	        p.closeInventory();
	        sendTitle(p, "§aWarp §7» §6Spawn");

		}
		if(e.getCurrentItem().getType() ==Material.BOW){
			File file = new File("plugins//Lobby//spawns.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        String w = cfg.getString("Spawn3.WeltName");
	        double x = cfg.getDouble("Spawn3.X");
	        double y = cfg.getDouble("Spawn3.Y");
	        double z = cfg.getDouble("Spawn3.Z");
	        double yaw = cfg.getDouble("Spawn3.Yaw");
	        double pitch = cfg.getDouble("Spawn3.Pitch");
	        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
	        loc.setYaw((float)yaw);
	        loc.setPitch((float)pitch);
	        p.teleport(loc);
	        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
	        p.closeInventory();

		}
		if(e.getCurrentItem().getType() == Material.IRON_SWORD){
			File file = new File("plugins//Lobby//spawns.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        String w = cfg.getString("Spawn4.WeltName");
	        double x = cfg.getDouble("Spawn4.X");
	        double y = cfg.getDouble("Spawn4.Y");
	        double z = cfg.getDouble("Spawn4.Z");
	        double yaw = cfg.getDouble("Spawn4.Yaw");
	        double pitch = cfg.getDouble("Spawn4.Pitch");
	        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
	        loc.setYaw((float)yaw);
	        loc.setPitch((float)pitch);
	        p.teleport(loc);
	        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
	        p.closeInventory();
	        sendTitle(p, "§aModus §7» §cSkyWars");

		}
		if(e.getCurrentItem().getType() == Material.SULPHUR){
			
			File file = new File("plugins//Lobby//spawns.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        String w = cfg.getString("Spawn5.WeltName");
	        double x = cfg.getDouble("Spawn5.X");
	        double y = cfg.getDouble("Spawn5.Y");
	        double z = cfg.getDouble("Spawn5.Z");
	        double yaw = cfg.getDouble("Spawn5.Yaw");
	        double pitch = cfg.getDouble("Spawn5.Pitch");
	        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
	        loc.setYaw((float)yaw);
	        loc.setPitch((float)pitch);
	        p.teleport(loc);
	        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
	        p.closeInventory();
		
		}
		if(e.getCurrentItem().getType() == Material.SKULL_ITEM){
			File file = new File("plugins//Lobby//spawns.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        String w = cfg.getString("Spawn6.WeltName");
	        double x = cfg.getDouble("Spawn6.X");
	        double y = cfg.getDouble("Spawn6.Y");
	        double z = cfg.getDouble("Spawn6.Z");
	        double yaw = cfg.getDouble("Spawn6.Yaw");
	        double pitch = cfg.getDouble("Spawn6.Pitch");
	        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
	        loc.setYaw((float)yaw);
	        loc.setPitch((float)pitch);
	        p.teleport(loc);
	        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
	        p.closeInventory();
	        sendTitle(p, "§aModus §7» §dCommunity");
		}
		if(e.getCurrentItem().getType() == Material.WOOD_SWORD){
			File file = new File("plugins//Lobby//spawns.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        String w = cfg.getString("Spawn8.WeltName");
	        double x = cfg.getDouble("Spawn8.X");
	        double y = cfg.getDouble("Spawn8.Y");
	        double z = cfg.getDouble("Spawn8.Z");
	        double yaw = cfg.getDouble("Spawn8.Yaw");
	        double pitch = cfg.getDouble("Spawn8.Pitch");
	        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
	        loc.setYaw((float)yaw);
	        loc.setPitch((float)pitch);
	        p.teleport(loc);
	        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
	        p.closeInventory();
	        sendTitle(p, "§aModus §7» §bKnockPvP");

		}
		if(e.getCurrentItem().getType() == Material.BED){
			File file = new File("plugins//Lobby//spawns.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	        String w = cfg.getString("Spawn7.WeltName");
	        double x = cfg.getDouble("Spawn7.X");
	        double y = cfg.getDouble("Spawn7.Y");
	        double z = cfg.getDouble("Spawn7.Z");
	        double yaw = cfg.getDouble("Spawn7.Yaw");
	        double pitch = cfg.getDouble("Spawn7.Pitch");
	        Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
	        loc.setYaw((float)yaw);
	        loc.setPitch((float)pitch);
	        p.teleport(loc);
	        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
	        p.closeInventory();
	        sendTitle(p, "§aModus §7» §9ClayWars");

		}
		if(e.getCurrentItem().getType() == Material.MUSHROOM_SOUP){
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
	        p.closeInventory();
	        sendTitle(p, "§aModus §7» §cWartungsarbeiten");
			return;
			//File file = new File("plugins//Lobby//spawns.yml");
			//YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			//String w = cfg.getString("Spawn9.WeltName");
			//double x = cfg.getDouble("Spawn9.X");
			//double y = cfg.getDouble("Spawn9.Y");
			//double z = cfg.getDouble("Spawn9.Z");
			//double yaw = cfg.getDouble("Spawn9.Yaw");
			//double pitch = cfg.getDouble("Spawn9.Pitch");
			//Location loc = new Location(Bukkit.getWorld((String)w), x, y, z);
			//loc.setYaw((float)yaw);
			//loc.setPitch((float)pitch);
			//p.teleport(loc);
			//p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
			//p.closeInventory();
			//sendTitle(p, "§aModus §7» §cSoupPvP");
		}
		}
	}catch(Exception e1){}
	}
	@EventHandler
	public void on(PlayerTeleportEvent e){
		if(e.getCause().equals(TeleportCause.ENDER_PEARL)){
			ItemStack n1223 = new ItemStack(Material.ENDER_PEARL);
			ItemMeta nm1223 = n1223.getItemMeta();
			nm1223.setDisplayName("§cEnderperle");
			n1223.setItemMeta(nm1223);
			Player p = e.getPlayer();
			p.getInventory().setItem(7, n1223);
		}
	}
	@EventHandler
	public void onClose(InventoryCloseEvent e){
		Player p = (Player) e.getPlayer();
		if(Main.effect.contains(p)){
			Bukkit.getScheduler().cancelTask(cd);
			Main.effect.clear();
			Main.effect.remove(p);
			Main.effect.clear();

		}
	}
	public void sendTitle(Player p, String Nachricht){
		IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + Nachricht + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");
		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
		PacketPlayOutTitle length = new PacketPlayOutTitle(1, 11, 1);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);
	}
	}

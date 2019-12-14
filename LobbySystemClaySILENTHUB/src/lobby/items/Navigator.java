package lobby.items;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
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
					Inventory inv = Bukkit.createInventory(null, 36, "§bNavigator");
					ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
					ItemMeta im = i.getItemMeta();
					im.setDisplayName(" ");
					i.setItemMeta(im);
					
					for(int a = 0 ; a < 9 ; a++){
						inv.setItem(a, i);
					}
					inv.setItem(10, ItemCreator.CreateItemwhitMaterial(Material.DIAMOND_SWORD, 0, Data.KitBattle, "§7➥ §bKitBattle", "§7Spiele §bKitBattle"));
					inv.setItem(11, ItemCreator.CreateItemwhitMaterial(Material.WOOD_SWORD, 0, Data.KnockPVP, "§7➥ §eKnockIT", "§7Spiele §eKnockIT"));
					inv.setItem(12, ItemCreator.CreateItemwhitMaterial(Material.IRON_SWORD, 0, Data.SkyWars, "§7➥ §cSkyWars", "§7Spiele §cSkyWars"));
					inv.setItem(13, i);
					inv.setItem(14, i);
					inv.setItem(15, ItemCreator.CreateItemwhitMaterial(Material.FIREWORK_CHARGE, 0, Data.Lobby01 + Data.Lobby02, "§7➥ §7Spawn", "§7Teleportiere dich zum §8Spawn"));
					
					ItemStack skull = new ItemStack(397, 1, (short) 3);
					ItemMeta sm = skull.getItemMeta();
					sm.setDisplayName("§7➥ §6Community");
					skull.setItemMeta(sm);
					SkullMeta meta = (SkullMeta) skull.getItemMeta();
					meta.setOwner(p.getName());
					ArrayList<String> list = new ArrayList<>();
					list.add("§7Schaue dir die §6Community §7an");
					meta.setLore(list);
					skull.setItemMeta(meta);
					
					inv.setItem(16, skull);
					inv.setItem(17, i);
					inv.setItem(18, i);
					inv.setItem(19, ItemCreator.CreateItemwhitMaterial(Material.MUSHROOM_SOUP, 0, Data.SoupPvP, "§7➥ §5SoupPvP §7[§cWARTUNGEN§7]", "§7Dieser Spielmodus befindet sich in §cWartungen"));
					inv.setItem(20, ItemCreator.CreateItemwhitMaterial(Material.BED, 0, Data.ClayWars, "§7➥ §aClayWars", "§7Spiele §aClayWars"));
					inv.setItem(21, ItemCreator.CreateItemwhitMaterial(Material.STICK, 0, Data.KnockbackFFA, "§7➥ §bKnockbackFFA", "§7Spiele §bKnockbackFFA"));
					inv.setItem(22, i);
					inv.setItem(23, i);
					inv.setItem(24, ItemCreator.CreateItemwhitMaterial(Material.CHEST, 0, 0, "§7➥ §f§lClaySG", "§aQuickSG + Lucky Effects"));
					inv.setItem(25, ItemCreator.CreateItemwhitMaterial(Material.GRASS, 0, 0, "§7➥ §7FREEBUILD", "§cSpielmodus in Arbeit"));
					inv.setItem(26, i);
					inv.setItem(27, i);
					inv.setItem(9, i);

					inv.setItem(28, i);
					inv.setItem(29, i);
					inv.setItem(30, i);
					inv.setItem(31, i);
					inv.setItem(32, i);
					inv.setItem(33, i);
					inv.setItem(34, i);
					inv.setItem(35, i);
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

					      sendTitle(p, "§8» §aKitBattle");
					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.WOOD_SWORD){
				Sounds.playInventoryClick(p);
				p.closeInventory();
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

					      sendTitle(p, "§8» §aKnockPvP");
					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.IRON_SWORD){
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
			if(e.getCurrentItem().getType() == Material.MUSHROOM_SOUP){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				sendTitle(p, "§c» §c§lWartungsarbeiten");
			}
			if(e.getCurrentItem().getType() == Material.BED){
				Sounds.playInventoryClick(p);
				p.closeInventory();
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

					      sendTitle(p, "§8» §aClayWars");
					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.STICK){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(1.4D).setY(1.0D);
			      p.setVelocity(v);
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

					      sendTitle(p, "§8» §aKnockbackFFA");
					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.FIREWORK_CHARGE){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				 org.bukkit.util.Vector v = p.getLocation().getDirection().multiply(1.4D).setY(1.0D);
			      p.setVelocity(v);
			      p.sendTitle("§7» §6Teleportpunkt", "");
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						 p.teleport(Data.spawn);
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

					      sendTitle(p, "§8» §aSpawn");
					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.SKULL_ITEM){
				Sounds.playInventoryClick(p);
				p.closeInventory();
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
						 p.teleport(Data.claysg);
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
					      sendTitle(p, "§8» §aClaySG");
					}
				},14L);
			}
			if(e.getCurrentItem().getType() == Material.GRASS){
				Sounds.playInventoryClick(p);
				p.closeInventory();
				sendTitle(p, "§c» §c§lIn Entwicklung");
			}
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

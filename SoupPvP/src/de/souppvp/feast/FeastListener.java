package de.souppvp.feast;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.mewin.WGRegionEvents.events.RegionLeaveEvent;

import de.souppvp.data.Data;
import de.souppvp.data.ItemCreator;
import de.souppvp.data.Scoreboard;
import de.souppvp.spawnmanager.SpawnManager;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class FeastListener implements Listener{
	public FeastListener(de.souppvp.main.Main Main){
		this.pl = Main;
	}
	private de.souppvp.main.Main pl;

	public static HashMap<String, Location> loc = new HashMap<>();
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		e.setDeathMessage(null);
		if(Data.FeastJoin.contains(p)){
			loc.put(p.getName(), p.getLocation());
			e.getDrops().clear();
			p.setHealth(20);
			p.getInventory().clear();
			SpawnManager.teleportToSpawn(p, "Feast");
			Data.FeastJoin.add(p);
			sendlongTitle(p, "§eNeues Kit? §7» §a§lSNEAKEN! §d(2 Sekunden)");
			int zahl = (int)((Math.random()) * 10 + 1);
			FeastData.SNEAK.add(p);
			Location l = loc.get(p.getName());
			ItemStack Suppe = new ItemStack(Material.MUSHROOM_SOUP, zahl);
			ItemMeta sm = Suppe.getItemMeta();
			sm.setDisplayName("§3Suppe");
			Suppe.setItemMeta(sm);
			Bukkit.getWorld(l.getWorld().getName()).dropItem(l, Suppe);
			Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
				
				@Override
				public void run() {
					if(!Data.FeastNoKit.contains(p)){
					KitMethods.getLastPlayerKit(p);	
					}else{
						ItemStack i = new ItemStack(Material.CHEST);
						ItemMeta im = i.getItemMeta();
						im.setDisplayName("§eKitauswahl §7» §f§lKLICK");
						i.setItemMeta(im);
						ItemStack a = new ItemStack(Material.BARRIER);
						ItemMeta am = a.getItemMeta();
						am.setDisplayName("§cFeast verlassen...");
						a.setItemMeta(am);
						p.setGameMode(GameMode.ADVENTURE);
						p.getInventory().setItem(0, i);
						p.getInventory().setItem(8, a);
						Scoreboard.setScoreboard(p);
						p.updateInventory();
					}
				}
			},5L);
			Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
				
				@Override
				public void run() {
					FeastData.SNEAK.remove(p);
				}
			},40L);
			if(k != null){
				k.playSound(k.getLocation(), Sound.LEVEL_UP, 10, 10);
				sendTitle(k, "§a+ §6" + zahl + "§e Soup-Drops");
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
	public void sendlongTitle(Player p, String Nachricht){
		IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + Nachricht + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");
		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
		PacketPlayOutTitle length = new PacketPlayOutTitle(3, 26, 3);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);
	}
	@EventHandler
	public void onMove(PlayerToggleSneakEvent e){
		Player p = e.getPlayer();
		if(FeastData.SNEAK.contains(p)){
				Inventory inv = Bukkit.createInventory(null, 18, Data.Prefix);
				inv.setItem(0, ItemCreator.CreateItemwhitMaterial(Material.IRON_CHESTPLATE, 0, 1, 0, "Anfänger", "Kämpfe mit dem Standart", "Kit"));
				inv.setItem(1, ItemCreator.CreateItemwhitMaterial(Material.BOW, 0, 1, 0, "Bogenschütze", "Du magst den Fernkampf?", "Hier ist das Perfekte Kit"));
				inv.setItem(2, ItemCreator.CreateKit(Material.FIREWORK, 0, 2, 2, "§6Gold", "Kangaroo", "Hebe mithilfe deiner Rakete", "komplett ab!", "§c§l✖"));
				inv.setItem(3, ItemCreator.CreateKit(Material.LEATHER, 0, 3, 3, "§6Gold", "Suppenmeister", "Du hast einen Rucksack in dem", "sich unendlich viele Suppen befinden!", "§c§l✖"));
				inv.setItem(4, ItemCreator.CreateKit(Material.DIAMOND_AXE, 0, 3, 3, "§6Gold", "Axt", "Kämpfst du lieber mit einer Axt?", "Das ist das Perfekte Kit für dich!", "§c§l✖"));
				inv.setItem(17, ItemCreator.CreateItemwhitMaterial(Material.BARRIER, 0, 1, "§cVerlassen", null));
				p.playSound(p.getLocation(), Sound.CHEST_OPEN, 10, 10);
				p.openInventory(inv);
				FeastData.SNEAK.remove(p);
		}
	}
}

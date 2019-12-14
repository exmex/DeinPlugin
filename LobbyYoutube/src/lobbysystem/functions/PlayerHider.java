package lobbysystem.functions;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import lobbysystem.data.Data;

public class PlayerHider implements Listener{
	static ArrayList<Player> hidden = new ArrayList<Player>();
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		try{

			if(e.getItem().getType() == Material.BLAZE_ROD){
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§eSpieler Verstecken");
				ItemStack i = new ItemStack(Material.INK_SACK, 1, (short) 10);
				ItemMeta im = i.getItemMeta();
				im.setDisplayName("§aSpieler anzeigen");
				i.setItemMeta(im);
				
				ItemStack a = new ItemStack(Material.INK_SACK, 1, (short)1);
				ItemMeta am = a.getItemMeta();
				am.setDisplayName("§cSpieler verstecken");
				a.setItemMeta(am);
				
				inv.setItem(1, i);
				inv.setItem(3, a);
				p.openInventory(inv);
			}
			
		}catch(Exception e1){}
	}
	@EventHandler
	public void onClic(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§eSpieler Verstecken")){
			e.setCancelled(true);
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSpieler anzeigen")){
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 999999));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 999999));

			Location loc = p.getLocation();
			Location ent = p.getLocation();
			ent.setX(loc.getX() + 2);
			ent.setX(loc.getZ() + 2);
			loc.setY(loc.getY() + 2);
			p.playEffect(ent, Effect.LAVA_POP, 11);
			p.teleport(loc);
			for(Player all : Bukkit.getOnlinePlayers()){
				p.showPlayer(all);
				hidden.remove(p);
			}
			p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
			p.sendMessage(Data.Prefix + "§7Alle Spieler sind nun für dich §asichtbar§7!");
			p.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSpieler verstecken")){
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 999999));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 999999));
			Location loc = p.getLocation();
			Location ent = p.getLocation();
			ent.setX(loc.getX() + 2);
			ent.setX(loc.getZ() + 2);
			loc.setY(loc.getY() + 2);
			p.playEffect(ent, Effect.LAVA_POP, 11);
			p.teleport(loc);
			for(Player all : Bukkit.getOnlinePlayers()){
				hidden.add(p);
				p.hidePlayer(all);
			}
			p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
			p.sendMessage(Data.Prefix + "§7Alle Spieler sind nun für dich §cunsichtbar§7!");
			p.closeInventory();
		}
	}
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		for(Player all : Bukkit.getOnlinePlayers()){
			if(hidden.contains(all)){
				all.hidePlayer(p);
			}
		}
	}
}

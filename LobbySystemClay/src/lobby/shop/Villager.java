package lobby.shop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftVillager;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import lobby.data.Data;
import lobby.listener.PlayerLogin;
import lobby.methods.ItemCreator;

public class Villager implements Listener, CommandExecutor{
	public static HashMap<Player, String> daten = new HashMap<>();
	public static String datum;
	public Villager(lobby.main.Main Main){
		this.pl = Main;
	}
	private lobby.main.Main pl;
	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("setshop")){
			if(s.hasPermission("claymc.admin")){
				Player p = (Player)s;
			   	  org.bukkit.entity.Villager villager = (org.bukkit.entity.Villager)p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
			    	((CraftVillager) villager).getHandle().setProfession(5);
			    	villager.setCustomNameVisible(true);
			    	villager.setCustomName("§e§lLobby-Shop");
			    	villager.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 100000));
			    	p.sendMessage(Data.Prefix + "§eVillager gespawnt!");
			}
			return true;
		}
		if(c.getName().equalsIgnoreCase("setbelohnungen")){
			Player p = (Player)s;
		   	  org.bukkit.entity.Villager villager = (org.bukkit.entity.Villager)p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
		    	((CraftVillager) villager).getHandle().setProfession(5);
		    	villager.setCustomNameVisible(true);
		    	villager.setCustomName("§9§lTägliche Belohnungen");
		    	villager.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 100000));
	}
		return false;
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e){
		if(e.getRightClicked().getType() == EntityType.VILLAGER){
			org.bukkit.entity.Villager villager = (org.bukkit.entity.Villager)e.getRightClicked();
	    	((CraftVillager) villager).getHandle().setProfession(5);
	    	if(villager.getName().equals("§9§lTägliche Belohnungen")){
	    		Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
					final Player p = e.getPlayer();
					@Override
					public void run() {
						 ResultSet rs = lobby.main.MySQL.getResult("SELECT * FROM LobbyBelohnung WHERE UUID = '" + p.getUniqueId().toString() + "';");
				        try {
				        	rs.next();
							datum = rs.getString("LASTDATUM").replace(" ", "");
							daten.put(p, datum.replace(" ", ""));
							p.sendMessage(daten.get(p));
				        }catch(Exception e1){
				        	e1.printStackTrace();
				        }
				        if(daten.get(e.getPlayer()).equals("UNBEKANNT")){
			    	    	Inventory inv = Bukkit.createInventory(null, 9, "§6Tägliche Belohnungen");
			    	    	inv.setItem(4, ItemCreator.CreateItemwhitOneLore(Material.STORAGE_MINECART, 0, 1, "§9Tägliche Belohnung §7» §aVerfügbar", "§7Sammle deine Tägliche Belohung ein", "§7und erhalte so, viele coole Features!"));
			    	    	e.getPlayer().openInventory(inv);
			    		}else{
			    			e.getPlayer().sendMessage(daten.get(e.getPlayer()));
			    		}
					}
				},2L);
	    		
	    	}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§6Tägliche Belohnungen")){
			if(e.getCurrentItem().getType() == Material.STORAGE_MINECART){
				p.sendMessage("§eLAN");
    	    	e.getInventory().setItem(4, ItemCreator.CreateItemwhitOneLore(Material.MINECART, 0, 1, "§9Tägliche Belohnung §7» §cIn 24:00 Stunden", "§7Sammle deine Tägliche Belohung ein", "§7und erhalte so, viele coole Features!"));
    	    	Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						lobby.main.MySQL.update("INSERT INTO LobbyBelohnung (UUID , LASTDATUM) VALUES ('" + p.getUniqueId().toString() + "' , '" + PlayerLogin.getTime() + "');");
					}
				}, 2L);
			}
		}
	}
}

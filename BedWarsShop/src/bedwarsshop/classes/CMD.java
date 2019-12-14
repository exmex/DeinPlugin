package bedwarsshop.classes;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftVillager;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CMD implements Listener{
	
	@EventHandler
	public void on(PlayerCommandPreprocessEvent e){
		if(e.getMessage().equalsIgnoreCase("/setshop")){
			Player p = e.getPlayer();
			if(p.hasPermission("claymc.admin")){
				spawnVillagaer(p.getLocation(), "§6Shop");
				p.sendMessage(Data.Prefix + "§6Du hast einen Villager gespawnt!");
				Methods.adminErfolg(p);
			}else{
				p.sendMessage(Data.Prefix + "§cDas hättest du wohl gern...");
				Methods.fehler(p);
			}
		}
	}
	public void spawnVillagaer(Location loc,String name){
		  Villager villager = (Villager)loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);
		((CraftVillager)villager).getHandle().setProfession(5);
		villager.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 100000));
		villager.setCustomNameVisible(true);
		villager.setCustomName(name);
}
	
}

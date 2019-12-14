package bridgefighter.mobs;

import java.lang.reflect.Field;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftZombie;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import bridgefighter.methods.ItemCreator;


public class Warteschlange implements Listener{
	
	@EventHandler
	public void onPlayer(PlayerCommandPreprocessEvent e){
		if(e.getMessage().equalsIgnoreCase("/setmob")){
			if(e.getPlayer().hasPermission("claymc.admin")){
				Zombie zombie = (Zombie) e.getPlayer().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.ZOMBIE);
				EntityEquipment eq = zombie.getEquipment();
				eq.setHelmet(ItemCreator.createItem(Material.CHAINMAIL_HELMET, 1, 0, "", ""));
				eq.setChestplate(ItemCreator.createItem(Material.CHAINMAIL_CHESTPLATE, 1, 0, "", ""));
				eq.setLeggings(ItemCreator.createItem(Material.CHAINMAIL_LEGGINGS, 1, 0, "", ""));
				eq.setBoots(ItemCreator.createItem(Material.CHAINMAIL_BOOTS, 1, 0, "", ""));
				zombie.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999999, 99999999));
				zombie.setCustomName("§3Warteschlange");
				
			}
		}
	}

}

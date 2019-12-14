package de.jumpit.methods;

import java.io.File;
import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.jumpit.itemfunctions.SaveInventoryContents;
import de.jumpit.itemfunctions.SaveInventoryListener;

public class JoinMethod {

	public static void processJoin(Player p){
	p.getInventory().clear();	
	}
	public static void checkFirstJoin(Player p){
		File file = new File("plugins//JumpIT//register.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(cfg.get(p.getUniqueId() + ".Register") == null){
			cfg.set(p.getUniqueId() + ".Register", true);
			try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Items.setLobbyItems(p);
			TeleportMethod.teleportToSpawn(p);
			p.getInventory().clear();
			p.getInventory().setHelmet(null);
			p.getInventory().setChestplate(null);
			p.getInventory().setLeggings(null);
			p.getInventory().setBoots(null);
			
		}else{
			try {
				SaveInventoryListener.setInventoryInConfig(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Items.setLobbyItems(p);
			TeleportMethod.teleportToSpawn(p);
			return;
		}
		
	}
}

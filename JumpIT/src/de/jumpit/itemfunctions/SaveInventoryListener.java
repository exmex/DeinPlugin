package de.jumpit.itemfunctions;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class SaveInventoryListener implements Listener{
	
	public static void setInventoryInConfig(Player p){
		File file = new File("plugins//JumpIT//inventorycontents.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		Inventory inv = p.getInventory();
		 for (int i = 0; i < inv.getContents().length; i++) {
             if (inv.getContents()[i] != null) {
               cfg.set(p.getUniqueId() + "." + String.valueOf(i), inv.getContents()[i]);
               try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
             }
           }
	}
}

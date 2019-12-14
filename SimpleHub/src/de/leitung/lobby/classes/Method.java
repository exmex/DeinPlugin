package de.leitung.lobby.classes;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import NickAPI.MySQL.NickAPI;
import NickAPI.main.ItemCreator;

public class Method {

	public static void getStart(Player p){
		p.getInventory().clear();
		ItemStack n = new ItemStack(Material.COMPASS);
		ItemMeta nm = n.getItemMeta();
		nm.setDisplayName("§8➤ §3§lNavigator §8[§7Rechtsklick§8]");
		n.setItemMeta(nm);
		
		ItemStack n1 = new ItemStack(Material.NETHER_STAR);
		ItemMeta nm1 = n1.getItemMeta();
		nm1.setDisplayName("§8➤ §e§lLobbywechsler §8[§7Rechtsklick§8]");
		n1.setItemMeta(nm1);
		
		ItemStack n122 = new ItemStack(Material.FEATHER);
		ItemMeta nm122 = n122.getItemMeta();
		nm122.setDisplayName("§8➤ §5§lRang-Verstecken §8[§7Rechtsklick§8]");
		n122.setItemMeta(nm122);
		
		ItemStack n12235 = new ItemStack(Material.SUGAR);
		ItemMeta nm12235 = n12235.getItemMeta();
		nm12235.setDisplayName("§8➤ §9§lFlug-Modus §8[§7Rechtsklick§8]");
		n12235.setItemMeta(nm12235);
		
		ItemStack n1223 = new ItemStack(Material.CHEST);
		ItemMeta nm1223 = n1223.getItemMeta();
		nm1223.setDisplayName("§8➤ §6§lGaderobe §8[§7Rechtsklick§8]");
		n1223.setItemMeta(nm1223);
		
		ItemStack n122431 = new ItemStack(Material.BLAZE_ROD);
		ItemMeta nm122431 = n122431.getItemMeta();
		nm122431.setDisplayName("§8➤ §c§lSpieler-Verstecken §8[§7Rechtsklick§8]");
		n122431.setItemMeta(nm122431);
	
		p.getInventory().setItem(0, n);
		p.getInventory().setItem(1, n122431);
		p.getInventory().setItem(7, n1223);
		p.getInventory().setItem(8, n1);
		
  if(p.hasPermission("claymc.nick")){
			  
			  if(NickAPI.getNick(p.getUniqueId().toString()).intValue() == 100){
				  
				  p.getInventory().setItem(4, ItemCreator.CreateItemwhitMaterial(Material.NAME_TAG, 0, 1, "§5AutoNick §8● §aAktiviert", null));
				  
			  }else if(NickAPI.getNick(p.getUniqueId().toString()).intValue() == 0){
				  
				  p.getInventory().setItem(4, ItemCreator.CreateItemwhitMaterial(Material.NAME_TAG, 0, 1, "§5AutoNick §8● §cDeaktiviert", null));
				  
			  }
			  
		  }
  
	}
}

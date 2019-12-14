package de.spigotplugins.freebuild.methods;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FirstJoin {

	public static void setFirstSpawn(Player p){
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.getInventory().setItem(0, ItemCreator.createItem(Material.IRON_SWORD, 1, 0, "�aAnf�nger-Schwert", "�7� �3Standartschwert"));
		p.getInventory().setItem(1, ItemCreator.createItem(Material.IRON_PICKAXE, 1, 0, "�aAnf�nger-Spitzhacke", "�7� �3Standartspitzhacke"));
		p.getInventory().setItem(2, ItemCreator.createItem(Material.IRON_AXE, 1, 0, "�aAnf�nger-Axt", "�7� �3Standartaxt"));
		p.getInventory().setItem(3, ItemCreator.createItem(Material.IRON_SPADE, 1, 0, "�aAnf�nger-Schaufel", "�3Standartschaufel"));
		p.getInventory().setItem(4, ItemCreator.createItem(Material.LEATHER_HELMET, 1, 0, "�aAnf�nger-Helm", "�3Standarthelm"));
		p.getInventory().setItem(5, ItemCreator.createItem(Material.IRON_CHESTPLATE, 1, 0, "�aAnf�nger-Brustpanzer", "�3Standartbrustpanzer")); 
		p.getInventory().setItem(6, ItemCreator.createItem(Material.LEATHER_LEGGINGS, 1, 0, "�aAnf�nger-Hose", "�3Standarthose"));
		p.getInventory().setItem(7, ItemCreator.createItem(Material.TORCH, 32, 0, "�aAnf�nger-Licht", "�3Perfekt f�r H�hlenerforschungen"));
		p.getInventory().setItem(8, ItemCreator.createItem(Material.COOKED_BEEF, 8, 0, "�aAnf�nger-Essen", "�3Gut f�r schlechte Zeiten"));
	}
}

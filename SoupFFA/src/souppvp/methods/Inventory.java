package souppvp.methods;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Inventory {

	public static void setStandartItems(Player p){
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.getInventory().setItem(0, ItemCreator.CreateItemwhitMaterial(Material.CHEST, 0, 1, "§7» §eKits §7«", "§7Wähle dir deine Kits aus!"));
		p.getInventory().setItem(1, ItemCreator.CreateItemwhitMaterial(Material.GLOWSTONE_DUST, 0, 1, "§7» §aAchievements§7 «",  "§7Schaue dir deine Errungenschaften an!"));
		p.getInventory().setItem(8, ItemCreator.CreateItemwhitMaterial(Material.SLIME_BALL, 0, 1, "§7» §cRunde verlassen§7 «", "§7Verlasse die Runde"));
		p.updateInventory();
		return;
	}
	public static void setLobbyItems(Player p){
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.getInventory().setItem(4, ItemCreator.CreateItemwhitMaterial(Material.COMPASS, 0, 1, "§7» §eMaps §7«", "§7Wähle eine Map aus!"));
		p.updateInventory();
		return;
	}
	
}

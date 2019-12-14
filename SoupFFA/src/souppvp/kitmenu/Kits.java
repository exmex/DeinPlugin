package souppvp.kitmenu;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import souppvp.methods.Scoreboard;

public class Kits {

	
	public static void getStandartKit(Player p){
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		ItemStack i = new ItemStack(Material.IRON_SWORD);
		ItemStack ia = new ItemStack(Material.IRON_HELMET);
		ItemStack ib = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack ic = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack id = new ItemStack(Material.IRON_BOOTS);
		ItemStack Suppe = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta SM = Suppe.getItemMeta();
		SM.setDisplayName("§3Suppe");
		Suppe.setItemMeta(SM);
		
		p.getInventory().setItem(0, i);
		p.getInventory().setHelmet(ia);
		p.getInventory().setChestplate(ib);
		p.getInventory().setLeggings(ic);
		p.getInventory().setBoots(id);
		
		for(int a = 1 ; a < 36 ; a++){
			p.getInventory().setItem(a, Suppe);
		}
		p.updateInventory();

		
	}
	public static void getBogenschütze(Player p){
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		ItemStack i = new ItemStack(Material.IRON_SWORD);
		ItemStack ia = new ItemStack(Material.IRON_HELMET);
		ItemStack ib = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemStack ic = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack id = new ItemStack(Material.IRON_BOOTS);
		ItemStack Suppe = new ItemStack(Material.MUSHROOM_SOUP);
		ItemStack Bogen = new ItemStack(Material.BOW);
		ItemStack Arrow = new ItemStack(Material.ARROW, 64);
		
		ItemMeta SM = Suppe.getItemMeta();
		SM.setDisplayName("§3Suppe");
		Suppe.setItemMeta(SM);
		p.getInventory().setItem(0, i);
		p.getInventory().setItem(1, Bogen);
		p.getInventory().setHelmet(ia);
		p.getInventory().setChestplate(ib);
		p.getInventory().setLeggings(ic);
		p.getInventory().setBoots(id);
		p.getInventory().setItem(35, Arrow);
		for(int a = 2 ; a < 35 ; a++){
			p.getInventory().setItem(a, Suppe);
		}
		p.updateInventory();
		
	}
	
	public static void getRodPvPKit(Player p){
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		ItemStack i = new ItemStack(Material.IRON_SWORD);
		ItemStack ia = new ItemStack(Material.IRON_HELMET);
		ItemStack ib = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack ic = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack id = new ItemStack(Material.IRON_BOOTS);
		ItemStack angel = new ItemStack(Material.FISHING_ROD);
		ItemStack Suppe = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta SM = Suppe.getItemMeta();
		SM.setDisplayName("§3Suppe");
		Suppe.setItemMeta(SM);
		
		p.getInventory().setItem(0, i);
		p.getInventory().setHelmet(ia);
		p.getInventory().setChestplate(ib);
		p.getInventory().setLeggings(ic);
		p.getInventory().setBoots(id);
		p.getInventory().setItem(1, angel);
		for(int a = 2 ; a < 36 ; a++){
			p.getInventory().setItem(a, Suppe);
		}
		p.updateInventory();

		
	}
	public static void getKaktusKit(Player p){
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		ItemStack i = new ItemStack(Material.IRON_SWORD);
		ItemStack ia = new ItemStack(Material.IRON_HELMET);
		ItemStack ib = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta ibm = ib.getItemMeta();
		ibm.addEnchant(Enchantment.THORNS, 2, true);
		ib.setItemMeta(ibm);
		ItemStack ic = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack id = new ItemStack(Material.IRON_BOOTS);
		ItemStack Suppe = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta SM = Suppe.getItemMeta();
		SM.setDisplayName("§3Suppe");
		Suppe.setItemMeta(SM);
		
		p.getInventory().setItem(0, i);
		p.getInventory().setHelmet(ia);
		p.getInventory().setChestplate(ib);
		p.getInventory().setLeggings(ic);
		p.getInventory().setBoots(id);
		for(int a = 1 ; a < 36 ; a++){
			p.getInventory().setItem(a, Suppe);
		}
		p.updateInventory();

		
	}
}

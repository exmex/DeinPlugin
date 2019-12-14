package de.Niclas.EarlyHG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ChestManager implements Listener{
	
	  
	public static HashMap<Location, Inventory> chests = new HashMap();
	    private ArrayList<ItemStack> loot = new ArrayList();

	    @EventHandler
	    public void onChestOpen(PlayerInteractEvent e) {
	        Player player = e.getPlayer();
	        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.CHEST){
	        	e.setCancelled(true);
	            if (!this.chests.containsKey((Object)e.getClickedBlock().getLocation())) {
	                this.registerLoot();
	                Inventory inv = Bukkit.createInventory((InventoryHolder)null, (int)27, (String)"\u00a7eTruhe");
	                int i = 0;
	                while (i < EarlyHG.Main.utils.rndInt(4, 9)) {
	                    inv.setItem(EarlyHG.Main.utils.rndInt(0, inv.getSize() - 1), this.loot.get(EarlyHG.Main.utils.rndInt(0, this.loot.size() - 1)));
	                    ++i;
	                }
	                this.chests.put(e.getClickedBlock().getLocation(), inv);
	            }else{
	            	player.sendMessage(Data.prefix + "�cDiese Truhe wurde bereits genutzt!");
	            }
	            e.getPlayer().openInventory(this.chests.get((Object)e.getClickedBlock().getLocation()));
	        }
	    }

	    public void registerLoot() {
	    	ItemStack regeneration = new ItemStack(Material.POTION, 1, (short)8225);
	    	ItemStack speed = new ItemStack(Material.POTION, 1, (short)8194);
	    	ItemStack direktheilung = new ItemStack(Material.POTION, 1, (short)16421);
	    	ItemStack langsamkeit = new ItemStack(Material.POTION, 1, (short)16426);
	    	ItemStack schwache = new ItemStack(Material.POTION, 1, (short)16424);
	    	ItemStack direktschaden = new ItemStack(Material.POTION, 1, (short)16460);
	    	ItemStack vergif = new ItemStack(Material.POTION, 1, (short)16388);
	        this.loot.clear();
	        this.loot.add(EarlyHG.Main.utils.createItemStack(regeneration));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(regeneration));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(direktheilung));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(direktheilung));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(langsamkeit));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(langsamkeit));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(schwache));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(schwache));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(direktschaden));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(direktschaden));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(vergif));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(vergif));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(regeneration));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(regeneration));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(direktheilung));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(direktheilung));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(langsamkeit));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(langsamkeit));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(schwache));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(schwache));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(direktschaden));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(direktschaden));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(vergif));
	        this.loot.add(EarlyHG.Main.utils.createItemStack(vergif));
	        this.loot.add(EarlyHG.Main.utils.create(Material.WOOD_SWORD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLDEN_APPLE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BOW, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.STONE_SWORD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.FISHING_ROD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.ARROW, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.DIAMOND_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.MELON, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_CHICKEN, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_BEEF, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_SWORD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BOW, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.ARROW, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.MELON, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_CHICKEN, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_BEEF, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_SWORD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.FISHING_ROD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BOW, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.STONE_AXE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_SWORD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.ARROW, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.STONE_SWORD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.MELON, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.DIAMOND_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_CHICKEN, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_BEEF, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_SWORD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BOW, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLDEN_APPLE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.STONE_SWORD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.WEB, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.ARROW, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.MELON, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_CHICKEN, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_BEEF, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BOW, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.STONE_SWORD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.STONE_AXE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.FISHING_ROD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLDEN_APPLE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.STICK, EarlyHG.Main.utils.rndInt(1, 3)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.MELON, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_CHICKEN, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_BEEF, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BOW, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_SWORD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.DIAMOND_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_SWORD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.ARROW, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.MELON, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.STONE_SWORD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.FISHING_ROD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_CHICKEN, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BOW, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_BEEF, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.ARROW, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.STONE_SWORD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.MELON, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BOW, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_CHICKEN, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_BEEF, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_SWORD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.DIAMOND_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.ARROW, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.FISHING_ROD, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_HELMET, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_CHESTPLATE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLDEN_APPLE, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BOW, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.BAKED_POTATO, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.MELON, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.APPLE, EarlyHG.Main.utils.rndInt(1, 4)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.IRON_BOOTS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_CHICKEN, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.CHAINMAIL_LEGGINGS, 1));
	        this.loot.add(EarlyHG.Main.utils.create(Material.COOKED_BEEF, EarlyHG.Main.utils.rndInt(1, 5)));
	        this.loot.add(EarlyHG.Main.utils.create(Material.GOLD_BOOTS, 1));
	        ItemStack i = new ItemStack(Material.GOLDEN_APPLE, 1, (short)1);
	        this.loot.add(EarlyHG.Main.utils.createItemStack(i));

	    }
	    public static void clear(){
	    	chests.clear();
	    }
}

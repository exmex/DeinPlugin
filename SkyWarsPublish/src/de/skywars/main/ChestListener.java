package de.skywars.main;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Score;

import com.mysql.jdbc.Util;

import de.skywars.gamestates.GameState;
import de.skywars.utils.Data;
import de.skywars.utils.Scoreboard;
import de.skywars.utils.Utils;


public class ChestListener implements Listener{
	public static HashMap<Location, Inventory> chests = new HashMap();
	public static HashMap<Player, Integer> openchests = new HashMap<>();
    private ArrayList<ItemStack> loot = new ArrayList();

    @EventHandler
    public void onChestOpen(PlayerInteractEvent e) {
    	try{
    	if(Main.chestuse == true){
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.CHEST || e.getClickedBlock().getType() == Material.TRAPPED_CHEST){
        	e.setCancelled(true);
        	if(!MainListener.players.contains(e.getPlayer())){
        		return;
        	}
        	if (!this.chests.containsKey((Object)e.getClickedBlock().getLocation())) {
                this.registerLoot();
                
                openchests.put(e.getPlayer(), openchests.get(e.getPlayer()) + 1);
                Scoreboard.setScoreboard(e.getPlayer());
                Inventory inv = Bukkit.createInventory((InventoryHolder)null, (int)27, (String)"\u00a7eTruhe");
                int i = 0;
                while (i < Utils.rndInt(15, 22)) {
                    inv.setItem(Utils.rndInt(0, inv.getSize() - 1), this.loot.get(Utils.rndInt(0, this.loot.size() - 1)));
                    ++i;
                }
                this.chests.put(e.getClickedBlock().getLocation(), inv);
            }else{
            	player.sendMessage(Data.Prefix + "§cDiese Truhe wurde bereits genutzt!");
            }
            e.getPlayer().openInventory(this.chests.get((Object)e.getClickedBlock().getLocation()));
        }
    	}else{
    		e.setCancelled(true);
    	}
    }catch(Exception e1){}
    }
    public void registerLoot() {
    	ItemStack regeneration = new ItemStack(Material.POTION, 1, (short)8225);
    	ItemStack speed = new ItemStack(Material.POTION, 1, (short)8194);
    	ItemStack direktheilung = new ItemStack(Material.POTION, 1, (short)16421);
    	ItemStack langsamkeit = new ItemStack(Material.POTION, 1, (short)16426);
    	ItemStack schwache = new ItemStack(Material.POTION, 1, (short)16424);
    	ItemStack direktschaden = new ItemStack(Material.POTION, 1, (short)16460);
    	ItemStack vergif = new ItemStack(Material.POTION, 1, (short)16388);
    	ItemStack eh = new ItemStack(Material.IRON_HELMET);
    	ItemMeta e = eh.getItemMeta();
    	e.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
    	eh.setItemMeta(e);
    	
    	ItemStack eh1 = new ItemStack(Material.IRON_CHESTPLATE);
    	ItemMeta e1 = eh1.getItemMeta();
    	e1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
    	eh1.setItemMeta(e1);
    	
    	ItemStack eh2 = new ItemStack(Material.IRON_LEGGINGS);
    	ItemMeta e2 = eh2.getItemMeta();
    	e2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
    	eh2.setItemMeta(e2);
    	
    	ItemStack eh3 = new ItemStack(Material.IRON_BOOTS);
    	ItemMeta e3 = eh3.getItemMeta();
    	e3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
    	eh3.setItemMeta(e3);
    	
    	ItemStack dh = new ItemStack(Material.CHAINMAIL_HELMET);
    	ItemMeta dm = dh.getItemMeta();
    	dm.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
    	dh.setItemMeta(dm);
    	
    	ItemStack dh1 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
    	ItemMeta dm1 = dh1.getItemMeta();
    	dm1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
    	dh1.setItemMeta(dm1);
    	
    	ItemStack dh2 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
    	ItemMeta dm2 = dh2.getItemMeta();
    	dm2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
    	dh2.setItemMeta(dm2);
    	
    	ItemStack dh3 = new ItemStack(Material.CHAINMAIL_HELMET);
    	ItemMeta dm3 = dh3.getItemMeta();
    	dm3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
    	dh3.setItemMeta(dm3);
    	 
    	ItemStack ws = new ItemStack(Material.WOOD_SWORD);
    	ItemMeta w = ws.getItemMeta();
    	w.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
    	ws.setItemMeta(w);
    
     	ItemStack ws1 = new ItemStack(Material.STONE_SWORD);
    	ItemMeta w1 = ws1.getItemMeta();
    	w1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
    	ws1.setItemMeta(w1);
    	
    	ItemStack ws11 = new ItemStack(Material.IRON_SWORD);
    	ItemMeta w11 = ws1.getItemMeta();
    	w11.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
    	ws11.setItemMeta(w11);
    	this.loot.add(ws11);

    	this.loot.add(ws);
    	this.loot.add(dh);
    	this.loot.add(dh1);
    	this.loot.add(dh2);
    	this.loot.add(dh3);
    	this.loot.add(eh);
    	this.loot.add(eh1);
    	this.loot.add(eh2);
    	this.loot.add(eh3);
    	this.loot.add(dh);
    	this.loot.add(dh1);
    	this.loot.add(dh2);
    	this.loot.add(dh3);
    	this.loot.add(eh);
    	this.loot.add(eh1);
    	this.loot.add(eh2);
    	this.loot.add(eh3);
        this.loot.clear();
        this.loot.add(Utils.createItemStack(regeneration));
        this.loot.add(Utils.createItemStack(direktheilung));
        this.loot.add(Utils.createItemStack(langsamkeit));
        this.loot.add(Utils.createItemStack(schwache));
        this.loot.add(Utils.createItemStack(vergif));
        this.loot.add(Utils.createItemStack(regeneration));
        this.loot.add(Utils.create(Material.WOOD_SWORD, 1));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.IRON_HELMET, 1));
        this.loot.add(Utils.create(Material.IRON_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.GOLDEN_APPLE, 1));
        this.loot.add(Utils.create(Material.BOW, 1));
    	this.loot.add(ws);

        this.loot.add(Utils.create(Material.STONE_SWORD, 1));
        this.loot.add(Utils.create(Material.FISHING_ROD, 1));
        this.loot.add(Utils.create(Material.ARROW, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.DIAMOND_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.DIAMOND, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.DIAMOND, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.IRON_INGOT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.IRON_INGOT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.IRON_INGOT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.GOLD_INGOT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.GOLD_INGOT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.GOLD_INGOT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.GOLD_INGOT, Utils.rndInt(1, 8)));

        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.MELON, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.TNT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.TNT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.TNT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.TNT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.TNT, Utils.rndInt(1, 8)));
    	this.loot.add(ws);

        this.loot.add(Utils.create(Material.FLINT_AND_STEEL, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.TNT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.FLINT_AND_STEEL, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.FLINT_AND_STEEL, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.FLINT_AND_STEEL, Utils.rndInt(1, 1)));

        this.loot.add(Utils.create(Material.IRON_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.IRON_BOOTS, 1));
        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.GOLD_BOOTS, 1));
        this.loot.add(Utils.create(Material.IRON_SWORD, 1));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.IRON_HELMET, 1));
        this.loot.add(Utils.create(Material.GOLD_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.ARROW, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.MELON, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
    	this.loot.add(ws);   
    	this.loot.add(ws1);
    	this.loot.add(ws11);


        this.loot.add(Utils.create(Material.IRON_SWORD, 1));
        this.loot.add(Utils.create(Material.FISHING_ROD, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_HELMET, 1));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.IRON_HELMET, 1));
        this.loot.add(Utils.create(Material.GOLD_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.STONE_AXE, 1));
        this.loot.add(Utils.create(Material.IRON_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.IRON_SWORD, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_BOOTS, 1));
        this.loot.add(Utils.create(Material.ARROW, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.STONE_SWORD, 1));
        this.loot.add(Utils.create(Material.MELON, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.IRON_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.IRON_BOOTS, 1));
        this.loot.add(Utils.create(Material.DIAMOND_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
    	this.loot.add(ws);

        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.GOLD_BOOTS, 1));
        this.loot.add(Utils.create(Material.IRON_SWORD, 1));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.IRON_HELMET, 1));
        this.loot.add(Utils.create(Material.GOLD_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.IRON_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.GOLDEN_APPLE, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_BOOTS, 1));
        this.loot.add(Utils.create(Material.STONE_SWORD, 1));
        this.loot.add(Utils.create(Material.WEB, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.ARROW, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
    	this.loot.add(dh);
    	this.loot.add(dh1);
    	this.loot.add(dh2);
    	this.loot.add(dh3);
    	this.loot.add(eh);
    	this.loot.add(eh1);
    	this.loot.add(eh2);
    	this.loot.add(eh3);
    	this.loot.add(dh);
    	this.loot.add(dh1);
    	this.loot.add(dh2);
    	this.loot.add(dh3);
    	this.loot.add(ws);

    	this.loot.add(eh);
    	this.loot.add(eh1);
    	this.loot.add(eh2);
    	this.loot.add(eh3);
        this.loot.add(Utils.create(Material.MELON, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.GOLD_BOOTS, 1));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_HELMET, 1));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.GOLD_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.STONE_SWORD, 1));
        this.loot.add(Utils.create(Material.STONE_AXE, 1));
        this.loot.add(Utils.create(Material.FISHING_ROD, 1));
        this.loot.add(Utils.create(Material.IRON_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
    	this.loot.add(ws);
    	this.loot.add(ws1);
    	this.loot.add(ws11);

        this.loot.add(Utils.create(Material.GOLDEN_APPLE, 1));
        this.loot.add(Utils.create(Material.STICK, Utils.rndInt(1, 3)));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.MELON, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.IRON_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.GOLD_PICKAXE, 1));
        this.loot.add(Utils.create(Material.GOLD_PICKAXE, 1));
        this.loot.add(Utils.create(Material.GOLD_PICKAXE, 1));
        this.loot.add(Utils.create(Material.IRON_PICKAXE, 1));
        this.loot.add(Utils.create(Material.IRON_PICKAXE, 1));
        this.loot.add(Utils.create(Material.IRON_PICKAXE, 1));
        this.loot.add(Utils.create(Material.DIAMOND_PICKAXE, 1));
        this.loot.add(Utils.create(Material.DIAMOND_PICKAXE, 1));
        this.loot.add(Utils.create(Material.DIAMOND_PICKAXE, 1));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.IRON_BOOTS, 1));
        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.IRON_SWORD, 1));
        this.loot.add(Utils.create(Material.DIAMOND_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_HELMET, 1));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.GOLD_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.IRON_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.IRON_SWORD, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_BOOTS, 1));
        this.loot.add(Utils.create(Material.ARROW, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.MELON, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.STONE_SWORD, 1));
        this.loot.add(Utils.create(Material.IRON_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.IRON_BOOTS, 1));
        this.loot.add(Utils.create(Material.FISHING_ROD, 1));
        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));   
        this.loot.add(ws);
    	this.loot.add(ws11);

        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.GOLD_BOOTS, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_HELMET, 1));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.IRON_HELMET, 1));
        this.loot.add(Utils.create(Material.GOLD_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.IRON_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.ARROW, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
    	this.loot.add(ws);
    	this.loot.add(ws1);

        this.loot.add(Utils.create(Material.STONE_SWORD, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_BOOTS, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.MELON, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.IRON_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.IRON_SWORD, 1));
        this.loot.add(Utils.create(Material.DIAMOND_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.ARROW, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.FISHING_ROD, 1));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.GOLD_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.IRON_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.GOLDEN_APPLE, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_BOOTS, 1));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.MELON, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.IRON_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.APPLE, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.IRON_BOOTS, 1));
        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
    	this.loot.add(ws);

        this.loot.add(Utils.create(Material.GOLD_BOOTS, 1));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WATER_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.WATER_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.LAVA_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.LAVA_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.ENDER_PEARL, Utils.rndInt(1, 2)));
        this.loot.add(Utils.create(Material.WATER_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.WATER_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.LAVA_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.LAVA_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.ENDER_PEARL, Utils.rndInt(1, 2)));
    	this.loot.add(ws1);
    	this.loot.add(ws11);

    }
    public static void clear(){
    	chests.clear();
    }
}

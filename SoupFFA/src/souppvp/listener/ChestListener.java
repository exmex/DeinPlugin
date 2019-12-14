package souppvp.listener;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
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

import souppvp.data.Data;
import souppvp.manager.Utils;
import souppvp.methods.ItemCreator;


public class ChestListener implements Listener{
	public static HashMap<Location, Inventory> chests = new HashMap();
	public static HashMap<Player, Integer> openchests = new HashMap<>();
    private ArrayList<ItemStack> loot = new ArrayList();

	@EventHandler
	public void onClick(PlayerInteractEvent e){
		try{
	        Player player = e.getPlayer();
	        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.CHEST || e.getClickedBlock().getType() == Material.TRAPPED_CHEST){
	        	e.setCancelled(true);
	  
	        	if (!this.chests.containsKey((Object)e.getClickedBlock().getLocation())) {
	                this.registerLoot();
	                Inventory inv = Bukkit.createInventory((InventoryHolder)null, (int)27, (String)"\u00a7eTruhe");
	                int i = 0;
	                while (i < Utils.rndInt(3, 12)) {
	                    inv.setItem(Utils.rndInt(0, inv.getSize() - 1), this.loot.get(Utils.rndInt(0, this.loot.size() - 1)));
	                    ++i;
	                }
	                this.chests.put(e.getClickedBlock().getLocation(), inv);
	                e.getPlayer().openInventory(inv);
	            }else{
	            	player.sendMessage(Data.Prefix + "§cDiese Truhe wurde bereits genutzt!");
	            }
	            e.getPlayer().openInventory(this.chests.get((Object)e.getClickedBlock().getLocation()));
	            return;
	        }
		}catch(Exception e1){}
		}
	
	    
	    public void registerLoot() {
	    	int Suppe = (int)((Math.random()) * 3 + 1);
	    	int GA = (int) ((Math.random()) * 2 + 1);
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, Suppe, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, Suppe, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, Suppe, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, 1, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, Suppe, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, Suppe, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, Suppe, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.MUSHROOM_SOUP, Suppe, 0));
	    	this.loot.add(ItemCreator.CreateForChest(Material.GOLDEN_APPLE, GA, 0));

	    }
}
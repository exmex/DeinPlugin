package de.golgolex.freebuild.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.golgolex.freebuild.methods.Data;
import de.golgolex.freebuild.methods.Stats;

public class LISTENER_PlayerInteractEvent implements Listener{
	
	@EventHandler
    public void onInteract(PlayerInteractEvent e){
    	Player p = e.getPlayer();
    	try{
    	if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
    		if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2§lSpielerklärung")){
    			p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
    			Inventory inv = Bukkit.createInventory(null, 9, "§2Spielerklärung");
    			@SuppressWarnings("deprecation")
				ItemStack a = new ItemStack(137, 1);
    			ItemMeta aa = a.getItemMeta();
    			aa.setDisplayName("§eCommands");
    			a.setItemMeta(aa);
    			
    			ItemStack b = new ItemStack(Material.PAPER);
    			ItemMeta bb = b.getItemMeta();
    			bb.setDisplayName("§aTipps");
    			b.setItemMeta(bb);
    			
    			ItemStack c = new ItemStack(Material.GOLD_NUGGET);
    			ItemMeta cc = c.getItemMeta();
    			cc.setDisplayName("§6Coins");
    			c.setItemMeta(cc);
    			
    			inv.setItem(1, a);
    			inv.setItem(4, b);
    			inv.setItem(7, c);
    			p.openInventory(inv);
    		}
    	}
    }catch(Exception e1){}
    }
	
	
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent ev) {
      if (ev.getAction() == Action.RIGHT_CLICK_BLOCK) {
        Block b = ev.getClickedBlock();
        if ((b.getType() == Material.SIGN_POST) || (b.getType() == Material.WALL_SIGN)) {
          Sign s = (Sign)b.getState();
          Player p = ev.getPlayer();
          if (s.getLine(1).equalsIgnoreCase("§6Coins")){
        	  if(Stats.getMoney(p.getName()) > 4){
        		  Stats.removeCoins(p.getName(), 5);
        		  ItemStack i = new ItemStack(Material.SPONGE);
        		  ItemMeta im = i.getItemMeta();
        		  im.setDisplayName("Coins");
        		  i.setItemMeta(im);
        		  p.getInventory().addItem(i);
        		  p.sendMessage(Data.pr + "§7Du hast dir einen §aShop-Coin §7gekauft!");
        		  p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
        	  }else{
        		  p.sendMessage(Data.pr + "§7Du brauchst mindestens §a5 §7Coins um dir einen ShopKey kaufen zu können!");
        		  p.playSound(p.getLocation(), Sound.NOTE_BASS, 10, 10);

        	  }
          }
}
      }
    }

}

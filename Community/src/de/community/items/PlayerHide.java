package de.community.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.community.utils.Data;

public class PlayerHide implements Listener{
	
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
			Player p = e.getPlayer();
			
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
				if(e.getItem().getType() == Material.BLAZE_ROD){
					Inventory inv = Bukkit.createInventory(null , 9 , "§cSpieler-Verstecken");
					ItemStack g = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)15);
		            ItemMeta gmeta = g.getItemMeta();
		            gmeta.setDisplayName(" ");
		            g.setItemMeta(gmeta);
                    inv.setItem(0 , Items.createItem(Material.getMaterial(351), 10 ,  "§aAlle Spieler anzeigen"));
                    inv.setItem(1 , g);
                    inv.setItem(2 , g);
                    inv.setItem(3 , g);
                    inv.setItem(4 , Items.createItem(Material.getMaterial(351) , 5 , "§5Premium Spieler anzeigen"));
                    inv.setItem(5 , g);
                    inv.setItem(6 , g);
                    inv.setItem(7 , g);
                    inv.setItem(8 , Items.createItem(Material.getMaterial(351) , 1 , "§cAlle Spieler unsichtbar"));
                    p.openInventory(inv);
                }
            }
 
 
        }catch (Exception e1) {
            e1.getMessage();
        }
    }
 
    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        try {
            Player p = (Player) e.getWhoClicked();
            if(e.getInventory().getName().equalsIgnoreCase("§cSpieler-Verstecken")) {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAlle Spieler anzeigen")) {
                    for(Player all : Bukkit.getOnlinePlayers()) {
                        p.showPlayer(all);
                    }
                    p.playSound(p.getLocation() , Sound.LEVEL_UP , 10 , 1);
                    p.sendMessage(Data.Prefix + "§aDu siehst jetzt §ealle §aSpieler!");
                    p.closeInventory();

                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Premium Spieler anzeigen")) {
                	for(Player all : Bukkit.getOnlinePlayers()){
                	p.showPlayer(all);
                	}
                    p.playSound(p.getLocation() , Sound.LEVEL_UP , 1 , 1);
                    p.sendMessage(Data.Prefix + "§7Jetzt werden dir nur noch §5Premium Spieler §7angezeigt");
                    for(Player all : Bukkit.getOnlinePlayers() ) {
                        if(!all.hasPermission("claymc.gold")) {
                            p.hidePlayer(all);
                        }
                    }
                    p.closeInventory();

                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cAlle Spieler unsichtbar")){
                    for(Player all : Bukkit.getOnlinePlayers() ) {
                        p.hidePlayer(all);
                    }
                    p.playSound(p.getLocation() , Sound.LEVEL_UP , 10 , 1);
                    p.sendMessage(Data.Prefix +"§cAlle Spieler werden dir nun als §eunsichtbar §cangezeigt!");
                    p.closeInventory();
                }
            }
        }catch (Exception e1){
            e1.getMessage();
        }
    }

}

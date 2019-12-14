package de.leitung.lobby.classes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class PlayerHider implements Listener{
	@EventHandler
    public void onHide(PlayerInteractEvent  e) {
 
 
        try {
 
            //Items
            ItemStack g = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)15);
            ItemMeta gmeta = g.getItemMeta();
            gmeta.setDisplayName(" ");
            g.setItemMeta(gmeta);

            Player p = e.getPlayer();
            if(e.getAction() == Action.RIGHT_CLICK_AIR  || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if(p.getItemInHand().getType() == Material.BLAZE_ROD) {
                    Inventory inv = Bukkit.createInventory(null , 9 , "§cSpieler-Verstecken");
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
                    p.sendMessage(Main.Prefix + "§7Jetzt sind alle §aSpieler sichtbar");
                    p.closeInventory();

                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Premium Spieler anzeigen")) {
                    p.playSound(p.getLocation() , Sound.LEVEL_UP , 1 , 1);
                    p.sendMessage(Main.Prefix + "§7Jetzt werden nur noch §5Premium Spieler §7angezeigt");
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
                    p.sendMessage(Main.Prefix +"§7Jetzt sind alle §cSpieler unsichtbar");
                    p.closeInventory();
                }
            }
        }catch (Exception e1){
            e1.getMessage();
        }
    }
}

package listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.omg.PortableInterceptor.ACTIVE;

/**
 * Created by regnatrix on 29.10.16.
 */
public class Team implements Listener{


    @EventHandler
    public void onInt(PlayerInteractEvent e) {

        Player p = e.getPlayer();



        //Items

        ItemStack rusher = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta rusherm = rusher.getItemMeta();
        rusherm.setDisplayName("§cRusher");
        rusher.setItemMeta(rusherm);

        ItemStack basedev = new ItemStack(Material.BOW);
        ItemMeta basedevm = basedev.getItemMeta();
        basedevm.setDisplayName("§9BaseDev");
        basedev.setItemMeta(basedevm);


        if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if(p.getItemInHand().getType() == Material.NETHER_STAR) {

                Inventory inv = Bukkit.createInventory(null, 9, "§7Teams");








                inv.setItem(2, rusher);
                inv.setItem(6, basedev);

                p.openInventory(inv);


            }
        }
    }


}

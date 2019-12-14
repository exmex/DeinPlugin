package listener;

import data.Data;
import gemestates.GameStateHandler;
import gemestates.LobbyState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static de.regnatrix.epbreaker.Main.basedev;
import static de.regnatrix.epbreaker.Main.rusher;

/**
 * Created by regnatrix on 29.10.16.
 */
public class InvClick implements Listener{

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();





        if(e.getInventory().getName().equals("§7Teams")) {


            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cRusher")) {


                if(rusher.contains(p)) {
                    rusher.remove(p);
                    p.sendMessage(Data.Prefix + " §7Du bist für diese nicht mehr Runde Rusher");

                }else {
                    rusher.add(p);
                    p.sendMessage(Data.Prefix + " §7Du bist für diese Runde Rusher");
                }








            }

            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9BaseDev")) {

                if(basedev.contains(p)) {
                    basedev.remove(p);
                    p.sendMessage(Data.Prefix + " §7Du bist für diese nicht mehr Runde BaseDev");

                }else {
                    basedev.add(p);
                    p.sendMessage(Data.Prefix + " §7Du bist für diese Runde BaseDev");
                }
            }
        }





        if(GameStateHandler.getCureGameState() instanceof LobbyState) {
            e.setCancelled(true);
        }else {
            e.setCancelled(false);
        }




    }

}

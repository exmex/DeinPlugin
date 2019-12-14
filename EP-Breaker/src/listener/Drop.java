package listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

/**
 * Created by regnatrix on 24.11.16.
 */
public class Drop implements Listener{


    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {


        e.setCancelled(true);
    }


}

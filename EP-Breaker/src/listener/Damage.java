package listener;

import org.bukkit.entity.EnderPearl;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Created by regnatrix on 27.11.16.
 */
public class Damage implements Listener{


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {


        if(e.getDamager() instanceof EnderPearl) {
            e.setDamage(0.0);
        }

    }


}

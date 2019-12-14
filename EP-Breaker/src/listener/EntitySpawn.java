package listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

/**
 * Created by regnatrix on 29.10.16.
 */
public class EntitySpawn implements Listener    {

    @EventHandler
    public void onSpawn(EntitySpawnEvent e) {
        e.setCancelled(true);
    }


}

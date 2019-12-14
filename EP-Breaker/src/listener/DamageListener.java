package listener;

import gemestates.GameState;
import gemestates.GameStateHandler;
import gemestates.IngameState;
import gemestates.LobbyState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by regnatrix on 28.10.16.
 */
public class DamageListener implements Listener {


    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if(GameStateHandler.getCureGameState() instanceof LobbyState) {
            e.setCancelled(true);
        }else if (GameStateHandler.getCureGameState() instanceof IngameState){
            e.setCancelled(false);
        }else {
            e.setCancelled(true);
        }
    }

}

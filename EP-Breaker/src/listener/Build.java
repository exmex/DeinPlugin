package listener;

import gemestates.GameStateHandler;
import gemestates.IngameState;
import gemestates.LobbyState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * Created by regnatrix on 28.10.16.
 */
public class Build implements Listener{

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (GameStateHandler.getCureGameState() instanceof IngameState){
            e.setCancelled(false);
            e.getItemInHand().setAmount(2);
        } else
        e.setCancelled(true);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (GameStateHandler.getCureGameState() instanceof IngameState){
            e.setCancelled(false);
            e.setExpToDrop(0);
        } else {
            e.setCancelled(true);
        }
    }
}

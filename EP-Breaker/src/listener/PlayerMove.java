package listener;

import data.Data;
import gemestates.GameStateHandler;
import gemestates.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import static de.regnatrix.epbreaker.Main.basedev;
import static de.regnatrix.epbreaker.Main.rusher;

/**
 * Created by regnatrix on 31.10.16.
 */
public class PlayerMove implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {



        Player p = e.getPlayer();

        if(GameStateHandler.getCureGameState() instanceof LobbyState) {
            if(p.getLocation().getY() < 56 ) {
                p.teleport(Bukkit.getWorld("world").getSpawnLocation());
            }
        }









    }


}

package listener;

import data.Data;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

/**
 * Created by regnatrix on 07.12.16.
 */
public class ServerList implements Listener {


    @EventHandler
    public void onServerList(ServerListPingEvent e) {
        if(e.getMaxPlayers() == 2 || Data.playing.size() == 2) {
            e.setMaxPlayers(20);
        }
    }
}

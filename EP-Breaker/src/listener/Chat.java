package listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import utils.Rank;

/**
 * Created by regnatrix on 24.11.16.
 */
public class Chat implements Listener{

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        Player p = e.getPlayer();

        e.setFormat(Rank.getRank(p).Chat + p.getName() + " §8» §7 " + e.getMessage() );
    }


}

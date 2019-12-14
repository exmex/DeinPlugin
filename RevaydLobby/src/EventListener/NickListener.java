package EventListener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class NickListener implements Listener {

	@EventHandler
	public void onSchutzschild(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_AIR
				| e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getPlayer().getItemInHand().getType() == Material.NAME_TAG) {
				if (p.hasPermission("staff.nick")
						|| p.hasPermission("staff.nick.others")) {
					e.setCancelled(true);
					p.performCommand("nick");
				}

			}
		}
	}

}

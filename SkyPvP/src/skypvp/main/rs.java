package skypvp.main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class rs implements Listener{
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
	
			
		Player p = e.getPlayer();
		ItemStack il = new ItemStack(Material.NETHER_STAR);
		ItemMeta ilmeta = il.getItemMeta();
		ilmeta.setDisplayName("§aWähle dein Kit!");
		il.setItemMeta(ilmeta);

		p.getInventory().addItem(il);
	}

}

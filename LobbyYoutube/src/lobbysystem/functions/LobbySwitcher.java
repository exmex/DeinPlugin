package lobbysystem.functions;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import lobbysystem.data.Data;
import lobbysystem.main.Main;

public class LobbySwitcher implements Listener{
	public static ArrayList<Player>into = new ArrayList<Player>();
	private lobbysystem.main.Main pl;
	  
	  public LobbySwitcher(lobbysystem.main.Main Main)
	  {
	    this.pl = Main;
	  }
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		try{
			if(e.getItem().getType() == Material.NETHER_STAR){
				into.add(p);
			Inventory inv = Bukkit.createInventory(null, 9, "§6Lobby Switcher");
			inv.setItem(0, Main.OnlineLobby);
			inv.setItem(1, Main.OfflineLobby);
			inv.setItem(2, Main.OfflineLobby);
			inv.setItem(3, Main.OfflineLobby);
			inv.setItem(4, Main.OfflineLobby);
			inv.setItem(5, Main.OfflineLobby);
			inv.setItem(6, Main.OfflineLobby);
			inv.setItem(7, Main.OfflineLobby);
			inv.setItem(8, Main.OfflineLobby);
			p.openInventory(inv);

			into.add(p);
			
			}
		}catch(Exception e1){}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onClose(InventoryCloseEvent e){
		Player p = (Player)e.getPlayer();
		into.remove(p);
	}
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p =(Player)e.getWhoClicked();
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aLobby-01§8 » §2Online")){
			p.sendMessage(Data.Prefix + "§cDu befindest dich bereits auf dieser Lobby!");
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aLobby §8» §cWird bei Bedarf gestartet")){
			p.sendMessage(Data.Prefix + "§cDiese Lobby ist Offline, kann jedoch bei Bedarf gestartet werden!");
		}
	}
}

package lobby.items;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import NickSystem.Manager.NickManager;
import lobby.data.Data;
import lobby.manager.PingManager;
import lobby.methods.ItemCreator;
import lobby.methods.Sounds;

public class QuickJoiner implements Listener{
	public static ArrayList<Player> nick = new ArrayList<>();
	public QuickJoiner(lobby.main.Main Main){
		this.pl = Main;
	}
	private lobby.main.Main pl;
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
		if(e.getItem().getType() == Material.ENDER_CHEST){
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
				Player p = e.getPlayer();
				Inventory inv = Bukkit.createInventory(null, 9, "§5Shop");
			
				
				p.openInventory(inv);
			}
		}
		if(e.getItem().getType() == Material.NAME_TAG){
			if(nick.contains(e.getPlayer())){
				e.getPlayer().sendMessage(Data.Prefix + "§cBitte benutze dieses Item nicht so oft, um die Serverressourcen zu schonen...");
				return;
			}
			nick.add(e.getPlayer());
			if(NickManager.isnicked(e.getPlayer().getUniqueId().toString())){
				Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
					
					@Override
					public void run() {
						NickManager.unnickPlayer(e.getPlayer().getUniqueId().toString());
						
					}
				},1L);
				e.getPlayer().sendMessage(Data.Prefix + "§cDu hast deinen §5Nick-Namen §centfernt!");
				e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.LEVEL_UP, 10, 10);
				e.getPlayer().getInventory().setItem(4, ItemCreator.CreateItemwhitMaterial(Material.NAME_TAG, 0, 1, "§3✘ §5Nick §7(§cDeaktiviert§7) §3✘", "§7Ändere deinen Nick-Namen"));
			
		}else{
			e.getPlayer().getInventory().setItem(4, ItemCreator.CreateItemwhitMaterial(Material.NAME_TAG, 0, 1, "§3✘ §5Nick §7(§aAktiviert§7) §3✘", "§7Ändere deinen Nick-Namen"));	
			Bukkit.getScheduler().scheduleAsyncDelayedTask(pl, new Runnable() {
				
				@Override
				public void run() {
					NickManager.nick(e.getPlayer().getUniqueId().toString(), e.getPlayer().getName());
					
				}
			},1L);			e.getPlayer().sendMessage(Data.Prefix + "§cDu hast deinen §5Nick-Namen §aaktiviert!");
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.LEVEL_UP, 10, 10);
		}
		}
		}catch(Exception e1){
		}
	}
}

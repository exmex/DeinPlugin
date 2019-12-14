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
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import lobby.data.Data;


public class LobbySwitcher implements Listener{
	public LobbySwitcher(lobby.main.Main Main){
		this.pl = Main;
	}
	private lobby.main.Main pl;	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		try{
		if(e.getItem().getType() == Material.PORK){
			if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
						Inventory inv = Bukkit.createInventory(null, InventoryType.BREWING, "§3LobbySwitch");
						ItemStack i3 = new ItemStack(Material.PAPER, Data.Lobby01 + Data.Lobby02);
						ItemMeta im3 = i3.getItemMeta();
						im3.setDisplayName("§eStatistiken");
						ArrayList<String> list = new ArrayList<>();
						list.add("");
						int total = Data.Lobby01 + Data.Lobby02 + Bukkit.getOnlinePlayers().size();
						list.add("§7Spieler auf Lobby's§8 » §6" + total);
						list.add("§7Lobby-01§8 » §6" + Data.Lobby01);
						list.add("§7Lobby-02§8 » §6" + Data.Lobby02);
						list.add("§7Silenthub§8 » §6" + Bukkit.getOnlinePlayers());
						list.add("");
						im3.setLore(list);
						i3.setItemMeta(im3);
						
						ItemStack i = new ItemStack(Material.POTION, Data.Lobby01);
						ItemMeta im = i.getItemMeta();
						im.setDisplayName("§3Lobby-01 §8| §aOnline");
						i.setItemMeta(im);
						
						ItemStack i1 = new ItemStack(Material.POTION, Data.Lobby02);
						ItemMeta im1 = i1.getItemMeta();
						im1.setDisplayName("§3Lobby-02 §8| §aOnline");
						i1.setItemMeta(im1);
						
						ItemStack i12 = new ItemStack(Material.POTION, Bukkit.getOnlinePlayers().size());
						ItemMeta im12 = i12.getItemMeta();
						im12.setDisplayName("§3SilentHub §8| §aOnline");
						i12.setItemMeta(im12);
						
						inv.setItem(3, i3);
						inv.setItem(0, i);
						inv.setItem(1, i1);
						inv.setItem(2, i12);

						e.getPlayer().openInventory(inv);
						e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.LEVEL_UP, 1, 1);
					}
		}
					}catch(Exception e1){}
				}


				@EventHandler
				public void onC(InventoryClickEvent e){
					Player p = (Player)e.getWhoClicked();
					if(e.getInventory().getName().equalsIgnoreCase("§3LobbySwitch")){
						e.setCancelled(true);
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Lobby-01 §8| §aOnline")){
			                     ByteArrayOutputStream b = new ByteArrayOutputStream();
			                     DataOutputStream     out = new DataOutputStream(b);
			                     try {
			                         out.writeUTF("Connect");
			                         out.writeUTF("Lobby-01");
			                         p.sendPluginMessage(pl, "BungeeCord", b.toByteArray());
			                     } catch (IOException e1) {
			                     }

							return;
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Lobby-02 §8| §aOnline")){
							ByteArrayOutputStream b = new ByteArrayOutputStream();
			                DataOutputStream     out = new DataOutputStream(b);
			                try {
			                    out.writeUTF("Connect");
			                    out.writeUTF("Lobby-02");
			                    p.sendPluginMessage(pl, "BungeeCord", b.toByteArray());

			                } catch (IOException e1) {
			                }
							return;
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3SilentHub §8| §aOnline")){
							p.sendMessage(Data.Prefix + "§cDu befindest sich bereits auf der SilentHub");
							p.closeInventory();
							return;
							
						}
					}
				}
				
			
		
			}


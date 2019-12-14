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
						Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§3LobbySwitch");


						
						ItemStack i = new ItemStack(Material.POTION, Data.Lobby01);
						ItemMeta im = i.getItemMeta();
						im.setDisplayName("§3Lobby-01 §8| §aOnline");
						i.setItemMeta(im);
						
						ItemStack i1 = new ItemStack(Material.POTION, Data.Lobby02);
						ItemMeta im1 = i1.getItemMeta();
						im1.setDisplayName("§3Lobby-02 §8| §aOnline");
						i1.setItemMeta(im1);
						
						ItemStack i12 = new ItemStack(Material.POTION, Data.Lobby03);
						ItemMeta im12 = i12.getItemMeta();
						im12.setDisplayName("§3Lobby-03 §8| §aOnline");
						i12.setItemMeta(im12);
						
						ItemStack i13 = new ItemStack(Material.POTION, Data.Lobby04);
						ItemMeta im13 = i13.getItemMeta();
						im13.setDisplayName("§3Lobby-04 §8| §aOnline");
						i13.setItemMeta(im13);
						
						ItemStack i14 = new ItemStack(Material.POTION, Data.Lobby05);
						ItemMeta im14 = i14.getItemMeta();
						im14.setDisplayName("§3Lobby-05 §8| §aOnline");
						i14.setItemMeta(im14);
						
						inv.setItem(0, i);
						inv.setItem(1, i1);
						inv.setItem(2, i12);
						inv.setItem(3, i13);
						inv.setItem(4, i14);

						e.getPlayer().openInventory(inv);
						e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.LEVEL_UP, 1, 1);
					}
		}
					}catch(Exception e1){}
				}


				@EventHandler
				public void onC(InventoryClickEvent e){
					Player p = (Player)e.getWhoClicked();
					try{
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
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Lobby-03 §8| §aOnline")){
							ByteArrayOutputStream b = new ByteArrayOutputStream();
			                DataOutputStream     out = new DataOutputStream(b);
			                try {
			                    out.writeUTF("Connect");
			                    out.writeUTF("Lobby-03");
			                    p.sendPluginMessage(pl, "BungeeCord", b.toByteArray());
			                } catch (IOException e1) {
			                }
							p.closeInventory();
							return;
							
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Lobby-04 §8| §aOnline")){
							ByteArrayOutputStream b = new ByteArrayOutputStream();
			                DataOutputStream     out = new DataOutputStream(b);
			                try {
			                    out.writeUTF("Connect");
			                    out.writeUTF("Lobby-04");
			                    p.sendPluginMessage(pl, "BungeeCord", b.toByteArray());
			                } catch (IOException e1) {
			                }
							p.closeInventory();
							return;
							
						}
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Lobby-05 §8| §aOnline")){
							ByteArrayOutputStream b = new ByteArrayOutputStream();
			                DataOutputStream     out = new DataOutputStream(b);
			                try {
			                    out.writeUTF("Connect");
			                    out.writeUTF("Lobby-05");
			                    p.sendPluginMessage(pl, "BungeeCord", b.toByteArray());
			                } catch (IOException e1) {
			                }
							p.closeInventory();
							return;
							
						}
						}
					}catch(Exception e2){}
					}
				
				
			
		
			}


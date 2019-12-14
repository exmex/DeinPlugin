package lobby.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import lobby.data.Data;
import lobby.methods.ItemCreator;
import lobby.methods.Sounds;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class YouTuber implements CommandExecutor, Listener{

	
	public static HashMap<Player, String> a = new HashMap<>();
	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		Player p = (Player)s;
		if(c.getName().equalsIgnoreCase("setrank")){
			if(p.hasPermission("claymc.uprank")){
			if(args.length != 1){
				p.sendMessage(Data.Prefix + "§cFehler! §eBitte Nutze: /SetRank [Spieler]");
				return true;
			}else{
				Inventory inv = Bukkit.createInventory(null, 18, "§e§l" + args[0]);
				ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
				ItemMeta im = i.getItemMeta();
				im.setDisplayName(" ");
				i.setItemMeta(im);
				a.put(p, args[0]);
				inv.setItem(4, ItemCreator.CreateYT(args[0], p, args[0]));
				inv.setItem(0, i);
				inv.setItem(1, i);
				inv.setItem(2, i);
				inv.setItem(3, i);
				inv.setItem(5, i);
				inv.setItem(6, i);
				inv.setItem(7, i);
				inv.setItem(8, i);
				inv.setItem(9, i);
				inv.setItem(10, i);
				inv.setItem(11, i);
				inv.setItem(12, ItemCreator.CreateItemONELORE(Material.GOLD_NUGGET, 0, 1, "§5Junior-YouTuber", "§7Setze den Spieler zum §5Jr-YouTuber"));
				inv.setItem(13, ItemCreator.CreateItemONELORE(Material.WOOD_SWORD, 0, 1, "§8Spieler", "§7Setze den Spieler zum §8Spieler"));
				inv.setItem(14, ItemCreator.CreateItemONELORE(Material.GOLD_INGOT, 0, 1, "§5YouTuber", "§7Setze den Spieler zum §5YouTuber"));
				inv.setItem(15, i);
				inv.setItem(16, i);
				inv.setItem(17, i);

				p.openInventory(inv);
			}
		}else{
			p.sendMessage(Data.Prefix + "§cDu hast keine Rechte um dies zu tun.");
		}
		}
		return false;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§e§l" + a.get(p))){
			e.setCancelled(true);
			String group = PermissionsEx.getUser(a.get(p)).getGroups()[0].getName();
			if(e.getCurrentItem().getType() == Material.GOLD_NUGGET){
				if(canRank(a.get(p)) == true){
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + a.get(p) + " group set JrYoutuber");
					Sounds.playOpenInventorySound(p);
					p.sendMessage(Data.Prefix + "§6" + a.get(p) + "§e hat nun den §5Jr-Youtuber §eRang!");
					p.closeInventory();
				}else{
					p.sendMessage(Data.Prefix + "§cDu darfst die Rechte von §e" + a.get(p) + "§c nicht ändern. Bitte wende dich an einen Admin.");
					Sounds.playSound(p);
					p.closeInventory();
				}
			}
			if(e.getCurrentItem().getType() == Material.WOOD_SWORD){
				if(canRank(a.get(p)) == true){
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + a.get(p) + " group set default");
					p.sendMessage(Data.Prefix + "§6" + a.get(p) + "§e hat nun den §8Spieler §eRang!");
					p.closeInventory();
					Sounds.playOpenInventorySound(p);
				}else{
					p.sendMessage(Data.Prefix + "§cDu darfst die Rechte von §e" + a.get(p) + "§c nicht ändern. Bitte wende dich an einen Admin.");
					Sounds.playSound(p);
					p.closeInventory();
				}
			}
			if(e.getCurrentItem().getType() == Material.GOLD_INGOT){
				if(canRank(a.get(p)) == true){
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + a.get(p) + " group set YouTuber");
					p.sendMessage(Data.Prefix + "§6" + a.get(p) + "§e hat nun den §5YouTuber §eRang!");
					Sounds.playOpenInventorySound(p);
					p.closeInventory();
				}else{
					p.closeInventory();
					p.sendMessage(Data.Prefix + "§cDu darfst die Rechte von §e" + a.get(p) + "§c nicht ändern. Bitte wende dich an einen Admin.");
					Sounds.playSound(p);
				}
			}
			p.sendMessage(Data.Prefix + "§e§lBitte gebe noch folgendes ein: §c§l/Rank set [Spieler] [Rang]");
			a.remove(p);
		}
	}
	public boolean canRank(String p){
		boolean bool = false;
		String group = PermissionsEx.getUser(p).getGroups()[0].getName();
		if(group.equalsIgnoreCase("default") || group.equalsIgnoreCase("youtuber") || group.equalsIgnoreCase("jryoutuber")){
			bool = true;
		}else{
			bool = false;
		}
		return bool;
	}
}

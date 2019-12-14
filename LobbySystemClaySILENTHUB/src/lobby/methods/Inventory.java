package lobby.methods;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Inventory {

	public static void getJoinInventory(Player p){
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.getInventory().setItem(0, ItemCreator.CreateItemwhitMaterial(Material.COMPASS, 0, 1, "§3✘ §5Navigator §3✘", "§7Teleportiere dich zu einem Spielmodus"));
		p.getInventory().setItem(1, ItemCreator.CreateItemwhitMaterial(Material.ENDER_CHEST, 0, 1, "§3✘ §dQuick-Joiner §3✘", "§7Wähle dir Gadgets aus"));
		ItemStack skull = new ItemStack(397, 1, (short) 3);
		ItemMeta sm = skull.getItemMeta();
		sm.setDisplayName("§3✘ §aFreunde §3✘");
		skull.setItemMeta(sm);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner(p.getName());
		ArrayList<String> list = new ArrayList<>();
		list.add("§7Verwalte deine Freundschaftsanfragen");
		skull.setItemMeta(meta);
		p.getInventory().setItem(7, skull);
		p.getInventory().setItem(8, ItemCreator.CreateItemwhitMaterial(Material.PORK, 0, 1, "§3✘ §eLobby wechseln §3✘", "§7Wähle eine neue Lobby aus"));
	
		if(p.hasPermission("claymc.legend")){
			if(NickAPI.MySQL.NickAPI.getNick(p.getUniqueId().toString()).intValue() == 100){
	              p.getInventory().setItem(3, ItemCreator.CreateItemwhitMaterial(Material.NAME_TAG, 0, 1, "§5AutoNick §8● §aAktiviert", null));
			}else{
			p.getInventory().setItem(3, ItemCreator.CreateItemwhitMaterial(Material.NAME_TAG, 0, 1, "§5AutoNick §8● §cDeaktiviert", "§7Ändere Global deinen Namen"));
		}
		}
		if(p.hasPermission("claymc.silenthub")){
			p.getInventory().setItem(5, ItemCreator.CreateItemwhitMaterial(Material.TNT, 0, 1, "§3✘ §cSilentLobby §8[§aAN§8] §3✘", "§7Zum 'alleine sein'"));
		}
		p.updateInventory();
		
	
	}
}

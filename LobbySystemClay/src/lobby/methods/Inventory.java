package lobby.methods;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import NickSystem.Manager.NickManager;
import net.minecraft.server.v1_8_R3.IpBanEntry;

public class Inventory {

	public static void getJoinInventory(Player p){
		p.getInventory().setArmorContents(null);
		p.getInventory().setItem(3, null);
		p.getInventory().setItem(5, null);
		p.getInventory().setItem(0, ItemCreator.CreateItemwhitMaterial(Material.COMPASS, 0, 1, "§3✘ §5Navigator §3✘", "§7Teleportiere dich zu einem Spielmodus"));
		p.getInventory().setItem(2, ItemCreator.CreateItemwhitMaterial(Material.FISHING_ROD, 0, 1, "§3✘ §5Enterhaken §3✘", "§7Ziehe dich hin und her"));
		p.getInventory().setItem(6, ItemCreator.CreateItemwhitMaterial(Material.FIREWORK_CHARGE, 0, 1, "§eGadGets", "§7Kaufe dir Gadgets!"));

		if(p.hasPermission("claymc.nick")){
			if(NickManager.isnicked(p.getUniqueId().toString())){
				p.getInventory().setItem(4, ItemCreator.CreateItemwhitMaterial(Material.NAME_TAG, 0, 1, "§3✘ §5Nick §7(§aAktiviert§7) §3✘", "§7Ändere deinen Nick-Namen"));
			}else{
				p.getInventory().setItem(4, ItemCreator.CreateItemwhitMaterial(Material.NAME_TAG, 0, 1, "§3✘ §5Nick §7(§cDeaktiviert§7) §3✘", "§7Ändere deinen Nick-Namen"));
			}
		}
		p.getInventory().setItem(1, ItemCreator.CreateItemwhitMaterial(Material.INK_SACK, 10, 1, "§3✘ §eAlle Spieler sichtbar §3✘", "§7Verstecke deine Mitspieler"));

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
		p.updateInventory();
		
	
	}

	public static void getLoadingInventory(Player p) {
		p.getInventory().clear();
		ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName("§7✘§c Daten werden abgerufen... §7✘");
		i.setItemMeta(im);
		for(int ia = 0 ; ia < 9 ; ia++){
		p.getInventory().setItem(ia, i);
	
		
		
			p.getInventory().setItem(0, i);
			p.getInventory().setItem(1, i);
			p.getInventory().setItem(2, i);
			p.getInventory().setItem(3, i);
			p.getInventory().setItem(5, i);
			p.getInventory().setItem(6, i);
			p.getInventory().setItem(7, i);
			p.getInventory().setItem(8, i);
		
	}
	}
}

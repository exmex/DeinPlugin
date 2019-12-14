package lobbysystem.methods;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Methods {

	public static void setLobbyItems(Player p){
		
		ItemStack compass = new ItemStack(Material.COMPASS);
		ItemMeta cm = compass.getItemMeta();
		cm.setDisplayName("§eNavigator");
		compass.setItemMeta(cm);
		
		ItemStack spielerverstecken = new ItemStack(Material.BLAZE_ROD);
		ItemMeta sv = spielerverstecken.getItemMeta();
		sv.setDisplayName("§aSpieler-Verstecken");
		spielerverstecken.setItemMeta(sv);
		
		ItemStack lobbyswitch = new ItemStack(Material.NETHER_STAR);
		ItemMeta ls = lobbyswitch.getItemMeta();
		ls.setDisplayName("§cLobby-Switcher");
		lobbyswitch.setItemMeta(ls);
		
		ItemStack gadgets = new ItemStack(Material.CHEST);
		ItemMeta gm = gadgets.getItemMeta();
		gm.setDisplayName("§bGadgets");
		gadgets.setItemMeta(gm);
		p.getInventory().clear();
		p.getInventory().setItem(0, compass);
		p.getInventory().setItem(1, spielerverstecken);
		p.getInventory().setItem(7, lobbyswitch);
		p.getInventory().setItem(8, gadgets);
		p.updateInventory();
	}
}

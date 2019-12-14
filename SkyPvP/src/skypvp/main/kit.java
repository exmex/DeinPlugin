package skypvp.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class kit implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Location loc = p.getLocation();
		
		if(cmd.getName().equalsIgnoreCase("kit")){
			p.sendMessage(main.Prefix + "§bBitte wähle ein Kit!");
			Inventory inv = Bukkit.createInventory(null, 9, "§aKitauswahlmenü");
			p.playSound(p.getLocation(), Sound.ANVIL_USE, 1F, 1F);
			
			ItemStack versetzer = new ItemStack(Material.LEATHER_CHESTPLATE);
			ItemMeta mversetzer = versetzer.getItemMeta();
			mversetzer.setDisplayName("§aKit: §bSpieler");
			List<String> versetzerlore = new ArrayList<String>();
			versetzerlore.add("§6---------------------");
			versetzerlore.add("§eEquipment:");
			versetzerlore.add("§e- Kettenrüstung");
			versetzerlore.add("§e- Steinschwert");
			versetzerlore.add("§e- 64 Steak");
			versetzerlore.add("§6---------------------");
			mversetzer.setLore(versetzerlore);
			versetzer.setItemMeta(mversetzer);

			ItemStack versetzer1 = new ItemStack(Material.GOLD_CHESTPLATE);
			ItemMeta mversetzer1 = versetzer1.getItemMeta();
			mversetzer1.setDisplayName("§aKit: §bVIP");
			List<String> versetzerlore1 = new ArrayList<String>();
			versetzerlore1.add("§6---------------------");
			versetzerlore1.add("§eEquipment:");
			versetzerlore1.add("§e- Ketten Helm");
			versetzerlore1.add("§e- Dia Brustpanzer");
			versetzerlore1.add("§e- Ketten Hose");
			versetzerlore1.add("§e- Ketten Schuhe");
			versetzerlore1.add("§e- Eisenschwert");
			versetzerlore1.add("§e- 1 Goldapfel");
			versetzerlore1.add("§e- 64 Steak");
			versetzerlore1.add("§6---------------------");
			mversetzer1.setLore(versetzerlore1);
			versetzer1.setItemMeta(mversetzer1);
			
			ItemStack versetzer2 = new ItemStack(Material.IRON_CHESTPLATE);
			ItemMeta mversetzer2 = versetzer2.getItemMeta();
			mversetzer2.setDisplayName("§aKit: §bPremium");
			List<String> versetzerlore2 = new ArrayList<String>();
			versetzerlore2.add("§6---------------------");
			versetzerlore2.add("§eEquipment:");
			versetzerlore2.add("§e- Diarüstung");
			versetzerlore2.add("§e- Eisenschwert");
			versetzerlore2.add("§e- 8 Goldäpfel");
			versetzerlore2.add("§e- 1 OP Goldapfel");
			versetzerlore2.add("§e- 64 Steak");
			versetzerlore2.add("§6---------------------");
			mversetzer2.setLore(versetzerlore2);
			versetzer2.setItemMeta(mversetzer2);
			
			ItemStack versetzer3 = new ItemStack(Material.DIAMOND_CHESTPLATE);
			ItemMeta mversetzer3 = versetzer3.getItemMeta();
			mversetzer3.setDisplayName("§aKit: §bMitglied");
			List<String> versetzerlore3 = new ArrayList<String>();
			versetzerlore3.add("§6---------------------");
			versetzerlore3.add("§eEquipment:");
			versetzerlore3.add("§e- Diarüstung");
			versetzerlore3.add("§e- Diaschwert");
			versetzerlore3.add("§e- 32 Goldäpfel");
			versetzerlore3.add("§e- 18 OP Goldäpfel");
			versetzerlore3.add("§e- 64 Steak");
			versetzerlore3.add("§6---------------------");
			mversetzer3.setLore(versetzerlore3);
			versetzer3.setItemMeta(mversetzer3);
			
			ItemStack versetzer4 = new ItemStack(Material.BARRIER);
			ItemMeta mversetzer4 = versetzer4.getItemMeta();
			mversetzer4.setDisplayName("§aWähle ein Kit");
			List<String> versetzerlore4 = new ArrayList<String>();
			versetzerlore4.add("§6---------------------");
			versetzerlore4.add("§bWähle ein Kit aus");
			versetzerlore4.add("§6---------------------");
			mversetzer4.setLore(versetzerlore4);
			versetzer4.setItemMeta(mversetzer4);
			
			ItemStack il = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short) 7);
			ItemMeta ilmeta = il.getItemMeta();
			ilmeta.setDisplayName("§aWähle dein Kit!");
			il.setItemMeta(ilmeta);
			
			inv.setItem(0, il);
			inv.setItem(1, versetzer);
			inv.setItem(2, il);
			inv.setItem(3, versetzer1);
			inv.setItem(4, il);
			inv.setItem(5, versetzer2);
			inv.setItem(6, il);
			inv.setItem(7, versetzer3);
			inv.setItem(8, il);




			p.openInventory(inv);
		}
		return false;
		}
}

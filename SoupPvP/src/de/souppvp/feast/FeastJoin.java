package de.souppvp.feast;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.souppvp.data.Data;
import de.souppvp.data.Scoreboard;

public class FeastJoin {
	public FeastJoin(de.souppvp.main.Main Main){
		this.pl = Main;
	}
	private de.souppvp.main.Main pl;

	public static void startFeast(Player p){
		p.getInventory().clear();
		FeastData.removeFormAllKits(p);
		Data.OneVSOneJoin.remove(p);
		Data.firstJoin.remove(p);
		Data.INOneVSOneJoin.remove(p);
		Data.OneVSOneJoin.remove(p);
		Data.OneVSOneWarteschlange.remove(p);
		Data.FeastJoin.add(p);
		Data.FeastNoKit.add(p);
		ItemStack i = new ItemStack(Material.CHEST);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName("§eKitauswahl §7» §f§lKLICK");
		i.setItemMeta(im);
		
		ItemStack a = new ItemStack(Material.BARRIER);
		ItemMeta am = a.getItemMeta();
		am.setDisplayName("§cFeast verlassen...");
		a.setItemMeta(am);
		p.setGameMode(GameMode.ADVENTURE);
		p.getInventory().setItem(0, i);
		p.getInventory().setItem(8, a);
		Scoreboard.setScoreboard(p);
		p.updateInventory();
	}
}

package skypvp.main;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class death implements Listener{
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		e.setDeathMessage(null);
		Player p = e.getEntity();
		Player k = e.getEntity().getKiller();
		e.setDeathMessage("§e" + p.getName() + " §bwurde von §e" + k.getName() + " §bgetötet!");
		ItemStack il = new ItemStack(Material.GOLD_NUGGET);
		ItemMeta ilmeta = il.getItemMeta();
		ilmeta.setDisplayName("§aGold-Nugget");
		il.setItemMeta(ilmeta);
		e.getDrops().add(il);
		k.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);

		
		k.sendMessage("§a+ 1 §6§lGoldNugget!");

		k.setHealth(20);
	}
	}


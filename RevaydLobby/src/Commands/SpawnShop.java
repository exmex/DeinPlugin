package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Main.Main;

public class SpawnShop implements CommandExecutor{

	public Main plugin;
	
	public SpawnShop(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("spawnshop")) {
				if(p.hasPermission("staff.spawnshop") || p.isOp()){
					Villager villager = (Villager) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
					villager.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000000, 6));
					villager.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000000, 128));
					villager.setCanPickupItems(false);
					villager.setFireTicks(0);
					villager.getEquipment().setArmorContents(new ItemStack[]{ });
					villager.setAdult();
					villager.setCustomName("§6Shop");
					villager.setCustomNameVisible(true);
					return true;				
		
				}else p.sendMessage("§cDu hast nicht genügend Rechte!");
			}
		}
		return false;
	}
}
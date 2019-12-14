package de.spigotplugins.methods;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.spigotplugins.ffa.data.Data;

public class NoHitDelay implements CommandExecutor{
	public static File file = new File("plugins//FFA//nhd.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("nohitdelay")){
			Player p = (Player)s;
			if(p.hasPermission("ffa.nohitdelay")){
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("on")){
					ItemStack a = new ItemStack(Material.DIAMOND_HELMET);
					ItemStack b = new ItemStack(Material.DIAMOND_CHESTPLATE);
					ItemStack ca = new ItemStack(Material.DIAMOND_LEGGINGS);
					ItemStack d = new ItemStack(Material.DIAMOND_BOOTS);

					for(Player all : Bukkit.getOnlinePlayers()){
						all.setMaximumNoDamageTicks(0);
						all.getInventory().setHelmet(a);
						all.getInventory().setChestplate(b);
						all.getInventory().setLeggings(ca);
						all.getInventory().setBoots(d);
					}
					Data.nhd = true;
					p.sendMessage(Data.Prefix + "§eNohitdelay wurde nun §aeingeschaltet§e!");
					for(Player all : Bukkit.getOnlinePlayers()){
						all.sendTitle("§6NoHitDelay", "§aAktiviert");
					}
					cfg.set("NHD", true);
					try {
						cfg.save(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}else if(args[0].equalsIgnoreCase("off")){
					for(Player all : Bukkit.getOnlinePlayers()){
						all.setMaximumNoDamageTicks(20);
						Inv.getPlayerStandart(all);
					}
					Data.nhd = false;
					p.sendMessage(Data.Prefix + "§eNohitdelay wurde nun §causgeschaltet§e!");
					for(Player all : Bukkit.getOnlinePlayers()){
						all.sendTitle("§6NoHitDelay", "§cDeaktiviert!");
					}
					cfg.set("NHD", false);
					try {
						cfg.save(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else{
					p.sendMessage(Data.Prefix + "§cFalsche Benutzung! Nutze §e/Nohitdelay §aon§7/§coff");
				}
			}else{
				p.sendMessage(Data.Prefix + "§cFalsche Benutzung! Nutze §e/Nohitdelay §aon§7/§coff");
			}
			}
		}
		return false;
	}
	
	

}

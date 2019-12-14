package de.arenapvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.arenapvp.data.Data;

public class ArenaPvP implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		Player p = (Player)s;
		if(c.getName().equalsIgnoreCase("arenapvp")){
			if(args.length == 0){
				p.sendMessage("§7§m--------------------------");
				p.sendMessage(Data.Prefix + "§bEntwicklung: §6SpigotPlugins");
				p.sendMessage(Data.Prefix + "§bDauer: §617 Stunden");
				p.sendMessage("§7§m--------------------------");
				if(p.hasPermission("claymc.admin")){
					p.sendMessage(Data.Prefix + "§bCommands:");
					p.sendMessage(Data.Prefix + "§7/ArenaPvP §eCreateInstance §7[Name]");
					p.sendMessage(Data.Prefix + "§7/ArenaPvP §eGetInstance §7[Instance]");
					p.sendMessage(Data.Prefix + "§7/ArenaPvP §eRemoveInstance §7[Instance]");
					p.sendMessage(Data.Prefix + "§7/ArenaPvP §eCreateArena §7[Name]");
					p.sendMessage(Data.Prefix + "§7/ArenaPvP §eRemoveArena §7[Instance]");
					p.sendMessage(Data.Prefix + "§7/ArenaPvP §eGetArena §7[Instance]");
					p.sendMessage(Data.Prefix + "§7/ArenaPvP §eSetSpawn §3[Instance] [Arena] [1-2]");
					p.sendMessage("§7§m--------------------------");
				}
			}else if(args.length == 1){
				p.sendMessage("§7§m--------------------------");
				p.sendMessage(Data.Prefix + "§bEntwicklung: §6SpigotPlugins");
				p.sendMessage(Data.Prefix + "§bDauer: §617 Stunden");
				p.sendMessage("§7§m--------------------------");
				if(p.hasPermission("claymc.admin")){
					p.sendMessage(Data.Prefix + "§bCommands:");
					p.sendMessage(Data.Prefix + "§7/ArenaPvP §eCreateInstance §7[Name]");
					p.sendMessage(Data.Prefix + "§7/ArenaPvP §eGetInstance §7[Instance]");
					p.sendMessage(Data.Prefix + "§7/ArenaPvP §eRemoveInstance §7[Instance]");
					p.sendMessage(Data.Prefix + "§7/ArenaPvP §eCreateArena §7[Name]");
					p.sendMessage(Data.Prefix + "§7/ArenaPvP §eRemoveArena §7[Instance]");
					p.sendMessage(Data.Prefix + "§7/ArenaPvP §eGetArena §7[Instance]");
					p.sendMessage(Data.Prefix + "§7/ArenaPvP §eSetSpawn §3[Instance] [Arena] [1-2]");
					p.sendMessage("§7§m--------------------------");
			}else if(args.length == 2){
			
				if(args[0].equalsIgnoreCase("CreateInstance")){
					Data.loadInstancList();
					if(Data.instancelist.contains("Instances")){
						p.sendMessage(Data.Prefix + "§cDiese §eInstanz §cexistiert bereits!");
						return true;
					}else{
						Data.instancelist.add(args[1]);
						Data.saveInstanceList();
						p.sendMessage(Data.Prefix + "§eDie Instanz §6" + args[1] + " §ewurde erfolgreich erstellt!");
						return true;
					}
				}
				
			}
			}
		}
		return false;
	}
	
	

}

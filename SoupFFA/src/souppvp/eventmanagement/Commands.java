package souppvp.eventmanagement;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import souppvp.data.Data;
import souppvp.listener.Archievements;
import souppvp.listener.ArchievementsData;
import souppvp.main.Main;
import souppvp.methods.Sounds;

public class Commands implements CommandExecutor{
	public Commands(souppvp.main.Main Main){
		this.pl = Main;
	}
	private souppvp.main.Main pl;
	public static int cd;
	public static int cdd;

	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("startevent")){
			Player p = (Player)s;
			if(p.hasPermission("claymc.eventstart")){
				if(Data.eventmodus == true){
					Data.eventmodus = false;
					stopEvent(p);
					p.sendMessage(Data.Prefix + "§eDu hast das §6Event §enun §3beendet§e!");
					Sounds.playAdminAcceptSound(p);
					return true;
				}
				if(Data.eventmodus == false){
					Data.eventmodus = true;
					startEvent(p);
					p.sendMessage(Data.Prefix + "§eDu hast das §6Event §enun §agestartet§e!");
					Sounds.playAdminAcceptSound(p);
				}
				
			}else{
				p.sendMessage(Data.NoPerm);
			}
		}
		if(c.getName().equalsIgnoreCase("addcoins")){
			Player p = (Player)s;
			if(args.length == 2){
				Player target = Bukkit.getPlayer(args[1]);
				int anzahl = Integer.parseInt(args[2]);
				
			}else{
				p.sendMessage(Data.Prefix + "§e/addcoins [name] [coins]");
			}
		}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public void startEvent(Player p){
		
		Data.Prefix = "§7┃ §eSoupFFA §7| §dEvent §8» ";
		for(Player all : Bukkit.getOnlinePlayers()){
			if(all.hasPermission("claymc.team")){
				int lagwahrscheinlichkeit;
				if(Bukkit.getOnlinePlayers().size() > 100){
					lagwahrscheinlichkeit = 100;
				}
				if(Bukkit.getOnlinePlayers().size() > 60 && Bukkit.getOnlinePlayers().size() < 80){
					lagwahrscheinlichkeit = 60;
				}
				if(Bukkit.getOnlinePlayers().size() > 50 && Bukkit.getOnlinePlayers().size() < 80){
					lagwahrscheinlichkeit = 50;
				}
				if(Bukkit.getOnlinePlayers().size() > 40 && Bukkit.getOnlinePlayers().size() < 50){
					lagwahrscheinlichkeit = 30;
				}
				if(Bukkit.getOnlinePlayers().size() > 30 && Bukkit.getOnlinePlayers().size() < 40){
					lagwahrscheinlichkeit = 20;
				}
				if(Bukkit.getOnlinePlayers().size() > 20 && Bukkit.getOnlinePlayers().size() < 30){
					lagwahrscheinlichkeit = 7;
				}else{
					lagwahrscheinlichkeit = 1;
				}
				
				all.sendMessage("");
				all.sendMessage("§7§m----------------------------------------");
				all.sendMessage("§3Das §9Event §3wurde gestartet!");
				all.sendMessage("§6Höchste Priorität §7» §aAN");
				all.sendMessage("§eLagwahrscheinlichkeit §7» §b" + lagwahrscheinlichkeit + "%");
				all.sendMessage("§7§m----------------------------------------");
				all.sendMessage("");


			}
			for(Player alla : Bukkit.getOnlinePlayers()){
				Main.sendActionbar(alla, Data.Prefix + "§cEventvorbereitungen werden getroffen... §7[§4Laggs?§7]");
				if(ArchievementsData.firstkill.contains(alla)){
					Archievements.cfg.set(alla.getUniqueId() + ".Firstkill", true);
					try {
						Archievements.cfg.save(Archievements.file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(ArchievementsData.firstdeath.contains(alla)){
					Archievements.cfg.set(alla.getUniqueId() + "Firstdeath", true);
					try {
						Archievements.cfg.save(Archievements.file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
				cd = Bukkit.getScheduler().scheduleAsyncRepeatingTask(pl, new Runnable() {
					
					@Override
					public void run() {
						
						for(Player all : Bukkit.getOnlinePlayers()){
						Main.sendActionbar(all, Data.Prefix);
						}
						
					}
				}, 20, 20);
				
			}
		
	}
	
	public void stopEvent(Player p){
		Bukkit.getScheduler().cancelTask(cd);
		Data.Prefix = "§7┃ §eSoupFFA §7| ";
		for(Player all : Bukkit.getOnlinePlayers()){
			if(all.hasPermission("claymc.team")){
				int lagwahrscheinlichkeit;
				if(Bukkit.getOnlinePlayers().size() > 100){
					lagwahrscheinlichkeit = 100;
				}
				if(Bukkit.getOnlinePlayers().size() > 60 && Bukkit.getOnlinePlayers().size() < 80){
					lagwahrscheinlichkeit = 70;
				}
				if(Bukkit.getOnlinePlayers().size() > 50 && Bukkit.getOnlinePlayers().size() < 80){
					lagwahrscheinlichkeit = 60;
				}
				if(Bukkit.getOnlinePlayers().size() > 40 && Bukkit.getOnlinePlayers().size() < 50){
					lagwahrscheinlichkeit = 40;
				}
				if(Bukkit.getOnlinePlayers().size() > 30 && Bukkit.getOnlinePlayers().size() < 40){
					lagwahrscheinlichkeit = 20;
				}
				if(Bukkit.getOnlinePlayers().size() > 20 && Bukkit.getOnlinePlayers().size() < 30){
					lagwahrscheinlichkeit = 11;
				}
				if(Bukkit.getOnlinePlayers().size() > 10 && Bukkit.getOnlinePlayers().size() < 20){
					lagwahrscheinlichkeit = 5;
				}else{
					lagwahrscheinlichkeit = 2;
				}
				
				all.sendMessage("");
				all.sendMessage("§7§m----------------------------------------");
				all.sendMessage("§3Das §9Event §3wurde §cgestoppt!");
				all.sendMessage("§6Höchste Priorität §7» §cAUS");
				all.sendMessage("§eLagwahrscheinlichkeit §7» §b" + lagwahrscheinlichkeit + "%");
				all.sendMessage("§7§m----------------------------------------");
				all.sendMessage("");

	}

		}
	}
}

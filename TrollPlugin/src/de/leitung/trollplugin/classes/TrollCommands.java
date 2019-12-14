package de.leitung.trollplugin.classes;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrollCommands implements CommandExecutor{
	public TrollCommands(de.leitung.trollplugin.classes.Main Main){
		this.pl = Main;
	}
	private de.leitung.trollplugin.classes.Main pl;
	@SuppressWarnings("deprecation")
	ArrayList<Player>spamlist = new ArrayList<Player>();
	int spamint;
	@SuppressWarnings({ "deprecation", "unused" })
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player p = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("troll")){
			if(args.length == 0){
				if(p.hasPermission("troll.allow")){
					p.sendMessage(Main.Prefix + "§6/Troll On §7- §3 Unsichtbar + Gamemode");
					p.sendMessage(Main.Prefix + "§6/Troll Vanish §7-§3 Unsichtbar");
					p.sendMessage(Main.Prefix + "§6/Troll Gamemode §7-§3 Gamemode");
					p.sendMessage(Main.Prefix + "§6/Troll Push [Spieler] §7-§3 Knockback geben");
					p.sendMessage(Main.Prefix + "§6/Troll Lag On [Spieler] §7-§3 Lässt den Spieler laggen");
					p.sendMessage(Main.Prefix + "§6/Troll Lag Off [Spieler] §7-§3 Lässt den Spieler nicht mehr laggen");
					p.sendMessage(Main.Prefix + "§6/Troll Crash [Spieler] §7-§3 Spiel Crashen lassen");
					p.sendMessage(Main.Prefix + "§6/Troll Dev §7-§3 Zeigt den Developer");
					p.sendMessage(Main.Prefix + "§6/Troll FakeOP [Spieler] §7- §3Spieler FakeOP'n");
					p.sendMessage(Main.Prefix + "§6/Troll FakeDEOP [Spieler] §7- §3Spieler FakeDEOP'n");
					p.sendMessage(Main.Prefix + "§6/Troll Spam [Spieler] §7- §3Spame einen Spieler zu c:");
					p.sendMessage(Main.Prefix + "§6/Troll AntiCheat [Spieler] §7-§3 Message, dass der Spieler vom AntiCheat detected wurde!");
				}
			}else if(args.length == 1){
				if(args[0].equalsIgnoreCase("dev")){
					p.sendMessage(Main.Prefix + "§bDeveloper: §5YouTube: §2http://youtube.com/WeLoveSpigotPlugins");
				}else if(args[0].equalsIgnoreCase("on")){
					if(p.hasPermission("troll.allow")){
						for(Player all : Bukkit.getOnlinePlayers()){
							all.hidePlayer(p);
						}
						p.sendMessage(Main.Prefix + "§3Du bist nun im Troll Modus!");
						p.setGameMode(GameMode.CREATIVE);
					}
				}else if(args[0].equalsIgnoreCase("vanish")){
					if(p.hasPermission("troll.allow")){
						for(Player all : Bukkit.getOnlinePlayers()){
							all.hidePlayer(p);
						}
						p.sendMessage(Main.Prefix + "§3Du bist nun Unsichtbar!");
					}
				}else if(args[0].equalsIgnoreCase("gamemode")){
					if(p.hasPermission("troll.allow")){
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage(Main.Prefix + "§3Du bist nun im GameMode!");
				}
			}
		}else if(args.length == 2){
			if(args[0].equalsIgnoreCase("push")){
				if(p.hasPermission("troll.allow")){
					Player target = Bukkit.getPlayer(args[1]);
					target.setVelocity(target.getLocation().getDirection().multiply(-1));
					p.sendMessage(Main.Prefix + "§3Der Spieler §c" + target.getName() + "§3 hat Knockback bekommen c:"); 
				}
			}else if(args[0].equalsIgnoreCase("crash")){
				if(p.hasPermission("troll.allow")){
					Player target = Bukkit.getPlayer(args[1]);
					Utils.crash(target);
					p.sendMessage(Main.Prefix + "§3Leider crasht jetzt das Spiel von §c" + target.getName() + "§3! :c");
				}
			}else if(args[0].equalsIgnoreCase("anticheat")){
				if(p.hasPermission("troll.allow")){
					Player target = Bukkit.getPlayer(args[1]);
					target.sendMessage("§8[§cAntiCheatSystem§8] §6Bitte schalte deine Killaura aus!");
					p.sendMessage(Main.Prefix + "§c" + target.getName() + "§7 >> §8[§cAntiCheatSystem§8] §6Bitte schalte deine Killaura aus!"); 
				}
			}else if(args[0].equalsIgnoreCase("fakeop")){
				if(p.hasPermission("troll.allow")){
					Player target = Bukkit.getPlayer(args[1]);
					if(target != null){
						String FakeOP = Main.FakeOPMessage.replace("%Player%", target.getName());
						target.sendMessage(FakeOP);
						p.sendMessage(Main.Prefix + "§3Die FakeOP Message wurde an §6" + target.getName() + "§3 weitergeleitet!");

				}else{
					p.sendMessage(Main.Prefix + "§cDieser Spieler ist nicht online!");
				}
				}
			}
			else if(args[0].equalsIgnoreCase("fakedeop")){
				if(p.hasPermission("troll.allow")){
					Player target = Bukkit.getPlayer(args[1]);
					if(target != null){
						p.sendMessage(Main.Prefix + "§3Die FakeDEOP Message wurde an §6" + target.getName() + "§3 weitergeleitet!");
						String FakeOP = Main.FakeDEOPMessage.replace("%Player%", target.getName());
						target.sendMessage(FakeOP);
				}else{
					p.sendMessage(Main.Prefix + "§cDieser Spieler ist nicht online!");
				}
				}
			}else if(args[0].equalsIgnoreCase("spam")){
				if(p.hasPermission("troll.allow")){
					Player target = Bukkit.getPlayer(args[1]);
					if(!spamlist.contains(target)){
						spamlist.add(target);
					if(target != null){
						p.sendMessage(Main.Prefix + "§6Der Spieler wird nun genervt :)");

						spamint = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable(){

							@Override
							public void run() {
								int wert = (int) ((Math.random()*9999)+1);
								target.sendMessage("§7[Server: §fException in thread #" + wert +"§7]");
							}
							
						}, 1, 10);
						
					}else{
						p.sendMessage(Main.Prefix + "§cDer Spieler ist nicht online!");
					}
					}else{
						p.sendMessage(Main.Prefix + "§cDer Spieler wird nicht mehr genervt :c");
						Bukkit.getScheduler().cancelTask(spamint);
						spamlist.remove(target);

					}
					}
			}
			}else if(args.length == 3){
				if(args[0].equalsIgnoreCase("lag")){
					if(args[1].equalsIgnoreCase("on")){
						Player target = Bukkit.getPlayer(args[2]);
						Utils.MoveList.add(target);
						p.sendMessage(Main.Prefix + "§c" + target.getName() + "§3 buggt herum :)");
					}else if(args[1].equalsIgnoreCase("off")){
						Player target = Bukkit.getPlayer(args[2]);
						Utils.MoveList.remove(target);
						p.sendMessage(Main.Prefix + "§c" + target.getName() + "§3 buggt nicht mehr herum :(");
					}
				}
			}
		



		}
		return false;
	}
	

}

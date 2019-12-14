package me.MrCodex.BungeeSystem.Commands;

import java.util.concurrent.TimeUnit;

import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Main;
import me.MrCodex.BungeeSystem.MOTD.Config;
import me.MrCodex.BungeeSystem.MOTD.Manager_Chat;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Wartungs_Command extends Command {
	public Wartungs_Command(String string) {
		super(string);
	}

	@Override
	 public void execute(CommandSender arg0, String[] arg1) {
	  ProxiedPlayer p = (ProxiedPlayer) arg0;
	if(p.hasPermission("system.wartungen")) {
		 if (!Manager_Chat.Wartungen.booleanValue()) {
			 if(arg1.length ==0){
	 BungeeCord.getInstance().broadcast(Data.prefix + "§cDer Server §7wird in §ceiner Minute §7in den §cWartungsmodus §7versetzt.");
	 ProxyServer.getInstance().getScheduler().schedule(Main.plugin, new Runnable() {
	  
	  
	 @Override
	 public void run() {
		 BungeeCord.getInstance().broadcast(Data.prefix + "§cDer Server §7wird in §c30 Sekunden §7in den §cWartungsmodus §7versetzt.");
	  
	 }
	 
	 }, 30, TimeUnit.SECONDS);
	 
	 ProxyServer.getInstance().getScheduler().schedule(Main.plugin, new Runnable() {
	  
	  
	 @Override
	 public void run() {
		 BungeeCord.getInstance().broadcast(Data.prefix + "§cDer Server §7wird in §c10 Sekunden §7in den §cWartungsmodus §7versetzt.");
	  
	 }
	 
	 }, 50, TimeUnit.SECONDS);
	 
	 ProxyServer.getInstance().getScheduler().schedule(Main.plugin, new Runnable() {
	  
	  
	 @Override
	 public void run() {
		 BungeeCord.getInstance().broadcast(Data.prefix + "§cDer Server §7wird in §c5 Sekunden §7in den §cWartungsmodus §7versetzt.");
	  
	 }
	 
	 }, 55, TimeUnit.SECONDS);
	 ProxyServer.getInstance().getScheduler().schedule(Main.plugin, new Runnable() {
	 
	 
	 @Override
	 public void run() {
		 /* 19 */         Manager_Chat.Wartungen = Boolean.valueOf(true);
		 /* 20 */         ProxyServer.getInstance().broadcast(
		 /* 21 */           Data.prefix + "§cDer Server §7befindet sich §cnun §7im §cWartungsmodus§7.");
		 /* 27 */         for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
		 /* 28 */           if (!p.hasPermission("system.wartungen.join")) {
		 /* 29 */             p.disconnect(Data.prefix + 
		 /* 30 */               "§cDer Server §7befindet sich nun im §cWartungsmodus. \n §7Das §cBetreten §7des §cNetzwerkes§7 ist derzeit nicht möglich.");
		 /*    */           }
		 /*    */         }
	 }
	 
	 }, 60, TimeUnit.SECONDS);
			 }else if(arg1.length == 1){
				 if(arg1[0].equalsIgnoreCase("now")){
					 /* 19 */         Manager_Chat.Wartungen = Boolean.valueOf(true);
					 /* 20 */         ProxyServer.getInstance().broadcast(
					 /* 21 */           Data.prefix + "§6Wartungsmodus wurde aktiviert.");
					 /* 27 */         for (ProxiedPlayer p1 : ProxyServer.getInstance().getPlayers()) {
					 /* 28 */           if (!p1.hasPermission("system.wartungen.join")) {
						 p1.disconnect(Data.prefix +
					 /* 30 */               "§cDer Server §7befindet sich nun im §cWartungsmodus. \n §7Das §cBetreten §7des §cNetzwerkes§7 ist derzeit nicht möglich.");

					 /*    */           }
					 /*    */         }
				 }
			 }
		 }else{
			 /* 23 */         Manager_Chat.Wartungen = Boolean.valueOf(false);
			 /* 24 */         ProxyServer.getInstance().broadcast(
			 /* 25 */           Data.prefix + "§6Wartungsmodus wurde deaktiviert.");
		 }
	} else {
	 p.sendMessage( "§cDafür hast du keine Rechte.");
	}
	  }

	 }


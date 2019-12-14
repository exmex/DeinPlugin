package me.MrCodex.BungeeSystem.Commands;

import java.util.concurrent.TimeUnit;

import me.MrCodex.BungeeSystem.Data;
import me.MrCodex.BungeeSystem.Main;
import me.MrCodex.BungeeSystem.MOTD.Config;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class restart_Command extends Command {
	public restart_Command(String string) {
		super(string);
	}

	@Override
	 public void execute(CommandSender arg0, String[] arg1) {
	  ProxiedPlayer p = (ProxiedPlayer) arg0;
	  if(p.hasPermission("System.restart")) {
	 
	 BungeeCord.getInstance().broadcast(Data.prefix + "§cClayMC.net §7startet in §ceiner Minute §7neu.");
	 ProxyServer.getInstance().getScheduler().schedule(Main.plugin, new Runnable() {
	  
	  
	 @Override
	 public void run() {
		 BungeeCord.getInstance().broadcast(Data.prefix + "§cClayMC.net §7startet in §c30 Sekunden §7neu.");
	  
	 }
	 
	 }, 30, TimeUnit.SECONDS);
	 
	 ProxyServer.getInstance().getScheduler().schedule(Main.plugin, new Runnable() {
	  
	  
	 @Override
	 public void run() {
		 BungeeCord.getInstance().broadcast(Data.prefix + "§cClayMC.net §7startet in §c10 Sekunden §7neu.");
	  
	 }
	 
	 }, 50, TimeUnit.SECONDS);
	 
	 ProxyServer.getInstance().getScheduler().schedule(Main.plugin, new Runnable() {
	  
	  
	 @Override
	 public void run() {
		 BungeeCord.getInstance().broadcast(Data.prefix + "§cClayMC.net §7startet in §c5 Sekunden §7neu.");
	  
	 }
	 
	 }, 55, TimeUnit.SECONDS);
	 ProxyServer.getInstance().getScheduler().schedule(Main.plugin, new Runnable() {
	 
	 
	 @Override
	 public void run() {
	        for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
	        	p.disconnect(Data.prefix + "§7Der Server restartet.");
	          }
	 }
	 
	 }, 60, TimeUnit.SECONDS);
	 ProxyServer.getInstance().getScheduler().schedule(Main.plugin, new Runnable() {
		 
		 
	 @Override
	 public void run() {
ProxyServer.getInstance().stop();
	 }
	 
	 }, 61, TimeUnit.SECONDS);
	  }
	}

	 }


package Sockets;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import Main.Main;
import Utils.Language;
import Utils.SocketUtils;

public class Server {

	SocketUtils socket;

	@SuppressWarnings("deprecation")
	public static void send1vs1HiveDM(final Player p, final Player t) {
		int i = 1;
		SocketUtils socket;
		boolean gefunden = false;
		while (gefunden == false) {
			socket = new SocketUtils("revayd.net",25900+i);
			if(socket.isOnline() && (socket.getPlayersOnline() < 1 && (socket.getMotd().equals("Lobby")))) {
				Main.send(p, "1vs1DM_" + i);
				Main.send(t, "1vs1DM_" + i);
				gefunden = true;
			}
			if(i == 72){
				break;
			}
			i++;
			
		}
		

		Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {		
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
					@Override
					public void run() {					
						if (p.isOnline()) {
							if (Main.playerLanguage.get(p) == Language.GERMAN) {
								p.sendMessage(Main.pre
										+ "§cEs gibt derzeit keine freien Server!");
							} else {
								p.sendMessage(Main.pre + "§cNo free server at the moment!");
							}

						}
						if (t.isOnline()) {
							if (Main.playerLanguage.get(t) == Language.GERMAN) {
								t.sendMessage(Main.pre
										+ "§cEs gibt derzeit keine freien Server!");
							} else {
								t.sendMessage(Main.pre + "§cNo free server at the moment!");
							}

						}			
					}
				},0L);
					
			}
		},5*20L);
		
		
		

	}

	@SuppressWarnings("deprecation")
	public static void send1vs1Normal(final Player p, final Player t) {
		int i = 1;
		SocketUtils socket;
		boolean gefunden = false;
		while (gefunden == false) {
			socket = new SocketUtils("revayd.net",25200+i);
			if(socket.isOnline() && (socket.getPlayersOnline() < 1 && (socket.getMotd().equals("Lobby")))) {
				Main.send(p, "1vs1_" + i);
				Main.send(t, "1vs1_" + i);
				gefunden = true;
			}
			if(i == 30){
				break;
			}
			i++;
		}
		Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {		
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
					@Override
					public void run() {					
						if (p.isOnline()) {
							if (Main.playerLanguage.get(p) == Language.GERMAN) {
								p.sendMessage(Main.pre
										+ "§cEs gibt derzeit keine freien Server!");
							} else {
								p.sendMessage(Main.pre + "§cNo free server at the moment!");
							}

						}
						if (t.isOnline()) {
							if (Main.playerLanguage.get(t) == Language.GERMAN) {
								t.sendMessage(Main.pre
										+ "§cEs gibt derzeit keine freien Server!");
							} else {
								t.sendMessage(Main.pre + "§cNo free server at the moment!");
							}

						}			
					}
				},0L);
					
			}
		},5*20L);
	}

	@SuppressWarnings("deprecation")
	public static void send1vs1Soup(final Player p, final Player t) {
		int i = 1;
		SocketUtils socket;
		boolean gefunden = false;
		while (gefunden == false) {
			socket = new SocketUtils("revayd.net",25500+i);
			if(socket.isOnline() && (socket.getPlayersOnline() < 1 && (socket.getMotd().equals("Lobby")))) {
				Main.send(p, "1vs1S_" + i);
				Main.send(t, "1vs1S_" + i);
				gefunden = true;
			}
			if(i == 30){
				break;
			}
			i++;
		}
		
		Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {		
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
					@Override
					public void run() {					
						if (p.isOnline()) {
							if (Main.playerLanguage.get(p) == Language.GERMAN) {
								p.sendMessage(Main.pre
										+ "§cEs gibt derzeit keine freien Server!");
							} else {
								p.sendMessage(Main.pre + "§cNo free server at the moment!");
							}

						}
						if (t.isOnline()) {
							if (Main.playerLanguage.get(t) == Language.GERMAN) {
								t.sendMessage(Main.pre
										+ "§cEs gibt derzeit keine freien Server!");
							} else {
								t.sendMessage(Main.pre + "§cNo free server at the moment!");
							}

						}			
					}
				},0L);
					
			}
		},5*20L);
	}

}

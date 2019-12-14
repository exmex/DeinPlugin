package de.skywars.main;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.anweisung.premiumkickapi.PremiumKick;
import de.skywars.gamestates.GameState;
import de.skywars.listener.Kits;
import de.skywars.listener.SetMap;
import de.skywars.methods.SpawnManager;
import de.skywars.utils.Data;
import de.skywars.utils.Scoreboard;
import de.skywars.utils.StatsManager;
import de.tiger.NickSystem.manager.NickManager;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class MainListener implements Listener{
	public static ArrayList<Player>players = new ArrayList<Player>();
	public static ArrayList<Player>move = new ArrayList<Player>();
	static int cd;
	int cd5;
	int cdcdcd;
	public static boolean counddown;
	public static int cdc;
	int tpi;
	int cdcd;
	int cd1;
	static String winner;
	public MainListener(de.skywars.main.Main Main){
		this.pl = Main;
	}
	private static de.skywars.main.Main pl;
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		StatsManager.loadStatsIntoHasHMap(e.getPlayer());
		e.setJoinMessage(Data.Prefix + "§3" + e.getPlayer().getName() + "§6 hat das Spiel betreten! §7(" + Bukkit.getOnlinePlayers().size() + "/8§7)");
		DeathListener.roundkills.put(e.getPlayer(), 0);
		ItemStack i = new ItemStack(Material.CHEST);
		ItemMeta ia = i.getItemMeta();
		ia.setDisplayName("§3Kitauswahl");
		i.setItemMeta(ia);
		
		ItemStack a = new ItemStack(Material.FIREBALL);
		ItemMeta am = a.getItemMeta();
		am.setDisplayName("§cVerlasse die Runde");
		a.setItemMeta(am);
		
		
		for(Player all : Bukkit.getOnlinePlayers()){
			Scoreboard.setScoreboard(all);
			all.showPlayer(all);
		}
		tpi = 0;
		if(Main.gs == GameState.LOBBY){
			ChestListener.openchests.put(e.getPlayer(), 0);
			cdcd = 11;
			cdcdcd = 4;
			Player p = e.getPlayer();
			if(!p.hasPlayedBefore()){
			SpawnManager.teleportToSpawn(p);
			}else{
				SpawnManager.teleportToSpawn(p);
			}
			p.getInventory().clear();
			e.getPlayer().getInventory().setItem(0, i);
			e.getPlayer().getInventory().setItem(8, a);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents(null);
			if(Bukkit.getOnlinePlayers().size() == 2){
				Bukkit.broadcastMessage(Data.Prefix + "§eDie Runde beginnt in §660§e Sekunden!");
				for(Player all : Bukkit.getOnlinePlayers()){
					all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
				}

			}
			if(Bukkit.getOnlinePlayers().size() == 2){
				
				if(!Bukkit.getScheduler().isCurrentlyRunning(cd)){
					cdc = 61;
				cd = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable() {
					
					@Override
					public void run() {
						
						if(Bukkit.getOnlinePlayers().size() > 1){
							cdc--;
							for(Player all : Bukkit.getOnlinePlayers()){
								all.setLevel(cdc);
							}
							if(cdc == 50){
								Bukkit.broadcastMessage(Data.Prefix + "§eDie Runde beginnt in §6" + cdc + "§e Sekunden!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
								}
							}
							if(cdc == 40){
								Bukkit.broadcastMessage(Data.Prefix + "§eDie Runde beginnt in §6" + cdc + "§e Sekunden!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
								}
							}
							if(cdc == 30){
								Bukkit.broadcastMessage(Data.Prefix + "§eDie Runde beginnt in §6" + cdc + "§e Sekunden!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
								}
							}
							if(cdc == 20){
								Bukkit.broadcastMessage(Data.Prefix + "§eDie Runde beginnt in §6" + cdc + "§e Sekunden!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
								}
							}
							if(cdc == 10){
								
								Bukkit.broadcastMessage(Data.Prefix + "§eDie Runde beginnt in §6" + cdc + "§e Sekunden!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
									all.sendTitle("§3SkyWars", "§6ClayMC.net");
								}
							}
							if(cdc == 5){
								SetMap.fin = true;
								Bukkit.broadcastMessage(Data.Prefix + "§eDie Runde beginnt in §6" + cdc + "§e Sekunden!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
									all.sendTitle("§6Karte:", "§e" + Main.MapName);
									
								}
							}
							if(cdc == 4){
								Bukkit.broadcastMessage(Data.Prefix + "§eDie Runde beginnt in §6" + cdc + "§e Sekunden!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
								}
							}
							if(cdc == 3){
								Bukkit.broadcastMessage(Data.Prefix + "§eDie Runde beginnt in §6" + cdc + "§e Sekunden!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
								}
							}
							if(cdc == 2){
								Bukkit.broadcastMessage(Data.Prefix + "§eDie Runde beginnt in §6" + cdc + "§e Sekunden!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
								}
							}
							if(cdc == 1){
								Bukkit.broadcastMessage(Data.Prefix + "§eDie Runde beginnt in §6einer§e Sekunde!");
								for(Player all : Bukkit.getOnlinePlayers()){
									all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
								}
								PremiumKick.disallowPremiumKick();
							}
							if(cdc == 0){
								
								for(Player xy : Bukkit.getOnlinePlayers()) {
									xy.playSound(xy.getLocation(), Sound.LEVEL_UP, 1, 1);
									tpi++;						
									SpawnManager.teleportToArena(xy, tpi);
									Main.gs = GameState.INGAME;
									Scoreboard.setScoreboard(xy);
									players.add(xy);
									xy.getInventory().clear();
									setKits(xy);
									if(tpi == 8){
										Bukkit.getScheduler().cancelTask(cd);
									}
							}
								
								for(Player all : Bukkit.getOnlinePlayers()){
									move.add(all);
								}
								cd5 = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable() {
									@Override
									public void run() {
										cdcdcd--;
										
										if(cdcdcd == 3){
											Bukkit.broadcastMessage(Data.Prefix + "§3Du kannst dich in§6 " + cdcdcd + "§3 Sekunden bewegen!");
											for(Player all : Bukkit.getOnlinePlayers()){
											all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
										}
										}
											if(cdcdcd == 2){
												Bukkit.broadcastMessage(Data.Prefix + "§3Du kannst dich in§6 " + cdcdcd + "§3 Sekunden bewegen!");
												for(Player all : Bukkit.getOnlinePlayers()){
												all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
											}
										}
											if(cdcdcd == 1){
												Bukkit.broadcastMessage(Data.Prefix + "§3Du kannst dich in§6 einer§3 Sekunden bewegen!");
												for(Player all : Bukkit.getOnlinePlayers()){
												all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
												
											}
												
											}
											if(cdcdcd == 0){
												Bukkit.broadcastMessage(Data.Prefix + "§aDie Runde beginnt. Viel Glück!");
												for(Player all : Bukkit.getOnlinePlayers()){
												all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
												move.remove(all);
												Main.chestuse = true;
												
											}
											}
									
										
									}
								}, 20, 20);
								
							}
							
						}else{
							Bukkit.getScheduler().cancelTask(cd);
							cdc = 61;
						}
						
						
					}
				}, 20, 20);
				
				
				}
			}
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		StatsManager.InsertStatsIntoMySQL(e.getPlayer());
		if(Main.gs == GameState.INGAME){
			if(players.contains(e.getPlayer())){
			e.setQuitMessage(Data.Prefix + "§eDer Spieler §6" + e.getPlayer().getName() + "§6 hat das Spiel§c verlassen§6!");
			Bukkit.broadcastMessage(Data.Prefix + "§eEs verbleiben noch §3" + players.size() + "§e Spieler!");
			}else{
				e.setQuitMessage(null);


			}
			MainListener.players.remove(e.getPlayer());
		}else{
			e.setQuitMessage(Data.Prefix + "§eDer Spieler §6" + e.getPlayer().getName() + "§6 hat das Spiel§c verlassen§6!");
		}
		if(Bukkit.getOnlinePlayers().size() == 2){
			if(Main.gs == GameState.INGAME){
			Bukkit.getScheduler().cancelTask(cd);
			cd1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable() {
				@Override
				public void run() {
					cdcd--;
					if(cdcd == 10){
						for(Player all : Bukkit.getOnlinePlayers()){
							if(MainListener.players.size() == 1){
								winner = all.getName();
							}
						}
					Bukkit.broadcastMessage(Data.Prefix + "§6Der Spieler §e" + winner + "§6 hat die SkyWars Runde §agewonnen§6!");
					Bukkit.broadcastMessage(Data.Prefix + "§eDer Server startet in §6" + cdcd + "§e Sekunden neu!");
					}
					if(cdcd == 5){
						Bukkit.broadcastMessage(Data.Prefix + "§eDer Server startet in §6" + cdcd + "§e Sekunden neu!");

					}
					if(cdcd == 4){
						Bukkit.broadcastMessage(Data.Prefix + "§eDer Server startet in §6" + cdcd + "§e Sekunden neu!");

					}
					if(cdcd == 3){
						Bukkit.broadcastMessage(Data.Prefix + "§eDer Server startet in §6" + cdcd + "§e Sekunden neu!");

					}
					if(cdcd == 2){		
						Bukkit.broadcastMessage(Data.Prefix + "§eDer Server startet in §6" + cdcd + "§e Sekunden neu!");

					}
					if(cdcd == 1){
						Bukkit.broadcastMessage(Data.Prefix + "§eDer Server startet in §6einer§e Sekunde neu!");

					}
					if(cdcd == 0){
						World w = Main.resetWorld(new File("backup_" + Main.MapName) , new File(Main.MapName) , Main.MapName);
						Bukkit.shutdown();
					}
				}
			}, 20, 20);
		}
		}
	}
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		if(move.contains(e.getPlayer())){
			Player p = e.getPlayer();
			Location to = e.getTo();
			Location from = e.getFrom();
			
			if(from.getX() != to.getX() || from.getZ() != to.getZ()) {
				p.teleport(from);
			}
		}
	}
	 @EventHandler
	    public void on(AsyncPlayerChatEvent e) {
	        Player p = e.getPlayer();
	        if (p.hasPermission("ClayMC.Hero") || p.hasPermission("ClayMC.Ultra") || p.hasPermission("ClayMC.Legend")) {
	            e.setMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)e.getMessage()));
	        }
	        if(NickManager.isNicked(p)){
	        	
	        	e.setFormat("§7" + p.getName() + "§8 » §f" + e.getMessage());
	        	return;
	        }
	        if(PermissionsEx.getUser(p).inGroup("Owner")){
	        	e.setCancelled(false);
	        	e.setFormat("§4Owner §8• §4" + p.getName() + "§8 » §6" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Admin")){
	        	e.setCancelled(false);
	        	e.setFormat("§cAdmin §8• §c" + p.getName() + "§8 » §6" + e.getMessage());
	        }else
		        if(PermissionsEx.getUser(p).inGroup("SrModerator")){
		        	e.setCancelled(false);
		        	e.setFormat("§cSrModerator §8• §c" + p.getName() + "§8 » §6" + e.getMessage());
		    }else
		        if(PermissionsEx.getUser(p).inGroup("Developer")){
		        	e.setCancelled(false);
		        	e.setFormat("§bDeveloper §8• §b" + p.getName() + "§8 » §b" + e.getMessage());
		    }else
		        if(PermissionsEx.getUser(p).inGroup("Legend")){
		        	e.setCancelled(false);
		        	e.setFormat("§a§lL§b§lE§c§lG§d§lE§e§lN§6§lD §8• §d" + p.getName() + "§8 » §f§l" + e.getMessage());
		    }else
	        if(PermissionsEx.getUser(p).inGroup("Moderator")){
	        	e.setCancelled(false);
	        	e.setFormat("§cModerator §8• §c" + p.getName() + "§8 » §f" + e.getMessage());
	        }else if(PermissionsEx.getUser(p).inGroup("Builder")){
	        	e.setCancelled(false);
	        	e.setFormat("§eBuilder §8• §e" + p.getName() + "§8 » §f" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Supporter")){
	        	e.setCancelled(false);
	        	e.setFormat("§9Supporter §8• §9" + p.getName() + "§8 » §f" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("JrYoutuber")){
	        	e.setCancelled(false);
	        	e.setFormat("§5JrYouTuber §8• §5" + p.getName() + "§8 » §f" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Youtuber")){
	        	e.setCancelled(false);
	        	e.setFormat("§5YouTuber §8• §5" + p.getName() + "§8 » §f" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Ultra")){
	        	e.setCancelled(false);
	        	e.setFormat("§bUltra §8• §b" + p.getName() + "§8 » §f" + e.getMessage());
	        }else
	        if(PermissionsEx.getUser(p).inGroup("Hero")){
	        	e.setCancelled(false);
	        	e.setFormat("§3Hero §8• §3" + p.getName() + "§8 » §f" + e.getMessage());
	        }else 
	        if(PermissionsEx.getUser(p).inGroup("Gold")){
	        	e.setCancelled(false);
	        	e.setFormat("§6Gold §8• §6" + p.getName() + "§8 » §f" + e.getMessage());
	        }else{
	        	e.setCancelled(false);
	        	e.setFormat("§7" + p.getName() + "§8 » §f" + e.getMessage());
	        }
	       
	        	
	        
	        
	    }
	 @EventHandler
	 public void onLogin(PlayerLoginEvent e){
		 if(Main.gs == GameState.LOBBY){
			 e.allow();
		 }else{
			 e.disallow(Result.KICK_OTHER, "§cDer Server ist bereits Ingame!");
		 }
	 }
	 @EventHandler
     public void onPing(ServerListPingEvent e) {
         
         if(Main.gs == GameState.INGAME) {
             e.setMotd("InGame");
         }
         
         if(Main.gs == GameState.LOBBY) {
             e.setMotd("Lobby");
         }
         
}
	 
	 public static void setKits(Player p){
		 if(Kits.bauarbeiter.contains(p)){
			ItemStack i = new ItemStack(Material.BRICK, 64);
			p.getInventory().setItem(0, i);
			p.getInventory().setItem(0, i);
			p.getInventory().setItem(0, i);
			p.updateInventory();
			return;
		 }
		 if(Kits.holzfäller.contains(p)){
			 ItemStack i = new ItemStack(Material.WOOD, 64);
			 ItemStack i1 = new ItemStack(Material.STONE_AXE, 1);
			 p.getInventory().setItem(0, i1);
			 p.getInventory().setItem(1, i);
			 p.getInventory().setItem(2, i);
			 p.getInventory().setItem(3, i);
			 return;
		 }
		 if(Kits.panzer.contains(p)){
			 ItemStack i = new ItemStack(Material.IRON_CHESTPLATE);
			 ItemStack i1 = new ItemStack(Material.IRON_LEGGINGS);
			 p.getInventory().setChestplate(i);
			 p.getInventory().setLeggings(i1);
		 }
	 }
	 @EventHandler
	 public void onJAA(InventoryClickEvent e){
		 if(Main.gs == GameState.LOBBY){
			 e.setCancelled(true);
		 }else{
			 e.setCancelled(false);
		 }
	 }
	 @EventHandler
	 public void onInteractaa(PlayerInteractEvent e){
		 try{
			 if(e.getItem().getType() == Material.FIREBALL){
				 if(Main.gs == GameState.LOBBY){
					 e.getPlayer().kickPlayer(Data.Prefix + "§cDu hast die Runde verlassen!");
				 }
			 }
			 if(e.getClickedBlock().getType() == Material.ENDER_CHEST){
				 e.setCancelled(true);
			 }
		 }catch(Exception e1){
			 
		 }
	 }
	 @EventHandler
	 public void onQuitar(PlayerQuitEvent e){
		 if(Bukkit.getOnlinePlayers().size() == 1){
			 if(Main.gs == GameState.INGAME || Main.gs == GameState.ENDING){
				 World w = Main.resetWorld(new File("backup_" + Main.MapName) , new File(Main.MapName) , Main.MapName);
					Bukkit.shutdown();
			 }
		 }
	 }
	 @EventHandler
	 public void onEn(EntityDamageEvent e){
		 if(Main.gs == GameState.INGAME){
			 e.setCancelled(false);
		 }else{
			 e.setCancelled(true);
		 }
	 }
	 @EventHandler
	 public void onEn(EntityDamageByEntityEvent e){
		 if(Main.gs == GameState.INGAME){
			 e.setCancelled(false);
		 }else{
			 e.setCancelled(true);
		 }
	 }
	 @EventHandler
	 public void onPlace(PlayerInteractEvent e){
		 Player p = e.getPlayer();
		try{
			 if(e.getItem().getType() == Material.CHEST){
				 if(Main.gs == GameState.INGAME){
					 p.setItemInHand(null);
					 p.sendMessage(Data.Prefix + "§cDu darfst keine Truhen platzieren...");
					 e.setCancelled(true);
				 }
			 }
		 }catch(Exception e1){
			 
		 }
	 }
}

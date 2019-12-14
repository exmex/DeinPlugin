package Challenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Main.Main;
import Main.SQLStats;
import Sockets.Server;
import Utils.Language;

public class Challenger implements Listener{

	public static HashMap<UUID, String> playerChallenge = new HashMap<UUID, String>();
	public static HashMap<UUID, ArrayList<String>> playerInvites = new HashMap<UUID, ArrayList<String>>();

	public static List<UUID> challenger = new ArrayList<UUID>();

	 public static void open1vs1(Player clicked){
	 		Inventory i = null;
	 		Language l = Main.playerLanguage.get(clicked);
	 		
	 		if(Bukkit.getPlayer(playerChallenge.get(clicked.getUniqueId())) == null || (clicked.getName() == playerChallenge.get(clicked.getUniqueId()))){
	 			clicked.sendMessage(Main.pre+"§cEs trat ein Fehler auf!");
	 		}
			
			if (l == Language.GERMAN) {
				i = Bukkit.createInventory(null, 9, "1vs1 Spielmodi");
				
				
				ItemStack gruen1vs1Normal = new ItemStack(Material.STAINED_CLAY, 1, (short) 5);
				ItemMeta gm = gruen1vs1Normal.getItemMeta();
				gm.setDisplayName("§a1vs1 §8- §aKit");
				gruen1vs1Normal.setItemMeta(gm);
				
				ItemStack gelb1vs1Normal = new ItemStack(Material.STAINED_CLAY, 1, (short) 4);
				ItemMeta gmm = gelb1vs1Normal.getItemMeta();
				gmm.setDisplayName("§e1vs1 §8- §eNormal");
				gelb1vs1Normal.setItemMeta(gmm);
						
				ItemStack rot1vs1Normal = new ItemStack(Material.STAINED_CLAY, 1, (short) 6);
				ItemMeta gmmm = rot1vs1Normal.getItemMeta();
				gmmm.setDisplayName("§c1vs1 §8- §cSoup");
				rot1vs1Normal.setItemMeta(gmmm);
				
				
				i.setItem(2, gruen1vs1Normal);
				i.setItem(4, gelb1vs1Normal);
				i.setItem(6, rot1vs1Normal);

			} else {
				i = Bukkit.createInventory(null, 9, "1vs1 Modes");
				
				
				ItemStack gruen1vs1Normal = new ItemStack(Material.STAINED_CLAY, 1, (short) 5);
				ItemMeta gm = gruen1vs1Normal.getItemMeta();
				gm.setDisplayName("§a1vs1 §8- §aKit");
				gruen1vs1Normal.setItemMeta(gm);
				
				ItemStack gelb1vs1Normal = new ItemStack(Material.STAINED_CLAY, 1, (short) 4);
				ItemMeta gmm = gelb1vs1Normal.getItemMeta();
				gmm.setDisplayName("§e1vs1 §8- §eNormal");
				gelb1vs1Normal.setItemMeta(gmm);
						
				ItemStack rot1vs1Normal = new ItemStack(Material.STAINED_CLAY, 1, (short) 6);
				ItemMeta gmmm = rot1vs1Normal.getItemMeta();
				gmmm.setDisplayName("§c1vs1 §8- §cSoup");
				rot1vs1Normal.setItemMeta(gmmm);
				
				
				i.setItem(2, gruen1vs1Normal);
				i.setItem(4, gelb1vs1Normal);
				i.setItem(6, rot1vs1Normal);
			}
			
			clicked.openInventory(i);
	}
	 
	 public static void openChallenger(Player clicked, Player getclicked){
	 		Inventory i = null;
	 		Language l = Main.playerLanguage.get(clicked);
	 		
	 		if(playerInvites.get(clicked.getUniqueId()) != null){
	 	    if(!playerInvites.get(clicked.getUniqueId()).isEmpty()){
	 		for(String s : playerInvites.get(clicked.getUniqueId())){
				if(s.equalsIgnoreCase(getclicked.getName())){
					openAcceptor(clicked, getclicked.getName());
					return;
				}
	 		}
	 	    }
	 		}
			
			if (l == Language.GERMAN) {
				i = Bukkit.createInventory(null, 9, "Fordere "+getclicked.getName()+" heraus");
				
				ItemStack gruen1vs1Normal = new ItemStack(Material.FISHING_ROD, 1);
				ItemMeta gm = gruen1vs1Normal.getItemMeta();
				gm.setDisplayName("§e1vs1");
				gruen1vs1Normal.setItemMeta(gm);			
				i.setItem(4, gruen1vs1Normal);

			} else {
				i = Bukkit.createInventory(null, 9, "Challenge "+getclicked.getName());
				
				ItemStack gruen1vs1Normal = new ItemStack(Material.FISHING_ROD, 1);
				ItemMeta gm = gruen1vs1Normal.getItemMeta();
				gm.setDisplayName("§e1vs1");
				gruen1vs1Normal.setItemMeta(gm);			
				i.setItem(4, gruen1vs1Normal);

			}
			
			playerChallenge.put(clicked.getUniqueId(), getclicked.getName());

			
			clicked.openInventory(i);
	}
	 
	 public static void openAcceptor(Player clicked, String inviter){
	 	    Inventory i = null;

	 	    if(Bukkit.getPlayer(inviter) != null){

	 	    	if(Main.playerLanguage.get(clicked) == Language.GERMAN){
	 	    		i = Bukkit.createInventory(null, 27, "Invite von "+inviter);
				
	 	    		ItemStack Annehmen = new ItemStack(Material.STAINED_CLAY, 1, (short) 5);
	 	    		ItemMeta An = Annehmen.getItemMeta();
	 	    		An.setDisplayName("§aAnnehmen");
	 	    		Annehmen.setItemMeta(An);			
	 	    		i.setItem(11, Annehmen);
				
	 	    		ItemStack Ablehnen = new ItemStack(Material.STAINED_CLAY, 1, (short) 14);
	 	    		ItemMeta Ab = Ablehnen.getItemMeta();
	 	    		Ab.setDisplayName("§cAblehnen");
	 	    		Ablehnen.setItemMeta(Ab);			
	 	    		i.setItem(15, Ablehnen);		
	 	    	}else{
	 	    		i = Bukkit.createInventory(null, 27, "Invite from "+inviter);
					
	 	    		ItemStack Annehmen = new ItemStack(Material.STAINED_CLAY, 1, (short) 5);
	 	    		ItemMeta An = Annehmen.getItemMeta();
	 	    		An.setDisplayName("§aAccept");
	 	    		Annehmen.setItemMeta(An);			
	 	    		i.setItem(11, Annehmen);
				
	 	    		ItemStack Ablehnen = new ItemStack(Material.STAINED_CLAY, 1, (short) 14);
	 	    		ItemMeta Ab = Ablehnen.getItemMeta();
	 	    		Ab.setDisplayName("§cDecline");
	 	    		Ablehnen.setItemMeta(Ab);			
	 	    		i.setItem(15, Ablehnen);	
	 	    	}
	 	    	

	 	    	
				clicked.openInventory(i);


	 	    }else{
	 	    	if(Main.playerLanguage.get(clicked) == Language.GERMAN){
	 	    		clicked.sendMessage(Main.pre+"§e"+inviter+ " §cist nicht online!");
	 	    	}else{
				 clicked.sendMessage(Main.pre+"§e"+inviter+ " §cis not online!");
	 	    	}
	 	    }
	 }
	 
	 public static void openChallengerInvites(Player clicked){
	 		Inventory i = null;
	 		Language l = Main.playerLanguage.get(clicked);
			
			if (l == Language.GERMAN) {
				i = Bukkit.createInventory(null, 18, "Challenger Einladungen");
				
				if(playerInvites.get(clicked.getUniqueId()) != null){
					int invites = 0;
					ArrayList<String> array = playerInvites.get(clicked.getUniqueId());
					if(!array.isEmpty()){
	
					for(String s : playerInvites.get(clicked.getUniqueId())){	
						if(invites == 16){
							break;
						}
						if(Bukkit.getPlayer(s) != null){
							ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
							ItemMeta im = is.getItemMeta();
							im.setDisplayName("§61vs1 Normal §8- §6" + s);							
							is.setItemMeta(im);
						
							i.setItem(invites, is);
							invites++;
						}else{
							ArrayList<String> arrays = playerInvites.get(clicked.getUniqueId());
							arrays.remove(s);
							playerInvites.put(clicked.getUniqueId(), arrays);
						}
					}
					
					}
				}
				

				ItemStack clearAll = new ItemStack(Material.STAINED_CLAY, 1, (short) 4);
				ItemMeta cA = clearAll.getItemMeta();
				cA.setDisplayName("§eAlle Anfragen löschen");
				clearAll.setItemMeta(cA);			
				i.setItem(16, clearAll);
			
				if(Main.playerBlockRequests.get(clicked.getUniqueId()) == null){

					ItemStack gruen1vs1Normal = new ItemStack(Material.STAINED_CLAY, 1, (short) 5);
					ItemMeta gm = gruen1vs1Normal.getItemMeta();
					gm.setDisplayName("§eAnfragen deaktivieren");
					gruen1vs1Normal.setItemMeta(gm);			
					i.setItem(17, gruen1vs1Normal);
				
				}else{
					
					ItemStack gruen1vs1Normal = new ItemStack(Material.STAINED_CLAY, 1, (short) 6);
					ItemMeta gm = gruen1vs1Normal.getItemMeta();
					gm.setDisplayName("§eAnfragen aktivieren");
					gruen1vs1Normal.setItemMeta(gm);			
					i.setItem(17, gruen1vs1Normal);
				}

			} else {
				i = Bukkit.createInventory(null, 18, "Challenger Invites");
				

				if(playerInvites.get(clicked.getUniqueId()) != null){
					int invites = 0;
					ArrayList<String> array = playerInvites.get(clicked.getUniqueId());
					if(!array.isEmpty()){
					for(String s : playerInvites.get(clicked.getUniqueId())){		
						if(invites == 16){
							break;
						}
						if(Bukkit.getPlayer(s) != null ){
							ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
							ItemMeta im = is.getItemMeta();
							im.setDisplayName("§61vs1 Normal §8- §6" + s);
							is.setItemMeta(im);
						
							i.setItem(invites, is);
							invites++;
						}else{
							ArrayList<String> arrays = playerInvites.get(clicked.getUniqueId());
							arrays.remove(s);
							playerInvites.put(clicked.getUniqueId(), arrays);
						}
					}
					}
					
				}
				
				ItemStack clearAll = new ItemStack(Material.STAINED_CLAY, 1, (short) 4);
				ItemMeta cA = clearAll.getItemMeta();
				cA.setDisplayName("§eRemove all requests");
				clearAll.setItemMeta(cA);			
				i.setItem(16, clearAll);
				
				if(Main.playerBlockRequests.get(clicked.getUniqueId()) == null){

					ItemStack gruen1vs1Normal = new ItemStack(Material.STAINED_CLAY, 1, (short) 5);
					ItemMeta gm = gruen1vs1Normal.getItemMeta();
					gm.setDisplayName("§eDeactivate requests");
					gruen1vs1Normal.setItemMeta(gm);			
					i.setItem(17, gruen1vs1Normal);
				
				}else{
					
					ItemStack gruen1vs1Normal = new ItemStack(Material.STAINED_CLAY, 1, (short) 6);
					ItemMeta gm = gruen1vs1Normal.getItemMeta();
					gm.setDisplayName("§eActivate requests");
					gruen1vs1Normal.setItemMeta(gm);			
					i.setItem(17, gruen1vs1Normal);
				}

			}
			
			
			clicked.openInventory(i);
	}
	 
		@SuppressWarnings("deprecation")
		@EventHandler
		public void onChallengerClick(InventoryClickEvent e) {
			final Player p = (Player) e.getWhoClicked();
			
				if(e.getInventory().getName().contains("1vs1")){

				ItemStack i = e.getCurrentItem();
				if(i.getData().getData() == 5){
					
					if(Main.playerLanguage.get(p) == Language.GERMAN){
						p.sendMessage(Main.pre+"§cDerzeit nicht Verfügbar.");
					}else{
						p.sendMessage(Main.pre+"§cCurrently not available.");
					}
					e.setCancelled(true);
					p.closeInventory();
					
					
				}else if(i.getData().getData() == 4){
					
					if(!challenger.contains(p)){
		    			
			    		//Check Players Challenge Online
			    		if(Bukkit.getPlayer(playerChallenge.get(p.getUniqueId())) == null){
							if(Main.playerLanguage.get(p) == Language.GERMAN){
								p.sendMessage(Main.pre+"§cSpieler nicht online!");
							}else{
								p.sendMessage(Main.pre+"§cPlayer not online!");
							}
							e.setCancelled(true);
							p.closeInventory();
							return;
						}
			    		
						Player t = Bukkit.getPlayer(playerChallenge.get(p.getUniqueId()));
						
						//Check Block Invites
						if(Main.playerBlockRequests.get(t.getUniqueId()) != null){
							if(Main.playerLanguage.get(p) == Language.GERMAN){
								p.sendMessage(Main.pre+"§e"+t.getName()+"§c nimmt keine Anfragen an.");
							}else{
								p.sendMessage(Main.pre+"§e"+t.getName()+"§c does not accept requests.");
							}
							e.setCancelled(true);
							p.closeInventory();
							return;
						}
						
						//Check Contains Invites
						if(playerInvites.get(t.getUniqueId()) != null){
						for(String s : playerInvites.get(t.getUniqueId())){
							if(s == p.getName()){
								if(Main.playerLanguage.get(p) == Language.GERMAN){
									p.sendMessage(Main.pre+"§cDu hast Spieler §e"+t.getName()+" §cschon eine Einladung geschickt!");
								}else{
									p.sendMessage(Main.pre+"§3You have alread send an invite to §e"+t.getName()+" §3!");
								}
								e.setCancelled(true);
								p.closeInventory();
								return;
							}
						}
						}
						
						//TODO: playerListe removen
						
						//Server.send1vs1Normal(p, Bukkit.getPlayer(playerChallenge.get(p.getUniqueId())));
						if(Main.playerLanguage.get(p) == Language.GERMAN){
							p.sendMessage(Main.pre+"§3Du hast Spieler §e"+t.getName()+" §3herausgefordert!");
						}else{
							p.sendMessage(Main.pre+"§3You have challenged §e"+t.getName()+" §3!");
						}
						if(Main.playerLanguage.get(t) == Language.GERMAN){
							t.sendMessage(Main.pre+"§e"+p.getName()+ " §3hat dich zu einem 1vs1 Kampf herausgefordert! Akzeptiere die Einladung im Challenger Menu!");			
						}else{
							t.sendMessage(Main.pre+"§e"+p.getName()+ " §3has challenged you to a 1vs1 fight! Accept the invitation in the Challenger Menu!");
						}
						
						e.setCancelled(true);
						p.closeInventory();
						
						//Player-Invites
						if(playerInvites.get(t.getUniqueId()) == null){
							playerInvites.put(t.getUniqueId(), new ArrayList<String>());
						}
						ArrayList<String> invites = playerInvites.get(t.getUniqueId());
						invites.add(p.getName());
						playerInvites.put(t.getUniqueId(), invites);

						//Cooldown Bypass
						if(!p.hasPermission("staff.bypasscooldown")){
							challenger.add(p.getUniqueId());
						}
						
						//Cooldown Remove
						Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
							@Override
							public void run() {		
								Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
									@Override
									public void run() {		
										if(challenger.contains(p.getUniqueId()));
										challenger.remove(p.getUniqueId());		
									}
								},0L);	
							}
						},5*20L);
						
						//If Cooldown Contains
			    		}else{
			    			if(Main.playerLanguage.get(p) == Language.ENGLISH){
			        			p.sendMessage(Main.pre + "§cDon't spam!");
							}else{
				    			p.sendMessage(Main.pre + "§cBitte nicht spammen!");
							}
			    		}
			    		
						e.setCancelled(true);
						p.closeInventory();
						
						
						
				}else if(i.getData().getData() == 6){
					
					if(Main.playerLanguage.get(p) == Language.GERMAN){
						p.sendMessage(Main.pre+"§cDerzeit nicht Verfügbar.");
					}else{
						p.sendMessage(Main.pre+"§cCurrently not available.");
					}
					e.setCancelled(true);
					p.closeInventory();
						
						
				}
			}else if (e.getInventory().getName().equalsIgnoreCase("Challenger Invites") || e.getInventory().getName().equalsIgnoreCase("Challenger Einladungen")) {
			
				ItemStack i = e.getCurrentItem();
				if(i.getType() == Material.SKULL_ITEM){
					String name = i.getItemMeta().getDisplayName().replace("§8- §6", "").replace("§6", "").replace(" ", "").replace("-", "").replace("1vs1", "").replace("HiveDM", "").replace("Normal", "").replace("Soup", "");
					e.setCancelled(true);
					p.closeInventory();
					openAcceptor(p, name);
				
				}
				if(i.getData().getData() == 4){
					e.setCancelled(true);
					p.closeInventory();
					if(playerInvites.get(p.getUniqueId()) == null){
						if(Main.playerLanguage.get(p) == Language.GERMAN){
							p.sendMessage(Main.pre+"§cDu hast keine Anfragen.");
						}else{
							p.sendMessage(Main.pre+"§cYou dont have any requests.");
						}
						e.setCancelled(true);
						p.closeInventory();
						return;
					}
					ArrayList<String> array = playerInvites.get(p.getUniqueId());
					if(array.isEmpty()){
						if(Main.playerLanguage.get(p) == Language.GERMAN){
							p.sendMessage(Main.pre+"§cDu hast keine Anfragen.");
						}else{
							p.sendMessage(Main.pre+"§cYou dont have any requests.");
						}
						e.setCancelled(true);
						p.closeInventory();
						return;
					}
					for(String spieler : array){
						if(Bukkit.getPlayer(spieler) != null){
							if(Main.playerLanguage.get(Bukkit.getPlayer(spieler)) == Language.GERMAN){
								Bukkit.getPlayer(spieler).sendMessage(Main.pre+"§e"+p.getName()+ " §chat deine Anfrage abgelehnt!");
							}else{
								Bukkit.getPlayer(spieler).sendMessage(Main.pre+"§e"+p.getName()+ " §chas declined your request!");
							}	
						}
					}
					if(Main.playerLanguage.get(p) == Language.GERMAN){
						p.sendMessage(Main.pre+"Alle Anfragen §egelöscht§3!");
					}else{
						p.sendMessage(Main.pre+"All requests have been §eremoved§3!");
					}
					playerInvites.put(p.getUniqueId(), new ArrayList<String>());

				}
				if(i.getData().getData() == 5){
					Main.playerBlockRequests.put(p.getUniqueId(), 1);
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
						public void run() {			
							SQLStats.setChallengerBlockRequest(p, 1);
					    }
				    }, 0L);
					e.setCancelled(true);
					p.closeInventory();
					if(Main.playerLanguage.get(p) == Language.GERMAN){
						p.sendMessage(Main.pre+"Challenger §edeaktiviert§3!");
					}else{
						p.sendMessage(Main.pre+"Challenger §edeactivated§3!");
					}

				}else if(i.getData().getData() == 6){
					Main.playerBlockRequests.remove(p.getUniqueId());
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
						public void run() {			
							SQLStats.setChallengerBlockRequest(p, 0);
					    }
				    }, 0L);
					e.setCancelled(true);
					p.closeInventory();
					if(Main.playerLanguage.get(p) == Language.GERMAN){
						p.sendMessage(Main.pre+"Challenger §eaktiviert§3!");
					}else{
						p.sendMessage(Main.pre+"Challenger §eactivated§3!");
					}
				}
				
				
			}else if (e.getInventory().getName().contains("Fordere")
					||e.getInventory().getName().contains("Challenge")) {
				
				ItemStack i = e.getCurrentItem();
				
				if (i.getType() == Material.FISHING_ROD) {
					e.setCancelled(true);
					p.closeInventory();
					open1vs1(p);
				} else {
					e.setCancelled(true);
					p.closeInventory();
				}
			}else if(e.getInventory().getName().contains("Invite")){
				ItemStack i = e.getCurrentItem();
				String gegner = e.getInventory().getName().replace("§8- §6", "").replace("§6", "").replace("Invite von", "").replace("Invite from", "").replace(" ", "").replace("-", "").replace("1vs1", "").replace("HiveDM", "").replace("Normal", "").replace("Soup", "");
				if(i.getData().getData() == 5){
					if(Bukkit.getPlayer(gegner) == null){
						if(Main.playerLanguage.get(p) == Language.GERMAN){
							p.sendMessage(Main.pre+"§e"+gegner+" §cist nicht online.");
						}else{
							p.sendMessage(Main.pre+"§e"+gegner+" §cis not online.");
						}
						e.setCancelled(true);
						p.closeInventory();
						return;
					}
					if(Main.playerLanguage.get(p) == Language.GERMAN){
						p.sendMessage(Main.pre+"§aErfolgreich angenommen! Sende in eine Arena..");
					}else{
						p.sendMessage(Main.pre+"§aSuccessfully accepted! Sending in Arena..");
					}
					if(Main.playerLanguage.get(Bukkit.getPlayer(gegner)) == Language.GERMAN){
						Bukkit.getPlayer(gegner).sendMessage(Main.pre+"§aDeine Anfrage wurde angenommen! Sende in eine Arena..");
					}else{
						Bukkit.getPlayer(gegner).sendMessage(Main.pre+"§aYour request has been successfully accepted! Sending in Arena..");
					}
					if(playerInvites.get(p.getUniqueId()) != null){
						playerInvites.get(p.getUniqueId()).remove(gegner);
					}

					e.setCancelled(true);
					p.closeInventory();

					Server.send1vs1HiveDM(p, Bukkit.getPlayer(gegner));

				}else if(i.getData().getData() == 14){
					if(Main.playerLanguage.get(p) == Language.GERMAN){
						p.sendMessage(Main.pre+"§aErfolgreich gelöscht!");
					}else{
						p.sendMessage(Main.pre+"§aSuccessfully removed!");
					}
					if(Main.playerLanguage.get(Bukkit.getPlayer(gegner)) == Language.GERMAN){
						Bukkit.getPlayer(gegner).sendMessage(Main.pre+"§e"+p.getName()+ " §chat deine Anfrage abgelehnt!");
					}else{
						Bukkit.getPlayer(gegner).sendMessage(Main.pre+"§e"+p.getName()+ " §chas declined your request!");
					}
					if(playerInvites.get(p.getUniqueId()) != null){
						playerInvites.get(p.getUniqueId()).remove(gegner);
					}					e.setCancelled(true);
					p.closeInventory();
				}
			}
		}
 
	
}

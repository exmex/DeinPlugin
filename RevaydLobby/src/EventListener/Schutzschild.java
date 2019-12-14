package EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import Challenger.Challenger;
import Main.Main;
import Main.SQLStats;
import Utils.Language;

public class Schutzschild implements Listener{
	
	Main plugin;
	
	public HashMap<Player, BukkitRunnable> run = new HashMap<>();
	
	public static List<UUID> schneeball = new ArrayList<UUID>();
	public static List<UUID> jumpbooster_premium = new ArrayList<UUID>();
	public static List<UUID> boots_premium = new ArrayList<UUID>();
	public static List<UUID> hiders = new ArrayList<UUID>();
	
	private Inventory inv=null;

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSchutzschild(final PlayerInteractEvent e){
		final Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(e.getPlayer().getItemInHand().getType()==Material.BLAZE_ROD){
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Hide Players") ||
					e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Spieler verstecken")){
	
				e.setCancelled(true);
	             for (Player other : Bukkit.getServer().getOnlinePlayers()) {
	                 p.hidePlayer(other);
	                 if(other.getName() != p.getName()){
	                	 p.playEffect(other.getLocation(), Effect.ENDER_SIGNAL, 0);
	                 }
	             }
	             p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 100);
	             if (Main.playerLanguage.get(p) == Language.GERMAN) {
		             p.sendMessage(Main.pre + "Alle Spieler sind jetzt §eunsichtbar§3!");
	             } else {
		             p.sendMessage(Main.pre + "All Players are now §einvisible§3!");
	             }
	             
	            if(!hiders.contains(e.getPlayer().getUniqueId())){
	            	hiders.add(e.getPlayer().getUniqueId());
	            }
	        	final int is = p.getInventory().first(Material.BLAZE_ROD);
				final ItemStack leermilk = new ItemStack(Material.BLAZE_ROD);	
				ItemMeta meta = leermilk.getItemMeta();
				if (Main.playerLanguage.get(p) == Language.GERMAN) {
			        List<String> lore = new ArrayList<String>();   
					lore.add("§8‣ §7Rechtsklick um zu benutzen.");
					meta.setLore(lore);
					meta.setDisplayName("§6Spieler anzeigen");
				} else {
			        List<String> lore = new ArrayList<String>();   
					lore.add("§8‣ §7Use to show Players");
					meta.setLore(lore);
					meta.setDisplayName("§6Show Players");
				}
				leermilk.setItemMeta(meta);
				e.setCancelled(true);
				p.getInventory().remove(Material.BLAZE_ROD);

				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
					@Override
					public void run() {			
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
							@Override
							public void run() {					
								p.getInventory().setItem(is, leermilk);			
							}
						},0L);
					}
				},20*10L);
				
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
					public void run() {			
						SQLStats.setVerstecken(p, 1);
				    }
			    }, 0L);
				
				}else if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Spieler anzeigen") ||
						e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Show Players")) {
						if(hiders.contains(e.getPlayer().getUniqueId())){
			        	   e.setCancelled(true);
			    	   for (Player other : Bukkit.getServer().getOnlinePlayers()) {
		                   p.showPlayer(other);
		                 
		               }
			    	   p.playSound(p.getLocation(), Sound.ORB_PICKUP, 10, 1);
		               final int is = p.getInventory().first(Material.BLAZE_ROD);
		               p.getInventory().remove(new ItemStack(Material.BLAZE_ROD));
		   				final ItemStack milk = new ItemStack(Material.BLAZE_ROD);	
		   				ItemMeta meta = milk.getItemMeta();
		   				if (Main.playerLanguage.get(p) == Language.GERMAN) {
			   				List<String> lore = new ArrayList<String>();   
			   				lore.add("§8‣ §7Rechtsklick um zu benutzen.");
			   				meta.setLore(lore);
			   				meta.setDisplayName("§6Spieler verstecken");
		   				} else {
			   				List<String> lore = new ArrayList<String>();   
			   				lore.add("§8‣ §7Use to hide Players");
			   				meta.setLore(lore);
			   				meta.setDisplayName("§6Hide Players");
		   				}
		   				milk.setItemMeta(meta);
						p.getInventory().setItem(is, milk);			
						if (Main.playerLanguage.get(p) == Language.GERMAN) {
							p.sendMessage(Main.pre + "Alle Spieler sind wieder §esichtbar§3!");
						} else {
							p.sendMessage(Main.pre + "All Players are now §evisibile§3!");
						}
		               	hiders.remove(e.getPlayer().getUniqueId());      
		               	Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
							public void run() {			
								SQLStats.setVerstecken(p, 0);
						    }
					    }, 0L);
			       }else{
			    	 if (Main.playerLanguage.get(p) == Language.GERMAN) {
			    		 p.kickPlayer("§cWegen eines Reloades musstest du gekickt werden!"); 
			    	 } else {
			    		 p.kickPlayer("§cYou get kicked because the Server has been reloaded."); 
			    	 }
			       }         
					
				}
			}
			
			 if(e.getPlayer().getItemInHand().getType() == Material.SHEARS) {
	    			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
						public void run() {	
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
								public void run() {	
									if(!Other.ueberschreiben.contains(e.getPlayer().getUniqueId())){
						    			Challenger.openChallengerInvites(e.getPlayer());  	 	
									}
							    }
						    }, 0L);
					    }
				    }, 1L);
	    	 }
			
			if(e.getPlayer().getItemInHand().getType() == Material.EYE_OF_ENDER){
				if(p.hasPermission("staff.schutzschild")){
				e.setCancelled(true);	
				if(Main.toggleSchutzschild == true && !p.isOp()){
					if (Main.playerLanguage.get(p) == Language.GERMAN) {
						p.sendMessage(Main.pre+"§cMomentan ist das Schutzschild §edeaktiviert§c.");
					} else {
						p.sendMessage(Main.pre+"§cThe protection is §edeactivated§c.");
					}
					return;
				}
				if(schneeball.contains(e.getPlayer().getUniqueId())){
					return;
				}
				if(!run.containsKey(p)){
					run.put(p, new BukkitRunnable(){
						@Override
						public void run(){
							p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 3);
						}
					});
					run.get(p).runTaskTimer(Main.getInstance(), 20, 20);
					if (Main.playerLanguage.get(p) == Language.GERMAN) {
						p.sendMessage(Main.pre + "Du hast dein Schutzschild für 3 Sekunden §eaktiviert§3.");
					} else {
						p.sendMessage(Main.pre + "Your protection has been §eactivated §3for 3 Seconds.");
					}
		            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 100);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
						@Override
						public void run() {	
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
								@Override
								public void run() {	
									if(p != null);
									if(run.containsKey(p)){
										run.get(p).cancel();
										run.remove(p);
									}
									if(schneeball.contains(p.getUniqueId())){
										schneeball.remove(p.getUniqueId());
									}

								}
							},0L);
						}
					},20*3L);
				}
				}
			}
			
   
		    
	
			if(e.getPlayer().getItemInHand().getType() == Material.GOLDEN_APPLE){
				if(!p.hasPermission("premium.features")){
					if (Main.playerLanguage.get(p) == Language.GERMAN) {
						p.sendMessage(Main.pre+"§cDu musst Premium sein, um dieses Feature benutzen zu können.");
						p.sendMessage(Main.pre+"§eKaufe Premium hier: §ohttp://store.revayd.net/");
					} else {
						p.sendMessage(Main.pre+"§cYou must have the Permium rank to use this.");
						p.sendMessage(Main.pre+"§eBuy Premium now: §ohttp://store.revayd.net/");
					}
					e.setCancelled(true);
					return;
				}
	
				  inv = p.getPlayer().getServer().createInventory(null, 9*1, "Premium Features");

				  String jumpbooststatus = null;
				  
				  if (Main.playerLanguage.get(p) == Language.GERMAN) {
					  if(jumpbooster_premium.contains(p.getUniqueId())){
						  jumpbooststatus = " deaktivieren";
					  }else{
						  jumpbooststatus = " aktivieren";
					  }
				  } else {
					  if(jumpbooster_premium.contains(p.getUniqueId())){
						  jumpbooststatus = " disable";
					  }else{
						  jumpbooststatus = " enable";
					  }
				  }
				  
			        ItemStack TM = new ItemStack(Material.QUARTZ);
			        ItemMeta TMMeta = TM.getItemMeta();

			        if(!p.hasPermission("premium.features")){
			        	
			        	if (Main.playerLanguage.get(p) == Language.GERMAN) {
					        TMMeta.setDisplayName("§cDoppeljump" + jumpbooststatus);
			        	} else {
					        TMMeta.setDisplayName("§cDoublejump" + jumpbooststatus);
			        	}
			        	
			        }else 

			        if (Main.playerLanguage.get(p) == Language.GERMAN) {
			        	TMMeta.setDisplayName("§bDoppeljump" + jumpbooststatus);
			        } else {
			        	TMMeta.setDisplayName("§bDoublejump" + jumpbooststatus);
			        }
			        	
			        List<String> lore2 = new ArrayList<String>();    
			        
			        if (Main.playerLanguage.get(p) == Language.GERMAN) {
				        lore2.add("§8‣ §7Aktiviert/Deaktiviert Doppeljump");
			        } else {
				        lore2.add("§8‣ §7Enable/Disable Doublejump");
			        }
			        
			        if(!p.hasPermission("premium.features")){
			        	TMMeta.addEnchant(Enchantment.THORNS, 1, false);
			        }
			        TMMeta.setLore(lore2);
			        TM.setItemMeta(TMMeta);
			        inv.setItem(2, TM);
			        

			        ItemStack Leer = new ItemStack(Material.GLASS_BOTTLE);
			        ItemMeta LeerMeta = Leer.getItemMeta();
			        if (Main.playerLanguage.get(p) == Language.GERMAN) {
			        	LeerMeta.setDisplayName("§cBald");
			        }else{
			        	LeerMeta.setDisplayName("§cComing soon");
			        }
			        Leer.setItemMeta(LeerMeta);
			        inv.setItem(6, Leer);

			        String bootsstatus = null;
			        if (Main.playerLanguage.get(p) == Language.GERMAN) {
						  if(boots_premium.contains(p.getUniqueId())){
							  bootsstatus = " deaktivieren";
						  }else{
							  bootsstatus = " aktivieren";
						  }
			        } else {
						  if(boots_premium.contains(p.getUniqueId())){
							  bootsstatus = " disable";
						  }else{
							  bootsstatus = " enable";
						  }
			        }
					  
					  Random color = new Random();
			          int bc = color.nextInt(16);
			          
			          ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			          LeatherArmorMeta bootsM = (LeatherArmorMeta)boots.getItemMeta();
				        if(!p.hasPermission("premium.features")){
				        	if (Main.playerLanguage.get(p) == Language.GERMAN) {
				        		bootsM.setDisplayName("§cFarbige Schuhe" + bootsstatus);
				        	} else {
				        		bootsM.setDisplayName("§cColored Boots" + bootsstatus);
				        	}
				        }else 				        	
				        if (Main.playerLanguage.get(p) == Language.GERMAN) {
			        		bootsM.setDisplayName("§cFarbige Schuhe" + bootsstatus);
			        	} else {
			        		bootsM.setDisplayName("§cColored Boots" + bootsstatus);
			        	}

				        List<String> lore3 = new ArrayList<String>();    
				        if (Main.playerLanguage.get(p) == Language.GERMAN) {
					        lore3.add("§8‣ §7Aktiviert/Deaktiviert Farbige Schuhe");
				        } else {
					        lore3.add("§8‣ §7Enable/Disable colored boots");
				        }
				        bootsM.setLore(lore3);
				        
			          if (bc == 0)
			          {
			            bootsM.setColor(Color.AQUA);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);			          }
			          if (bc == 1)
			          {
			            bootsM.setColor(Color.BLACK);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          if (bc == 2)
			          {
			            bootsM.setColor(Color.BLUE);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          if (bc == 3)
			          {
			            bootsM.setColor(Color.FUCHSIA);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          if (bc == 4)
			          {
			            bootsM.setColor(Color.GRAY);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          if (bc == 5)
			          {
			            bootsM.setColor(Color.GREEN);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          if (bc == 6)
			          {
			            bootsM.setColor(Color.LIME);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          if (bc == 7)
			          {
			            bootsM.setColor(Color.MAROON);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          if (bc == 8)
			          {
			            bootsM.setColor(Color.NAVY);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          if (bc == 9)
			          {
			            bootsM.setColor(Color.OLIVE);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          if (bc == 10)
			          {
			            bootsM.setColor(Color.ORANGE);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          if (bc == 11)
			          {
			            bootsM.setColor(Color.PURPLE);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          if (bc == 12)
			          {
			            bootsM.setColor(Color.RED);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          if (bc == 13)
			          {
			            bootsM.setColor(Color.SILVER);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          if (bc == 14)
			          {
			            bootsM.setColor(Color.TEAL);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          if (bc == 15)
			          {
			            bootsM.setColor(Color.WHITE);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          if (bc == 16)
			          {
			            bootsM.setColor(Color.YELLOW);
				        if(!p.hasPermission("premium.features")){
				        	bootsM.addEnchant(Enchantment.THORNS, 1, false);
				        }
			            boots.setItemMeta(bootsM);
			            inv.setItem(4, boots);
			          }
			          
				        
//				        boots.setItemMeta(bootsM);
//				        inv.setItem(4, boots);
			        
			        

			        p.openInventory(inv);    
				
			}
		}	
	}
	
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		e.setQuitMessage(null);
		if(run.containsKey(e.getPlayer())){
			run.get(e.getPlayer()).cancel();
			run.remove(e.getPlayer());
		}
		if(schneeball.contains(e.getPlayer().getUniqueId())){
			schneeball.remove(e.getPlayer().getUniqueId());
		}
	}
	
	@EventHandler
	public void onKick(PlayerKickEvent e){
		e.setLeaveMessage(null);
		if(run.containsKey(e.getPlayer())){
			run.get(e.getPlayer()).cancel();
			run.remove(e.getPlayer());
		}	
		if(schneeball.contains(e.getPlayer().getUniqueId())){
			schneeball.remove(e.getPlayer().getUniqueId());
		}
	}
	
	@EventHandler 
	public void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();

		for(Player players : run.keySet()){
			if(p != players && !p.hasPermission("staff.schutzschild")){

				if(p.getLocation().distance(players.getLocation()) <= 4){
					double Ax = p.getLocation().getX();
					double Ay = p.getLocation().getY();
					double Az = p.getLocation().getZ();
					
					double Bx = players.getLocation().getX();
					double By = players.getLocation().getY();
					double Bz = players.getLocation().getZ();
					
					double x = Ax - Bx;
					double y = Ay - By;
					double z = Az - Bz;
					
					Vector v = new Vector(x, y, z).normalize().multiply(1.2D).setY(0.5D);
					p.setVelocity(v);
				}
				}
			}
		
		if(run.containsKey(p)){
		for(Entity entity : p.getNearbyEntities(4, 4, 4)){
			if(entity instanceof Player){
				Player target = (Player) entity;
				if(p != target){
					if(!target.hasPermission("staff.schutzschild")){
						
					double Ax = p.getLocation().getX();
					double Ay = p.getLocation().getY();
					double Az = p.getLocation().getZ();
					
					double Bx = target.getLocation().getX();
					double By = target.getLocation().getY();
					double Bz = target.getLocation().getZ();
					
					double x = Bx - Ax;
					double y = By - Ay;
					double z = Bz - Az;
					
					Vector v = new Vector(x, y, z).normalize().multiply(1.2D).setY(0.5D);
					target.setVelocity(v);
				}
				}
			}
		}
		}
		}


}

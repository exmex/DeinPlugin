package Main;

import java.util.HashMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import Utils.Language;

public class Chat implements Listener, CommandExecutor{
	
	
	  public static HashMap<UUID, Long> times = new HashMap<UUID, Long>();
	  private HashMap<UUID, String> message = new HashMap<UUID, String>();
	  public HashMap<UUID, Long> chatCooldowns = new HashMap<UUID, Long>();
	  public HashMap<UUID, Long> commandCooldowns = new HashMap<UUID, Long>();
		public static boolean globalmute;

	  @EventHandler (priority = EventPriority.LOWEST)
	  public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event){
		    if (event.isCancelled()) {
			      return;
			}
			Player p = event.getPlayer();
			String msg = event.getMessage();
			
			Language l = Main.playerLanguage.get(p);
			
			PermissionUser user  = PermissionsEx.getUser(p);		    
			Pattern webPattern = Pattern.compile("(http://)|(https://)?(www)?\\S{2,}((\\.com)|(\\.ru)|(\\.net)|(\\.org)|(\\.co\\.uk)|(\\.fr)|(\\.tk)|(\\.info)|(\\.me)|(\\.es)|(\\.de)|(\\.arpa)|(\\.edu)|(\\.firm)|(\\.int)|(\\.mil)|(\\.mobi)|(\\.nato)|(\\.to)|(\\.fr)|(\\.ms)|(\\.vu)|(\\.eu)|(\\.nl)|(\\.ch)|(\\.us)|(\\.dk))", Pattern.CASE_INSENSITIVE);
			Pattern ipPattern = Pattern.compile("((?<![0-9])(?:(?:25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})[ ]?[.,_ ][ ]?(?:25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})[ ]?[.,_ ][ ]?(?:25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})[ ]?[.,_ ][ ]?(?:25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2}))(?![0-9]))", Pattern.CASE_INSENSITIVE);
			Pattern boese = Pattern.compile("(l2p)|(#derarti)|(derartiarmy)|(ddos)|(#derartiarmy)|(relaxoarmy)|(#relaxoarmy)|(hrnshn)|(nab)|(eZ)|(eZZ)|(e z)|(e  z)|(arschloch)|(hurensohn)|(nazi)|(hitler)|(heil hitler)|(Wixxer)|(huso)|(e2)|(e²)|(noob)|(bad)|(schlecht)|(leck mich)|(fotze)|(fggt)|(fgt)|(faggot)|(geh sterben)|(get ebola)|(get ddos)|(sack)|(fick)|(lappen)|(lppn)|(lauch)|(simple)|(l appen)|(fuck)|(can i have op)", Pattern.CASE_INSENSITIVE);

				if(Chat.globalmute == true && !p.hasPermission("staff.globalmute.bypass")){
					if (l == Language.GERMAN) {
						p.sendMessage(Main.pre + "§cGlobalmute ist momentan §eaktiviert§c.");
					} else {
						p.sendMessage(Main.pre + "§cThe Chat is currently §edisabled§c.");
					}
				event.setCancelled(true);
				return;
				}
			
				if (!p.hasPermission("staff.chat") && !p.isOp()){

				Matcher webmatcher = webPattern.matcher(msg);
				while (webmatcher.find()) {
					event.setCancelled(true);
					p.sendMessage(" ");
					if (l == Language.GERMAN) {
						p.sendMessage("    §cDu darfst keine Links schreiben!");
					} else {
						p.sendMessage("    §cYou may not advertise!");
					}
					p.sendMessage(" ");
  					p.playSound(p.getEyeLocation(), Sound.CHICKEN_HURT, 20F, 1F);
  					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*3, 1));			
				    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*3, 1));			
				}
				Matcher ipmatcher = ipPattern.matcher(msg);
				while (ipmatcher.find()) {
					event.setCancelled(true);
					p.sendMessage(" ");
					if (l == Language.GERMAN) {
						p.sendMessage("    §cDu darfst keine Links schreiben!");
					} else {
						p.sendMessage("    §cYou may not advertise!");
					}
					p.sendMessage(" ");
  					p.playSound(p.getEyeLocation(), Sound.CHICKEN_HURT, 20F, 1F);
  					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*3, 1));			
				    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*3, 1));
				}
			
				Matcher boeser = boese.matcher(msg);
				while (boeser.find()) {
					event.setCancelled(true);
					p.sendMessage(" ");
					p.sendMessage(" ");
					if (l == Language.GERMAN) {
						p.sendMessage("    §cDu darfst das nicht schreiben!");
					} else {
						p.sendMessage("    §cYou are not allowed to write this!");
					}
					p.sendMessage(" ");
					p.sendMessage(" ");
  					p.playSound(p.getEyeLocation(), Sound.CHICKEN_HURT, 20F, 1F);
  					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*3, 1));			
				    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*3, 1));
				}
	
				 if(msg.length() >= 6 && 
					      (getUppercasePercentage(msg) > 30)) {
					    	 String msga = msg.toLowerCase();;
					    	 msg = msga;
			     }
				 Long time = Long.valueOf(System.currentTimeMillis());
				    Long lastUse = (Long)chatCooldowns.get(p.getName());
				    if (lastUse == null) {
				      lastUse = Long.valueOf(0L);
				    }
				    if (lastUse.longValue() + 1000L > time.longValue())
				    {
				    	if (l == Language.GERMAN) {
						      p.sendMessage(Main.pre + "§cDu darfst nicht spammen!");
				    	} else {
						      p.sendMessage(Main.pre + "§cYou are not allowed to spam!");
				    	}
				      event.setCancelled(true);
				    }
				    chatCooldowns.remove(p.getName());
				    chatCooldowns.put(p.getUniqueId(), time);
				    if (this.message.containsKey(p.getName()))
				    {
				      String prevMessage = (String)this.message.get(p.getName());
				      if (prevMessage.equals(msg))
				      {
					    	if (l == Language.GERMAN) {
							      p.sendMessage(Main.pre + "§cDu darfst nicht spammen!");
					    	} else {
							      p.sendMessage(Main.pre + "§cYou are not allowed to spam!");
					    	}
				        event.setCancelled(true);
				      }
				      else
				      {
				        this.message.remove(p.getName());
				        this.message.put(p.getUniqueId(), msg);
				      }
				    }
				    else
				    {
				      this.message.put(p.getUniqueId(), msg);
				    }	
				    
				}   
				    
				    
				    if (l == Language.GERMAN) {
				    	msg = msg.replace("%", "Prozent");
				    } else {
				    	msg = msg.replace("%", "Percent");
				    }
					
					if(p.hasPermission("staff.chat")){
						msg = ChatColor.translateAlternateColorCodes('&', msg);
					}

						
					String format;
					if(l.getDisplay() != null) {
						format = "§2" + l.getDisplay() + " §8▏ " + user.getPrefix() + p.getName() + " §8» " +getColor(p)+  msg;
					} else {
						format = "§2" + "EN" + " §8▏ " + user.getPrefix() + p.getName() + " §8» " +getColor(p)+  msg;
					}
					event.setFormat(format);
			
			}
			 
			  public static boolean isUppercase(char c)
			  {
			    return Character.isUpperCase(c);
			  }
			  
			  public static double getUppercasePercentage(String string)
			  {
			    double upperCase = 0.0D;
			    for (char c : string.toCharArray()) {
			      if (isUppercase(c)) {
			        upperCase += 1.0D;
			      }
			    }
			    return upperCase / string.length() * 100.0D;
			  }
			
		 	public ChatColor getColor(Player p){
				if(p.hasPermission("staff.chat.admin")) return ChatColor.GOLD;
				return ChatColor.WHITE;
			}
		 	
		 	
			@Override
			public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
				Player p = null;
				if(sender instanceof Player)
					p = (Player) sender;
				if(cmd.getName().equalsIgnoreCase("globalmute")){
		    		if(p.hasPermission("staff.globalmute")){
		    			if(Chat.globalmute == false){
		    				Chat.globalmute = true;
		    				p.sendMessage(Main.pre+"Du hast Globalmute §eaktiviert§3.");
		    				return true;
		    			}else{
		    				Chat.globalmute = false;
		    				p.sendMessage(Main.pre+"Du hast Globalmute §edeaktiviert§3.");

		    				return true;
		    			}
	    	    	}else p.sendMessage(Main.pre + "§cDu besitzt keine Rechte!");
    	    	}else p.sendMessage(Main.pre + "§cVerwendung: /globalmute");

				return true;
			}
}

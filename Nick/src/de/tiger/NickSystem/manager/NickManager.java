package de.tiger.NickSystem.manager;

import de.tiger.NickSystem.Main;
import de.tiger.NickSystem.event.PlayerNickEvent;
import de.tiger.NickSystem.event.PlayerUnNickEvent;
import de.tiger.NickSystem.message.English_Message;
import de.tiger.NickSystem.message.German_Message;
import de.tiger.NickSystem.sql.MySQL;
import de.tiger.NickSystem.uuid.UUIDFetcher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class NickManager 
{
	
  public static void nick(final Player p)
  {
    if (isNicked(p))
    {
      p.sendMessage(Main.getInstance().prefix + "§cDu bist schon genickt§8!");
      return;
    }
    String name = getRandomName();
    UUID id = getRandomUUID();
    String nick = p.getName();
    if ((name != null) && (id != null))
    {
      PlayerNickEvent event = new PlayerNickEvent(p, name, id);
      
      Bukkit.getPluginManager().callEvent(event);
      if (!event.isCancelled())
      {
    	  SkinUtils.updateSkinFrom(p, id, true);
        
        NameUtils.setName(p, name);
        
        if (Main.getInstance().getConfig().getString("Language").equalsIgnoreCase("de_DE")) {
          p.sendMessage(" ");
          p.sendMessage(Main.getInstance().prefix + German_Message.NICKCHANGED.replace("{Name}", name));
          p.sendMessage(" ");
          //p.setPlayerListName("§a" + p.getName());
          p.hidePlayer(p);
          p.showPlayer(p);
          p.setDisplayName("§7");
          
          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
          {
            public void run()
            {
              
          	    String name = "§7" + p.getName();
          	    p.setDisplayName(name);
          		
          	    final Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
          	    
          	    Team owner = board.getTeam("01-Owner");
                  Team admin = board.getTeam("02-Admin");
                  Team developer = board.getTeam("03-Dev");
                  Team srmoderator = board.getTeam("04-SrMod");
                  Team mod = board.getTeam("05-Mod");
                  Team supp = board.getTeam("06-Sup");
                  Team builder = board.getTeam("07-Builder");
                  Team youtuber = board.getTeam("08-YouTuber");
                  Team jryoutuber = board.getTeam("09-JrYouTuber");
                  Team legend = board.getTeam("10-Legend");
                  Team ultra = board.getTeam("11-Ultra");
                  Team hero = board.getTeam("12-Hero");
                  Team gold = board.getTeam("13-Gold");
                  Team spieler = board.getTeam("14-Spieler");
          	    
                  
          	    if (spieler == null)
          	    {
          	      spieler = board.registerNewTeam("14-Spieler");
          	      spieler.setPrefix("§7");
          	    }
          	    if (gold == null)
          	    {
          	      gold = board.registerNewTeam("13-Gold");
          	      gold.setPrefix("§6Gold §8● §6");
          	    }
          	    if (hero == null)
          	    {
          	      hero = board.registerNewTeam("12-Hero");
          	      hero.setPrefix("§3Hero §8● §3");
          	    }
          	    if (ultra == null)
          	    {
          	      ultra = board.registerNewTeam("11-Ultra");
          	      ultra.setPrefix("§aUltra §8● §a");
          	    }
          	    if (legend == null)
          	    {
          	      legend = board.registerNewTeam("10-Legend");
          	      legend.setPrefix("§dLegend §8● §d");
          	    }
          	    if (jryoutuber == null)
          	    {
          	      jryoutuber = board.registerNewTeam("09-JrYouTuber");
          	      jryoutuber.setPrefix("§5JrYT §8● §5");
          	    }
          	    if (youtuber == null)
          	    {
          	      youtuber = board.registerNewTeam("08-YouTuber");
          	      youtuber.setPrefix("§5YT §8● §5");
          	    }
          	    if (builder == null)
          	    {
          	      builder = board.registerNewTeam("07-Builder");
          	      builder.setPrefix("§eBuilder §8● §e");
          	    }
          	    if (supp == null)
          	    {
          	      supp = board.registerNewTeam("06-Sup");
          	      supp.setPrefix("§9Supp §8● §9");
          	    }
          	    if (mod == null)
          	    {
          	      mod = board.registerNewTeam("05-Mod");
          	      mod.setPrefix("§cMod §8● §c");
          	    }
          	    if (srmoderator == null)
          	    {
          	      srmoderator = board.registerNewTeam("04-SrMod");
          	      srmoderator.setPrefix("§cSrMod §8● §c");
          	    }
          	    if (developer == null)
          	    {
          	      developer = board.registerNewTeam("03-Dev");
          	      developer.setPrefix("§bDev §8● §b");
          	    }
          	    if (admin == null)
          	    {
          	      admin = board.registerNewTeam("02-Admin");
          	      admin.setPrefix("§cAdmin §8● §c");
          	    }
          	    if (owner == null)
          	    {
          	      owner = board.registerNewTeam("01-Owner");
          	      owner.setPrefix("§4Owner §8● §4");
          	    }
          	    
          	    
          	    if(NickManager.isNicked(p)){
          	    	spieler.addPlayer(p);
          	    }
          	    
          	    for(Player players : Bukkit.getOnlinePlayers()){
          	    	
          	    	players.setScoreboard(board);
          	    	
          	    }
          	    
          	    p.setScoreboard(board);
            	
            }
          }, 5L);
          
          for(Player all : Bukkit.getOnlinePlayers()){
        	  all.hidePlayer(p);
        	  all.showPlayer(p);
          }
        } else {
          p.sendMessage(Main.getInstance().prefix + English_Message.NICKCHANGED.replace("{Name}", name));
        }
      }
    }
    else if (Main.getInstance().getConfig().getString("Language").equalsIgnoreCase("de_DE"))
    {
      p.sendMessage(Main.getInstance().prefix + German_Message.NICKNOTFOUND);
    }
    else
    {
      p.sendMessage(Main.getInstance().prefix + English_Message.NICKNOTFOUND);
    }
  }
  
  public static void unNick(Player p)
  {
    String realName = NameUtils.getRealName(p);
    
    PlayerUnNickEvent event = new PlayerUnNickEvent(p);
    Bukkit.getPluginManager().callEvent(event);
    
    NameUtils.resetName(p);
    SkinUtils.updateSkinFrom(p, UUIDFetcher.getUUID(realName), true);
    
    p.setDisplayName(realName);
    if (Main.getInstance().getConfig().getString("Language").equalsIgnoreCase("de_DE")) {
      p.sendMessage(Main.getInstance().prefix + German_Message.NICKRESETTET); 
      
      if (p.hasPermission("system.admin")) {
          //p.setPlayerListName("§4" + p.getName());
          p.setDisplayName("§4" + p.getName());
        } else if (p.hasPermission("system.spieler")) {
         //p.setPlayerListName("§a" + p.getName());
         p.setDisplayName("§9" + p.getName());
       } else if (p.hasPermission("system.premium")) {
         //p.setPlayerListName("§6" + p.getName());
         p.setDisplayName("§6" + p.getName());
       } else if (p.hasPermission("system.youtuber")) {
       //p.setPlayerListName("§5" + p.getName());
       p.setDisplayName("§5" + p.getName());
        } else if (p.hasPermission("system.builder")) {
         //p.setPlayerListName("§2" + p.getName());
         p.setDisplayName("§2" + p.getName());
                    } else if (p.hasPermission("system.premiumplus")) {
                        //p.setPlayerListName("§e" + p.getName());
                        p.setDisplayName("§e" + p.getName());
                                   } else if (p.hasPermission("system.supporter")) {
               	   //p.setPlayerListName("§9" + p.getName());
               	  p.setDisplayName("§9" + p.getName());
                    } else if (p.hasPermission("system.moderator")) {
                	  //p.setPlayerListName("§c" + p.getName());
                	p.setDisplayName("§c" + p.getName());
                    } else if (p.hasPermission("system.srmoderator")) {
                	  //p.setPlayerListName("§c" + p.getName());
                	p.setDisplayName("§c" + p.getName());
                    } else if (p.hasPermission("system.developer")) {
                	   //p.setPlayerListName("§b" + p.getName());
                	 p.setDisplayName("§b" + p.getName());
                     } else if (p.hasPermission("system.admin")) {
                	   //p.setPlayerListName("§4" + p.getName());
                	 p.setDisplayName("§4" + p.getName());
                     }
      
      for(Player all : Bukkit.getOnlinePlayers()){
    	  all.hidePlayer(p);
    	  p.hidePlayer(p);
    	  all.showPlayer(p);
    	  p.showPlayer(p);
      }
    } else {
      p.sendMessage(Main.getInstance().prefix + English_Message.NICKRESETTET);
    }
  }
  
  public static boolean isNicked(Player p)
  {
    return Main.getInstance().REALNAMES.containsKey(p);
  }
  
  private static String getRandomName()
  {
    List<String> names = new ArrayList();
    ResultSet rs;
    if (Main.getInstance().getConfig().getBoolean("MySQL.Enable")) {
      try
      {
        PreparedStatement ps = Main.getSQL().getStatement("SELECT name FROM nicknames");
        rs = ps.executeQuery();
        while (rs.next())
        {
          String name = rs.getString(1);
          
          boolean exists = false;
          for (Player players : Bukkit.getOnlinePlayers()) {
            if (players.getName().equalsIgnoreCase(name)) {
              exists = true;
            }
          }
          if (!exists) {
            names.add(name);
          }
        }
        rs.clearWarnings();
        rs.close();
        ps.clearWarnings();
        ps.clearBatch();
        ps.clearParameters();
        ps.close();
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
    } else {
      for (String all : Main.getInstance().getConfig().getStringList("Nicknames")) {
        names.add(all);
      }
    }
    if (names.size() > 0)
    {
      Random rdm = new Random();
      
      return (String)names.get(rdm.nextInt(names.size()));
    }
    return null;
  }
  
  private static UUID getRandomUUID()
  {
    List<UUID> ids = new ArrayList();
    ResultSet rs;
    if (Main.getInstance().getConfig().getBoolean("MySQL.Enable")) {
      try
      {
        PreparedStatement ps = Main.getSQL().getStatement("SELECT uuid FROM nickids");
        rs = ps.executeQuery();
        while (rs.next()) {
          ids.add(UUID.fromString(rs.getString("uuid")));
        }
        rs.clearWarnings();
        rs.close();
        ps.clearWarnings();
        ps.clearBatch();
        ps.clearParameters();
        ps.close();
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
    } else {
      for (String all : Main.getInstance().getConfig().getStringList("Skins")) {
        ids.add(UUID.fromString(all));
      }
    }
    if (ids.size() > 0)
    {
      Random rdm = new Random();
      
      return (UUID)ids.get(rdm.nextInt(ids.size()));
    }
    return null;
  }
}

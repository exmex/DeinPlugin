package de.tiger.NickSystem.commands;

import de.tiger.NickSystem.Main;
import de.tiger.NickSystem.manager.NickManager;
import de.tiger.NickSystem.message.English_Message;
import de.tiger.NickSystem.message.German_Message;
import de.tiger.NickSystem.sql.MySQL;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.sql.PreparedStatement;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class AddNick
  implements CommandExecutor
{
  private Main plugin;
  
  public AddNick(Main main)
  {
    this.plugin = main;
    this.plugin.getCommand("addNick").setExecutor(this);
  }
  
  public boolean onCommand(CommandSender cs, Command cmd, String lable, String[] args)
  {
    if ((cs instanceof Player))
    {
      Player p = (Player)cs;
      if (!p.hasPermission("Nick.addNick"))
      {
        if (this.plugin.getConfig().getString("Language").equalsIgnoreCase("de_DE")) {
          p.sendMessage(this.plugin.prefix + German_Message.NOPERMISSIONS);
        } else {
          p.sendMessage(this.plugin.prefix + English_Message.NOPERMISSIONS);
        }
        return true;
      }
      if (args.length == 1)
      {
        String name = args[0];
        if (Main.getInstance().getConfig().getBoolean("MySQL.Enable"))
        {
          try
          {
            PreparedStatement ps = Main.getSQL().getStatement("INSERT INTO nicknames (name) VALUES (?)");
            ps.setString(1, name);
            ps.executeUpdate();
            ps.clearWarnings();
            ps.clearParameters();
            ps.clearBatch();
            ps.close();
          }
          catch (Exception ex)
          {
            ex.printStackTrace();
          }
        }
        else
        {
          List<String> nicks = Main.getInstance().getConfig().getStringList("Nicknames");
          nicks.add(name);
          
          Main.getInstance().getConfig().set("Nicknames", nicks);
          Main.getInstance().saveConfig();
        }
        if (Main.getInstance().getConfig().getString("Language").equalsIgnoreCase("de_DE")) {
          p.sendMessage(this.plugin.prefix + German_Message.NICKADDED.replace("{Name}", name));
        } else {
          p.sendMessage(this.plugin.prefix + English_Message.NICKADDED.replace("{Name}", name));
        }
      }
      else
      {
        p.sendMessage(this.plugin.prefix + "§7Benutze §8»§6 /" + cmd.getName() + " §8[§aNick§8]");
        
        for(Player all : Bukkit.getOnlinePlayers()){
        	
    	    String name = "§7" + p.getName();
    	    if (PermissionsEx.getUser(p).inGroup("Owner")) {
    	      name = "§4" + p.getName();
    	    }
    	    if (PermissionsEx.getUser(p).inGroup("Admin")) {
    		      name = "§cA" + p.getName();
    		    }
    	    if (PermissionsEx.getUser(p).inGroup("SrModerator")) {
    		      name = "§cS" + p.getName();
    		    }
    	    if (PermissionsEx.getUser(p).inGroup("Moderator")) {
    		      name = "§cM" + p.getName();
    		    }
    	    if (PermissionsEx.getUser(p).inGroup("Developer")) {
    		      name = "§b" + p.getName();
    		    }
    	    if (PermissionsEx.getUser(p).inGroup("Supporter")) {
    		      name = "§9" + p.getName();
    		    }
    	    if (PermissionsEx.getUser(p).inGroup("Builder")) {
    		      name = "§e" + p.getName();
    		    }
    	    if (PermissionsEx.getUser(p).inGroup("Legend")) {
    		      name = "§d" + p.getName();
    		    }
    	    if (PermissionsEx.getUser(p).inGroup("Ultra")) {
    		      name = "§a" + p.getName();
    		    }
    	    if (PermissionsEx.getUser(p).inGroup("Hero")) {
    		      name = "§3" + p.getName();
    		    }
    	    if (PermissionsEx.getUser(p).inGroup("Gold")) {
    		      name = "§6" + p.getName();
    		    }
    	    if (PermissionsEx.getUser(p).inGroup("JrYouTuber")) {
    		      name = "§5J" + p.getName();
    		    }
    	    if (PermissionsEx.getUser(p).inGroup("YouTuber")) {
    		      name = "§5Y" + p.getName();
    		    }
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
    	    if (p.getDisplayName().startsWith("§7")) {
    	      spieler.addPlayer(p);
    	    }
    	    if(p.getDisplayName().startsWith("§6")){
    	    	gold.addPlayer(p);
    	    }
    	    if(p.getDisplayName().startsWith("§3")){
    	    	hero.addPlayer(p);
    	    }
    	    if(p.getDisplayName().startsWith("§a")){
    	    	ultra.addPlayer(p);
    	    }
    	    if(p.getDisplayName().startsWith("§d")){
    	    	legend.addPlayer(p);
    	    }
    	    if(p.getDisplayName().startsWith("§5J")){
    	    	jryoutuber.addPlayer(p);
    	    }
    	    if(p.getDisplayName().startsWith("§5Y")){
    	    	youtuber.addPlayer(p);
    	    }
    	    if(p.getDisplayName().startsWith("§e")){
    	    	builder.addPlayer(p);
    	    }
    	    if(p.getDisplayName().startsWith("§9")){
    	    	supp.addPlayer(p);
    	    }
    	    if(p.getDisplayName().startsWith("§cM")){
    	    	mod.addPlayer(p);
    	    }
    	    if(p.getDisplayName().startsWith("§cS")){
    	    	srmoderator.addPlayer(p);
    	    }
    	    if(p.getDisplayName().startsWith("§b")){
    	    	developer.addPlayer(p);
    	    }
    	    if(p.getDisplayName().startsWith("§cA")){
    	    	admin.addPlayer(p);
    	    }
    	    if(p.getDisplayName().startsWith("§4")){
    	    	owner.addPlayer(p);
    	    }
    	    
    	    all.setScoreboard(board);
        	
        }
        
      }
    }
    else
    {
      cs.sendMessage(this.plugin.prefix + "§4Du bist kein Spieler§8!");
    }
    return true;
  }
}

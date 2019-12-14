package de.tiger.NickSystem;

import de.tiger.NickSystem.commands.AddNick;
import de.tiger.NickSystem.commands.AddSkin;
import de.tiger.NickSystem.commands.Nick;
import de.tiger.NickSystem.commands.RemoveNick;
import de.tiger.NickSystem.commands.RemoveSkin;
import de.tiger.NickSystem.event.ChatEvent;
import de.tiger.NickSystem.listener.PlayerDeathListener;
import de.tiger.NickSystem.listener.PlayerJoinListener;
import de.tiger.NickSystem.manager.Scoreboard;
import de.tiger.NickSystem.manager.Scoreboard1;
import de.tiger.NickSystem.sql.MySQL;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main
  extends JavaPlugin
{
  public HashMap<Player, String> REALNAMES = new HashMap();
  public HashMap<UUID, String[]> PLAYERDATAS = new HashMap();
  public ArrayList<Player> NODEATH = new ArrayList();
  public String version;
  public String prefix;
  private static Main instance;
  private static MySQL sql;
  public static Main plugin;
  
  public static ArrayList<Player> nick;
  
  public void onEnable()
  {
	  
	  plugin = this;
	  
	  registerListener();
	  
	/*  Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
	    {
	      public void run()
	      {
	        
	    	  for(Player players : Bukkit.getOnlinePlayers()){
	    		  
	    		  Scoreboard.setScoreboard(players);
	    		  
	    	  }
	    	  
	      }
	    }, 1L, 1L); */
	  
    this.prefix = "§8[§5NICK§8] ";
    String path = Bukkit.getServer().getClass().getPackage().getName();
    this.version = path.substring(path.lastIndexOf('.') + 1, path.length());
    
    getConfig().options().copyDefaults(true);
    saveConfig();
    
    Main.nick = new ArrayList<Player>();
    
    instance = this;
    if (!this.version.equalsIgnoreCase("v1_8_R3"))
    {
      getServer().getPluginManager().disablePlugin(this);
      Bukkit.getConsoleSender().sendMessage(this.prefix + "§cThis plugin is running on Spigot 1.8.8 R3. Please take an older version or update your spigot server. §e(" + this.version + ")");
      return;
    }
    if (getConfig().getBoolean("MySQL.Enable"))
    {
      sql = new MySQL(getConfig().getString("MySQL.Host"), String.valueOf(getConfig().getInt("MySQL.Port")), getConfig().getString("MySQL.Username"), getConfig().getString("MySQL.Passwort"), getConfig().getString("MySQL.Datenbank"));
      try
      {
        PreparedStatement ps = getSQL().getStatement("CREATE TABLE IF NOT EXISTS nicknames (name VARCHAR(16)) ");
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
      try
      {
        PreparedStatement ps = getSQL().getStatement("CREATE TABLE IF NOT EXISTS nickids (uuid VARCHAR(36)) ");
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
      getConfig().addDefault("Nicknames", new ArrayList());
      getConfig().addDefault("Skins", new ArrayList());
      saveConfig();
    }
    new AddNick(this);
    new AddSkin(this);
    new Nick(this);
    new RemoveNick(this);
    new RemoveSkin(this);
    
    new PlayerDeathListener(this);
    //new ChatEvent(this);
    
    Bukkit.getConsoleSender().sendMessage("§7-------------==+==-------------");
    Bukkit.getConsoleSender().sendMessage("§3Plugin: §5NickSystem");
    Bukkit.getConsoleSender().sendMessage("§3Plugin version: §e1.0");
    Bukkit.getConsoleSender().sendMessage("§3Plugin author: §eCuzImTiger");
    Bukkit.getConsoleSender().sendMessage("§3Plugin status: §aAktiviert");
    Bukkit.getConsoleSender().sendMessage("§7-------------==+==-------------");
  }
  
  public void onDisable()
  {
	    Bukkit.getConsoleSender().sendMessage("§7-------------==+==-------------");
	    Bukkit.getConsoleSender().sendMessage("§3Plugin: §5NickSystem");
	    Bukkit.getConsoleSender().sendMessage("§3Plugin version: §e1.0");
	    Bukkit.getConsoleSender().sendMessage("§3Plugin author: §eCuzImTiger");
	    Bukkit.getConsoleSender().sendMessage("§3Plugin status: §cDeaktiviert");
	    Bukkit.getConsoleSender().sendMessage("§7-------------==+==-------------");
  }
  
  public static void registerListener()
  {
    Bukkit.getPluginManager().registerEvents(new Scoreboard1(), plugin);
  }
  
  public static Main getInstance()
  {
    return instance;
  }
  
  public static MySQL getSQL()
  {
    return sql;
  }
  
  public static Main getInstance1()
  /* 87:   */   {
  /* 88:90 */     return getInstance();
  /* 89:   */   }
  
}

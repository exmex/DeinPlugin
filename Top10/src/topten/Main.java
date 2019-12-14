package topten;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	Logger log = Logger.getLogger("Minecraft");
	  public FileConfiguration config;
	  
	  public void onEnable()
	  {
	    PluginDescriptionFile pdffile = getDescription();
	    this.log.info("[" + pdffile.getName() + "] v" + pdffile.getVersion() + " has been enabled!");
	    this.log.info("[" + pdffile.getName() + "] by SpigotPlugins");
	    getServer().getPluginManager().registerEvents( this, this);
	    loadConfiguration();
	  }
	  
	  public void onDisable()
	  {
	    PluginDescriptionFile pdffile = getDescription();
	    this.log.info("[" + pdffile.getName() + "] v" + pdffile.getVersion() + " Has been disabled!");
	    this.log.info("[" + pdffile.getName() + "] by SpigotPlugins");
	  }
	  
	  public void loadConfiguration()
	  {
	    this.config = getConfig();
	    this.config.options().copyDefaults(true);
	    saveConfig();
	  }
	  
	  @EventHandler
	  public void onPlayerDeath(PlayerDeathEvent event)
	  {
	    if ((event.getEntity().getKiller() instanceof Player))
	    {
	      Player killer = event.getEntity().getKiller();
	      int kills = 0;
	      if (this.config.contains("Kills." + killer.getName())) {
	        kills = this.config.getInt("Kills." + killer.getName());
	      }
	      if (!this.config.getStringList("Players").contains(killer.getName()))
	      {
	        List<String> list = getConfig().getStringList("Players");
	        list.add(killer.getName());
	        getConfig().set("Players", list);
	      }
	      getConfig().set("Kills." + killer.getName(), Integer.valueOf(kills + 1));
	      saveConfig();
	    }
	  }
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
	    if (cmd.getName().equalsIgnoreCase("top")) {
	      if ((sender instanceof ConsoleCommandSender))
	      {
	        this.log.info("The command 'SpigotPlugins',cannot be used from the console");
	      }
	
	      else if (args.length == 0)
	      {
	        loadConfiguration();
	        List<String> players = this.config.getStringList("Players");
	        
	        String[] top10Players = new String[10];
	        
	        int[] top10Killamount = new int[10];
	        boolean done = false;
	        for (Iterator localIterator = players.iterator(); localIterator.hasNext();)
	        {
	          String player = (String)localIterator.next();
	          int kills = this.config.getInt("Kills." + player);
	          done = false;
	          int i = 0;
	        }
	        sender.sendMessage("§7§m------------------------------------------");
	        for (int i1 = 0; i1 < 10; i1++)
	        {
	          String currentPlayer = top10Players[i1];
	          int currentKills = top10Killamount[i1];
	          int currentNumber = i1 + 1;
	          if(currentPlayer == null){
	        	  currentPlayer = "Unbekannt";
	          }
	          sender.sendMessage("§7┃ §eSoupPvP §8» §e#" + currentNumber + " §9" + currentPlayer + " §8» §e" + currentKills + " §3Kills");
	        }
	        sender.sendMessage("§7§m------------------------------------------");
	        saveConfig();
	      }
	      else
	      {
	    	  
	      }
	    }
	    return true;
	  }
	  
}

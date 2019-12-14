package de.tiger.NickSystem.commands;

import de.tiger.NickSystem.Main;
import de.tiger.NickSystem.manager.NickManager;
import de.tiger.NickSystem.manager.SkinUtils;
import de.tiger.NickSystem.message.English_Message;
import de.tiger.NickSystem.message.German_Message;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Nick
  implements CommandExecutor
{
  private Main plugin;
  
  public Nick(Main main)
  {
    this.plugin = main;
    this.plugin.getCommand("Nick").setExecutor(this);
  }
  
  public boolean onCommand(CommandSender cs, Command cmd, String lable, String[] args)
  {
    if ((cs instanceof Player))
    {
      final Player p = (Player)cs;
      if (!p.hasPermission("system.nick"))
      {
        if (this.plugin.getConfig().getString("Language").equalsIgnoreCase("de_DE")) {
          p.sendMessage(this.plugin.prefix + German_Message.NOPERMISSIONS);
        } else {
          p.sendMessage(this.plugin.prefix + English_Message.NOPERMISSIONS);
        }
        return true;
      }
      if (args.length == 0)
      {
        if (!NickManager.isNicked(p)) {
          NickManager.nick(p);
          
          
        } else {
          NickManager.unNick(p);
          
        }
      }
      else {
        p.sendMessage(this.plugin.prefix + "§7Benutze §8»§6 /" + cmd.getName());
      }
    }
    else
    {
      cs.sendMessage(this.plugin.prefix + "§4Du bist kein Spieler§8!");
    }
    return true;
  }
}

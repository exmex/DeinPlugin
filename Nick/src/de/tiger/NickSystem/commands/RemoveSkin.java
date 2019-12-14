package de.tiger.NickSystem.commands;

import de.tiger.NickSystem.Main;
import de.tiger.NickSystem.message.English_Message;
import de.tiger.NickSystem.message.German_Message;
import de.tiger.NickSystem.sql.MySQL;
import de.tiger.NickSystem.uuid.UUIDFetcher;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class RemoveSkin
  implements CommandExecutor
{
  private Main plugin;
  
  public RemoveSkin(Main main)
  {
    this.plugin = main;
    this.plugin.getCommand("removeSkin").setExecutor(this);
  }
  
  public boolean onCommand(CommandSender cs, Command cmd, String lable, String[] args)
  {
    if ((cs instanceof Player))
    {
      Player p = (Player)cs;
      if (!p.hasPermission("Nick.removeSkin"))
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
        
        UUID id = UUIDFetcher.getUUID(name);
        if (id == null)
        {
          p.sendMessage(this.plugin.prefix + "§cDieser Spieler wurde nicht gefunden§8.");
          return true;
        }
        if (Main.getInstance().getConfig().getBoolean("MySQL.Enable"))
        {
          try
          {
            PreparedStatement ps = Main.getSQL().getStatement("DELETE FROM nickids WHERE uuid=?");
            ps.setString(1, id.toString());
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
          List<String> nicks = Main.getInstance().getConfig().getStringList("Skins");
          nicks.remove(id.toString());
          
          Main.getInstance().getConfig().set("Skins", nicks);
          Main.getInstance().saveConfig();
        }
        if (Main.getInstance().getConfig().getString("Language").equalsIgnoreCase("de_DE")) {
          p.sendMessage(this.plugin.prefix + German_Message.SKINREMOVED.replace("{Name}", name));
        } else {
          p.sendMessage(this.plugin.prefix + English_Message.SKINREMOVED.replace("{Name}", name));
        }
      }
      else
      {
        p.sendMessage(this.plugin.prefix + "§7Benutze §8»§6 /" + cmd.getName() + " §8[§aName§8]");
      }
    }
    else
    {
      cs.sendMessage(this.plugin.prefix + "§4Du bist kein Spieler§8!");
    }
    return true;
  }
}

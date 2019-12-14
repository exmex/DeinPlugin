package de.golgolex.freebuild.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.golgolex.freebuild.methods.Data;

public class CMD_tpa implements CommandExecutor{
	
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tpa")) {
            Player p = (Player)sender;
            if (args.length == 0) {
                Player tar = Bukkit.getPlayer((String)args[0]);
                p.sendMessage(Data.pr + "§7Du hast §2" + tar.getName() + "§7 eine TPA Anfage gesendet!");
                tar.sendMessage("");
                tar.sendMessage(Data.pr + "§7Der Spieler §2" + p.getName() + "§7 hat dir eine TPA Anfage gesendet!");
                tar.sendMessage("");
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("accept")) {
                    Player tar = Bukkit.getPlayer((String)args[1]);
                    p.sendMessage(Data.pr + "§7Du hast die Teleportanfage angenommen!");
                    tar.sendMessage(Data.pr + "§7Du wirst nun zu §2" + p.getName() + "§7 teleportiert!");
                }
            } else {
                p.sendMessage(Data.pr + "§7Bitte benutze §2/tpa [Spieler]");
            }
        }
        return false;
    }

}

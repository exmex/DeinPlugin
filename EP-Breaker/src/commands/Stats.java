package commands;

import data.Data;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utils.StatsAPI;

/**
 * Created by regnatrix on 10.12.16.
 */
public class Stats implements CommandExecutor{



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {


        Player p = (Player)sender;


        if(cmd.getName().equalsIgnoreCase("stats")) {
            if(args.length == 0) {
                p.sendMessage("▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌");
                p.sendMessage("           §b§lStats-System");
                p.sendMessage("§7§lKills §8➤ §7 " + StatsAPI.getKills(p.getName()));
                p.sendMessage("§7§lTode §8➤ §7 " + StatsAPI.getTode(p.getName()));
                p.sendMessage("§7§lVom Wem §8➤ §7Dir");
                p.sendMessage("▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌▌");
            }else {
                p.sendMessage(Data.Prefix + " §7Gebe nur /stats ein!");
            }
        }
        return false;
    }
}

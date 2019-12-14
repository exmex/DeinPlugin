package listener;

import org.bukkit.entity.Player;

public class getRealTag {

    public static String getRealRankColor(Player p ) {
        String tag = "";


        if(p.hasPermission("chat.admin")) {
            tag = "§3Admin §8| §3";
        }else if(p.hasPermission("chat.dev")) {
            tag = "§bDev §8| §b";
        }else if(p.hasPermission("chat.srmod")) {
            tag = "§4SrMod §8| §4";
        }else if(p.hasPermission("chat.mod")) {
            tag = "§cMod §8| §c";
        }else if(p.hasPermission("chat.sup")) {
            tag = "§eSup §8| §e";
        }else if(p.hasPermission("chat.yt")) {
            tag = "§5YT §8| §5";
        }else if(p.hasPermission("chat.vip")) {
            tag = "§2VIP §8| §2";
        }else if(p.hasPermission("chat.premi")) {
            tag = "§6";
        }else {
            tag = "§a";
        }

        return tag;
    }
}

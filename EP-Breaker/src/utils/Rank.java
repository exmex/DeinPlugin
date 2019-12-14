package utils;

import org.bukkit.entity.Player;

import static de.regnatrix.epbreaker.Main.rusher;

/**
 * Created by regnatrix on 05.11.16.
 */
public enum Rank {

    Admin("chat.admin", "§3Admin §8┃ §3", "§3Administrator", "§3Administrator §8┃ §3"), Developer("chat.dev", "§bDev §8┃ §b", "§bDeveloper", "§bDeveloper §8┃ §b"), SrMod("chat.srmod", "§4SrMod §8┃ §4", "§4SrModerator", "§4SrModerator §8┃ §4"),
    Mod("chat.mod", "§cMod §8┃ §c", "§cModerator", "§cModerator §8┃ §c"), Sup("chat.sup", "§eSup §8┃ §e", "§eSupporter" , "§eSupporter §8┃ §e"), YouTube("chat.yt", "§5YT §8┃ §5", "§5YouTuber", "§5YouTuber §8┃ §5"),
    VIP("chat.vip", "§2VIP §8┃ §2", "§2VIP" , ""), Premium("chat.premi", "§6", "§6Premium" , "§6Premium §8┃ §6"), Spieler("", "§a", "§aSpieler ", "§aSpieler §8┃ §a");

    public String Permission;
    public String Prefix;
    public String Color;
    public String Chat;

    Rank(String permission, String prefix, String color, String chat) {
        Permission = permission;
        Prefix = prefix;
        Color = color;
        Chat = chat;
    }

    public static Rank getRank(Player p) {
        for (Rank r : Rank.values()) {
            if (p.hasPermission(r.Permission)) return r;
        }
        return Spieler;
    }
}

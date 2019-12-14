package utils;

import data.Data;
import gemestates.GameStateHandler;
import gemestates.IngameState;
import gemestates.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import static de.regnatrix.epbreaker.Main.basedev;
import static de.regnatrix.epbreaker.Main.rusher;

/**
 * Created by regnatrix on 23.11.16.
 */
public class sb {

    public static void SetScoreboard(Player p) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                update(all);
            }
    }



    public static  void update(Player p)  {


        Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();

        Team admin;
        Team dev;
        Team srmod;
        Team mod;
        Team sup;
        Team yt;
        Team vip;
        Team premi;
        Team spieler;




        admin = sb.registerNewTeam("00000Admin");
        admin.setPrefix(Rank.Admin.Prefix);

        dev = sb.registerNewTeam("00001Dev");
        dev.setPrefix(Rank.Developer.Prefix);

        srmod = sb.registerNewTeam("00002SrMod");
        srmod.setPrefix(Rank.SrMod.Prefix);

        mod = sb.registerNewTeam("00003Mod");
        mod.setPrefix(Rank.Mod.Prefix);

        sup = sb.registerNewTeam("00004Sup");
        sup.setPrefix(Rank.Sup.Prefix);

        yt = sb.registerNewTeam("00005YT");
        yt.setPrefix(Rank.YouTube.Prefix);

        vip = sb.registerNewTeam("00006VIP");
        vip.setPrefix(Rank.VIP.Prefix);

        premi = sb.registerNewTeam("00007premi");
        premi.setPrefix(Rank.Premium.Prefix);


        spieler = sb.registerNewTeam("00008spieler");
        spieler.setPrefix(Rank.Spieler.Prefix);




        Objective obj = sb.registerNewObjective("ddd" , "sss");

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§cVisatic.de");

        if(GameStateHandler.getCureGameState() instanceof LobbyState) {
            obj.getScore("§8➜ §eMap").setScore(9);
            obj.getScore("  §8● §eRush").setScore(8);
        }


        if(GameStateHandler.getCureGameState() instanceof IngameState) {


            obj.getScore("§f➜ §7Dein Team").setScore(9);
            if(rusher.contains(p)) {
                obj.getScore("  §f● §cRusher").setScore(8);
            }else if (basedev.contains(p)) {
                obj.getScore("  §f● §cBaseDev").setScore(8);
            }

            obj.getScore("§8§8§8§8§8§8§8§8§8§8§8§8§8§8§8§8§8").setScore(7);

            obj.getScore("§f➜ §7Spieler").setScore(6);
            obj.getScore("  §f● §6 " + Data.playing.size()).setScore(5);
        }
        for (Player all : Bukkit.getOnlinePlayers()) {
            switch (Rank.getRank(all)) {
                case Admin:
                    admin.addPlayer(all);
                    break;
                case Developer:
                    dev.addPlayer(all);
                    break;
                case SrMod:
                    srmod.addPlayer(all);
                    break;
                case Mod:
                    mod.addPlayer(all);
                    break;
                case Sup:
                    sup.addPlayer(all);
                    break;
                case YouTube:
                    yt.addPlayer(all);
                    break;
                case VIP:
                    vip.addPlayer(all);
                    break;
                case Premium:
                    premi.addPlayer(all);
                    break;
                case Spieler:
                    spieler.addPlayer(all);
                    break;
            }
            p.setScoreboard(sb);
        }


    }


}

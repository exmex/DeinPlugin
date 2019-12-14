package de.Niclas.EarlyHG;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Team;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Scoreboard {
	public static String nextevent = "Laden";
    public static File file = new File("plugins/Lobby", "nexteventfuerfalki.yml");
    public static YamlConfiguration yamlcfg = YamlConfiguration.loadConfiguration((File)file);

    public static Team getTeamForPlayer(org.bukkit.scoreboard.Scoreboard board, Player forWhom) {
        if (PermissionsEx.getUser((Player)forWhom).inGroup("Owner")) {
            return board.getTeam("a");
        }
        if (PermissionsEx.getUser((Player)forWhom).inGroup("Admin")) {
            return board.getTeam("b");
        }
        if (PermissionsEx.getUser((Player)forWhom).inGroup("Moderator")) {
            return board.getTeam("d");
        }
        if (PermissionsEx.getUser((Player)forWhom).inGroup("Supporter")) {
            return board.getTeam("e");
        }
        if (PermissionsEx.getUser((Player)forWhom).inGroup("Developer")) {
            return board.getTeam("c");
        }
        if (PermissionsEx.getUser((Player)forWhom).inGroup("YouTuber")) {
            return board.getTeam("f");
        }
        if (PermissionsEx.getUser((Player)forWhom).inGroup("JrYouTuber")) {
            return board.getTeam("g");
        }
        if (PermissionsEx.getUser((Player)forWhom).inGroup("Ultra")) {
            return board.getTeam("h");
        }
        if (PermissionsEx.getUser((Player)forWhom).inGroup("Hero")) {
            return board.getTeam("i");
        }
        if (PermissionsEx.getUser((Player)forWhom).inGroup("Gold") || PermissionsEx.getUser((Player)forWhom).inGroup("Premium")) {
            return board.getTeam("j");
        }
        return board.getTeam("k");
    }

    public static Team searchTeamsForEntry(Player forWhom, String entry) {
        if (forWhom.getScoreboard() == null) {
            Scoreboard.setScoreboard(forWhom);
        }
        org.bukkit.scoreboard.Scoreboard board = forWhom.getScoreboard();
        for (Team team : board.getTeams()) {
            if (!team.hasEntry(entry)) continue;
            return team;
        }
        return null;
    }
    public static void setScoreboard(Player p) {
        org.bukkit.scoreboard.Scoreboard board2 = Bukkit.getScoreboardManager().getNewScoreboard();
        Team owner = board2.registerNewTeam("a");
        Team admin = board2.registerNewTeam("b");
        Team developer = board2.registerNewTeam("c");
        Team mod = board2.registerNewTeam("d");
        Team supp = board2.registerNewTeam("e");
        Team youtuber = board2.registerNewTeam("f");
        Team jryoutuber = board2.registerNewTeam("g");
        Team ultra = board2.registerNewTeam("h");
        Team hero = board2.registerNewTeam("i");
        Team gold = board2.registerNewTeam("j");
        Team spieler = board2.registerNewTeam("k");
        spieler.setPrefix(ChatColor.GREEN + "");
        gold.setPrefix(ChatColor.GOLD + "" + (Object)ChatColor.DARK_GRAY + (Object)ChatColor.GOLD);
        hero.setPrefix(ChatColor.DARK_AQUA + "" + (Object)ChatColor.DARK_GRAY + (Object)ChatColor.DARK_AQUA);
        ultra.setPrefix(ChatColor.YELLOW + "" + (Object)ChatColor.DARK_GRAY + (Object)ChatColor.YELLOW);
        jryoutuber.setPrefix(ChatColor.DARK_PURPLE + "" + (Object)ChatColor.DARK_GRAY + (Object)ChatColor.DARK_PURPLE);
        youtuber.setPrefix(ChatColor.DARK_PURPLE + "" + (Object)ChatColor.DARK_GRAY + (Object)ChatColor.DARK_PURPLE);
        supp.setPrefix(ChatColor.BLUE + "" + (Object)ChatColor.DARK_GRAY + (Object)ChatColor.BLUE);
        mod.setPrefix(ChatColor.RED + "" + (Object)ChatColor.DARK_GRAY + (Object)ChatColor.RED);
        developer.setPrefix(ChatColor.AQUA + "" + (Object)ChatColor.DARK_GRAY +(Object)ChatColor.AQUA);
        admin.setPrefix(ChatColor.RED + "" + (Object)ChatColor.DARK_GRAY +(Object)ChatColor.RED);
        owner.setPrefix(ChatColor.DARK_RED + "" + (Object)ChatColor.DARK_GRAY +  (Object)ChatColor.DARK_RED);
        for (Player all : Bukkit.getOnlinePlayers()) {
            Team playerTeam = Scoreboard.getTeamForPlayer(board2, all);
            if (playerTeam.hasEntry(all.getName())) continue;
            playerTeam.addEntry(all.getName());
        }
		Objective ob = board2.registerNewObjective("lobby", "system");
			ob.setDisplaySlot(DisplaySlot.SIDEBAR);
			ob.setDisplayName("§7» §9ClayMC.net §7«");
			Score sm0 = ob.getScore(ChatColor.GREEN.toString());
			    Score sm1 = ob.getScore("§7» §e§lDeine Kills:");
			    Score sm2 = ob.getScore(net.md_5.bungee.api.ChatColor.LIGHT_PURPLE.toString() + "   §6" + Listeners.getKills(p.getUniqueId()));
				Score s = ob.getScore(ChatColor.RED.toString());
				Score s0 = ob.getScore("§7» §c§lDeine Tode:");
				Score s1 = ob.getScore(ChatColor.GOLD.toString() + "   §6" + Listeners.getDeaths(p.getUniqueId()));
				Score s2 = ob.getScore(ChatColor.YELLOW.toString());
				Score s3 = ob.getScore("§7» §3§lDeine KD/R:");
				Score s4 = ob.getScore("   §6"+ (Listeners.getKills(p.getUniqueId()) / (Listeners.getDeaths(p.getUniqueId()) > 0 ? Double.valueOf(Listeners.getDeaths(p.getUniqueId())) : 1)));
				Score s5 = ob.getScore(ChatColor.AQUA.toString());
				Score s6 = ob.getScore("§7» §9§lTeamSpeak:");
				Score s7 = ob.getScore("   §aClayMC.net");
				

				s7.setScore(1);
				s6.setScore(2);
				s5.setScore(3);
				s4.setScore(4);
				s3.setScore(5);
				s2.setScore(6);
				s1.setScore(7);
				s0.setScore(8);
				s.setScore(9);
				sm1.setScore(11);
				sm2.setScore(10);
				sm0.setScore(12);


				p.setScoreboard(board2);
	}

}

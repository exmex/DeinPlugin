package de.golgolex.freebuild.methods;

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
        if (PermissionsEx.getUser(forWhom).inGroup("Owner")) {
            return board.getTeam("a");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Admin")) {
            return board.getTeam("b");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Developer")) {
            return board.getTeam("c");
        }
        if(PermissionsEx.getUser(forWhom).inGroup("Script")){
        	return board.getTeam("d");
        }
        if(PermissionsEx.getUser(forWhom).inGroup("SrModerator")){
        	return board.getTeam("e");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Moderator")) {
            return board.getTeam("f");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Supporter")) {
            return board.getTeam("g");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Builder")) {
            return board.getTeam("h");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("YouTuber")) {
            return board.getTeam("i");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("JrYouTuber")) {
            return board.getTeam("j");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Legend")) {
            return board.getTeam("k");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Ultra")) {
            return board.getTeam("l");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Hero")) {
            return board.getTeam("m");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Gold") || PermissionsEx.getUser(forWhom).inGroup("Premium")) {
            return board.getTeam("n");
        }
        return board.getTeam("o");
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
        Team manager = board2.registerNewTeam("d");
        Team srmoderator = board2.registerNewTeam("e");
        Team mod = board2.registerNewTeam("f");
        Team supp = board2.registerNewTeam("g");
        Team builder = board2.registerNewTeam("h");
        Team youtuber = board2.registerNewTeam("i");
        Team jryoutuber = board2.registerNewTeam("j");
        Team legend = board2.registerNewTeam("k");
        Team ultra = board2.registerNewTeam("l");
        Team hero = board2.registerNewTeam("m");
        Team gold = board2.registerNewTeam("n");
        Team spieler = board2.registerNewTeam("o");
        spieler.setPrefix(ChatColor.GRAY + "");
        gold.setPrefix(ChatColor.GOLD + "Gold" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.GOLD);
        hero.setPrefix(ChatColor.DARK_AQUA + "Hero" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.DARK_AQUA);
        ultra.setPrefix(ChatColor.GREEN + "Ultra" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.GREEN);
        legend.setPrefix("§dLegend" + (Object)ChatColor.DARK_GRAY + " \u25cf " + "§d");
        jryoutuber.setPrefix(ChatColor.DARK_PURPLE + "JrYT" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.DARK_PURPLE);
        youtuber.setPrefix(ChatColor.DARK_PURPLE + "YT" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.DARK_PURPLE);
        supp.setPrefix(ChatColor.BLUE + "Supp" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.BLUE);
        builder.setPrefix(ChatColor.YELLOW + "Builder" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.YELLOW);
        mod.setPrefix(ChatColor.RED + "Mod" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.RED);
        srmoderator.setPrefix(ChatColor.RED + "SrMod" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.RED);
        manager.setPrefix("§3Script" + (Object)ChatColor.DARK_GRAY + " \u25cf §3");
        developer.setPrefix(ChatColor.AQUA + "Dev" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.AQUA);
        admin.setPrefix(ChatColor.RED + "Admin" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.RED);
        owner.setPrefix(ChatColor.DARK_RED + "Owner" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.DARK_RED);
        for (Player all : Bukkit.getOnlinePlayers()) {
            Team playerTeam = Scoreboard.getTeamForPlayer(board2, all);
            if (playerTeam.hasEntry(all.getName())) continue;
            playerTeam.addEntry(all.getName());
        }
        Objective ob = board2.registerNewObjective("lobby", "system");
        
        ob.setDisplaySlot(DisplaySlot.SIDEBAR);
        ob.setDisplaySlot(DisplaySlot.SIDEBAR);
        ob.setDisplayName("   \u00a73FreeBuild");
        Score sm0 = ob.getScore(ChatColor.GREEN.toString());
        Score sm1 = ob.getScore("   \u00a7a\u00a7l\u272f\u00a77 \u00bb\u00a7f Kills:");
        Score sm2 = ob.getScore(String.valueOf(net.md_5.bungee.api.ChatColor.LIGHT_PURPLE.toString()) + "   \u00a79" + Statsmanager.getKill(p.getUniqueId()));
        Score s = ob.getScore(ChatColor.RED.toString());
        Score s0 = ob.getScore("   \u00a7c\u00a7l\u271e \u00a77\u00bb \u00a7fTode:");
        Score s1 = ob.getScore(String.valueOf(ChatColor.GOLD.toString()) + "   \u00a79" + Statsmanager.getDeaths(p.getUniqueId()));
        Score s2 = ob.getScore(ChatColor.YELLOW.toString());
        Score s3 = ob.getScore("   \u00a7b\u00a7l\u270c\u00a77 \u00bb \u00a7fCoins:");
        Score s4 = ob.getScore("   \u00a79" + Statsmanager.getCoins(p.getUniqueId()));
        Score s5 = ob.getScore(ChatColor.AQUA.toString());
        Score s6 = ob.getScore("   \u00a76\u00a7l\u03a6 \u00a77\u00bb\u00a7f Online:");
        Score s7 = ob.getScore(ChatColor.DARK_AQUA + "   \u00a79" + Bukkit.getOnlinePlayers().size());
        Score s9 = ob.getScore(ChatColor.DARK_GREEN.toString());
        s9.setScore(1);
        s7.setScore(2);
        s6.setScore(3);
        s5.setScore(4);
        s4.setScore(5);
        s3.setScore(6);
        s2.setScore(7);
        s1.setScore(8);
        s0.setScore(9);
        s.setScore(10);
        sm1.setScore(12);
        sm2.setScore(11);
        sm0.setScore(13);
		p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
        p.setScoreboard(board2);
    }

}

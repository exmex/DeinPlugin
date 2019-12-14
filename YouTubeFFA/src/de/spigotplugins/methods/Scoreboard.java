package de.spigotplugins.methods;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Team;

import de.spigotplugins.ffa.main.Main;
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
        if(PermissionsEx.getUser(forWhom).inGroup("SrModerator")){
        	return board.getTeam("d");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Moderator")) {
            return board.getTeam("e");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Supporter")) {
            return board.getTeam("f");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Builder")) {
            return board.getTeam("g");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Developer")) {
            return board.getTeam("c");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("YouTuber")) {
            return board.getTeam("h");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("JrYouTuber")) {
            return board.getTeam("i");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Legend")) {
            return board.getTeam("j");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Ultra")) {
            return board.getTeam("k");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Hero")) {
            return board.getTeam("l");
        }
        if (PermissionsEx.getUser(forWhom).inGroup("Gold") || PermissionsEx.getUser(forWhom).inGroup("Premium")) {
            return board.getTeam("m");
        }
        return board.getTeam("n");
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
        Team srmoderator = board2.registerNewTeam("d");
        Team mod = board2.registerNewTeam("e");
        Team supp = board2.registerNewTeam("f");
        Team builder = board2.registerNewTeam("g");
        Team youtuber = board2.registerNewTeam("h");
        Team jryoutuber = board2.registerNewTeam("i");
        Team legend = board2.registerNewTeam("j");
        Team ultra = board2.registerNewTeam("k");
        Team hero = board2.registerNewTeam("l");
        Team gold = board2.registerNewTeam("m");
        Team spieler = board2.registerNewTeam("n");
        spieler.setPrefix(ChatColor.GRAY + "");
        gold.setPrefix(ChatColor.GOLD + "Gold" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.GOLD);
        hero.setPrefix(ChatColor.DARK_AQUA + "Hero" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.DARK_AQUA);
        ultra.setPrefix(ChatColor.GREEN + "Ultra" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.GREEN);
        legend.setPrefix("Legend" + (Object)ChatColor.DARK_GRAY + " \u25cf " + "§d");
        jryoutuber.setPrefix(ChatColor.DARK_PURPLE + "JrYT" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.DARK_PURPLE);
        youtuber.setPrefix(ChatColor.DARK_PURPLE + "YT" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.DARK_PURPLE);
        supp.setPrefix(ChatColor.BLUE + "Supp" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.BLUE);
        builder.setPrefix(ChatColor.YELLOW + "Builder" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.YELLOW);
        mod.setPrefix(ChatColor.RED + "Mod" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.RED);
        srmoderator.setPrefix(ChatColor.RED + "SrMod" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.RED);
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
        ob.setDisplayName("§8» §eFFA §8«");
        ob.getScore(" ").setScore(12);
        ob.getScore("§a§lKills:").setScore(11);
        ob.getScore(ChatColor.GREEN.toString() + "§8» §6" + StatsManager.kills.get(p.getUniqueId())).setScore(10);
        ob.getScore("  ").setScore(9);
        ob.getScore("§c§lTode:").setScore(8);
        ob.getScore(ChatColor.BLACK.toString() + "§8» §6" + StatsManager.deaths.get(p.getUniqueId())).setScore(7);
        ob.getScore("   ").setScore(6);
        ob.getScore("§f§lSpieler:").setScore(5);
        ob.getScore("§8» §e" + Bukkit.getOnlinePlayers().size()).setScore(4);
        ob.getScore("    ").setScore(3);
        ob.getScore("§f§lMap:").setScore(2);
        ob.getScore("§8» §e" + Main.MapName).setScore(1);
        ob.getScore("        ").setScore(0);
        p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
        p.setScoreboard(board2);
    }
    

}

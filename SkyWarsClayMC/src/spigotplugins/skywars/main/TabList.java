package spigotplugins.skywars.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import NickSystem.Manager.NickManager;
import ru.tehkode.permissions.bukkit.PermissionsEx;



public class TabList {
	public static String nextevent = "Laden";
    public static File file = new File("plugins/Lobby", "nexteventfuerfalki.yml");
    public static YamlConfiguration yamlcfg = YamlConfiguration.loadConfiguration((File)file);

    public static Team getTeamForPlayer(org.bukkit.scoreboard.Scoreboard board, Player forWhom) {
    	if(NickManager.isNicked(forWhom)){
    		return board.getTeam("o");
    	}
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
            TabList.setScoreboard(forWhom);
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
            Team playerTeam = TabList.getTeamForPlayer(board2, all);
            if (playerTeam.hasEntry(all.getName())) continue;
            playerTeam.addEntry(all.getName());
        }
        Objective ob = board2.registerNewObjective("lobby", "system");
        ob.setDisplaySlot(DisplaySlot.SIDEBAR);
        if (nextevent == "Laden") {
            if (!yamlcfg.contains("nextevent")) {
                yamlcfg.set("nextevent", (Object)"Nicht bestimmt");
                try {
                    yamlcfg.save(file);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                nextevent = yamlcfg.getString("nextevent");
            }
        }
       p.setScoreboard(board2);
    }
}

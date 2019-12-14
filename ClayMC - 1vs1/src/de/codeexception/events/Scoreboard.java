package de.codeexception.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Scoreboard {
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
	        spieler.setPrefix(ChatColor.GRAY + "");
	        gold.setPrefix(ChatColor.GOLD + "Gold" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.GOLD);
	        hero.setPrefix(ChatColor.DARK_AQUA + "Hero" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.DARK_AQUA);
	        ultra.setPrefix(ChatColor.GREEN + "Ultra" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.GREEN);
	        jryoutuber.setPrefix(ChatColor.DARK_PURPLE + "JrYT" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.DARK_PURPLE);
	        youtuber.setPrefix(ChatColor.DARK_PURPLE + "YT" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.DARK_PURPLE);
	        supp.setPrefix(ChatColor.BLUE + "Supp" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.BLUE);
	        mod.setPrefix(ChatColor.RED + "Mod" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.RED);
	        developer.setPrefix(ChatColor.AQUA + "Dev" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.AQUA);
	        admin.setPrefix(ChatColor.RED + "Admin" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.RED);
	        owner.setPrefix(ChatColor.DARK_RED + "Owner" + (Object)ChatColor.DARK_GRAY + " \u25cf " + (Object)ChatColor.DARK_RED);
	        for (Player all : Bukkit.getOnlinePlayers()) {
	            Team playerTeam = Scoreboard.getTeamForPlayer(board2, all);
	            if (playerTeam.hasEntry(all.getName())) continue;
	            playerTeam.addEntry(all.getName());
	        }
	        p.setScoreboard(board2);
	    }

}

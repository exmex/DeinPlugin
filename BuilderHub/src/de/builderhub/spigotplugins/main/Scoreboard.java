package de.builderhub.spigotplugins.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Team;

import ru.tehkode.permissions.bukkit.PermissionsEx;


public class Scoreboard {
	 public static String nextevent = "Laden";

	    public static Team getTeamForPlayer(org.bukkit.scoreboard.Scoreboard board, Player forWhom) {
	        if (PermissionsEx.getUser(forWhom).inGroup("Team")) {
	            return board.getTeam("a");
	        }else
	        if (PermissionsEx.getUser(forWhom).inGroup("TeamS")) {
	            return board.getTeam("b");
	        }else
	        if (PermissionsEx.getUser(forWhom).inGroup("TeamB")) {
	            return board.getTeam("c");   
	        }else
	        if (PermissionsEx.getUser(forWhom).inGroup("Fort")) {
	            return board.getTeam("d");   
	        }else{
	        return board.getTeam("e");
	    }
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
	        Team Team = board2.registerNewTeam("a");
	        Team TeamS = board2.registerNewTeam("b");
	        Team TeamB = board2.registerNewTeam("c");
	        Team Fort = board2.registerNewTeam("d");
	        Team Default = board2.registerNewTeam("e");
	        
	        Default.setPrefix(ChatColor.GRAY + "");
	        Team.setPrefix("§b");
	        TeamS.setPrefix("§9");
	        TeamB.setPrefix("§e");
	        Fort.setPrefix("§3");
	      
	        for (Player all : Bukkit.getOnlinePlayers()) {
	            Team playerTeam = Scoreboard.getTeamForPlayer(board2, all);
	            if (playerTeam.hasEntry(all.getName())) continue;
	            playerTeam.addEntry(all.getName());
	        }
	        Objective ob = board2.registerNewObjective("lobby", "system");
	        ob.setDisplaySlot(DisplaySlot.SIDEBAR);
	        ob.setDisplayName("§8➢ §3§lBauServer ");
	        ob.getScore("").setScore(12);
	        ob.getScore("§7➢ §6Lobby§7:").setScore(11);
	        ob.getScore(ChatColor.GREEN.toString() + "   §7" + Bukkit.getOnlinePlayers().size()).setScore(10);
	        ob.getScore("  ").setScore(9);
	        ob.getScore("§7➢ §3Gäste-Server§7:").setScore(8);
	        ob.getScore(ChatColor.AQUA.toString() + "   §7" + Main.gastPlayers).setScore(7);
	        ob.getScore("   ").setScore(6);
	        ob.getScore("§7➢ §3F-Server§7:§b").setScore(5);
	        ob.getScore(ChatColor.BLACK.toString() + "   §7" + Main.fortPlayers).setScore(4);
	        ob.getScore("    ").setScore(3);
	        ob.getScore("§7➢ §3Team-Server§7:").setScore(2);
	        ob.getScore(ChatColor.BLUE.toString() + "   §7" + Main.teamPlayers).setScore(1);
	        ob.getScore(" ").setScore(0);
			p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
	        p.setScoreboard(board2);
	    }
	    

}

package lobby.methods;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Team;

import de.golgolex.coinsapi.main.CoinsAPI;
import lobby.data.Data;
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
        ob.setDisplayName("§8» §3§lClayMC §8«");
        Score sm0 = ob.getScore(ChatColor.GREEN.toString());
        String total = null;
        Score sm1 = ob.getScore("§8» §f§lDein Rang:");
        String group = PermissionsEx.getUser(p).getGroups()[0].getName();
        if(group.equalsIgnoreCase("default")){
        	total = "§7Spieler";
        }else if(group.equalsIgnoreCase("Gold")){
        	total = "§6Gold";
        }else if(group.equalsIgnoreCase("Hero")){
        	total = "§3Hero";
        }else if(group.equalsIgnoreCase("Ultra")){
        	total = "§bUltra";
        }else if(group.equalsIgnoreCase("Legend")){
        	total = "§dLegend";
        }else if(group.equalsIgnoreCase("JrYoutuber")){
        	total = "§5JrYouTuber";
        }else if(group.equalsIgnoreCase("Youtuber")){
        	total = "§5YouTuber";
        }else if(group.equalsIgnoreCase("Supporter")){
        	total = "§9Supporter";
        }else if(group.equalsIgnoreCase("Moderator")){
        	total = "§cModerator";
        }else if(group.equalsIgnoreCase("SrModerator")){
        	total = "§cSrModerator";
        }else if(group.equalsIgnoreCase("Admin")){
        	total = "§cAdministrator";
        }else if(group.equalsIgnoreCase("Owner")){
        	total = "§4Inhaber";
        }else if(group.equalsIgnoreCase("Developer")){
        	total = "§bDeveloper";
        }else if(group.equalsIgnoreCase("Script")){
        	total = "§3Script";
        }else{
        	total = "§7Unbekannt";
        }
        Score s10 = ob.getScore("   " + total);
        
        Score s = ob.getScore(ChatColor.RED.toString());
        Score s0 = ob.getScore("§8» §f§lProfil:");
        Score s1 = ob.getScore("   §a" + p.getName());
        Score s2 = ob.getScore(ChatColor.YELLOW.toString());
        Score s6 = ob.getScore("§8» §f§lClays:");
        Score s7 = ob.getScore("   §6" + "" + CoinsAPI.getCoins(p));
        Score s8 = ob.getScore("§8» §f§lWebseite:");
        Score s88 = ob.getScore(ChatColor.DARK_PURPLE.toString());
        Score s9 = ob.getScore("   §eClayMC.net");
        s9.setScore(1);
        s8.setScore(2);
        s88.setScore(3);
        s7.setScore(4);
        s6.setScore(5);
        s2.setScore(6);
        s1.setScore(7);
        s0.setScore(8);
        s.setScore(9);
        s10.setScore(10);
        sm1.setScore(11);
        sm0.setScore(12);
		p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
        p.setScoreboard(board2);
    }
}

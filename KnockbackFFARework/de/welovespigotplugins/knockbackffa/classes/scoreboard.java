/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.entity.Player
 *  org.bukkit.scoreboard.DisplaySlot
 *  org.bukkit.scoreboard.Objective
 *  org.bukkit.scoreboard.Score
 *  org.bukkit.scoreboard.Scoreboard
 *  org.bukkit.scoreboard.Team
 *  ru.tehkode.permissions.bukkit.PermissionsEx
 */
package de.welovespigotplugins.knockbackffa.classes;

import de.welovespigotplugins.knockbackffa.classes.levelsystem;
import de.welovespigotplugins.knockbackffa.classes.statsmanager;
import java.util.HashMap;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class scoreboard {
    public static void setScoreboard(Player p) {
        Scoreboard board2 = Bukkit.getScoreboardManager().getNewScoreboard();
        
        Objective ob = board2.registerNewObjective("lobby", "system");
        ob.setDisplaySlot(DisplaySlot.SIDEBAR);
        ob.setDisplayName("   \u00a73\u00a7lK\u00a73nockback\u00a73\u00a7lFFA");
        Score sm0 = ob.getScore(ChatColor.GREEN.toString());
        Score sm1 = ob.getScore("   \u00a7a\u00a7l\u272f\u00a77 \u00bb\u00a7f Kills:");
        Score sm2 = ob.getScore(String.valueOf(net.md_5.bungee.api.ChatColor.LIGHT_PURPLE.toString()) + "   \u00a79" + statsmanager.kills.get((Object)p));
        Score s = ob.getScore(ChatColor.RED.toString());
        Score s0 = ob.getScore("   \u00a7c\u00a7l\u271e \u00a77\u00bb \u00a7fTode:");
        Score s1 = ob.getScore(String.valueOf(ChatColor.GOLD.toString()) + "   \u00a79" + statsmanager.deaths.get((Object)p));
        Score s2 = ob.getScore(ChatColor.YELLOW.toString());
        Score s3 = ob.getScore("   \u00a7b\u00a7l\u270c\u00a77 \u00bb \u00a7fCoins:");
        Score s4 = ob.getScore("   \u00a79" + statsmanager.coins.get((Object)p));
        Score s5 = ob.getScore(ChatColor.AQUA.toString());
        Score s6 = ob.getScore("   \u00a76\u00a7l\u03a6 \u00a77\u00bb\u00a7f Level:");
        Score s7 = ob.getScore((Object)ChatColor.DARK_AQUA + "   \u00a79" + levelsystem.level.get((Object)p));
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
        p.setScoreboard(board2);
    }
}


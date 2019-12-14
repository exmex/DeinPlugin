package de.leitung.scoreboardstats.classes;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

import net.minecraft.server.v1_8_R3.Scoreboard;

public class StatsScoreboard {

	public static void setScoreboard(Player p){
		Scoreboard board = (Scoreboard) Bukkit.getScoreboardManager().getNewScoreboard();
		Objective ob = board.setDisplaySlot(DisplaySlot.SIDEBAR);
	}
}

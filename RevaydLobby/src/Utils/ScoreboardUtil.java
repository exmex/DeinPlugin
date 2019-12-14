package Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import ru.tehkode.permissions.bukkit.PermissionsEx;
import Main.Main;


public class ScoreboardUtil {
	
	public static String getRang(Player p){
		if(Main.playerRank.get(p.getUniqueId()) == null){
			String prefix;
			prefix = PermissionsEx.getUser(p).getPrefix();
			if(prefix.contains("§9")){
				prefix = "§9Spieler";
			}else if(prefix.contains("§5")){
				prefix = "§5Youtuber";
			}else if(prefix.contains("§6")){
				prefix = "§6Premium";
			}else{
				prefix = PermissionsEx.getUser(p).getPrefix().replace("§8▏", "").replace(" ", "");
			}

			Main.playerRank.put(p.getUniqueId(), prefix);
			return prefix;
		}else{
			String prefix = Main.playerRank.get(p.getUniqueId());
			return prefix;
		}
	}
	
	public static void updateScoreboard(final Player p) {
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			public void run() {
				ScoreboardManager sm = Bukkit.getScoreboardManager();
				Scoreboard sb = sm.getNewScoreboard();
				Objective score = sb.registerNewObjective("aaa", "bbb");
				score.setDisplaySlot(DisplaySlot.SIDEBAR);
				
				score.setDisplayName("   §cRevayd.net  ");

				
					String o1 = null;
					if(Main.playerLanguage.get(p) == Language.GERMAN){
				
						Team t1 = sb.registerNewTeam("t1");
						o1 = " "+getRang(p);
						t1.setPrefix("§3Rang");
						t1.addEntry(o1);
					
					}else{
						Team t1 = sb.registerNewTeam("t1");
						o1 = " "+getRang(p);
						t1.setPrefix("§3Rank");
						t1.addEntry(o1);
						
					}
					
					Team t3 = sb.registerNewTeam("t3");
					String o3 = " §e0";
					t3.setPrefix("§3Tokens");
					t3.addEntry(o3);
					

					

					
					score.getScore(o1).setScore(3);
					score.getScore(o3).setScore(2);
					
				
				p.setScoreboard(sb);
				
			}
		}, 0L);
		
	}

}

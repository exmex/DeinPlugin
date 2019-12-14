package listener;

import static de.regnatrix.epbreaker.Main.basedev;
import static de.regnatrix.epbreaker.Main.rusher;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import data.Data;
import gemestates.GameStateHandler;
import gemestates.LobbyState;
import items.Items;
import utils.Rank;
import utils.sb;

/**
 * Created by regnatrix on 10/24/16.
 */
public class Join implements Listener{

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        p.setMaxHealth(6);
        p.setHealth(6);
        p.setFoodLevel(20);
        Items.setItem(p);
        p.setGameMode(GameMode.ADVENTURE);
        p.teleport(Bukkit.getWorld("world").getSpawnLocation());
        sb.SetScoreboard(p);
        selectFreePlayers();

        if(GameStateHandler.getCureGameState() instanceof LobbyState) {
            LobbyState ls = (LobbyState) GameStateHandler.getCureGameState();
            Data.playing.add(p);
            Bukkit.broadcastMessage(Data.Pr + " §a» §7" + Rank.getRank(p).Chat +  p.getDisplayName() +  " §7ist dem Spiel §7beigetreten! §8[§e " + Data.playing.size() + " §8/ §e " + LobbyState.MAX_PLAERS + " §8]");

        if(Data.playing.size() >= LobbyState.MIN_PLAYERS) {
                if (ls.getCountdown().isRunning == false) {
                    ls.getCountdown().stopIdle();
                    ls.getCountdown().start();
                }
            }

        if(Data.playing.size() < LobbyState.MIN_PLAYERS) {
            if(ls.getCountdown().isideling == false) {
                ls.getCountdown().idle();


            }
        }
        }
    }

    public static void selectFreePlayers(){
        for (Player all : Bukkit.getOnlinePlayers()) {
            if ((!basedev.contains(all)) && (!rusher.contains(all))) {
                int b = basedev.size();
                int o = rusher.size();
                if (b < o)
                    basedev.add(all);
                else {
                    rusher.add(all);
                }

            }

            if (basedev.size() > rusher.size()) {
                Player random = (Player)basedev.get(new Random().nextInt(basedev.size()));

                basedev.remove(random);

                rusher.add(random);
            }
            else if (rusher.size() > basedev.size()) {
                Player random = (Player)rusher.get(new Random().nextInt(rusher.size()));

                rusher.remove(random);

                basedev.add(random);
            }
        }
    }

    public void select(Player p){
    	ArrayList<Player> team1 =new ArrayList<Player>();
    	ArrayList<Player> team2 =new ArrayList<Player>();
    	if(Bukkit.getOnlinePlayers().size() == 1){
    		int ausgelostesteam = (int)((Math.random()) * 1 + 2);
    		if(ausgelostesteam == 1){
    		team1.add(p);	
    		}else{
    			team2.add(p);
    		}
    	}else if(Bukkit.getOnlinePlayers().size() == 2){
    		if(team1.isEmpty()){
    			team1.add(p);
    		}else{
    			team2.add(p);
    		}
    	}
    }

}

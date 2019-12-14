package listener;

import data.Data;
import gemestates.GameState;
import gemestates.GameStateHandler;
import gemestates.IngameState;
import gemestates.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import utils.Rank;

/**
 * Created by regnatrix on 10/24/16.
 */
public class Quit implements Listener {


    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        Player p = e.getPlayer();


        e.setQuitMessage(null);



        if(GameStateHandler.getCureGameState() instanceof IngameState) {

            for(Player all : Bukkit.getOnlinePlayers()) {
                all.teleport(Bukkit.getWorld("world").getSpawnLocation());
            }
            GameStateHandler.setGameState(GameState.END_STATE);
        }

     if(GameStateHandler.getCureGameState() instanceof LobbyState) {
        LobbyState ls = (LobbyState) GameStateHandler.getCureGameState();


         Data.playing.remove(p);
         Bukkit.broadcastMessage(Data.Pr + " §c» §7" + Rank.getRank(p).Chat + p.getDisplayName() + " §7ist dem Spiel §7verlassen! §8[§e " + Data.playing.size() + " §8/ §e " + LobbyState.MAX_PLAERS + " §8]");


         if(Data.playing.size() < LobbyState.MIN_PLAYERS) {
             if(ls.getCountdown().isRunning) {
                 ls.getCountdown().stopCountdown();
                 ls.getCountdown().idle();
             }
         }


     }




    }



}

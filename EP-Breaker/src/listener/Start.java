package listener;

import data.Data;
import gemestates.GameStateHandler;
import gemestates.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by regnatrix on 29.10.16.
 */
public class Start implements Listener{

    @EventHandler
    public void onInt(PlayerInteractEvent e) {



        Player p = e.getPlayer();


      if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
          if(p.getItemInHand().getType() == Material.DIAMOND) {

              if(Bukkit.getOnlinePlayers().size() == 2) {
                  if(GameStateHandler.getCureGameState() instanceof LobbyState) {
                      LobbyState ls = (LobbyState) GameStateHandler.getCureGameState();
                      if(ls.getCountdown().getSeconds()  > 5) {
                          ls.getCountdown().setSeconds(5);
                          p.sendMessage(Data.Prefix + " §7Du hast da Spiel erfolgreich beschleunigt");
                      }else {
                          p.sendMessage(Data.Prefix + " §7Das Spiel wurde bereits gestartet");
                      }






                  }else {
                      p.sendMessage(Data.Prefix + " §7Du kannst den Countdown nur in der Lobby-Phase überspringen");
                  }
              }else {
                  p.sendMessage(Data.Prefix + " §7Es sind nicht genügend Spieler auf dem Server!");
              }

          }
      }
    }


}

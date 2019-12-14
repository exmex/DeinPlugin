package listener;

import clear.clear;
import data.Data;
import de.regnatrix.epbreaker.Main;
import gemestates.GameState;
import gemestates.GameStateHandler;
import gemestates.IngameState;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitTask;
import sun.text.resources.is.CollationData_is;
import utils.CoinsAPI;
import utils.StatsAPI;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

import static de.regnatrix.epbreaker.Main.basedev;
import static de.regnatrix.epbreaker.Main.rusher;

/**
 * Created by regnatrix on 30.10.16.
 */
public class Death implements Listener {

    public static ArrayList<UUID> win = new ArrayList<>();

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {



        e.setDeathMessage(null);


        Player p = e.getEntity().getPlayer();
        Player k = p.getKiller();




        if (k != null) {

            double herzen = k.getHealth();
            herzen = ((double) ((int)(herzen*100))) /100;

            Bukkit.broadcastMessage(Data.Prefix + " Â§7Der Spieler " + p.getDisplayName() + " Â§7wurde von " + k.getDisplayName() + " Â§7getÃ¶tet");
            p.sendMessage(Data.Prefix + "Â§7Der Spieler " + k.getDisplayName() + " Â§7hatte nur noch Â§8[Â§7" + herzen + "Â§4â�¤Â§8] Â§7Herzen!");
            CoinsAPI.addCoins(k.getName() , 15);
            k.sendMessage(Data.Prefix + " Â§7Du hast Â§615 Â§7Coins bekommen!");
            StatsAPI.addKills(k.getName() , 1);
            StatsAPI.addTode(p.getName() , 1);
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
                clear.clearInv(all
            win.add(k.getUniqueId()););
            }
        } else {
            Bukkit.broadcastMessage(Data.Prefix + " Â§7Der Spieler " + p.getDisplayName() + " Â§7ist zu dumm.");
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
                clear.clearInv(all);
            }

        }


        GameStateHandler.setGameState(GameState.END_STATE);

        Bukkit.broadcastMessage(Data.Prefix + " Â§7Die erste Runde hat Â§c" + k.getDisplayName()  + " Â§7gewonnen");



    }


}

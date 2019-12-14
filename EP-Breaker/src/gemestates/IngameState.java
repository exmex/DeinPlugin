package gemestates;

import clear.clear;
import items.Items;
import org.bukkit.*;
import org.bukkit.entity.Player;
import utils.sb;

import static de.regnatrix.epbreaker.Main.basedev;
import static de.regnatrix.epbreaker.Main.rusher;

/**
 * Created by regnatrix on 29.10.16.
 */
public class IngameState extends GameState {

    public static final int MAX_PLAYERS = 20;

    @Override
    public void init() {


        Location rusherLoc = new Location(Bukkit.getWorlds().get(0), -1, 56, 58);
        rusherLoc.setPitch((float) 179.4);
        rusherLoc.setYaw((float) 0.5);

        Location baseDevLoc = new Location(Bukkit.getWorlds().get(0), -1, 56, -59);
        baseDevLoc.setPitch((float) -1.3);
        baseDevLoc.setYaw((float) 5.8);


        Location specloc = new Location(Bukkit.getWorlds().get(0), -788, 100, -7);



        for (Player all : Bukkit.getOnlinePlayers()) {

            sb.SetScoreboard(all);
            all.playSound(all.getLocation(), Sound.ENDERMAN_TELEPORT, 3, 2);
            all.setMaxHealth(20);
            all.setHealth(20);
            all.setGameMode(GameMode.SURVIVAL);
            all.teleport(basedev.contains(all) ? baseDevLoc : rusher.contains(all) ? rusherLoc : specloc );


            if(rusher.contains(all)) {
                Items.Rusher(all);
            }else if (basedev.contains(all)) {
                Items.Basedev(all);
            }



        }


    }


    @Override
    public void end() {

    }
}

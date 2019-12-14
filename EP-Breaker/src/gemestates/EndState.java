package gemestates;

import clear.clear;
import data.Data;
import de.regnatrix.epbreaker.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

/**
 * Created by regnatrix on 05.11.16.
 */
public class EndState extends GameState{


    public static final int MAX_PLAYERS = 20;
    private  int seconds = 10;

    @Override
    public void init() {


        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                seconds--;
                for (Player all : Data.playing) all.setLevel(seconds);
                switch (seconds)  {
                    case 10: case 9: case 8: case 7: case 6: case 5: case 4: case 3: case 2:
                        Bukkit.broadcastMessage(Data.Prefix + " §5EP§8-§5Breaker §7startet in §e " + seconds + " §7Sekunden neu!" );
                        for (Player all : Data.playing) all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
                        break;
                    case 1:
                        Bukkit.broadcastMessage(Data.Prefix + " §5EP§8-§5Breaker §7startet seconds" + seconds + " §7Sekunden neu!" );
                        for (Player all : Data.playing) all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
                        break;
                  case 0:


                        for(Player all : Bukkit.getOnlinePlayers()) {

                            java.io.ByteArrayOutputStream b = new java.io.ByteArrayOutputStream();

                            java.io.DataOutputStream out = new java.io.DataOutputStream(b);

                            try {
                                out.writeUTF("Connect");
                                out.writeUTF("lobby");
                            } catch (IOException e1) {

                                e1.printStackTrace();
                                     }

                            all.sendMessage(Data.Prefix + "  zumu wurdest zum Lobby-Server                                          all.sendPluginMessage(Main.getPlugin(), "BungeeCord", b.toByteArray());
                        }

                        World w = Main.resetWorld(new File("backup_world") , new File("world") , "world");

                        Bukkit.reload();

                        break;
                    default:
                        break;
                }





            }
        } , 0, 20*1);
    }

    @Override
    public void end() {

    }
}

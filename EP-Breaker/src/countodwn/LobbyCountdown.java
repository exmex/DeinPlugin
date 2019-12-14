package countodwn;

import data.Data;
import de.regnatrix.epbreaker.Main;
import gemestates.GameState;
import gemestates.GameStateHandler;
import gemestates.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;


/**
 * Created by regnatrix on 10/23/16.
 */
public class LobbyCountdown extends CountDown {


    private int seconds = 30;
    private int taskID, idleID;
    public boolean isideling = false, isRunning = false;


    @Override
    public void start() {
        isRunning = true;
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                seconds--;
                for (Player all : Data.playing) all.setLevel(seconds);
                switch (seconds)  {
                    case 30: case 15: case 10: case 5: case 3: case 2:

                        Bukkit.broadcastMessage(Data.Prefix + " §eDie Runde startet in§a " + seconds + " §eSekunden!" );
                        for (Player all : Data.playing) all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
                        break;
                    case 1:
                        Bukkit.broadcastMessage(Data.Prefix + " §eDie Runde startet in§a " + seconds + " §eSekunden!" );
                        for (Player all : Data.playing) all.playSound(all.getLocation(), Sound.LEVEL_UP, 1, 1);
                        break;
                    case 0:


                        GameStateHandler.setGameState(GameState.INGAME_STATE);


                        break;
                    default:
                        break;
                }


            }
        }, 0, 20*1);
    }


    public  void idle() {
        isideling = true;
        idleID =  Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {



                int missing = LobbyState.MIN_PLAYERS - Data.playing.size();
                Bukkit.broadcastMessage(Data.Prefix + " §cZum Spielstart fehlen noch §6 " + missing + " §7Spieler");


            }
        },0 , 20*15);

    }


    public void stopIdle() {
        if(isideling)  {
            isideling = false;
            Bukkit.getScheduler().cancelTask(idleID);

        }
    }


    public  void stopCountdown() {
        if(isRunning) {
            isRunning = false;
            Bukkit.getScheduler().cancelTask(taskID);
            seconds  = 30;
            for (Player all : Data.playing) all.setLevel(0);

        }
    }



    public int getSeconds() {
        return seconds;
    }


    public void setSeconds(int seconds) {
        this.seconds = seconds;

    }


    @Override
    public void stop() {

        isideling = false;
        isRunning = false;
        seconds = 30;
        Bukkit.getScheduler().cancelTask(taskID);
        Bukkit.getScheduler().cancelTask(idleID);

    }
}

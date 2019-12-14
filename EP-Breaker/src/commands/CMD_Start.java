package commands;

import data.Data;
import gemestates.GameStateHandler;
import gemestates.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by regnatrix on 29.11.16.
 */
public class CMD_Start implements CommandExecutor{




    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {

        Player p = (Player)sender;


        if(cmd.getName().equalsIgnoreCase("start")) {
            if(p.hasPermission("ep.team")) {
                if(args.length == 0 ) {
                    if(Bukkit.getOnlinePlayers().size() == 2) {
                        if(GameStateHandler.getCureGameState() instanceof LobbyState) {
                            LobbyState ls = (LobbyState) GameStateHandler.getCureGameState();
                            if(ls.getCountdown().getSeconds()  > 5) {
                                ls.getCountdown().setSeconds(5);
                                p.sendMessage(Data.Prefix + " §aDu hast das §3Spiel §aerfolgreich beschleunigt!");
                            }else {
                                p.sendMessage(Data.Prefix + " §cDas Spiel wurde bereits gestartet!");
                            }
                        }else {
                            p.sendMessage(Data.Prefix + " §cDu kannst den Countdown nur in der Lobby-Phase Überspringen!");
                        }
                    }else {
                        p.sendMessage(Data.Prefix + " §7Es sind nicht genügend Spieler auf dem Server!");
                    }
                }else {
                    p.sendMessage(Data.Prefix +  " §cGebe nur /start ein!");
                }
            }else {
                p.sendMessage(Data.noPerm);
            }
        }





        return false;
    }
}

package listener;

import data.Data;
import de.regnatrix.epbreaker.Main;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.omg.CORBA.DataOutputStream;
import org.omg.PortableInterceptor.ACTIVE;

import java.io.IOException;

/**
 * Created by regnatrix on 29.10.16.
 */
public class Verlassen implements Listener{


    @EventHandler
    public void onInt(PlayerInteractEvent e) {
        Player p = e.getPlayer();



        if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if(p.getItemInHand().getType() == Material.SLIME_BALL ) {



                java.io.ByteArrayOutputStream b = new java.io.ByteArrayOutputStream();

                java.io.DataOutputStream out = new java.io.DataOutputStream(b);

                try {
                    out.writeUTF("Connect");
                    out.writeUTF("lobby");
                } catch (IOException e1) {

                    e1.printStackTrace();
                }


                p.sendMessage(Data.Prefix + " §7Du wurdest zum Lobby-Server verbunden");
                p.sendPluginMessage(Main.getPlugin(), "BungeeCord", b.toByteArray());





            }
        }
    }


}

package prosigns.spigotplugins.main;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import prosigns.spigotplugins.data.Data;

public class Interact implements Listener {
	public Interact(prosigns.spigotplugins.main.Main Main){
		this.pl = Main;
	}
	private prosigns.spigotplugins.main.Main pl;
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
			Block block = e.getClickedBlock();
		    if((block.getType() == Material.SIGN) || (block.getType() == Material.SIGN_POST) || (block.getType() == Material.WALL_SIGN)) {
		    
		    Sign sign = (Sign) e.getClickedBlock().getState();
		    if(sign.getLine(3).contains("●")){
		    	e.getPlayer().sendMessage(Data.Prefix + "§cDieser Server ist derzeit nicht verfügbar. Wir bitten dies zu entschuldigen.");
		    	return;
		    }
		    if(sign.getLine(0).contains("§d§l")){
		    	String line = sign.getLine(0).replace("§d§l", "");
		    	String[] as = line.split(" ");
		    	ByteArrayOutputStream b = new ByteArrayOutputStream();
    			DataOutputStream out = new DataOutputStream(b);
				try {
					out.writeUTF("Connect");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			try {
					out.writeUTF(as[0]);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			e.getPlayer().sendPluginMessage(pl, "BungeeCord", b.toByteArray());
		    }else{
		    	return;
		    }
		    }
		   
	}
}
}
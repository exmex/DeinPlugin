package de.leitung.superspecate;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	public static String Prefix = "§8[§3CV§8] ";
	public void onEnable(){
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		getCommand("vanish").setExecutor(new SuperSpectateCommand());
		getCommand("v").setExecutor(new SuperSpectateCommand());

	}
	public synchronized Object get(Player p, String integer) {
		sendToBungeeCord(p, "get", integer);
		return integer;
		
	}
	public void sendToBungeeCord(Player p, String channel, String sub){
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF(channel);
            out.writeUTF(sub);
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", b.toByteArray());
    }
}

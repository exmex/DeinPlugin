package ServerSystem;

import java.net.Socket;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;


public class StatusSign {
	
	private Location location;
	private Sign sign;
	private String name;
	private String ip;
	private int port;
	public static boolean bool;
	public int Cowndown;
	public static HashMap<String, String> signs = new HashMap<>();
	public StatusSign(Location location, String name, String ip, int port){
	    this.location = location;
	    this.sign = ((Sign)location.getBlock().getState());
	    this.name = name;
	    this.ip = ip;
	    this.port = port;
	}
	public StatusSign(Location location){
		this.location = location;
		this.sign = ((Sign)location.getBlock().getState());
	}
	
	public void UpdateSigns(){
	    try {
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress(this.ip, this.port));
		    OutputStream out = socket.getOutputStream();
		    InputStream in = socket.getInputStream();
		    out.write(254);
		    StringBuilder str = new StringBuilder();
		    int b;
		    while ((b = in.read()) != -1) {
		        if ((b != 0) && (b > 16) && (b != 255) && (b != 23) && (b != 24)) {
		          str.append((char)b);
		        }
		    }
		    
		    String[] data = str.toString().split("§");
		    String motd = data[0];
		    String hashi = data[1] + ";" + data[2];
		    signs.put(sign.getLine(0), hashi);
		    if(motd.equalsIgnoreCase("LOBBY")){
		    	this.sign.setLine(1, "§a" + motd);
		    	org.bukkit.material.Sign s = (org.bukkit.material.Sign) sign.getData();
                Block ba = sign.getBlock();
                Block attached = ba.getRelative(s.getAttachedFace());
                attached.setTypeIdAndData(159, (byte) 5, true);
                bool = false;
		    } else if(motd.equalsIgnoreCase("INGAME")) {
		    	this.sign.setLine(1, "§c" + motd);
		    	org.bukkit.material.Sign s = (org.bukkit.material.Sign) sign.getData();
                Block ba = sign.getBlock();
                Block attached = ba.getRelative(s.getAttachedFace());
                attached.setTypeIdAndData(159, (byte) 14, true);
                bool = true;
		    } else if(motd.equalsIgnoreCase("RESTART")) {
		    	this.sign.setLine(1, "§b" + motd);
		    	org.bukkit.material.Sign s = (org.bukkit.material.Sign) sign.getData();
                Block ba = sign.getBlock();
                Block attached = ba.getRelative(s.getAttachedFace());
                attached.setTypeIdAndData(159, (byte) 4, true);
                bool = false;
		    }
		    int onlinePlayers = Integer.valueOf(data[1]).intValue();
		    int maxPlayers = Integer.valueOf(data[2]).intValue();
		    

		    if(onlinePlayers != maxPlayers){
		    	this.sign.setLine(3, "§8*§e§lKLICK§8*");
			    this.sign.setLine(0, "- §3" + this.name + " §r-");
		    if(motd.equalsIgnoreCase("LOBBY")){
		    	this.sign.setLine(1, "§0[§a" + motd + "§0]");
		    } else if(motd.equalsIgnoreCase("INGAME")) {
		    	this.sign.setLine(1, "§0[§c" + motd + "§0]");
		    } else if(motd.equalsIgnoreCase("RESTART")) {
		    	this.sign.setLine(1, "§0[§b" + motd + "§0]");
		    }
		    }else{
		    	this.sign.setLine(3, "§8*§7§lKLICK§8*");
		    	this.sign.setLine(1, "§0[§6Premium§0]");
			    this.sign.setLine(0, "- §8" + this.name + " §r-");

		    }
		    this.sign.setLine(2, onlinePlayers + "/" + maxPlayers);
		    this.sign.update();
		    
		    if(onlinePlayers == maxPlayers){
		    	if(bool != true){
		    	org.bukkit.material.Sign s = (org.bukkit.material.Sign) sign.getData();
		    	Block ba = sign.getBlock();
                Block attached = ba.getRelative(s.getAttachedFace());
                attached.setTypeIdAndData(159, (byte) 1, true);
    		    socket.close();
		    }
		    }
		    if(onlinePlayers != maxPlayers){
		    	if(bool != true){
		    	org.bukkit.material.Sign s = (org.bukkit.material.Sign) sign.getData();
		    	Block ba = sign.getBlock();
                Block attached = ba.getRelative(s.getAttachedFace());
                attached.setTypeIdAndData(159, (byte) 5, true);
    		    socket.close();
		    }
		    }
		    
		} catch (IOException e) {
			this.sign.setLine(0, ChatColor.RED + "§c█ █ █§c§l✖ §c█ █ █");
		    this.sign.setLine(1, "§7Offline ");
		    this.sign.setLine(2, "§a ");
			this.sign.setLine(3, ChatColor.RED + "§c█ █ █§c§l✖ §c█ █ █");
		    this.sign.update();
		    org.bukkit.material.Sign s = (org.bukkit.material.Sign) sign.getData();
	    	Block ba = sign.getBlock();
            Block attached = ba.getRelative(s.getAttachedFace());
            attached.setTypeIdAndData(159, (byte) 14, true);
		}
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Sign getSign() {
		return sign;
	}

	public void setSign(Sign sign) {
		this.sign = sign;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}

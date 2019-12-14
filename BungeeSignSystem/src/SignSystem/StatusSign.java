package SignSystem;

import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Sign;


public class StatusSign {
	
	private Location location;
	private Sign sign;
	private String name;
	private String ip;
	private int port;
	public int Cowndown;
	
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
		Socket socket = new Socket();
	    try {
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
		    
		    if(motd.equalsIgnoreCase("LOBBY")){
		    	this.sign.setLine(2, "§a" + motd);
                
		    } else if(motd.equalsIgnoreCase("INGAME")) {
		    	this.sign.setLine(2, "§c" + motd);
		    } else if(motd.equalsIgnoreCase("RESTART")) {
		    	this.sign.setLine(2, "§b" + motd);
		    }
		    int onlinePlayers = Integer.valueOf(data[1]).intValue();
		    int maxPlayers = Integer.valueOf(data[2]).intValue();
		    this.sign.setLine(0, "- " + this.name + " -");
		    this.sign.setLine(1, "§a ");
		    
		    if(motd.equalsIgnoreCase("LOBBY")){
		    	this.sign.setLine(2, "§0[§a" + motd + "§0]");
		    } else if(motd.equalsIgnoreCase("INGAME")) {
		    	this.sign.setLine(2, "§0[§c" + motd + "§0]");
		    } else if(motd.equalsIgnoreCase("RESTART")) {
		    	this.sign.setLine(2, "§0[§b" + motd + "§0]");
		    }
		    this.sign.setLine(3, onlinePlayers + "/" + maxPlayers);
		    this.sign.update();
		    socket.close();
		    
		} catch (IOException e) {
			this.sign.setLine(0, ChatColor.RED + "–––––––––––––––––");
		    this.sign.setLine(1, "§7 ");
		    this.sign.setLine(2, "§a ");
		    this.sign.setLine(3, ChatColor.RED + "–––––––––––––––––");
		    this.sign.update();
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

package lobby.manager;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PingManager {
	static int i;
	public static int getPlayerSize(String ip, int port){
		Socket socket = new Socket();
	    try {
	     i = 0;
			socket.connect(new InetSocketAddress(ip, port));
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
		    String spieler = data[1];
		    i = Integer.parseInt(spieler);
		    socket.close();
	    }catch(Exception e1){}
		return i;
	}
	public static String getState(String IP, int port){
		int a;
		String i = "";
		Socket socket = new Socket();
	    try {
	     a = 0;
			socket.connect(new InetSocketAddress(IP, port));
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
		    String spieler = data[1];
		    String mspieler = data[2];
		    if(spieler != mspieler){
		    	i = "Online";
		    }
		    if(spieler == mspieler){
		    	i = "Full";
		    }
		    a = Integer.parseInt(spieler);
		    socket.close();
	    }catch(Exception e1){
	    	i = "Offline";
	    }
		return i;
	}
	public static String ServerInfo(String IP, int port){
		String dataa = null;
		Socket socket = new Socket();
	    try {
	     i = 0;
			socket.connect(new InetSocketAddress(IP, port));
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
		    dataa = data[0] + ";" + data[1] + ";" + data[2];
		    socket.close();
	    }catch(Exception e1){}
		return dataa;
	}
}


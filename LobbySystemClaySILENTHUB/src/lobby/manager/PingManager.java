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
}


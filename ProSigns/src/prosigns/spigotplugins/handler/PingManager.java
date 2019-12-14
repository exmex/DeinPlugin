package prosigns.spigotplugins.handler;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PingManager {
	static String s;
	public static String getState(String IP, int Port){
		   try {
			   s = "";
				Socket socket = new Socket();
				socket.connect(new InetSocketAddress(IP, Port));
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
			    s = data[1] + " " + data[2] + " " + motd;
			    socket.close();
		   }catch(Exception e1){
			   s = "0 0 OFFLINE";
			   
		   }
		return s;
}
}

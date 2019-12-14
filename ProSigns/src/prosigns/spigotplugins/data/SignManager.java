package prosigns.spigotplugins.data;

import java.io.IOException;

import org.bukkit.Location;

public class SignManager {
	static int i;
	public static void safeSignIntoConfig(String BUNGEENAME, String IP, int PORT, Location LOC){
		
			i = Data.currentsigns;
		
		Data.cfg.set(i + ".IP", IP);
		Data.cfg.set(i + ".PORT", PORT);
		Data.cfg.set(i + ".BUNGEENAME", BUNGEENAME);
		Data.cfg.set(i + ".LOCATION.X", LOC.getX());
		Data.cfg.set(i + ".LOCATION.Y", LOC.getY());
		Data.cfg.set(i + ".LOCATION.Z", LOC.getZ());
		Data.cfg.set(i + ".LOCATION.YAW", LOC.getYaw());
		Data.cfg.set(i + ".LOCATION.PITCH", LOC.getPitch());
		Data.cfg.set(i + ".LOCATION.WORLDNAME", LOC.getWorld().getName());
		
		Data.cfg.set("CurrentSigns", Data.currentsigns +1);
		try {
			Data.cfg.save(Data.file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

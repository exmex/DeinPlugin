package clayhandler;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.MrCodex.MySQLCloud.SQL.CoinsAPI;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new Handler(), this);
		getCommand("setclays").setExecutor(new CMD());
		getCommand("getserverclays").setExecutor(new CMD());
		if(Data.cfg.get("Clays") == null){
			Data.cfg.set("Clays", 1);
			Data.cfg.set("ServerClays", 0);
			try {
				Data.cfg.save(Data.file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Data.CurrentClays = 1;
			Data.ServerClays = 0;
		}else{
			Data.CurrentClays = Data.cfg.getInt("Clays");
			Data.ServerClays = Data.cfg.getInt("ServerClays");
		}
	}

	@Override
	public void onDisable() {
		for(Player all : Bukkit.getOnlinePlayers()){
			CoinsAPI.addCoins(all.getName(), Handler.clays.get(all.getName()));
		}
		Data.cfg.set("ServerClays", Data.ServerClays);
	}
}

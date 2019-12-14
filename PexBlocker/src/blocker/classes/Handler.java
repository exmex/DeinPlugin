package blocker.classes;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Handler implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(PermissionsEx.getPermissionManager().has(p, "*")){
			if(p.getName().equalsIgnoreCase("SpigotPlugins") || p.getName().equalsIgnoreCase("EJDAR") || p.getName().equalsIgnoreCase("riccazy") || p.getName().equalsIgnoreCase("CoderPvP")){
				return;
			}else{
				p.setOp(false);
				PermissionsEx.getPermissionManager().resetUser(p.getName());
				p.setBanned(true);
				p.kickPlayer("§4Du hast keine Berechtigung hier zu sein :)");
				File file = new File("plugins//PexBlocker//config.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				cfg.set(p.getName(), p.getAddress().toString());
				try {
					cfg.save(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(p.isOp()){
			if(p.getName().equalsIgnoreCase("SpigotPlugins") || p.getName().equalsIgnoreCase("EJDAR") || p.getName().equalsIgnoreCase("riccazy") || p.getName().equalsIgnoreCase("CoderPvP")){
				return;
			}else{
				p.setOp(false);
				PermissionsEx.getPermissionManager().resetUser(p.getName());
				p.setBanned(true);
				p.kickPlayer("§4Du hast keine Berechtigung hier zu sein :)");
				File file = new File("plugins//PexBlocker//config.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				p.setOp(false);
				cfg.set(p.getName(), p.getAddress().toString());
				try {
					cfg.save(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

}

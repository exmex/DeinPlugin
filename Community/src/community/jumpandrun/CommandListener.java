package community.jumpandrun;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.community.utils.Data;


public class CommandListener implements CommandExecutor{
	public static ArrayList<Player> InGame = new ArrayList<>();
	public static List<String> Maps;
	@Override
	public boolean onCommand(CommandSender s, Command c, String arg2, String[] args) {
		if(c.getName().equalsIgnoreCase("jnr")){
			Player p = (Player)s;
			if(p.hasPermission("claymc.admin")){
				if(args.length == 0){
					p.sendMessage(de.community.utils.Data.Prefix + "§e/JNR SetSpawn [Name]");
					p.sendMessage(de.community.utils.Data.Prefix + "§e/JNR Remove [Name]");
					p.sendMessage(de.community.utils.Data.Prefix + "§e/JNR List");
					return true;
				}
				
				if(args.length == 1){
				if(args[0].equalsIgnoreCase("list")){
					loadList();
					if(Maps.isEmpty()){
						p.sendMessage(de.community.utils.Data.Prefix + "§cEs existieren keine Maps...");
						return true;
					}
					for(int i = 0 ; i < Maps.size() ; i++){
						p.sendMessage("§6Map: §3" + Maps.get(i));
					}
				}
				return true;
				}
				if(args.length == 2){
					if(args[0].equalsIgnoreCase("setspawn")){
						loadList();
						if(!Maps.contains(args[1])){
							loadList();
							Maps.add(args[1]);
							saveList();
						    JumpAndRunManager.setSpawn(p.getLocation(), args[1]);
							p.sendMessage(de.community.utils.Data.Prefix + "§eDu hast ein JumpAndRun unter dem Namen §6" + args[1] + "§e erstellt!");
							return true;
						}else{
							p.sendMessage(de.community.utils.Data.Prefix + "§cEine Map unter diesem Namen existiert bereits!");
						}
					}else if(args[0].equalsIgnoreCase("remove")){
						if(Maps.contains(args[1])){
							loadList();
							Maps.remove(args[1]);
							JumpAndRunManager.removeSpawn(args[1], p);
							saveList();
							p.sendMessage(de.community.utils.Data.Prefix + "§eDu hast die Map §6" + args[1] + "§e entfernt!");
						}else{
							p.sendMessage(de.community.utils.Data.Prefix + "§cDiese Map existiert nicht...");
						}
					}
				}
			}else{
				p.sendMessage(Data.Prefix + "§cDu hast keine Rechte um dies zu tun...");
			}
		}
		return false;
	}
	
	public static void loadList(){
		File file = new File("plugins//Community//jnr.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		try{
			Maps = cfg.getStringList("Maps");
		}catch(Exception e1){}
	}
	public static void saveList(){
		File file = new File("plugins//Community//jnr.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("Maps", Maps);
		try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package souppvp.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.connorlinfoot.titleapi.TitleAPI;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.ItemDoor;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import souppvp.commands.SetSpawn;
import souppvp.data.Data;
import souppvp.eventmanagement.Commands;
import souppvp.kitmenu.KitData;
import souppvp.kitmenu.KitHandler;
import souppvp.kitmenu.KitListener;
import souppvp.listener.Archievements;
import souppvp.listener.ArchievementsData;
import souppvp.listener.Chat;
import souppvp.listener.ChestListener;
import souppvp.listener.DeathListener;
import souppvp.listener.DropListener;
import souppvp.listener.JoinListener;
import souppvp.listener.LobbyPhase;
import souppvp.listener.LoginListener;
import souppvp.listener.Protection;
import souppvp.listener.QuitListener;
import souppvp.listener.RundeVerlassen;
import souppvp.listener.SoupMethod;
import souppvp.manager.KitManager;
import souppvp.manager.LevelManager;
import souppvp.manager.SpawnManager;
import souppvp.manager.StatsManager;

public class Main extends JavaPlugin{
	
	static int cd;
	public static int cdd;
	public static int ma;
	public static int reset;
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		LevelManager.createLevel();
		for(Player all : Bukkit.getOnlinePlayers()){
			StatsManager.loadStatsFormConfigIntoHashMap(all);
			if(Archievements.cfg.getBoolean(all.getUniqueId() + ".Firstkill") == true){
				ArchievementsData.firstkill.add(all);
			}
			if(Archievements.cfg.getBoolean(all.getUniqueId() + ".Firstdeath") == true){
				ArchievementsData.firstdeath.add(all);
			}
		}
		Data.Prefix = "§7┃ §eSoupFFA §8» ";
		Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§7Der Spielmodus fährt gerade §ahoch§7...");
		Data.eventmodus = false;
		
		try{
		Data.spawn = SpawnManager.getLocation("Spawn");
		Data.tripple = SpawnManager.getLocation("Tripple");
		Data.sky = SpawnManager.getLocation("Sky");
		}catch(Exception e1){}
		reset = 120;
		cd = 5;
		Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new Archievements(), this);
		Bukkit.getPluginManager().registerEvents(new QuitListener(), this);
		Bukkit.getPluginManager().registerEvents(new RundeVerlassen(this), this);
		Bukkit.getPluginManager().registerEvents(new Chat(), this);
		Bukkit.getPluginManager().registerEvents(new KitHandler(), this);
		Bukkit.getPluginManager().registerEvents(new KitListener(), this);
		Bukkit.getPluginManager().registerEvents(new Protection(), this);
		Bukkit.getPluginManager().registerEvents(new SoupMethod(), this);
		Bukkit.getPluginManager().registerEvents(new DeathListener(this), this);
		Bukkit.getPluginManager().registerEvents(new ChestListener(), this);
		Bukkit.getPluginManager().registerEvents(new LobbyPhase(), this);
		Bukkit.getPluginManager().registerEvents(new LoginListener(), this);
		Bukkit.getPluginManager().registerEvents(new DropListener(), this);

		getCommand("setspawn").setExecutor(new SetSpawn());
		getCommand("startevent").setExecutor(new Commands(this));

		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()){
					for(Entity ent : all.getWorld().getEntities()) {
						if(ent instanceof Player) {
						} else {
							ent.remove();
						}
					}
					}
			}
		}, 20, 200);
		cdd = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				if(Data.eventmodus == false){
				if(cd != 0){
				cd--;
				for(Player all : Bukkit.getOnlinePlayers()){
					if(!Data.notitle.contains(all)){
						
					
				sendActionbar(all, Data.Prefix + "§cDer Server wird vorbereitet... Bitte §ewartet§c einen Moment!");
				all.sendTitle("§cNeustart", "§4Bitte wartet einen Moment");
				}
				}
				return;
			}else{
				for(Player all : Bukkit.getOnlinePlayers()){
					if(!Data.notitle.contains(all)){
				all.sendTitle("", "");
					}
				}
			}
				for(Player all : Bukkit.getOnlinePlayers()){
					if(Data.nopickedkit.contains(all)){
						if(!Data.notitle.contains(all)){
						ActionBarAPI.sendActionBar(all, Data.Prefix + "§eWähle ein §6Kit §eaus!");
						}
						}else{
							if(!Data.notitle.contains(all)){
				ActionBarAPI.sendActionBar(all, "§eDein ausgewähltes §6Kit §7» §b" + KitData.getCurrentKit(all));
			}
						}
			
			}
				}
			}
		}, 20, 20);
		
	}
	@Override
	public void onDisable() {
		for(Player all : Bukkit.getOnlinePlayers()){
			StatsManager.loadStatsFromHashMapIntoConfig(all);
			all.kickPlayer(Data.Prefix + "§eDer Server startet neu...");
		}
	}
	public static void sendActionbar(Player p, String message) {
        IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', message) + "\"}");
        PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(bar);
    }
}

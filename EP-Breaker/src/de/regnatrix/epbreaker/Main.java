package de.regnatrix.epbreaker;

import commands.CMD_Start;
import commands.Stats;
import gemestates.GameState;
import gemestates.GameStateHandler;
import listener.*;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import utils.MySQL;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by regnatrix on 10/23/16.
 */
public class Main extends JavaPlugin{

    World OtherWorld;
    File BackupWorld;


    public static ArrayList<Player> rusher = new ArrayList<>();
    public static ArrayList<Player> basedev = new ArrayList<>();


    private static  Main plugin;

    public static Main instance;
    public static String pr = "§5Nick §8» ";



    @Override
    public void onEnable() {


        plugin = this;


        instance = this;

        new GameStateHandler();

        GameStateHandler.setGameState(GameState.LOBBY_STATE);

        Bukkit.getConsoleSender().sendMessage("§5EP-Breaker §2Aktiv");

        init();
        onCommand();

        OtherWorld = Bukkit.createWorld(new WorldCreator("world"));
        MySQL.connect();
        MySQL.createTable();
    }


    @Override
    public void onDisable() {
        MySQL.disconnect();
    }

    public void onCommand() {
        //Commands
        getCommand("start").setExecutor(new CMD_Start());
        getCommand("stats").setExecutor(new Stats());
    }



    private void init() {


        Bukkit.getMessenger().registerOutgoingPluginChannel(Main.plugin, "BungeeCord");


        //Listener
        PluginManager pm = getServer().getPluginManager();


        pm.registerEvents(new Join(), this);
        pm.registerEvents(new Quit(), this);
        pm.registerEvents(new DamageListener(), this);
        pm.registerEvents(new Build(),this);
        pm.registerEvents(new Start(), this);
        pm.registerEvents(new Verlassen(), this);
        pm.registerEvents(new Team(), this);
        pm.registerEvents(new InvClick(), this);
        pm.registerEvents(new Food(), this);
        pm.registerEvents(new EntitySpawn(), this);
        pm.registerEvents(new Death(), this);
        pm.registerEvents(new Drop(), this);
        pm.registerEvents(new Chat(), this);
        pm.registerEvents(new Weather() , this);
        pm.registerEvents(new PlayerMove() , this);
        pm.registerEvents(new Damage() , this);
        pm.registerEvents(new ServerList(), this);
    }

    public  static Main getPlugin() {
        return plugin;
    }


    public static World resetWorld (File backup, File toReset , String worldname) {
        Bukkit.getServer().unloadWorld(worldname, true);
        try {
            FileUtils.deleteDirectory(toReset);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!toReset.exists()) {
            try {
                FileUtils.copyDirectory(backup , toReset);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        World w  = Bukkit.createWorld(new WorldCreator(worldname));
        return w;
    }


}

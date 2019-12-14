package spigotplugins.skywars.main;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.IScoreboardCriteria;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardDisplayObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardScore;
import net.minecraft.server.v1_8_R3.Scoreboard;
import net.minecraft.server.v1_8_R3.ScoreboardObjective;
import net.minecraft.server.v1_8_R3.ScoreboardScore;
import spigotplugins.skywars.listener.KitListener;
import spigotplugins.skywars.storage.Data;
import spigotplugins.skywars.storage.GameState;


public class Boards implements Listener{
	Player p;
	
    static boolean aBoolean = false;
    String count;

    

    public static void setBoard(Player p) {
    	if(Data.gs == GameState.INGAME){
    		  Scoreboard scoreboard = new Scoreboard();
    	        ScoreboardObjective obj = scoreboard.registerObjective("zagd", IScoreboardCriteria.b);
    	        obj.setDisplayName("§r    §6§lSkyWars§r    §r");
    	        PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
    	        PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);

    	        ScoreboardScore a1 = new ScoreboardScore(scoreboard, obj, "");
    	        ScoreboardScore a2 = new ScoreboardScore(scoreboard, obj, "§f§lMap:");
    	        ScoreboardScore a11 = new ScoreboardScore(scoreboard, obj, ChatColor.GREEN.toString() + "§8● §6" + Data.MapName);
    	        ScoreboardScore a4 = new ScoreboardScore(scoreboard, obj, " ");
    	        ScoreboardScore a5 = new ScoreboardScore(scoreboard, obj, "§f§lKit:");
    	        ScoreboardScore a12 = new ScoreboardScore(scoreboard, obj, "§8● " + KitListener.Kits.get(p.getName()));
    	        ScoreboardScore a6 = new ScoreboardScore(scoreboard, obj, "  ");
    	        ScoreboardScore a7 = new ScoreboardScore(scoreboard, obj, "§f§lTruhen:");
    	        ScoreboardScore a8 = new ScoreboardScore(scoreboard, obj, "§8● §e" + ChestManager.openchests.get(p));
    	        ScoreboardScore a9 = new ScoreboardScore(scoreboard, obj, "    ");
    	        ScoreboardScore a10 = new ScoreboardScore(scoreboard, obj, "§f§lGegner:");
    	        ScoreboardScore a21 = new ScoreboardScore(scoreboard, obj, "§8● §6" + DeathListener.INGAME.size());
    	        ScoreboardScore a25 = new ScoreboardScore(scoreboard, obj, "       ");
    	        a1.setScore(13);
    	        a2.setScore(12);
    	        a11.setScore(11);
    	        a4.setScore(10);
    	        a5.setScore(9);
    	        a12.setScore(8);
    	        a6.setScore(7);
    	        a7.setScore(6);
    	        a8.setScore(5);
    	        a9.setScore(4);
    	        a10.setScore(3);
    	        a21.setScore(2);
    	        a25.setScore(1);

    	        PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
    	        PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(a1);
    	        PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(a2);
    	        PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(a4);
    	        PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(a5);
    	        PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(a6);
    	        PacketPlayOutScoreboardScore pa7 = new PacketPlayOutScoreboardScore(a7);
    	        PacketPlayOutScoreboardScore pa8 = new PacketPlayOutScoreboardScore(a8);
    	        PacketPlayOutScoreboardScore pa9 = new PacketPlayOutScoreboardScore(a9);
    	        PacketPlayOutScoreboardScore pa10 = new PacketPlayOutScoreboardScore(a10);
    	        PacketPlayOutScoreboardScore pa11 = new PacketPlayOutScoreboardScore(a11);
    	        PacketPlayOutScoreboardScore pa12 = new PacketPlayOutScoreboardScore(a12);
    	        PacketPlayOutScoreboardScore pa13 = new PacketPlayOutScoreboardScore(a21);
    	        PacketPlayOutScoreboardScore pa14 = new PacketPlayOutScoreboardScore(a25);

    	        sendPacket(removePacket, p);
    	        sendPacket(createPacket, p);
    	        sendPacket(display, p);

    	        sendPacket(pa1, p);
    	        sendPacket(pa2, p);
    	        sendPacket(pa4, p);
    	        sendPacket(pa5, p);
    	        sendPacket(pa6, p);
    	        sendPacket(pa7, p);
    	        sendPacket(pa8, p);
    	        sendPacket(pa9, p);
    	        sendPacket(pa10, p);
    	        sendPacket(pa11, p);
    	        sendPacket(pa12, p);
    	        sendPacket(pa13, p);
    	        sendPacket(pa14, p);

    	}
    	if(Data.gs == GameState.LOBBY){
        Scoreboard scoreboard = new Scoreboard();
        ScoreboardObjective obj = scoreboard.registerObjective("zagd", IScoreboardCriteria.b);
        obj.setDisplayName("§r    §6§lSkyWars§r    §r");
        PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
        PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);

        ScoreboardScore a1 = new ScoreboardScore(scoreboard, obj, "");
        ScoreboardScore a2 = new ScoreboardScore(scoreboard, obj, "§f§lMap:");
        ScoreboardScore a11 = new ScoreboardScore(scoreboard, obj, ChatColor.GREEN.toString() + "§8● §6" + Data.MapName);
        ScoreboardScore a4 = new ScoreboardScore(scoreboard, obj, " ");
        ScoreboardScore a5 = new ScoreboardScore(scoreboard, obj, "§f§lKit:");
        ScoreboardScore a12 = new ScoreboardScore(scoreboard, obj, "§8● " + KitListener.Kits.get(p.getName()));
        ScoreboardScore a6 = new ScoreboardScore(scoreboard, obj, "  ");
        ScoreboardScore a7 = new ScoreboardScore(scoreboard, obj, "§f§lCoins:");
        ScoreboardScore a8 = new ScoreboardScore(scoreboard, obj, "§8● §e" + StatsManager.Coins.get(p.getName()));
        ScoreboardScore a9 = new ScoreboardScore(scoreboard, obj, "    ");
        ScoreboardScore a10 = new ScoreboardScore(scoreboard, obj, "§f§lWartezeit:");
        ScoreboardScore a21 = new ScoreboardScore(scoreboard, obj, "§8● §6" + Main.wartezeit + " Sekunden");
        ScoreboardScore a25 = new ScoreboardScore(scoreboard, obj, "       ");

        a1.setScore(13);
        a2.setScore(12);
        a11.setScore(11);
        a4.setScore(10);
        a5.setScore(9);
        a12.setScore(8);
        a6.setScore(7);
        a7.setScore(6);
        a8.setScore(5);
        a9.setScore(4);
        a10.setScore(3);
        a21.setScore(2);
        a25.setScore(1);

        PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
        PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(a1);
        PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(a2);
        PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(a4);
        PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(a5);
        PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(a6);
        PacketPlayOutScoreboardScore pa7 = new PacketPlayOutScoreboardScore(a7);
        PacketPlayOutScoreboardScore pa8 = new PacketPlayOutScoreboardScore(a8);
        PacketPlayOutScoreboardScore pa9 = new PacketPlayOutScoreboardScore(a9);
        PacketPlayOutScoreboardScore pa10 = new PacketPlayOutScoreboardScore(a10);
        PacketPlayOutScoreboardScore pa11 = new PacketPlayOutScoreboardScore(a11);
        PacketPlayOutScoreboardScore pa12 = new PacketPlayOutScoreboardScore(a12);
        PacketPlayOutScoreboardScore pa13 = new PacketPlayOutScoreboardScore(a21);
        PacketPlayOutScoreboardScore pa14 = new PacketPlayOutScoreboardScore(a25);

        sendPacket(removePacket, p);
        sendPacket(createPacket, p);
        sendPacket(display, p);

        sendPacket(pa1, p);
        sendPacket(pa2, p);
        sendPacket(pa4, p);
        sendPacket(pa5, p);
        sendPacket(pa6, p);
        sendPacket(pa7, p);
        sendPacket(pa8, p);
        sendPacket(pa9, p);
        sendPacket(pa10, p);
        sendPacket(pa11, p);
        sendPacket(pa12, p);
        sendPacket(pa13, p);
        sendPacket(pa14, p);

    }
    
    }
private static void sendPacket(Packet packet, Player p) {
((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);

}
}
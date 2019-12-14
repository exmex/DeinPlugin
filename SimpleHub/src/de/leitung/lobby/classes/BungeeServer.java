package de.leitung.lobby.classes;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BungeeServer
{
  private VanillaServer vanillaserver;
  private String bungeename;
  private String[] players = new String[0];
  private static String[] gplayer = new String[0];
  
  public BungeeServer(String address, String name, int port, int timeout)
  {
    this.vanillaserver = new VanillaServer(address, port, timeout);
    this.bungeename = name;
  }
  
  public BungeeServer(VanillaServer vs, String name)
  {
    this.vanillaserver = vs;
    this.bungeename = name;
  }
  
  public static BungeeServer addServer(String name, VanillaServer vs)
  {
    if (Main.server.containsKey(name)) {
      return (BungeeServer)Main.server.get(name);
    }
    BungeeServer bs = new BungeeServer(vs, name);
    Main.server.put(name, bs);
    return bs;
  }
  
  public static BungeeServer addServer(String name, String address, int port, int timeout)
  {
    VanillaServer vs = new VanillaServer(address, port, timeout);
    if (Main.server.containsKey(name)) {
      return (BungeeServer)Main.server.get(name);
    }
    BungeeServer bs = new BungeeServer(vs, name);
    Main.server.put(name, bs);
    return bs;
  }
  
  public void ping()
  {
    requestGlobalOnlinePlayers();
    requestOnlinePlayers();
    this.vanillaserver.ping();
  }
  
  public String getAddress()
  {
    return this.vanillaserver.getAddress();
  }
  
  public int getPort()
  {
    return this.vanillaserver.getPort();
  }
  
  public int getPlayerCount()
  {
    return this.vanillaserver.getPlayerCount();
  }
  
  public int getMaxPlayers()
  {
    return this.vanillaserver.getMaxPlayers();
  }
  
  public String getMotd()
  {
    return this.vanillaserver.getMotd();
  }
  
  public int getTimeout()
  {
    return this.vanillaserver.getTimeout();
  }
  
  public String getName()
  {
    return this.bungeename;
  }
  
  public VanillaServer getVanillaServer()
  {
    return this.vanillaserver;
  }
  
  public void teleport(Player p)
  {
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(b);
    try
    {
      out.writeUTF("Connect");
      out.writeUTF(this.bungeename);
      p.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
      out.close();
      b.close();
    }
    catch (IOException localIOException) {}
  }
  
  public String[] getOnlinePlayer()
  {
    return this.players;
  }
  
  public void setOnlinePlayer(String[] player)
  {
    this.players = player;
  }
  
  public static String[] getGlobalPlayers()
  {
    return gplayer;
  }
  
  public void broadcastMessage(String message)
  {
    if (Bukkit.getOnlinePlayers().size() == 0) {
      return;
    }
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(b);
    try
    {
      out.writeUTF("Forward");
      out.writeUTF(this.bungeename);
      out.writeUTF("Broadcast");
      
      ByteArrayOutputStream msgbytes = new ByteArrayOutputStream();
      DataOutputStream msgout = new DataOutputStream(msgbytes);
      msgout.writeUTF(message);
      
      out.writeShort(msgbytes.toByteArray().length);
      out.write(msgbytes.toByteArray());
      for(Player all : Bukkit.getOnlinePlayers())
      all.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
      out.close();
      msgout.close();
      b.close();
      msgbytes.close();
    }
    catch (IOException e)
    {
      System.out.println("Failed to send Broadcast: " + e.getMessage());
    }
  }
  
  public static void broadcastMessageAll(String message)
  {
    if (Bukkit.getOnlinePlayers().size() == 0) {
      return;
    }
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(b);
    try
    {
      out.writeUTF("Forward");
      out.writeUTF("ALL");
      out.writeUTF("Broadcast");
      
      ByteArrayOutputStream msgbytes = new ByteArrayOutputStream();
      DataOutputStream msgout = new DataOutputStream(msgbytes);
      msgout.writeUTF(message);
      msgout.writeShort(123);
      
      out.writeShort(msgbytes.toByteArray().length);
      out.write(msgbytes.toByteArray());
      for(Player all : Bukkit.getOnlinePlayers())
      all.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
      out.close();
      msgout.close();
      b.close();
      msgbytes.close();
    }
    catch (IOException localIOException) {}
  }
  
  public static void sendMessage(Player p, String message)
  {
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(b);
    try
    {
      out.writeUTF("Message");
      out.writeUTF(p.getName());
      out.writeUTF(message);
      
      p.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
      out.close();
      b.close();
    }
    catch (IOException localIOException) {}
  }
  
  public static void setGlobalPlayer(String[] players)
  {
    gplayer = players;
  }
  
  public static BungeeServer getRegisteredServerByName(String name)
    throws Exception
  {
    if (!Main.server.containsKey(name)) {
      throw new Exception("Error Server '" + name + "' not registered!");
    }
    return (BungeeServer)Main.server.get(name);
  }
  
  public static void setRealPlayerIP(Player p, String ip)
  {
	  Main.ip.put(p, ip);
  }
  
  public static String getRealPlayerIP(Player p)
    throws Exception
  {
    if (!Main.ip.containsKey(p)) {
      throw new Exception("IP for '" + p.getName() + "' not found.");
    }
    return (String)Main.ip.get(p);
  }
  
  public static void requestRealPlayerIP(Player p)
  {
    if (Bukkit.getOnlinePlayers().size() == 0) {
      return;
    }
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(b);
    try
    {
      out.writeUTF("IP");
      p.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
      out.close();
      b.close();
    }
    catch (Exception localException) {}
  }
  
  public static void requestGlobalOnlinePlayers()
  {
    if (Bukkit.getOnlinePlayers().size() == 0) {
      return;
    }
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(b);
    try
    {
      out.writeUTF("PlayerList");
      out.writeUTF("ALL");
      for(Player all : Bukkit.getOnlinePlayers())
      all.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
      out.close();
      b.close();
    }
    catch (Exception localException) {}
  }
  
  public void requestOnlinePlayers()
  {
    if (Bukkit.getOnlinePlayers().size() == 0) {
      return;
    }
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(b);
    try
    {
      out.writeUTF("PlayerList");
      out.writeUTF(this.bungeename);
      for(Player all : Bukkit.getOnlinePlayers())
     all.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
      out.close();
      b.close();
    }
    catch (Exception localException) {}
  }
}

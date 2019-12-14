package de.tiger.NickSystem.manager;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;

import de.tiger.NickSystem.Main;
import de.tiger.NickSystem.uuid.UUIDFetcher;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.EnumDifficulty;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;
import net.minecraft.server.v1_8_R3.PacketPlayOutRespawn;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.minecraft.server.v1_8_R3.PlayerInteractManager;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SkinUtils
{
  private static Field modifiers = getField(Field.class, "modifiers");
  private static Field uuidField = getField(GameProfile.class, "id");
  
  public static String[] getSkinData(UUID id)
  {
    String[] array = new String[3];
    if (Main.getInstance().PLAYERDATAS.containsKey(id))
    {
      array = (String[])Main.getInstance().PLAYERDATAS.get(id);
      return array;
    }
    File file = new File("https://de.namemc.com/skin/" + id.toString());
    if (!file.exists())
    {
      FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
      try
      {
        file.createNewFile();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      try
      {
        URL url = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + id.toString().replace("-", "") + "?unsigned=false");
        URLConnection uc = url.openConnection();
        uc.setUseCaches(false);
        uc.setDefaultUseCaches(false);
        uc.setRequestProperty("User-Agent", "curl/7.26.0");
        uc.setRequestProperty("Host", "sessionserver.mojang.com");
        uc.setRequestProperty("Accept", "*/*");
        
        Scanner scn = new Scanner(uc.getInputStream(), "UTF-8");
        String json = scn.useDelimiter("\\A").next();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);
        JSONArray properties = (JSONArray)((JSONObject)obj).get("properties");
        for (int i = 0; i < properties.size(); i++)
        {
          JSONObject property = (JSONObject)properties.get(i);
          String name = (String)property.get("name");
          String value = (String)property.get("value");
          String signature = property.containsKey("signature") ? (String)property.get("signature") : null;
          
          array[0] = name;
          array[1] = value;
          array[2] = signature;
          
          Main.getInstance().PLAYERDATAS.put(id, array);
        }
        scn.close();
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
      cfg.set("Name", array[0]);
      cfg.set("Value", array[1]);
      cfg.set("Signature", array[2]);
      try
      {
        cfg.save(file);
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
    }
    else
    {
      FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
      
      array[0] = cfg.getString("Name");
      array[1] = cfg.getString("Value");
      array[2] = cfg.getString("Signature");
    }
    return array;
  }
  
  public static void updateGameProfile(GameProfile gp, UUID id)
  {
    String[] array = getSkinData(id);
    
    String name = array[0];
    String value = array[1];
    String signature = array[2];
    
    gp.getProperties().clear();
    gp.getProperties().put(name, new Property(name, value, signature));
  }
  
  public static void updateSkin(Player p, UUID id)
  {
    EntityPlayer ep = ((CraftPlayer)p).getHandle();
    UUID uuid = UUIDFetcher.getUUID(p.getName());
    try
    {
      uuidField.set(ep.getProfile(), uuid);
    }
    catch (IllegalArgumentException e)
    {
      e.printStackTrace();
    }
    catch (IllegalAccessException e)
    {
      e.printStackTrace();
    }
    String[] data = getSkinData(id);
    
    ep.getProfile().getProperties().clear();
    ep.getProfile().getProperties().put(data[0], new Property(data[0], data[1], data[2]));
  }
  
  public static void updateSkinFrom(final Player p, UUID id, final boolean noSelfAutoUpdate)
  {
    String[] array = getSkinData(id);
    
    String name = array[0];
    String value = array[1];
    String signature = array[2];
    
    EntityPlayer ep = ((CraftPlayer)p).getHandle();
    try
    {
      uuidField.set(ep.getProfile(), UUIDFetcher.getUUID(p.getName()));
    }
    catch (IllegalArgumentException e)
    {
      e.printStackTrace();
    }
    catch (IllegalAccessException e)
    {
      e.printStackTrace();
    }
    PacketPlayOutPlayerInfo remove = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, new EntityPlayer[] { ep });
    for (Player players : Bukkit.getOnlinePlayers()) {
      if (!noSelfAutoUpdate) {
        ((CraftPlayer)players).getHandle().playerConnection.sendPacket(remove);
      } else if (players != p) {
        ((CraftPlayer)players).getHandle().playerConnection.sendPacket(remove);
      }
    }
    PacketPlayOutEntityDestroy destroy = new PacketPlayOutEntityDestroy(new int[] { p.getEntityId() });
    
    final Location oldloc = p.getLocation();
    final boolean isOp = p.isOp();
    if (!noSelfAutoUpdate) {
      Main.getInstance().NODEATH.add(p);
    }
    for (Player players : Bukkit.getOnlinePlayers()) {
      if (players != p) {
        ((CraftPlayer)players).getHandle().playerConnection.sendPacket(destroy);
      } else if (!noSelfAutoUpdate) {
        ((CraftPlayer)players).getHandle().playerConnection.sendPacket(destroy);
      }
    }
    GameProfile gp = ep.getProfile();
    gp.getProperties().clear();
    gp.getProperties().put(name, new Property(name, value, signature));
    

    new BukkitRunnable()
    {
      public void run()
      {
        PacketPlayOutNamedEntitySpawn spawn = new PacketPlayOutNamedEntitySpawn(SkinUtils.this);
        PacketPlayOutRespawn respawn = new PacketPlayOutRespawn(p.getEntityId(), EnumDifficulty.EASY, SkinUtils.this.world.G(), SkinUtils.this.playerInteractManager.getGameMode());
        for (Player players : Bukkit.getOnlinePlayers()) {
          if (players != p) {
            ((CraftPlayer)players).getHandle().playerConnection.sendPacket(spawn);
          } else {
            ((CraftPlayer)players).getHandle().playerConnection.sendPacket(respawn);
          }
        }
        PacketPlayOutPlayerInfo add = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, new EntityPlayer[] { SkinUtils.this });
        for (Player players : Bukkit.getOnlinePlayers()) {
          if (!noSelfAutoUpdate) {
            ((CraftPlayer)players).getHandle().playerConnection.sendPacket(add);
          } else if (players != p) {
            ((CraftPlayer)players).getHandle().playerConnection.sendPacket(add);
          }
        }
        if (!noSelfAutoUpdate)
        {
          p.teleport(oldloc);
          p.setOp(isOp);
          Main.getInstance().NODEATH.remove(p);
        }
      }
    }.runTaskLater(Main.getInstance(), 2L);
  }
  
  public static void skin(final Player p, final boolean noSelfAutoUpdate)
  {
    
    EntityPlayer ep = ((CraftPlayer)p).getHandle();
    try
    {
      uuidField.set(ep.getProfile(), UUIDFetcher.getUUID(p.getName()));
    }
    catch (IllegalArgumentException e)
    {
      e.printStackTrace();
    }
    catch (IllegalAccessException e)
    {
      e.printStackTrace();
    }
    PacketPlayOutPlayerInfo remove = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, new EntityPlayer[] { ep });
    for (Player players : Bukkit.getOnlinePlayers()) {
      if (!noSelfAutoUpdate) {
        ((CraftPlayer)players).getHandle().playerConnection.sendPacket(remove);
      } else if (players != p) {
        ((CraftPlayer)players).getHandle().playerConnection.sendPacket(remove);
      }
    }
    PacketPlayOutEntityDestroy destroy = new PacketPlayOutEntityDestroy(new int[] { p.getEntityId() });
    
    final Location oldloc = p.getLocation();
    final boolean isOp = p.isOp();
    if (!noSelfAutoUpdate) {
      Main.getInstance().NODEATH.add(p);
    }
    for (Player players : Bukkit.getOnlinePlayers()) {
      if (players != p) {
        ((CraftPlayer)players).getHandle().playerConnection.sendPacket(destroy);
      } else if (!noSelfAutoUpdate) {
        ((CraftPlayer)players).getHandle().playerConnection.sendPacket(destroy);
      }
    }
    GameProfile gp = ep.getProfile();
    gp.getProperties().clear();
    

    new BukkitRunnable()
    {
      public void run()
      {
        PacketPlayOutNamedEntitySpawn spawn = new PacketPlayOutNamedEntitySpawn(SkinUtils.this);
        PacketPlayOutRespawn respawn = new PacketPlayOutRespawn(p.getEntityId(), EnumDifficulty.EASY, SkinUtils.this.world.G(), SkinUtils.this.playerInteractManager.getGameMode());
        for (Player players : Bukkit.getOnlinePlayers()) {
          if (players != p) {
            ((CraftPlayer)players).getHandle().playerConnection.sendPacket(spawn);
          } else {
            ((CraftPlayer)players).getHandle().playerConnection.sendPacket(respawn);
          }
        }
        PacketPlayOutPlayerInfo add = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, new EntityPlayer[] { SkinUtils.this });
        for (Player players : Bukkit.getOnlinePlayers()) {
          if (!noSelfAutoUpdate) {
            ((CraftPlayer)players).getHandle().playerConnection.sendPacket(add);
          } else if (players != p) {
            ((CraftPlayer)players).getHandle().playerConnection.sendPacket(add);
          }
        }
        if (!noSelfAutoUpdate)
        {
          p.teleport(oldloc);
          p.setOp(isOp);
          Main.getInstance().NODEATH.remove(p);
        }
      }
    }.runTaskLater(Main.getInstance(), 2L);
  }
  
  public static Field getField(Class<?> clazz, String name)
  {
    try
    {
      Field f = clazz.getDeclaredField(name);
      f.setAccessible(true);
      if (Modifier.isFinal(f.getModifiers())) {
        modifiers.set(f, Integer.valueOf(f.getModifiers() & 0xFFFFFFEF));
      }
      return f;
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    return null;
  }
}

package de.tiger.NickSystem.manager;

import com.mojang.authlib.GameProfile;

import de.tiger.NickSystem.Main;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class NameUtils
{
  private static Field modifiers = getField(Field.class, "modifiers");
  private static Field nameField = getField(GameProfile.class, "name");
  
  public static void setName(Player p, String name)
  {
    try
    {
      Main.getInstance().REALNAMES.put(p, p.getName());
      EntityPlayer ep = ((CraftPlayer)p).getHandle();
      nameField.set(ep.getProfile(), name);
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
  
  public static void resetName(Player p)
  {
    String realName = (String)Main.getInstance().REALNAMES.get(p);
    try
    {
      EntityPlayer ep = ((CraftPlayer)p).getHandle();
      nameField.set(ep.getProfile(), realName);
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    Main.getInstance().REALNAMES.remove(p);
  }
  
  public static String getRealName(Player p)
  {
    if (Main.getInstance().REALNAMES.containsKey(p)) {
      return (String)Main.getInstance().REALNAMES.get(p);
    }
    return p.getName();
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

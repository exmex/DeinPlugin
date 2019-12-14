package Utils;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public enum ParticleEffect
{
  HUGE_EXPLOSION("hugeexplosion"),  LARGE_EXPLODE("largeexplode"),  FIREWORKS_SPARK("fireworksSpark"),  BUBBLE("bubble"),  SUSPEND("suspend"),  DEPTH_SUSPEND("depthSuspend"),  TOWN_AURA("townaura"),  CRIT("crit"),  MAGIC_CRIT("magicCrit"),  MOB_SPELL("mobSpell"),  MOB_SPELL_AMBIENT("mobSpellAmbient"),  SPELL("spell"),  INSTANT_SPELL("instantSpell"),  WITCH_MAGIC("witchMagic"),  NOTE("note"),  PORTAL("portal"),  ENCHANTMENT_TABLE("enchantmenttable"),  EXPLODE("explode"),  FLAME("flame"),  LAVA("lava"),  FOOTSTEP("footstep"),  SPLASH("splash"),  LARGE_SMOKE("largesmoke"),  CLOUD("cloud"),  RED_DUST("reddust"),  SNOWBALL_POOF("snowballpoof"),  DRIP_WATER("dripWater"),  DRIP_LAVA("dripLava"),  SNOW_SHOVEL("snowshovel"),  SLIME("slime"),  HEART("heart"),  ANGRY_VILLAGER("angryVillager"),  HAPPY_VILLAGER("happerVillager"),  ICONCRACK("iconcrack_"),  TILECRACK("tilecrack_");
  
  private String particleName;
  
  private ParticleEffect(String particleName)
  {
    this.particleName = particleName;
  }
  
  public void sendToPlayer(Player player, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count)
    throws Exception
  {
    PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles();
    ReflectionUtils.setValue(packet, "a", this.particleName);
    ReflectionUtils.setValue(packet, "b", Float.valueOf((float)location.getX()));
    ReflectionUtils.setValue(packet, "c", Float.valueOf((float)location.getY()));
    ReflectionUtils.setValue(packet, "d", Float.valueOf((float)location.getZ()));
    ReflectionUtils.setValue(packet, "e", Float.valueOf(offsetX));
    ReflectionUtils.setValue(packet, "f", Float.valueOf(offsetY));
    ReflectionUtils.setValue(packet, "g", Float.valueOf(offsetZ));
    ReflectionUtils.setValue(packet, "h", Float.valueOf(speed));
    ReflectionUtils.setValue(packet, "i", Integer.valueOf(count));
    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
  }
}
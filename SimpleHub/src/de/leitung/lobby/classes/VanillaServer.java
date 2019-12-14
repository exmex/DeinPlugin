package de.leitung.lobby.classes;

import java.net.InetSocketAddress;

public class VanillaServer
{
  private final ServerListPing17 mcping;
  private String address;
  private int port;
  private int timeout;
  private InetSocketAddress inet;
  private boolean online;
  private int playercount;
  private int maxplayers;
  private String motd;
  
  public VanillaServer(String address, int port, int timeout)
  {
    this.address = address;
    this.port = port;
    this.timeout = timeout;
    this.inet = new InetSocketAddress(getAddress(), getPort());
    this.mcping = new ServerListPing17();
    this.mcping.setAddress(this.inet);
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public void setAddress(String address)
  {
    this.address = address;
  }
  
  public int getPort()
  {
    return this.port;
  }
  
  public void setPort(int port)
  {
    this.port = port;
  }
  
  public int getTimeout()
  {
    return this.timeout;
  }
  
  public void setTimeout(int timeout)
  {
    this.timeout = timeout;
  }
  
  public boolean isOnline()
  {
    return this.online;
  }
  
  private void setOnline(boolean online)
  {
    this.online = online;
  }
  
  public int getPlayerCount()
  {
    return this.playercount;
  }
  
  private void setPlayerCount(int playercount)
  {
    this.playercount = playercount;
  }
  
  public int getMaxPlayers()
  {
    return this.maxplayers;
  }
  
  private void setMaxPlayers(int maxplayers)
  {
    this.maxplayers = maxplayers;
  }
  
  public String getMotd()
  {
    return this.motd;
  }
  
  private void setMotd(String motd)
  {
    this.motd = motd;
  }
  
  public void ping()
  {
    try
    {
      ServerListPing17.StatusResponse data = this.mcping.fetchData();
      setMotd(data.getDescription());
      setOnline(true);
      setPlayerCount(data.getPlayers().getOnline());
      setMaxPlayers(data.getPlayers().getMax());
    }
    catch (Exception e)
    {
      setOnline(false);
      setMotd(null);
    }
  }
}
package de.leitung.lobby.classes;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

import com.google.gson.Gson;

public class ServerListPing17
{
  private InetSocketAddress host;
  private int timeout = 7000;
  private Gson gson = new Gson();
 
  public void setAddress(InetSocketAddress host)
  {
    this.host = host;
  }
 
  public InetSocketAddress getAddress()
  {
    return this.host;
  }
 
  void setTimeout(int timeout)
  {
    this.timeout = timeout;
  }
 
  int getTimeout()
  {
    return this.timeout;
  }
 
  public int readVarInt(DataInputStream in)
    throws IOException
  {
    int i = 0;
    int j = 0;
    int k;
    do
    {
      k = in.readByte();
      i |= (k & 0x7F) << j++ * 7;
      if (j > 5) {
        throw new RuntimeException("VarInt too big");
      }
    } while ((k & 0x80) == 128);
    return i;
  }
 
  public void writeVarInt(DataOutputStream out, int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        out.writeByte(paramInt);
        return;
      }
      out.writeByte(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
 
  public StatusResponse fetchData()
    throws IOException
  {
    Socket socket = new Socket();
    socket.setSoTimeout(this.timeout);
    socket.connect(this.host, this.timeout);
   
    OutputStream outputStream = socket.getOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
    InputStream inputStream = socket.getInputStream();
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    DataOutputStream handshake = new DataOutputStream(b);
   
    handshake.writeByte(0);
    writeVarInt(handshake, 4);
    writeVarInt(handshake, this.host.getHostString().length());
    handshake.writeBytes(this.host.getHostString());
    handshake.writeShort(this.host.getPort());
    writeVarInt(handshake, 1);
    writeVarInt(dataOutputStream, b.size());
    dataOutputStream.write(b.toByteArray());
   
    dataOutputStream.writeByte(1);
    dataOutputStream.writeByte(0);
    DataInputStream dataInputStream = new DataInputStream(inputStream);
    int size = readVarInt(dataInputStream);
    int id = readVarInt(dataInputStream);
    if (id == -1) {
      throw new IOException("Premature end of stream.");
    }
    if (id != 0) {
      throw new IOException("Invalid packetID");
    }
    int length = readVarInt(dataInputStream);
    if (length == -1) {
      throw new IOException("Premature end of stream.");
    }
    if (length == 0) {
      throw new IOException("Invalid string length.");
    }
    byte[] in = new byte[length];
    dataInputStream.readFully(in);
    String json = new String(in);
    long now = System.currentTimeMillis();
    dataOutputStream.writeByte(9);
    dataOutputStream.writeByte(1);
    dataOutputStream.writeLong(now);
    readVarInt(dataInputStream);
    id = readVarInt(dataInputStream);
    if (id == -1) {
      throw new IOException("Premature end of stream.");
    }
    if (id != 1) {
      throw new IOException("Invalid packetID");
    }
    long pingtime = dataInputStream.readLong();
    StatusResponse response = (StatusResponse)this.gson.fromJson(json, StatusResponse.class);
    response.setTime((int)(now - pingtime));
    dataOutputStream.close();
    outputStream.close();
    inputStreamReader.close();
    inputStream.close();
    socket.close();
    return response;
  }
 
  public class StatusResponse
  {
    private String description;
    private ServerListPing17.Players players;
    private ServerListPing17.Version version;
    private String favicon;
    private int time;
   
    public StatusResponse() {}
   
    public String getDescription()
    {
      return this.description;
    }
   
    public ServerListPing17.Players getPlayers()
    {
      return this.players;
    }
   
    public ServerListPing17.Version getVersion()
    {
      return this.version;
    }
   
    public String getFavicon()
    {
      return this.favicon;
    }
   
    public int getTime()
    {
      return this.time;
    }
   
    public void setTime(int time)
    {
      this.time = time;
    }
  }
 
  public class Players
  {
    private int max;
    private int online;
    private List<ServerListPing17.Player> sample;
   
    public Players() {}
   
    public int getMax()
    {
      return this.max;
    }
   
    public int getOnline()
    {
      return this.online;
    }
   
    public List<ServerListPing17.Player> getSample()
    {
      return this.sample;
    }
  }
 
  public class Player
  {
    private String name;
    private String id;
   
    public Player() {}
   
    public String getName()
    {
      return this.name;
    }
   
    public String getId()
    {
      return this.id;
    }
  }
 
  public class Version
  {
    private String name;
    private String protocol;
   
    public Version() {}
   
    public String getName()
    {
      return this.name;
    }
   
    public String getProtocol()
    {
      return this.protocol;
    }
  }
}

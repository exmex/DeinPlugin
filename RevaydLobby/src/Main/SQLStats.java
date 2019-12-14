package Main;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SQLStats {

	  public static void registerPlayer(Player p)
	  {
	    if (MySQL.playerDataContainsPlayer(p)) {
	      return;
	    }
	    try
	    {
	      PreparedStatement st = MySQL.conn.prepareStatement("INSERT INTO `LOBBY` values(?,0,0,0,0,0)");
	      st.setString(1, p.getUniqueId().toString());
	      st.execute();
	      st.close();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	  }
	  
	  
	  public static void setVerstecken(Player p, int i)
	  {
	    try
	    {
	      PreparedStatement st = MySQL.conn.prepareStatement("UPDATE `LOBBY` SET spieler_verstecken=? WHERE uuid=?");
	      st.setInt(1, i);
	      st.setString(2, p.getUniqueId().toString());
	      st.executeUpdate();
	    }
	    catch (Exception localException) {}
	  }
	  
	  public static void setDoublejump(Player p, int i)
	  {
	    try
	    {
	      PreparedStatement st = MySQL.conn.prepareStatement("UPDATE `LOBBY` SET spieler_doublejump=? WHERE uuid=?");
	      st.setInt(1, i);
	      st.setString(2, p.getUniqueId().toString());
	      st.executeUpdate();
	    }
	    catch (Exception localException) {}
	  }
	  
	  public static void setColorboots(Player p, int i)
	  {
	    try
	    {
	      PreparedStatement st = MySQL.conn.prepareStatement("UPDATE `LOBBY` SET spieler_colorboots=? WHERE uuid=?");
	      st.setInt(1, i);
	      st.setString(2, p.getUniqueId().toString());
	      st.executeUpdate();
	    }
	    catch (Exception localException) {}
	  }

	  public static void setChallengerBlockRequest(Player p, int i)
	  {
	    try
	    {
	      PreparedStatement st = MySQL.conn.prepareStatement("UPDATE `LOBBY` SET challenger_blockrequests=? WHERE uuid=?");
	      st.setInt(1, i);
	      st.setString(2, p.getUniqueId().toString());
	      st.executeUpdate();
	    }
	    catch (Exception localException) {}
	  }

	  
	  public static boolean getVerstecken(Player p)
	  {
	    try
	    {
	      PreparedStatement st = MySQL.conn.prepareStatement("SELECT * FROM `LOBBY` WHERE uuid=?");
	      st.setString(1, p.getUniqueId().toString());
	      ResultSet rs = st.executeQuery();
	      rs.next();
	      int points = rs.getInt("spieler_verstecken");
	      rs.close();
	      st.close();
	      if(points == 0){
	    	  return false;
	      }else{
	    	  return true;
	      }
	    }
	    catch (Exception localException) {}
	    return false;
	  }
	  
	  public static boolean getDoublejump(Player p)
	  {
	    try
	    {
	      PreparedStatement st = MySQL.conn.prepareStatement("SELECT * FROM `LOBBY` WHERE uuid=?");
	      st.setString(1, p.getUniqueId().toString());
	      ResultSet rs = st.executeQuery();
	      rs.next();
	      int points = rs.getInt("spieler_doublejump");
	      rs.close();
	      st.close();
	      if(points == 0){
	    	  return false;
	      }else{
	    	  return true;
	      }
	    }
	    catch (Exception localException) {}
	    return false;
	  }
	  
	  public static boolean getColorboots(Player p)
	  {
	    try
	    {
	      PreparedStatement st = MySQL.conn.prepareStatement("SELECT * FROM `LOBBY` WHERE uuid=?");
	      st.setString(1, p.getUniqueId().toString());
	      ResultSet rs = st.executeQuery();
	      rs.next();
	      int points = rs.getInt("spieler_verstecken");
	      rs.close();
	      st.close();
	      if(points == 0){
	    	  return false;
	      }else{
	    	  return true;
	      }
	    }
	    catch (Exception localException) {}
	    return false;
	  }
	  
	  public static boolean getChallengerBlockRequest(Player p)
	  {
	    try
	    {
	      PreparedStatement st = MySQL.conn.prepareStatement("SELECT * FROM `LOBBY` WHERE uuid=?");
	      st.setString(1, p.getUniqueId().toString());
	      ResultSet rs = st.executeQuery();
	      rs.next();
	      int points = rs.getInt("challenger_blockrequests");
	      rs.close();
	      st.close();
	      if(points == 0){
	    	  return false;
	      }else{
	    	  return true;
	      }
	    }
	    catch (Exception localException) {}
	    return false;
	  }
	  

	  
	  public static class MySQL
	  {
	    public static Connection conn;
	    private static String username;
	    private static String database;
	    private static String password;
	    private static String host;
	    private static int port;
	    
	    public MySQL()
	    {
	      File f = new File(Main.getInstance().getDataFolder(), "sql.yml");
	      FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	      cfg.addDefault("user", "user");
	      cfg.addDefault("database", "database");
	      cfg.addDefault("password", "password");
	      cfg.addDefault("host", "host");
	      cfg.addDefault("port", Integer.valueOf(3306));
	      cfg.options().copyDefaults(true);
	      try
	      {
	        cfg.save(f);
	      }
	      catch (IOException e)
	      {
	        e.printStackTrace();
	      }
	      cfg = YamlConfiguration.loadConfiguration(f);
	      username = cfg.getString("user");
	      database = cfg.getString("database");
	      password = cfg.getString("password");
	      host = cfg.getString("host");
	      port = cfg.getInt("port");
	    }
	    
	    public boolean init()
	    {
	      
	      if (conn != null) {
	        try
	        {
	          PreparedStatement st = conn.prepareStatement("CREATE TABLE IF NOT EXISTS LOBBY (id INT AUTO_INCREMENT PRIMARY KEY, uuid VARCHAR(100), tokens INT(100), spieler_verstecken INT(1), spieler_doublejump INT(1), spieler_colorboots INT(1), challenger_blockrequests INT(1))");
	          st.execute();
	          st.close();
	        }
	        catch (SQLException localSQLException) {}
	      }
	      return conn != null;
	    }
	    
	    public static synchronized void openConnection()
	    {
	      try
	      {
	        conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
	      }
	      catch (Exception localException) {}
	    }
	    
	    public static synchronized void closeConnection()
	    {
	      try
	      {
	        conn.close();
	      }
	      catch (Exception localException) {}
	    }
	    
	    public static synchronized boolean playerDataContainsPlayer(Player p)
	    {
	      try
	      {
	        PreparedStatement sql = conn.prepareStatement("SELECT * FROM `LOBBY` WHERE uuid=?;");
	        sql.setString(1, p.getUniqueId().toString());
	        ResultSet set = sql.executeQuery();
	        boolean containsPlayer = set.next();
	        sql.close();
	        set.close();
	        
	        return containsPlayer;
	      }
	      catch (Exception e) {}
	      return false;
	    }
	    
	    public static synchronized boolean playerDataContainsPlayer(UUID uuid)
	    {
	      try
	      {
	        PreparedStatement sql = conn.prepareStatement("SELECT * FROM `LOBBY` WHERE uuid=?;");
	        sql.setString(1, uuid.toString());
	        ResultSet set = sql.executeQuery();
	        boolean containsPlayer = set.next();
	        sql.close();
	        set.close();
	        
	        return containsPlayer;
	      }
	      catch (Exception e)
	      {
	        e.printStackTrace();
	      }
	      return false;
	    }
	    
	    public static void restartSQL()
	    {
	      closeConnection();
	      openConnection();
	    }
	    
		public static void performUpdate(String query) {
			
			if (conn == null) {
				openConnection();
			}
			
			try {
				Statement statement = conn.createStatement();
				statement.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println("[Error] Error whilest performing Update!");
				System.out.println("[Query] " + query);
			}
		}
		
		public static ResultSet getQuery(String query) {
			ResultSet resultSet = null;
			
			if (conn == null) {
				openConnection();
			}
			
			try {
				Statement statement = conn.createStatement();
				resultSet = statement.executeQuery(query);
			} catch (SQLException e) {
				System.out.println("[Error] Error whilest getting ResultSet");
				System.out.println("[Query] " + query);
			}
			
			return resultSet;
		}
		
		public static boolean hasConnection() {
			return conn != null;
		}
	    
	   
		  
	  }	 
}

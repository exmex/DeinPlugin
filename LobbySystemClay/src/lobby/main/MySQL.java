package lobby.main;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;

import com.mysql.jdbc.Connection;

import lobby.data.Data;


public class MySQL {
	public static String Host = "localhost";
	public static int Port = 3306;
	public static String Database = "Lobby";
	public static String UserName = "root";
	public static String Password = "wstrzq3237sd2";
	  public static Connection con;



	    public static void connect() {

	        if(!isConnected()) {
	            try {
	                con = (Connection) DriverManager.getConnection("jdbc:mysql://"+ Host + ":"+Port + "/" +Database + "?autoReconnect=true" , UserName , Password);
	                Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§6§l[MySQL] §a§lDie Verbindung wurde erfolgreich hergestellt!");
	            } catch (SQLException e) {
	                Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§6§l[MySQL] §c§lDie Verbindung konnte nicht hergestellt werden!");
	            e.printStackTrace();    
	            }
	        }


	    }

	    public static void disconnect() {

	        if(isConnected()) {
	            try {
	                con.close();
	                Bukkit.getConsoleSender().sendMessage(Data.Prefix + "§6§l[MySQL] §c§lDie Verbindung wurde unterbrochen");
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	    }


	    public static boolean isConnected() {
	        return (con != null);
	    }


	    public static void createTable() {
	        if(isConnected()) {
	            try {
	                con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS LobbyBelohnung (UUID VARCHAR(100), LASTDATUM VARCHAR(100));");
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }


	    public static void update(String qry) {
	        try {
	            java.sql.Statement st = con.createStatement();
	            st.executeUpdate(qry);
	            st.close();
	        } catch (SQLException e) {
	            connect();
	            System.err.println(e);
	        }
	    }


	    public static ResultSet getResult(String qry) {
	        if(isConnected()) {
	            try {
	                return con.createStatement().executeQuery(qry);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return null;
	    }



}

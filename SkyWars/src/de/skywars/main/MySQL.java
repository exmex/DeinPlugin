package de.skywars.main;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MySQL {

    public static Connection con;



    public static void connect() {

        if(!isConnected()) {
            try {
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SkyWars?autoReconnect=true" , "root" , "wstrzq3237sd2");
                System.out.println("[MySQL] Die Verbindung wurde erfolgreich hergestellt!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static void disconnect() {

        if(isConnected()) {
            try {
                con.close();
                System.out.println("[MySQL] Verbindung aus");
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
                con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS SkyWarsStats (Name VARCHAR(100), Kills int , Tode int);");
                con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS SkyCoins (Name VARCHAR(100), Coins int);");
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
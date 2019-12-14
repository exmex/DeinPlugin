package utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by regnatrix on 28.11.16.
 */
public class MySQL {

    public static Connection con;



    public static void connect() {

        if(!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/AutoNick?autoReconnect=true" , "root" , "44/ub=(K}33fMa=$>Q");
                System.out.println("[MySQL] Verbindung an");
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
                con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS EPStats (Name VARCHAR(100), Kills int , Tode int);");
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

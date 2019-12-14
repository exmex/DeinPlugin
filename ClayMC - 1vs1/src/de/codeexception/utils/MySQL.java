package de.codeexception.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQL {

	public static String user = "a";
	public static String pass = "a";
	public static String db = "1vs1";
	public static String port = "3306";
	public static String host = "localhost";
	public static Connection con;

	
	public static void connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db + "?autoReconnect=true", user, pass);
			System.out.println("§6[§aMySQL§6] §eDie Verbindung zur MySQL wurde Erfolgreich hergestellt!");
		} catch (SQLException e) {
			System.out.println("[MySQL] Die Verbindung zur MySQL ist fehlgeschlagen! Fehler: " + e.getMessage());
		}
	}
	public static void close() {
		if(con != null) {
			try {
				con.close();
				System.out.println("§6[§aMySQL§6] §eDie Verbindung zur MySQL wurde Erfolgreich beendet!");
			} catch (SQLException e) {
				System.out.println("[MySQL] Die Verbindung zur MySQL ist fehlgeschlagen! Fehler: " + e.getMessage());
			}
		}
	}
	public static void update(final String sql) {
		Thread thread = new Thread() {
			public void run() {
				try {
				    con.createStatement().executeUpdate(sql);
					System.out.println("§6[§aMySQL§6] §aMySQL successfully updated!");
				}catch (SQLException e) {
					System.out.println("§6[§aMySQL§6] §cWas the update (§7" + sql + "§c) not run!");
				}
			};
		};
		thread.start();
	}
	public static ResultSet query(final String qry) {
		final ResultSet[] rs = {null}; 
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					Statement st = con.createStatement();
					rs[0] = st.executeQuery(qry);
				} catch (SQLException e) {
					System.err.println(e);
				}
			}
		};
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs[0];
	}
}
package DataBase.DataDelete;

import java.sql.Connection;
import java.sql.Statement;

import Data.Client;
import DataBase.SQLiteConnection;

public class ClientDataDelete {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	
	public static void deleteData(Client c) {
		try {
			stmt = con.createStatement();
			
			sql = ("REMOVE FROM client WHERE dni = " + c.getDni() + ";");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't delete data");
		}
	}
}

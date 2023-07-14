package DataBase.DataInsert;

import java.sql.Connection;
import java.sql.Statement;

import DataBase.SQLiteConnection;

public class AddressDataInsert {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	
	public static void insertData(String street, int number, String postalCode, String clientDni) {
		try {
			stmt = con.createStatement();
			
			sql = ("INSERT INTO address(street, number, postal_code, client_dni)"
					+ "VALUES(" + street + ", " + number + ", " + postalCode + ", " + clientDni + ");");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't insert data");
		}
	}
	
}

package DataBase.DataInsert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

import DataBase.SQLiteConnection;

public class ClientDataInsert {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	
	public static void insertData(String dni, String name, String surname, Date birthDate, boolean memberSubscription) {
		try {
			stmt = con.createStatement();
			
			sql = ("INSERT INTO book(dni, name, surname, birthdate, member_subscription)"
					+ "VALUES(" + dni + ", " + name + ", " + surname + ", " + birthDate + ", " + memberSubscription+ ");");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't insert data");
		}
	}

}

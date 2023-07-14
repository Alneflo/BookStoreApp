package DataBase.DataInsert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

import DataBase.SQLiteConnection;

public class AuthorDataInsert {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	
	public static void insertData(String name, String surname, Date birthDate) {
		try {
			stmt = con.createStatement();
			
			sql = ("INSERT INTO author(name, surname, birth_date)"
					+ "VALUES(" + name + ", " + surname + ", " + birthDate + ");");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't insert data");
		}
	}

}

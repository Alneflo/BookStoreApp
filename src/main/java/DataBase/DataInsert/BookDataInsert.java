package DataBase.DataInsert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

import DataBase.SQLiteConnection;

public class BookDataInsert {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	
	public static void insertData(String isbn, String title, int minAge, String smallDescription, String publishingHouse, Date publishingDate, double price, int amount) {
		try {
			stmt = con.createStatement();
			
			sql = ("INSERT INTO book(isbn, title, minimum_age, small_description, publishing_house, publishing_date, price, amount)"
					+ "VALUES(" + isbn + ", " + title + ", " + minAge + ", " + smallDescription + ", " + publishingHouse + ", " + publishingDate + ", " + price + ", " + amount + ");");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't insert data");
		}
	}

}

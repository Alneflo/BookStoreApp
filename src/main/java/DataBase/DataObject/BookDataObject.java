package DataBase.DataObject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Book;
import DataBase.SQLiteConnection;

public class BookDataObject {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	private static ResultSet rs;
	
	public static void setInfo(ArrayList<Book> a) {
		rs = DataAccess.getResultSet("author");
		if(rs != null) {
			String isbn, title, smallDesc, publishingHouse;
			int minAge, amount;
			Date publishingDate;
			double price;
			
			try {
				a = new ArrayList<>();
				
				while(rs.next()) {
					isbn = rs.getString("isbn");
					title = rs.getString("title");
					minAge = rs.getInt("minimum_age");
					smallDesc = rs.getString("small_description");
					publishingHouse = rs.getString("publishing_house");
					publishingDate = rs.getDate("publishing_date");
					price = rs.getDouble("price");
					amount = rs.getInt("amount");
					
					a.add(new Book(isbn, title, minAge, smallDesc, publishingHouse, publishingDate, price, amount));
				}
				
				rs.close();
				
			}catch(Exception e) {
				a = null;
			}
			
		}else {
			System.err.println("No data to show");
		}
		
	}
	
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
	
	public static void updateData(String column, String value, Book object) {
		try {
			stmt = con.createStatement();
			
			sql = ("UPDATE TABLE book SET " + column + " = " + value + " WHERE isbn = " + object.getIsbn() + ";");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't insert data");
		}
	}

}

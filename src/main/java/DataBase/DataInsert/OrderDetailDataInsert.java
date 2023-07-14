package DataBase.DataInsert;

import java.sql.Connection;
import java.sql.Statement;

import DataBase.SQLiteConnection;

public class OrderDetailDataInsert {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	
	public static void insertData(int orderId, String bookIsbn, int amount, double memberDiscount, double finalPrice) {
		try {
			stmt = con.createStatement();
			
			sql = ("INSERT INTO order_detail(order_id, book_isbn, amount, member_discount, final_price)"
					+ "VALUES(" + orderId + ", " + bookIsbn + ", " + amount + ", " + memberDiscount + ", " + finalPrice + ");");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't insert data");
		}
	}

}

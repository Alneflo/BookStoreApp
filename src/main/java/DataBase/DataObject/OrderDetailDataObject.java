package DataBase.DataObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Data.OrderDetail;
import DataBase.SQLiteConnection;

public class OrderDetailDataObject {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	private static ResultSet rs;
	
	public static void setInfo(ArrayList<OrderDetail> a) {
		rs = DataAccess.getResultSet("author");
		if(rs != null) {
			String bookIsbn;
			int id, orderId, amount;
			double memberDiscount, finalPrice;
			
			try {
				a = new ArrayList<>();
				
				while(rs.next()) {
					bookIsbn = rs.getString("book_isbn");
					id = rs.getInt("id");
					orderId = rs.getInt("order_id");
					amount = rs.getInt("amount");
					memberDiscount = rs.getDouble("member_discount");
					finalPrice = rs.getDouble("final_price");
					
					a.add(new OrderDetail(id, orderId, bookIsbn, amount, memberDiscount, finalPrice));
				}
				
				rs.close();
				
			}catch(Exception e) {
				a = null;
			}
			
		}else {
			System.err.println("No data to show");
		}
		
	}
	
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
	
	public static void updateData(String column, String value, OrderDetail object) {
		try {
			stmt = con.createStatement();
			
			sql = ("UPDATE TABLE order_detail SET " + column + " = " + value + " WHERE id = " + object.getId() + ";");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't insert data");
		}
	}

}

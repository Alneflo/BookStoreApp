package DataBase.DataObject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Data.OrderHead;
import DataBase.SQLiteConnection;

public class OrderHeadDataObject {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	private static ResultSet rs;
	
	public static void setInfo(ArrayList<OrderHead> a) {
		rs = DataAccess.getResultSet("author");
		if(rs != null) {
			String employeeDni, clientDni;
			int id, addressId;
			Date orderDate;
			
			try {
				a = new ArrayList<>();
				
				while(rs.next()) {
					clientDni = rs.getString("client_dni");
					id = rs.getInt("id");
					employeeDni = rs.getString("employee_dni");
					addressId = rs.getInt("address_id");
					orderDate = rs.getDate("order_date");
					
					a.add(new OrderHead(id, employeeDni, clientDni, addressId, orderDate));
				}
				
				rs.close();
				
			}catch(Exception e) {
				a = null;
			}
			
		}else {
			System.err.println("No data to show");
		}
		
	}
	
	public static void insertData(String employeeDni, String clientDni, int addressId, Date orderDate) {
		try {
			stmt = con.createStatement();
			
			sql = ("INSERT INTO order_head(employee_dni, client_dni, address_id, order_date)"
					+ "VALUES(" + employeeDni + ", " + clientDni + ", " + addressId + ", " + orderDate + ");");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't insert data");
		}
	}
	
	public static void updateData(String column, String value, OrderHead object) {
		try {
			stmt = con.createStatement();
			
			sql = ("UPDATE TABLE order_head SET " + column + " = " + value + " WHERE id = " + object.getId() + ";");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't insert data");
		}
	}

}

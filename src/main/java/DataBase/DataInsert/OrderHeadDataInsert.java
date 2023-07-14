package DataBase.DataInsert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

import DataBase.SQLiteConnection;

public class OrderHeadDataInsert {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	
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

}

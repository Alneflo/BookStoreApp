package DataBase.DataObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Address;
import DataBase.SQLiteConnection;

public class AddressDataObject {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	private static ResultSet rs;
	
	public static void setInfo(ArrayList<Address> a) {
		rs = DataAccess.getResultSet("address");
		if(rs != null) {
			String street, postalCode, clientId;
			int id, number;
			try {
				a = new ArrayList<>();
				
				while(rs.next()) {
					street = rs.getString("street");
					postalCode = rs.getString("postal_code");
					clientId = rs.getString("client_id");
					id = rs.getInt("id");
					number = rs.getInt("number");
					
					a.add(new Address(id, street, number, postalCode, clientId));
				}
				
				rs.close();
				
			}catch(Exception e) {
				a = null;
			}
		}else {
			System.err.println("No data to show");
		}
		
	}
	
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
	
	public static void updateData(String column, String value, Address object) {
		try {
			stmt = con.createStatement();
			
			sql = ("UPDATE TABLE address SET " + column + " = " + value + " WHERE id = " + object.getId() + ";");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't insert data");
		}
	}
	
}

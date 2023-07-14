package DataBase.DataObject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Client;
import DataBase.SQLiteConnection;

public class ClientDataObject {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	private static ResultSet rs;
	
	public static void setInfo(ArrayList<Client> a) {
		rs = DataAccess.getResultSet("author");
		if(rs != null) {
			String dni, name, surname;
			boolean memberSubscription;
			Date birthDate;
			
			try {
				a = new ArrayList<>();
				
				while(rs.next()) {
					dni = rs.getString("dni");
					name = rs.getString("name");
					surname = rs.getString("surname");
					birthDate = rs.getDate("birthdate");
					memberSubscription = rs.getBoolean("member_subscription");
					
					a.add(new Client(dni, name, surname, birthDate, memberSubscription));
				}
				
				rs.close();
				
			}catch(Exception e) {
				a = null;
			}
			
		}else {
			System.err.println("No data to show");
		}
		
	}
	
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
	
	public static void updateData(String column, String value, Client object) {
		try {
			stmt = con.createStatement();
			
			sql = ("UPDATE TABLE client SET " + column + " = " + value + " WHERE dni = " + object.getDni() + ";");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't insert data");
		}
	}
	
	public static void deleteData(Client c) {
		try {
			stmt = con.createStatement();
			
			sql = ("REMOVE FROM client WHERE dni = " + c.getDni() + ";");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't delete data");
		}
	}

}

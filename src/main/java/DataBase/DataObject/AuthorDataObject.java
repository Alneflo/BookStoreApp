package DataBase.DataObject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Author;
import DataBase.SQLiteConnection;

public class AuthorDataObject {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	private static ResultSet rs;
	
	public static void setInfo(ArrayList<Author> a) {
		rs = DataAccess.getResultSet("author");
		if(rs != null) {
			String name, surname;
			int id;
			Date birthDate;
			
			try {
				a = new ArrayList<>();
				
				while(rs.next()) {
					id = rs.getInt("id");
					name = rs.getString("name");
					surname = rs.getString("surname");
					birthDate = rs.getDate("birthDate");
					
					a.add(new Author(id, name, surname, birthDate));
				}
				
				rs.close();
				
			}catch(Exception e) {
				a = null;
			}
		}else {
			System.err.println("No data to show");
		}
		
	}
	
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
	
	public static void updateData(String column, String value, Author object) {
		try {
			stmt = con.createStatement();
			
			sql = ("UPDATE TABLE author SET " + column + " = " + value + " WHERE id = " + object.getId() + ";");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't insert data");
		}
	}

}

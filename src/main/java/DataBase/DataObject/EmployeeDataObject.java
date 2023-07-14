package DataBase.DataObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Employee;
import DataBase.SQLiteConnection;

public class EmployeeDataObject {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	private static ResultSet rs;
	
	public static void setInfo(ArrayList<Employee> a) {
		rs = DataAccess.getResultSet("author");
		if(rs != null) {
			String dni, name, surname, telephone, email, passwd;
			int jobId;
			
			try {
				a = new ArrayList<>();
				
				while(rs.next()) {
					dni = rs.getString("dni");
					name = rs.getString("name");
					surname = rs.getString("surname");
					jobId = rs.getInt("job_id");
					telephone = rs.getString("telephone");
					email = rs.getString("email");
					passwd = rs.getString("passwd");
					
					a.add(new Employee(dni, name, surname, jobId, telephone, email, passwd));
				}
				
				rs.close();
				
			}catch(Exception e) {
				a = null;
			}
			
		}else {
			System.err.println("No data to show");
		}
		
	}
	
	public static void insertData(String dni, String name, String surname, int jobId, String telephone, String email, String passwd) {
		try {
			stmt = con.createStatement();
			
			sql = ("INSERT INTO employee(dni, name, surname, job_id, telephone, email, passwd)"
					+ "VALUES(" + dni + ", " + name + ", " + surname + ", " + jobId + ", " + telephone + ", " + email + ", " + passwd + ");");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't insert data");
		}
	}
	
	public static void updateData(String column, String value, Employee object) {
		try {
			stmt = con.createStatement();
			
			sql = ("UPDATE TABLE employee SET " + column + " = " + value + " WHERE dni = " + object.getDni() + ";");
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			System.err.println("Couldn't insert data");
		}
	}
	
	public static void deleteData(Employee e) {
		try {
			stmt = con.createStatement();
			
			sql = ("REMOVE FROM employee WHERE dni = " + e.getDni() + ";");
			
			stmt.executeUpdate(sql);
		}catch(Exception ex) {
			System.err.println("Couldn't delete data");
		}
	}

}

package DataBase.DataInsert;

import java.sql.Connection;
import java.sql.Statement;

import DataBase.SQLiteConnection;

public class EmployeeDataInsert {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	
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

}

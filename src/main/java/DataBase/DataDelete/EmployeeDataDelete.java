package DataBase.DataDelete;

import java.sql.Connection;
import java.sql.Statement;

import Data.Employee;
import DataBase.SQLiteConnection;

public class EmployeeDataDelete {
	
	private static Connection con = new SQLiteConnection().getConnection();
	private static Statement stmt;
	private static String sql;
	
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

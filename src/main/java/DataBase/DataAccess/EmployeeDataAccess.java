package DataBase.DataAccess;

import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Employee;

public class EmployeeDataAccess {
	
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

}

package DataBase.DataAccess;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Client;

public class ClientDataAccess {
	
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

}

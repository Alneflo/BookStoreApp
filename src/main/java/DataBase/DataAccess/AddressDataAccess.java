package DataBase.DataAccess;

import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Address;

public class AddressDataAccess {
	
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
	
}

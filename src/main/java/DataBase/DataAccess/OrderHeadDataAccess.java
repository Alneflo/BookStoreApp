package DataBase.DataAccess;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import Data.OrderHead;

public class OrderHeadDataAccess {
	
	private static ResultSet rs;
	
	public static void setInfo(ArrayList<OrderHead> a) {
		rs = DataAccess.getResultSet("author");
		if(rs != null) {
			String employeeDni, clientDni;
			int id, addressId;
			Date orderDate;
			
			try {
				a = new ArrayList<>();
				
				while(rs.next()) {
					clientDni = rs.getString("client_dni");
					id = rs.getInt("id");
					employeeDni = rs.getString("employee_dni");
					addressId = rs.getInt("address_id");
					orderDate = rs.getDate("order_date");
					
					a.add(new OrderHead(id, employeeDni, clientDni, addressId, orderDate));
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

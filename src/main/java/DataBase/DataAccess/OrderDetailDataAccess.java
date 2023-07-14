package DataBase.DataAccess;

import java.sql.ResultSet;
import java.util.ArrayList;

import Data.OrderDetail;

public class OrderDetailDataAccess {
	
	private static ResultSet rs;
	
	public static void setInfo(ArrayList<OrderDetail> a) {
		rs = DataAccess.getResultSet("author");
		if(rs != null) {
			String bookIsbn;
			int id, orderId, amount;
			double memberDiscount, finalPrice;
			
			try {
				a = new ArrayList<>();
				
				while(rs.next()) {
					bookIsbn = rs.getString("book_isbn");
					id = rs.getInt("id");
					orderId = rs.getInt("order_id");
					amount = rs.getInt("amount");
					memberDiscount = rs.getDouble("member_discount");
					finalPrice = rs.getDouble("final_price");
					
					a.add(new OrderDetail(id, orderId, bookIsbn, amount, memberDiscount, finalPrice));
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

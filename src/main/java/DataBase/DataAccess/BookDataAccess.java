package DataBase.DataAccess;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Book;

public class BookDataAccess {
	
	private static ResultSet rs;
	
	public static void setInfo(ArrayList<Book> a) {
		rs = DataAccess.getResultSet("author");
		if(rs != null) {
			String isbn, title, smallDesc, publishingHouse;
			int minAge, amount;
			Date publishingDate;
			double price;
			
			try {
				a = new ArrayList<>();
				
				while(rs.next()) {
					isbn = rs.getString("isbn");
					title = rs.getString("title");
					minAge = rs.getInt("minimum_age");
					smallDesc = rs.getString("small_description");
					publishingHouse = rs.getString("publishing_house");
					publishingDate = rs.getDate("publishing_date");
					price = rs.getDouble("price");
					amount = rs.getInt("amount");
					
					a.add(new Book(isbn, title, minAge, smallDesc, publishingHouse, publishingDate, price, amount));
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

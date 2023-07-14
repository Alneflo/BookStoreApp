package DataBase.DataAccess;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import Data.Author;

public class AuthorDataAccess {
	
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

}

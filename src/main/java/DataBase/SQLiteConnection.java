package DataBase;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteConnection {
	private static Connection con;
	private static final String FILEPATHNAME = "C:\\Users\\AlejandroNebotFlores\\eclipse-workspace\\BookStore480";
	
	public SQLiteConnection() {
		File database = new File(FILEPATHNAME);
		try {
			if(!database.exists()) {
				GenerateDataBase.Generate();
			}
			con = DriverManager.getConnection("jdbc:sqlite:" + FILEPATHNAME);
		}catch(Exception e) {
			
		}
	}
	
	public Connection getConnection() {
		return con;
	}
	
}

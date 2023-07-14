package DataBase.DataObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Data.Address;
import DataBase.SQLiteConnection;

@SuppressWarnings("unused")
public class DataAccess {
	
	private static ResultSet rs;
	private static Statement st;
	private static Connection con = new SQLiteConnection().getConnection();
	private static String sql;
	
	public static ResultSet getResultSet(String tableName) {
		sql = "SELECT * FROM " + tableName + ";";
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			return rs;
		}catch(Exception e) {
			return null;
		}
	}

}

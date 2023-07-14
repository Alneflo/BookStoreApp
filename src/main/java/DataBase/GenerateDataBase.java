package DataBase;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GenerateDataBase {
	
	private static Connection con;
	private static Statement stmt;
	private static String sql;
	private static final String FILEPATHNAME = "BookStore.db";
	
	public GenerateDataBase() {
		sql = "";
		con = null;
		stmt = null;
	}

	public static void Generate() {
		File dbFile = new File(FILEPATHNAME);
		try {
			dbFile.createNewFile();
			
			con = DriverManager.getConnection("jdbc:sqlite:" + FILEPATHNAME);
			stmt = con.createStatement();
			
			createAllTables();
			
			stmt.close();
			
		} catch (Exception e) {
			System.err.println("Error, couldn't connect");
		}
	}
	
	private static void createAllTables() {
		//Creates each one of the tables without foreign keys
		createTableAddress();
		createTableAuthor();
		createTableBook();
		createTableBookAuthorRel();
		createTableClient();
		createTableEmployee();
		createTableJob();
		createTableOrderDetail();
		createTableOrderDHead();
		
		//Adds foreign keys after
		addForeignKeys();
	}
	
	private static void createTableAddress() {
		sql = ("CREATE TABLE address("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "street varchar(30) NOT NULL,"
				+ "number int NOT NULL,"
				+ "postal_code char(5) NOT NULL,"
				+ "client_dni char(9) NOT NULL)");
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void createTableAuthor() {
		sql = ("CREATE TABLE author("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "name varchar(30) DEFAULT 'anon',"
				+ "surname varchar(30),"
				+ "birthdate Date)");
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void createTableBook() {
		sql = ("CREATE TABLE book("
				+ "isbn char(17) NOT NULL PRIMARY KEY,"
				+ "title varchar(30) NOT NULL,"
				+ "minimum_age int DEFAULT 0,"
				+ "small_description TEXT,"
				+ "publishing_house varchar(30) NOT NULL,"
				+ "publishing_date Date,"
				+ "price double(3,2) DEFAULT 0.00,"
				+ "amount int DEFAULT 1)");
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void createTableBookAuthorRel() {
		sql = ("CREATE TABLE book_author_rel("
				+ "book_isbn char(17) NOT NULL,"
				+ "author_id int NOT NULL)");
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void createTableClient() {
		sql = ("CREATE TABLE client("
				+ "dni char(9) NOT NULL PRIMARY KEY,"
				+ "name varchar(30) NOT NULL,"
				+ "surname varchar(30) NOT NULL,"
				+ "birthdate Date NOT NULL,"
				+ "member_subscription BOOLEAN DEFAULT false)");
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void createTableEmployee() {
		sql = ("CREATE TABLE employee("
				+ "dni char(9) NOT NULL PRIMARY KEY,"
				+ "name varchar(30) NOT NULL,"
				+ "surname varchar(30) NOT NULL,"
				+ "job_id int NOT NULL,"
				+ "telephone char(9) NOT NULL,"
				+ "email varchar(64),"
				+ "passwd varchar(40) NOT NULL)");
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void createTableJob() {
		sql = ("CREATE TABLE job("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "name varchar(30) NOT NULL)");
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void createTableOrderDetail() {
		sql = ("CREATE TABLE order_detail("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "order_id int NOT NULL,"
				+ "book_isbn char(17) NOT NULL,"
				+ "amount int NOT NULL DEFAULT 1,"
				+ "member_discount double(2,2) NOT NULL DEFAULT 5.00,"
				+ "final_price double(3,2) NOT NULL DEFAULT 0.00)");
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void createTableOrderDHead() {
		sql = ("CREATE TABLE order_head("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "employee_dni char(9) NOT NULL,"
				+ "client_dni char(9) NOT NULL,"
				+ "address_id int NOT NULL,"
				+ "order_date Date NOT NULL)");
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void addForeignKeys() {
		
		String fKAddress = ("ALTER TABLE address"
				+ "ADD FOREIGN KEY(client_dni) REFERENCES client(dni);");
		
		String fKBookAuthorRel = ("ALTER TABLE book_author_rel"
				+ "ADD FOREIGN KEY(book_isbn) REFERENCES book(isbn),"
				+ "FOREIGN KEY(author_id) REFERENCES author(id);");
		
		String fKEmployee = ("ALTER TABLE employee"
				+ "ADD FOREIGN KEY(job_id) REFERENCES job(id);");
		
		String fKOrderDetail = ("ALTER TABLE order_detail"
				+ "ADD FOREIGN KEY(order_id) REFERENCES order_head(id),"
				+ "FOREIGN KEY(book_isbn) REFERENCES book(isbn);");
		
		String fKOrderHead = ("ALTER TABLE order_head"
				+ "ADD FOREIGN KEY(employee_dni) REFERENCES employee(dni),"
				+ "FOREIGN KEY(client_dni) REFERENCES client(dni),"
				+ "FOREIGN KEY(address_id) REFERENCES address(id);");
		
		sql = fKAddress + fKBookAuthorRel + fKEmployee + fKOrderDetail + fKOrderHead;
		
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

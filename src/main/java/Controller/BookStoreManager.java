package Controller;

import java.sql.Date;
import java.util.ArrayList;
import Data.*;
import DataBase.DataObject.AddressDataObject;
import DataBase.DataObject.AuthorDataObject;
import DataBase.DataObject.BookDataObject;
import DataBase.DataObject.ClientDataObject;
import DataBase.DataObject.EmployeeDataObject;
import DataBase.DataObject.OrderDetailDataObject;
import DataBase.DataObject.OrderHeadDataObject;

public class BookStoreManager {
	
	private ArrayList<Address> addresses;
	private ArrayList<Book> books;
	private ArrayList<Client> clients;
	private ArrayList<Employee> employees;
	private ArrayList<OrderDetail> ordersDetail;
	private ArrayList<OrderHead> ordersHead;
	
	public BookStoreManager() {
		addresses = new ArrayList<>();
		books = new ArrayList<>();
		clients = new ArrayList<>();
		employees = new ArrayList<>();
		ordersDetail = new ArrayList<>();
		ordersHead = new ArrayList<>();
		
		initValues();
		
	}
	
	private void initValues() {
		
		AddressDataObject.setInfo(addresses);
		BookDataObject.setInfo(books);
		ClientDataObject.setInfo(clients);
		EmployeeDataObject.setInfo(employees);
		OrderDetailDataObject.setInfo(ordersDetail);
		OrderHeadDataObject.setInfo(ordersHead);
		
		for (Book book : books) {
			AuthorDataObject.setInfo(book.getAuthorList());
		}
		
	}
	
	public void addBook(String isbn, String title, int minAge, String smallDescription, String publishingHouse, Date publishingDate, double price, int amount, ArrayList<Author> authors) {
		Book b = new Book(isbn, title, minAge, smallDescription, publishingHouse, publishingDate, price, amount);
		
		BookDataObject.insertData(isbn, title, minAge, smallDescription, publishingHouse, publishingDate, price, amount);
		
		for (Author author : authors) {
			b.addAuthor(author);
		}
		
		books.add(b);
	}
	
	public int oddOrEvenOrFebruaryMonth(int monthValue) {
		
		switch (monthValue) {
		case 1:case 3:case 5:case 7:case 8:case 10:case 12:
			return 1;
		case 2:
			return 2;
		default:
			return 0;
		}
			
	}
	
	public boolean isLeapYear(int year) {
		return (year % 4 == 0 || (year % 100 == 0 && year % 400 == 0));
	}
	
}

package Data;

import java.sql.Date;

public class Book {
	private String isbn;
	private String title;
	private int minimumAge;
	private String smallDescription;
	private String publishingHouse;
	private Date publishingDate;
	private double price;
	private int amount;
	
	public Book(String isbn, String title, int minimumAge, String smallDescription, String publishing_house, Date publishingDate, double price, int amount) {
		this.isbn = isbn;
		this.title = title;
		this.minimumAge = minimumAge;
		this.smallDescription = smallDescription;
		this.publishingHouse = publishing_house;
		this.publishingDate = publishingDate;
		this.price = price;
		this.amount = amount;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public int getMinimumAge() {
		return minimumAge;
	}

	public String getSmallDescription() {
		return smallDescription;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}
	
	public Date getPublishingDate() {
		return publishingDate;
	}

	public double getPrice() {
		return price;
	}

	public int getAmount() {
		return amount;
	}
}

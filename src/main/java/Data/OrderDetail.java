package Data;

public class OrderDetail {
	private int id;
	private int order_id;
	private String bookIsbn;
	private int amount;
	private double memberDiscount;
	private double finalPrice;
	
	public OrderDetail(int id, int order_id, String bookIsbn, int amount, double memberDiscount, double finalPrice) {
		this.id = id;
		this.order_id = order_id;
		this.bookIsbn = bookIsbn;
		this.amount = amount;
		this.memberDiscount = memberDiscount;
		this.finalPrice = finalPrice;
	}

	public int getId() {
		return id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public String getBookIsbn() {
		return bookIsbn;
	}

	public int getAmount() {
		return amount;
	}

	public double getMemberDiscount() {
		return memberDiscount;
	}

	public double getFinalPrice() {
		return finalPrice;
	}
	
}

package Data;

import java.sql.Date;

public class OrderHead {
	private int id;
	private String employeeDni;
	private String clientDni;
	private int addressId;
	private Date orderDate;
	
	public OrderHead(int id, String employeeDni, String clientDni, int addressId, Date orderDate) {
		this.id = id;
		this.employeeDni = employeeDni;
		this.clientDni = clientDni;
		this.addressId = addressId;
		this.orderDate = orderDate;
	}

	public int getId() {
		return id;
	}

	public String getEmployeeDni() {
		return employeeDni;
	}

	public String getClientDni() {
		return clientDni;
	}

	public int getAddressId() {
		return addressId;
	}

	public Date getOrderDate() {
		return orderDate;
	}
	
}

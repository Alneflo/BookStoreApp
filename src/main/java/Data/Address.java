package Data;

public class Address {
	private int id;
	private String street;
	private int number;
	private String postalCode;
	private String clientDni;
	
	public Address(int id, String street, int number, String postalCode, String clientDni) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.postalCode = postalCode;
		this.clientDni = clientDni;
	}

	public int getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public int getNumber() {
		return number;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getClientDni() {
		return clientDni;
	}
	
}

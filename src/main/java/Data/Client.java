package Data;

import java.sql.Date;

public class Client {
	private String dni;
	private String name;
	private String surname;
	private Date birthDate;
	private boolean memberSubscription;
	
	public Client(String dni, String name, String surname, Date birthDate, boolean memberSubscription) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.memberSubscription = memberSubscription;
	}

	public String getDni() {
		return dni;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public boolean getMemberSubscription() {
		return memberSubscription;
	}
	
}

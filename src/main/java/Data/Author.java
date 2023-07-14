package Data;

import java.sql.Date;

public class Author {
	private int id;
	private String name;
	private String surname;
	private Date birthDate;

	public Author(int id, String name, String surname, Date birthDate) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
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
	
}

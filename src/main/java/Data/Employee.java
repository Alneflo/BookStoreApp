package Data;

public class Employee {
	private String dni;
	private String name;
	private String surname;
	private int jobId;
	private String telephone;
	private String email;
	private String passwd;
	
	public Employee(String dni, String name, String surname, int jobId, String telephone, String email, String passwd) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.jobId = jobId;
		this.telephone = telephone;
		this.email = email;
		this.passwd = passwd;
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

	public int getJobId() {
		return jobId;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getEmail() {
		return email;
	}

	public String getPasswd() {
		return passwd;
	}
	
}

package hello;

import javax.persistence.*;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String firstName;
	private String lastName;

	@ManyToOne
	private Department department;

	public Person(String firstName, String lastName, Department department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}

	Person() {}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDepartment() { return department; }

	public void setDepartment(Department department) { this.department = department; }
}

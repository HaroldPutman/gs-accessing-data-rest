package hello;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	@OneToMany(mappedBy = "department")
	private List<Person> people;

	public Department(String name) {
		this.name = name;
	}

	Department() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPeople() { return people; }

	public void setPeople(List<Person> people) { this.people = people; }
}

package hello;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	@Transient
	public List<String> getEmployeeNames() {
		List<String> names = new ArrayList<String>(people.size());
		people.forEach(person -> names.add(person.getFirstName() + " " + person.getLastName()) );
		return names;
	}

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

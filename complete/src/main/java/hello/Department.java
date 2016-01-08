package hello;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	@Transient
	public List<String> getEmployeeNames() {
		return people.stream()
				.map(person -> new String(person.getFirstName() + " " + person.getLastName()))
				.collect(Collectors.toCollection(ArrayList::new));
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

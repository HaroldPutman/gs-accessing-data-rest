package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Bean
	CommandLineRunner init(DepartmentRepository departmentRepository,
						   PersonRepository personRepository) {
		return (evt) -> {
			Department marketing = departmentRepository.save(new Department("Marketing"));
			Department engineering = departmentRepository.save(new Department("Engineering"));
			personRepository.save(new Person("Barb", "Dwyer", engineering));
			personRepository.save(new Person("Anna", "Conda", marketing));
			personRepository.save(new Person("Barry", "Cade", engineering));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

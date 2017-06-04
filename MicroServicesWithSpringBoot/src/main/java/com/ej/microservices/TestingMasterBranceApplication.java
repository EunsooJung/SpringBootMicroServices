/*
 * ref.: https://github.com/livelessons-spring/building-microservices/blob/master/livelessons-data/livelessons-data-jdbc/src/main/java/demo/DataJdbcApplication.java
 */

package com.ej.microservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ej.microservices.car_with_mysql.CarModelWithMySQLRepository;

// Section 4 Lecture 4.4 Work with relational database
@SpringBootApplication
public class MicroServicesWithSpringBootApplication {
	
	// S4-L4: Working with Relational Database
	@Bean
	public CommandLineRunner exampleQuery(CarModelWithMySQLRepository repository) {
		return args -> repository.findByMakeIgnoringCase("HONDA")
				.forEach(System.err::println);
	}
	
	
	/*
	@Bean
	InitializingBean seedDatabase(CarRepository repository) {
		return () -> {
			repository.save(new Car("Honda", "Civic", 1997));
			repository.save(new Car("Honda", "Accord", 2003));
			repository.save(new Car("Ford", "Escort", 1985));
		};
	}
	
	@Bean
	CommandLineRunner exampleQuery(CarRepository repository) {
		return args -> 
		repository.findByMakeIgnoringCase("HONDA").forEach(System.err::println);
	}
	}
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServicesWithSpringBootApplication.class, args);
	}
	
}

/*
@SpringBootApplication
@EnableConfigurationProperties
public class MicroServicesWithSpringBootApplication {
	// Map properties to POJOs
	@Value("${configuration.projectName}")
	void setProjectName(String projectName) {
		System.out.println("setting project name: " + projectName);
	}
	
	@Autowired
	void setEnvironment(Environment env) {
		System.out.println("setting environment: " + env.getProperty("configuration.projectName"));
	}
	
	/*@Autowired
	void setConfiguraitionProjectProperties(ConfigurationProjectProperties cp) {
		cp.getProjectName());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServicesWithSpringBootApplication.class, args);
	}
}

@Component
@ConfigurationProperties("configuration")
class ConfigurationProjectProperties {
	private String projectName;
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
*/
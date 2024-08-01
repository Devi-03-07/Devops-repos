package ltts.com.eventbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("ltts.com")
@EntityScan("ltts.com.model")
@EnableJpaRepositories("ltts.com.jpa")
public class EventBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventBookingApplication.class, args);
		System.out.println("Application Started !!!");
	}

}

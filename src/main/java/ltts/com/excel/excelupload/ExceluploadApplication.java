package ltts.com.excel.excelupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("ltts.com")
@EntityScan("ltts.com.model")
@EnableJpaRepositories("ltts.com.jpa")
@ComponentScan("ltts.com.config")
public class ExceluploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceluploadApplication.class, args);
		System.out.println("Application Started !!!");
	}

}

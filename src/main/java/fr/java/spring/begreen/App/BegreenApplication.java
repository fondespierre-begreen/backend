package fr.java.spring.begreen.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BegreenApplication {

	public static void main(String[] args) {
		SpringApplication.run(BegreenApplication.class, args);
	}

}

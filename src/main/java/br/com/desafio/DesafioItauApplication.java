package br.com.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.desafio.domain")
@ComponentScan(basePackages = "br.com.desafio")
public class DesafioItauApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioItauApplication.class, args);
	}

}

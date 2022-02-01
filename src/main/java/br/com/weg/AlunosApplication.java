package br.com.weg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AlunosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunosApplication.class, args);
		System.out.println("inicio");
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}

}

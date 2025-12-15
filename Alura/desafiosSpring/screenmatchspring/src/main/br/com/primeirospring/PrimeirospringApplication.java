package main.br.com.primeirospring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.br.com.primeirospring.principal.Menu;

@SpringBootApplication
public class PrimeirospringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PrimeirospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new Menu().iniciarLoopDeInteracao();
		;
	}
}

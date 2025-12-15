package br.com.carrosaluraspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.carrosaluraspring.principal.Menu;

@SpringBootApplication
public class CarrosaluraspringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CarrosaluraspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new Menu().iniciarLoopDeInteracao();
	}

}

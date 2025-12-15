package br.com.screenmatchspringjpa;

import br.com.screenmatchspringjpa.principal.Menu;
import br.com.screenmatchspringjpa.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
public class ScreenmatchspringjpaApplication implements CommandLineRunner {

	@Autowired
	private SerieRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchspringjpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu(repositorio);
		menu.iniciarLoopDeInteracao();
	}
}

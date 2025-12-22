package br.com.screensoundmusic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.screensoundmusic.repository.ArtistaRepository;
import br.com.screensoundmusic.view.Menu;

@SpringBootApplication
public class ScreensoundmusicApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(ScreensoundmusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu(repositorio);
		menu.iniciarLoopDeInteracao();
	}

}

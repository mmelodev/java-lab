package br.com.screensoundmusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.screensoundmusic.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

}

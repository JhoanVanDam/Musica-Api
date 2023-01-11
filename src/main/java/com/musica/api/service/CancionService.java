package com.musica.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musica.api.entity.Cancion;
import com.musica.api.repository.CancionRepository;

@Service
public class CancionService {
	@Autowired
	private CancionRepository musicaRepository;

	public Cancion SaveSong(Cancion song) {

		return this.musicaRepository.save(song);

	}

	public String DeleteSong(int id) {
		this.musicaRepository.deleteById(id);
		return "se elimino la cancion";

	}

	public Cancion EditSong(Cancion song) {
		return this.musicaRepository.save(song);

	}

	public Cancion getSong(int id) {

		return this.musicaRepository.findById(id).orElse(null);

	}

	public List<Cancion> obtenerCanciones(int listaId) {
		List<Cancion> Lista = this.musicaRepository.findBylistaId(listaId);
		return Lista;
	}
}

package com.musica.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musica.api.entity.Cancion;
import com.musica.api.service.CancionService;

@RequestMapping("/Canciones")
@Controller
public class CancionController {

	@Autowired
	private CancionService musicaService;

	@GetMapping("/obtener/{id}")
	public ResponseEntity<Cancion> obtenerCancion(@PathVariable("id") int id) {

		try {
			Cancion Song = this.musicaService.getSong(id);
			return ResponseEntity.ok(Song);
		} catch (Exception e) {
			System.out.println("Error en GetMapping ObtenerCancion" + e);
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping("/guardar/")
	public ResponseEntity<Cancion> subirCancion(@RequestBody Cancion Song) {
		try {
			this.musicaService.SaveSong(Song);
			return ResponseEntity.ok(Song);
		} catch (Exception e) {
			System.out.println("Error en PostMapping SubirCancion" + e);
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<Cancion> eliminarCancion(@PathVariable("id") int id) {
		try {
			Cancion song = this.musicaService.getSong(id);
			if (song == null) {
				return ResponseEntity.notFound().build();
			}
			this.musicaService.DeleteSong(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {

			System.out.println("Error en DeleteMapping BorrarCancion" + e);
			return ResponseEntity.badRequest().build();
		}

	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<Cancion> actualizarCancion(@PathVariable("id") int id, @RequestBody Cancion Song) {
		try {
			Cancion cancionbuscar = this.musicaService.getSong(id);

			if (cancionbuscar == null) {
				return ResponseEntity.notFound().build();
			}

			cancionbuscar = null;
			Song.setId(id);

			this.musicaService.SaveSong(Song);

			return ResponseEntity.ok(Song);

		} catch (Exception e) {
			System.out.println("Error en PutMapping EditarCancion" + e);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/listar/{listaId}")
	public ResponseEntity<List<Cancion>> getCancionesDeLista(@PathVariable("listaId") int listaId) {
		List<Cancion> lista = this.musicaService.obtenerCanciones(listaId);
		return ResponseEntity.ok(lista);
	}

}

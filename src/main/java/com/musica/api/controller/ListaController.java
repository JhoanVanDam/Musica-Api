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

import com.musica.api.entity.Lista;
import com.musica.api.service.ListaService;

@RequestMapping("/Lista")
@Controller
public class ListaController {

	@Autowired
	private ListaService listaService;

	@GetMapping("/obtenerTodas/{usuarioId}")
	public ResponseEntity<List<Lista>> getListas(@PathVariable("usuarioId") int usuarioId) {
		try {
			List<Lista> Listas = this.listaService.getListas(usuarioId);
			if (Listas.isEmpty() == true) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(Listas);

		} catch (Exception e) {
			System.out.println("Error en GetMapping getListas" + e);
			return ResponseEntity.badRequest().build();
		}

	}

	@GetMapping("/obtenerLista/{listaId}")
	public ResponseEntity<Lista> getLista(@PathVariable("listaId") int listaId) {
		try {
			Lista listabuscar = this.listaService.getLista(listaId);
			if (listabuscar == null) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(listabuscar);
		} catch (Exception e) {
			System.out.println("error en getmapping getLista" + e);
			return ResponseEntity.badRequest().build();
		}

	}

	@PostMapping("/agregarLista")
	public ResponseEntity<Lista> saveLista(@RequestBody Lista List) {
		try {
			Lista Lista = this.listaService.SaveLista(List);
			return ResponseEntity.ok(Lista);
		} catch (Exception e) {
			System.out.println("Error en postMapping saveLista " + e);
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/editarLista/{id}")
	public ResponseEntity<Lista> editLista(@PathVariable int id, @RequestBody Lista List) {
		Lista listabuscar = this.listaService.getLista(id);
		if (listabuscar == null) {
			return ResponseEntity.notFound().build();
		}
		listabuscar = null;
		List.setId(id);
		this.listaService.SaveLista(List);
		return ResponseEntity.ok(List);

	}

	@DeleteMapping("/borrarLista/{listaId}")
	public ResponseEntity<Lista> deleteLista(@PathVariable("listaId") int listaId) {
		try {
			Lista List = this.listaService.getLista(listaId);
			if (List == null) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(List);
		} catch (Exception e) {
			System.out.println("Error en DeleteMapping deleteLista" + e);
			return ResponseEntity.badRequest().build();
		}
	}

}

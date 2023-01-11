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

import com.musica.api.entity.Usuario;
import com.musica.api.service.UsuarioService;

@RequestMapping("/Usuario")
@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/obtener")
	public ResponseEntity<List<Usuario>> getUsuarios() {
		try {
			List<Usuario> listaUser = this.usuarioService.getAll();
			if (listaUser.isEmpty() == true) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(listaUser);

		} catch (Exception e) {
			System.out.println("Error en usuariocontroller getUsuarios" + e);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/obtener/{usuarioId}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("usuarioId") int usuarioId) {
		try {
			Usuario user = this.usuarioService.getUsuario(usuarioId);
			if (user == null) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			System.out.println("Error en usuariocontroller getUsuario" + e);
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/editar/{usuarioId}")
	public ResponseEntity<Usuario> editUsuario(@PathVariable("usuarioId") int usuarioId, @RequestBody Usuario user) {
		try {
			Usuario usuario = this.usuarioService.getUsuario(usuarioId);
			if (usuario == null) {
				return ResponseEntity.notFound().build();
			}
			user.setId(usuarioId);
			this.usuarioService.editarUsuario(user);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			System.out.println("Error en ususario controller edit usuario" + e);
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/borrar/{usuarioId}")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable("usuarioId") int usuarioId) {
		try {
			Usuario user = this.usuarioService.getUsuario(usuarioId);
			if (user == null) {
				return ResponseEntity.noContent().build();
			}
			this.usuarioService.deleteUsuario(usuarioId);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			System.out.println("Error en usuario controller deleteuser" + e);
			return ResponseEntity.badRequest().build();
		}
	}
}

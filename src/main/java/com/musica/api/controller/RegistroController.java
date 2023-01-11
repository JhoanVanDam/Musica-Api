package com.musica.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musica.api.entity.Usuario;
import com.musica.api.service.UsuarioService;

@RequestMapping("/Registro")
@Controller
public class RegistroController {
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping()
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario user) {
		try {
			this.usuarioService.SaveUsuario(user);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			System.out.println("Error en saveUsuario Usuario controller" + e);
			return ResponseEntity.badRequest().build();
		}
	}
}

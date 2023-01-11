package com.musica.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musica.api.entity.Usuario;
import com.musica.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioreposiroty;

	public List<Usuario> getAll() {
		return usuarioreposiroty.findAll();

	}

	public Usuario getUsuario(int id) {
		return usuarioreposiroty.findById(id).orElse(null);
	}

	public Usuario SaveUsuario(Usuario user) {
		Usuario usuario = usuarioreposiroty.save(user);
		return usuario;
	}

	public Usuario deleteUsuario(int id) {
		Usuario user = this.usuarioreposiroty.findById(id).orElse(null);
		this.usuarioreposiroty.deleteById(id);
		return user;
	}

	public Usuario editarUsuario(Usuario user) {
		this.usuarioreposiroty.save(user);
		return user;
	}
}

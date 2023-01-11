package com.musica.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.musica.api.entity.Usuario;
import com.musica.api.repository.UsuarioRepository;

@Service
public class UserDetailsImplementation implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = this.usuarioRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("no se encontró");
		}

		return user;
	}

}

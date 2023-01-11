package com.musica.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musica.api.entity.Lista;
import com.musica.api.repository.ListaRepository;

@Service
public class ListaService {
	@Autowired
	private ListaRepository listaRepository;

	public Lista SaveLista(Lista List) {
		return this.listaRepository.save(List);

	}

	public List<Lista> getListas(int usuarioId) {
		List<Lista> List = this.listaRepository.findListasByusuarioId(usuarioId);
		return List;
	}

	public Lista getLista(int id) {
		Lista List = this.listaRepository.findListaById(id);
		return List;
	}

	public Lista editLista(Lista List) {
		return this.listaRepository.save(List);

	}

	public Lista deleteLista(int id) {
		Lista list = this.listaRepository.findById(id).orElse(null);
		this.listaRepository.deleteById(id);
		return list;
	}

}

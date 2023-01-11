package com.musica.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musica.api.entity.Lista;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer> {
	List<Lista> findListasByusuarioId(int usuarioId);

	Lista findListaById(int id);

}

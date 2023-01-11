package com.musica.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musica.api.entity.Cancion;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Integer> {
	List<Cancion> findBylistaId(int listaId);
}

package com.musica.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cancion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String Nombre;
	private String FechaLanzamiento;
	private String Descripcion;
	private String Genero;
	private String Artista;
	private int listaId;

	public int getId() {
		return id;
	}

	public Cancion() {
		super();
	}

	public Cancion(int id, String nombre, String fechaLanzamiento, String descripcion, String genero, String artista,
			int listaId) {
		super();
		this.id = id;
		Nombre = nombre;
		FechaLanzamiento = fechaLanzamiento;
		Descripcion = descripcion;
		Genero = genero;
		Artista = artista;
		this.listaId = listaId;
	}

	public int getListaId() {
		return listaId;
	}

	public void setListaId(int listaId) {
		this.listaId = listaId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getFechaLanzamiento() {
		return FechaLanzamiento;
	}

	public void setFechaLanzamiento(String fechaLanzamiento) {
		FechaLanzamiento = fechaLanzamiento;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public String getArtista() {
		return Artista;
	}

	public void setArtista(String artista) {
		Artista = artista;
	}

}

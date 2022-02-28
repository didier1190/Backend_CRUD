package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="categoria")
@Getter
@Setter
@ToString
public class Categoria {
	
	// Siguiendo estandares de Postgresql 
    // https://sites.google.com/a/banregio.com/transformacion/home/desarrollo/wiki/estandar_postgresql
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categoria",nullable = false,unique = true)
	private long idCategoria;
	
	@Column(name="nombre",nullable = false)
	private String nombre;
	
}

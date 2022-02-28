package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "producto")  
@Getter
@Setter
@ToString
public class Producto {
	
	// Siguiendo estandares de Postgresql 
	// https://sites.google.com/a/banregio.com/transformacion/home/desarrollo/wiki/estandar_postgresql
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_producto",nullable = false, unique = true)
	private long idProducto;
	
	@Column(name ="nombre",nullable = false)
	private String nombre;
	
	@Column(name="estatus",nullable = false)
	private boolean estatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn (name="id_categoria", nullable = false,foreignKey= @ForeignKey(name="categoria_id_categoria_FK"))
	private Categoria categoria;
	

	
}

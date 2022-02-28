package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Categoria;
import com.example.demo.model.Producto;
import com.example.demo.service.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("api/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping()
	@Operation(summary = "Obtiene todas las categorias")
	public ArrayList<Categoria> getCategorias() {
		
		return categoriaService.getAll();
	}
	
	@GetMapping(path = "/{id}")
	@Operation(summary = "Obtiene todas las categorias por id")
	public Optional<Categoria> getById(@PathVariable("id") Long id){
		
		return this.categoriaService.getById(id);
	}
	
	@PostMapping()
	@Operation(summary = "Agrega una categoria")
	public Categoria save(@RequestBody Categoria categoria) {
		
		return categoriaService.save(categoria);
    }
	
	@PutMapping(path="/{id}")
	@Operation(summary = "Actualiza una categoria")
	public Categoria update(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
       
		return categoriaService.update(id,categoria);
	}
	
	@PatchMapping(path = "/{id}")
	@Operation(summary = "Actualiza una categoria parcialmente")
	public Categoria parcialUpdate(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
	  
		return categoriaService.parcialUpdate(id, categoria);
		
	}
	
	@DeleteMapping(path = "{id}")
	@Operation(summary = "Elimina una categoria")
	public String delete(@PathVariable ("id") Long id) {
		boolean correct = categoriaService.delete(id);
		 if(correct){
	            return "Deleted true";
	        }else {
	            return "Error";
	        }
		
	}
	
	
	
	

}

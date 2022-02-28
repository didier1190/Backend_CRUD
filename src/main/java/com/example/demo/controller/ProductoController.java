package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;;
	
	@GetMapping()
	@Operation(summary = "Obtiene todos los productos")
	public List<Producto> getProductos() {

		return productoService.getAll();
	
	}
	
	@GetMapping(path = "/{id}")
	@Operation(summary = "Obtiene un producto por id")
	public Optional<Producto> getProductosById(@PathVariable("id") Long id){
		
		return this.productoService.getById(id);
	}
	
	@PostMapping
	@Operation(summary = "Agrega un producto")
	public Producto save(@RequestBody Producto producto) {
		System.out.println(producto);
		
		return productoService.save(producto);
    }
	
	@PutMapping(path="/{id}")
	@Operation(summary = "Actualiza un producto")
	public Producto update(@PathVariable("id") Long id, @RequestBody Producto producto) {
       
		return productoService.update(id,producto);
	}
	
	@PatchMapping(path = "/{id}")
	@Operation(summary = "Acrtualiza un producto parcialmente")
	public Producto parcialUpdate(@PathVariable("id") Long id, @RequestBody Producto producto) {
	  
		return productoService.parcialUpdate(id, producto);
		
	}
	
	@DeleteMapping(path = "{id}")
	@Operation(summary = "Elimina un producto por id")
	public boolean delete(@PathVariable ("id") Long id) {
		boolean correct = productoService.delete(id);
		 if(correct){
	            return true;
	        }else {
	            return false;
	        }
		
	}
	
	

}

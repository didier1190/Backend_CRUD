package com.example.demo.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Categoria;
import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;



@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class ProductoControllerTest {
	
	@Mock
	private ProductoService productoService;

	@InjectMocks
	private ProductoController productoController;
	private Producto producto;
	
	@BeforeEach
	void setup() {
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(1);
		categoria.setNombre("Categoria Prueba");
		producto = new Producto();
		producto.setNombre("Producto Prueba");
		producto.setEstatus(true);
		producto.setIdProducto(1);
		producto.setCategoria(categoria);
	}
		
	@Test
	void getProductos() {
		when(productoController.getProductos()).thenReturn(Arrays.asList(producto));
		assertNotNull(productoController.getProductos());
	}
	
	@Test
	void getProductosById() {
		when(productoController.getProductosById(any(Long.class))).thenReturn(Optional.of(producto));
		assertNotNull(productoController.getProductosById(1L));
	}
	
	@Test
	void saveProduct() {
		when ( productoController.save(any(Producto.class))).thenReturn(producto);
		assertNotNull(productoController.save(new Producto()));
	}
	
	@Test
	void deleteProducto() {
		when(productoController.delete(any(Long.class))).thenReturn(true);
		assertNotNull(productoController.delete(1L));
		
	}
	
	@Test
	void updateProducto() {
		when ( productoController.update(anyLong(),any(Producto.class))).thenReturn(producto);
		assertNotNull(productoController.update(1L,new Producto()));
	}
	


}

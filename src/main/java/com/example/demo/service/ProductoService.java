package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categoria;
import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public List<Producto> getAll(){
		return (List<Producto>) productoRepository.findAll();
	}


    public Optional <Producto> getById(long id){
    	
      return productoRepository.findById(id);
    	
    }
    
   public Producto save(Producto producto) {
    	
    	return productoRepository.save(producto);
    	
    }
    
    public Producto update(long id, Producto newProducto) {
    	
    	return	productoRepository.findById(id).map(
    			p ->{
    				p.setNombre(newProducto.getNombre());
    			    p.setEstatus(newProducto.isEstatus());
    			    p.setCategoria(newProducto.getCategoria());
    				return productoRepository.save(p);
    			}
    			).get();
    }
    
    public Producto parcialUpdate(long id, Producto newProducto) {
    	

    	return	productoRepository.findById(id).map(
    			p ->{
    				p.setNombre(newProducto.getNombre());
    			    p.setEstatus(newProducto.isEstatus());
    			    p.setCategoria(newProducto.getCategoria());
    				return productoRepository.save(p);
    			}
    			).get();
    	
    }
    
    
    public boolean delete(long id) {
    	try {
    		productoRepository.deleteById(id);
    		return true;
    		
    	}catch(Exception ex){
    		return false;
    	}
    	
    }
    
}

package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired 
	private CategoriaRepository categoriaRepository;
	
	
    public ArrayList<Categoria> getAll(){
    	
    	return (ArrayList<Categoria>) categoriaRepository.findAll();
    }
    
	
    public Optional <Categoria> getById(long id){
    	
      return categoriaRepository.findById(id);
    	
    }
  
    public Categoria save(Categoria categoria) {
    	
    	return categoriaRepository.save(categoria);
    	
    }
    
    public Categoria update(Long id, Categoria newCategoria) {
    	
    	return	categoriaRepository.findById(id).map(
    			c ->{
    				c.setNombre(newCategoria.getNombre());
    				return categoriaRepository.save(c);
    			}
    			).get();
    	
    }
    
    public Categoria parcialUpdate(Long id, Categoria newCategoria) {
    	
    	return	categoriaRepository.findById(id).map(
    			c ->{
    				c.setNombre(newCategoria.getNombre());
    				return categoriaRepository.save(c);
    			}
    			).get();
    	
    }
    
    
    public boolean delete(long id) {
    	try {
    		categoriaRepository.deleteById(id);
    		return true;
    		
    	}catch(Exception ex){
    		return false;
    	}
    	
    }
    


}

package com.fabionobre.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabionobre.cursomc.domain.Categoria;
import com.fabionobre.cursomc.repositories.CategoriaRepository;
import com.fabionobre.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);  
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(    
						"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));  
	}
}

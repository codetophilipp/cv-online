package com.philipp.repository;

import org.springframework.data.repository.CrudRepository;

import com.philipp.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	
	Usuario findById(Long id);
	
}

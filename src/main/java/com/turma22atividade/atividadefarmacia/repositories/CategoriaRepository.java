package com.turma22atividade.atividadefarmacia.repositories;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turma22atividade.atividadefarmacia.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public List<Object> findAllByNomeCategoriaContaining(String nomeCategoria);
	
	public Optional<Object> findByNomeCategoria(String nomeCategoria);

}

	
	


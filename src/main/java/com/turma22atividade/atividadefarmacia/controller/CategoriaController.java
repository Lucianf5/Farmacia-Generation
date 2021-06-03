package com.turma22atividade.atividadefarmacia.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turma22atividade.atividadefarmacia.model.Categoria;
import com.turma22atividade.atividadefarmacia.repositories.CategoriaRepository;
import com.turma22atividade.atividadefarmacia.services.CategoriaService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CategoriaService serviceC;

	
	@GetMapping(path = "/categoria")
	public ResponseEntity<List<Categoria>> listar(){
		List<Categoria> listaDeCategorias = categoriaRepository.findAll();
		
		if(listaDeCategorias.isEmpty()) {
			return ResponseEntity.status(204).build();
		}else
			{
				return ResponseEntity.status(200).body(listaDeCategorias);
			}
		
	}
	@GetMapping(path = "/id/{id_categoria}")
	public ResponseEntity<Optional<Categoria>> buscarCategoriaPorId(@PathVariable(value = "id_categoria")Long idCategoria) {
		Optional<Categoria> idDaCategoria = categoriaRepository.findById(idCategoria);
		
		if(idDaCategoria.isEmpty()) {
			return ResponseEntity.status(204).build();
		}
		else {
			return ResponseEntity.status(200).body(idDaCategoria);
		}
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Object> buscarCategoriaPorNome(@RequestParam String nomeCategoria){
		List<Object> listaDeCategorias = categoriaRepository.findAllByNomeCategoriaContaining(nomeCategoria);
		if(listaDeCategorias.isEmpty()) {
			return ResponseEntity.status(400).body("Não há categorias com este nome.");			
		}else {
			return ResponseEntity.status(200).body(listaDeCategorias);
		}
		
	}
	
	@PostMapping("/categoria/save") 
	public ResponseEntity<Object> salvarNovaCategoria(@RequestBody Categoria novaCategoria){
		return serviceC.cadastrarNovaCategoria(novaCategoria)
				.map(verificandoCategoria -> ResponseEntity.status(201).body(verificandoCategoria))
				.orElse(ResponseEntity.status(400).body("Categoria já cadastrada, por favor verifique."));
	}
				
				
	@PutMapping("/categoria/update/{id_categoria}")
	public ResponseEntity<Object> remodelarCategoria(@PathVariable(value = "id_categoria")Long idCategoria, 
		@Valid @RequestBody Categoria atualizacaoCategoria){
		return serviceC.atualizarCategoria(idCategoria, atualizacaoCategoria)
				.map(categoriaAtualizada -> ResponseEntity.status(201).body(categoriaAtualizada))
				.orElse(ResponseEntity.status(400).body("Usuario existente"));
	}
	
	@DeleteMapping("/categoria/deletar")
	public ResponseEntity<String> deletarCategoria(@RequestParam Long idCategoria) {
		return serviceC.deletarIdCategoria(idCategoria)
				.map(categoriaDeletada -> ResponseEntity.status(400).body("Categoria não localizada. "
						+ "Por favor entre com outro id."))
				.orElse(ResponseEntity.status(200).body("Categoria deletada."));
	}
}

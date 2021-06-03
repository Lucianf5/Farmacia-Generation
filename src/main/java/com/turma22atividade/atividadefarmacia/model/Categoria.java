package com.turma22atividade.atividadefarmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;



import javax.persistence.GenerationType;


@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long idCategoria;
	
	@NotNull
	@NotBlank
	private String nomeCategoria;
	
	@NotNull
	@NotBlank
	private String tipoCategoria;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties
	private List<Produto> produtosDaCategoria = new ArrayList<>();

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public List<Produto> getProdutosDaCategoria() {
		return produtosDaCategoria;
	}

	public void setProdutosDaCategoria(List<Produto> produtosDaCategoria) {
		this.produtosDaCategoria = produtosDaCategoria;
	}

	
	
	
}

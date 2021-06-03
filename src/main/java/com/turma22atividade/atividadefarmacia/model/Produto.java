package com.turma22atividade.atividadefarmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.FetchType;
import com.sun.istack.NotNull;



@Entity
@Table(name = "produto")
public class Produto {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 100, message = "entre 1 e 100 caracteres")
	private String nomeProduto;
	
	@NotNull
	@NotBlank
	private double precoProduto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_categoria")
	private Categoria categoria;
	
		public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}

//Criar uma aplicação para gerenciar uma biblioteca de livros armazenando no banco de dados
//Entidade Livro
//Id - identificador (número, sequence, chave primária)
//titulo - titulo do livro (texto, obrigatório, minimo 5 e máximo 30 caracteres)
//tipo - tipo do livro (fantasia, técnico, romance) (texto, obrigatório, minimo 3 máximo 20)
//autor - nome do autor do livro (texto, obrigatorio, minimo 10, maximo 40)
//data de publicação - data de publicação do livro (deve ser uma data anterior a data atual)
//API
//Todas as operações CRUD no tópico /livro
//Bonus
//No endpoint GET /livro possibilidade de passar um parâmetro ?ordem=campo para que a listagem venha ordenada por aquele campo
//Pesquisar:  
//Como passar a data em json para o controller (qual o formato)?
//Como ordenar no findAll do repositório 
package org.serratec.backend.biblioteca.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Size(min = 5, max = 30, message = "{Numero de caracteres inválido}") 
	private String titulo;
	@NotBlank
	@Size(min = 3, max = 20, message = "{Numero de caracteres inválido}") 
	private String tipo;
	@NotBlank
	@Size(min = 10, max = 40, message = "{Numero de caracteres inválido}") 
	private String autor;
	@NotBlank
	@Past// proibi datat atual
	private LocalDate dataPublicacao;
	
	public Livro() {
		super();
	}

	public Integer getid() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

}

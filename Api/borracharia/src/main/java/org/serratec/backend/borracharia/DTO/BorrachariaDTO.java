package org.serratec.backend.borracharia.DTO;

import java.time.LocalDate;

public class BorrachariaDTO {

	private Integer idBorracharia;
	private double valor;
	private LocalDate data;
	private String servico;
	private Integer idCarro;
	
	public BorrachariaDTO() {
		super();
	}

	public Integer getIdBorracharia() {
		return idBorracharia;
	}

	public void setIdBorracharia(Integer idBorracharia) {
		this.idBorracharia = idBorracharia;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}
	
	
	
	
}

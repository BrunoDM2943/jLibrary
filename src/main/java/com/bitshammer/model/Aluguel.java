package com.bitshammer.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe representando um aluguel
 * @author Bruno
 *
 */
@Entity
public class Aluguel {

	@Id
	@GeneratedValue
	private Long id;

	private List<Livro> livros;

	private Cliente cliente;

	@Temporal(TemporalType.DATE)
	private Date dtRetirada;

	@Temporal(TemporalType.DATE)
	private Date dtEntrega;
	
	@Enumerated(EnumType.ORDINAL)
	private StatusAluguel statusAluguel;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the livros
	 */
	public List<Livro> getLivros() {
		return livros;
	}

	/**
	 * @param livros the livros to set
	 */
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the dtRetirada
	 */
	public Date getDtRetirada() {
		return dtRetirada;
	}

	/**
	 * @param dtRetirada the dtRetirada to set
	 */
	public void setDtRetirada(Date dtRetirada) {
		this.dtRetirada = dtRetirada;
	}

	/**
	 * @return the dtEntrega
	 */
	public Date getDtEntrega() {
		return dtEntrega;
	}

	/**
	 * @param dtEntrega the dtEntrega to set
	 */
	public void setDtEntrega(Date dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	/**
	 * @return the statusAluguel
	 */
	public StatusAluguel getStatusAluguel() {
		return statusAluguel;
	}

	/**
	 * @param statusAluguel the statusAluguel to set
	 */
	public void setStatusAluguel(StatusAluguel statusAluguel) {
		this.statusAluguel = statusAluguel;
	}

}

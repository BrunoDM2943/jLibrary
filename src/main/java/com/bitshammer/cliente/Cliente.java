package com.bitshammer.cliente;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bitshammer.comum.Endereco;
import com.bitshammer.security.model.Usuario;

/**
 * Classe que representa um Cliente
 * 
 * @author Bruno
 *
 */
@Entity
public class Cliente {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue
	@Column(name = "cliente_id")
	private Long id;

	/**
	 * Nome
	 */
	@Column(nullable = false, length = 200)
	private String nome;

	/**
	 * Telefone
	 */
	@Column(nullable = false, length = 10)
	private String telefone;

	/**
	 * Celular
	 */
	@Column(nullable = false, length = 11)
	private String celular;
	
	/**
	 * Data de nascimento
	 */
	@Temporal(TemporalType.DATE)
	private Date dtNascimento;
	
	/**
	 * Sexo
	 */
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	/**
	 * Endereco
	 */
	@Embedded
	private Endereco endereco;
	
	/**
	 * CPF
	 */
	@Column
	private String cpf;

	/**
	 * Usu�rio
	 */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
	private Usuario usuario;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular
	 *            the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the dtNascimento
	 */
	public Date getDtNascimento() {
		return dtNascimento;
	}

	/**
	 * @param dtNascimento the dtNascimento to set
	 */
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	/**
	 * @return the sexo
	 */
	public Sexo getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		if(endereco == null)
			endereco = new Endereco();
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		if(usuario == null){
			usuario = new Usuario();
		}
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(!(obj instanceof Cliente))
			return false;
		return id.equals(((Cliente)obj).getId());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [getId()=").append(getId())
				.append(", getNome()=").append(getNome())
				.append(", getTelefone()=").append(getTelefone())
				.append(", getCelular()=").append(getCelular())
				.append(", getDtNascimento()=").append(getDtNascimento())
				.append(", getSexo()=").append(getSexo())
				.append(", getEndereco()=").append(getEndereco())
				.append(", getCpf()=").append(getCpf())
				.append(", getUsuario()=").append(getUsuario()).append("]");
		return builder.toString();
	}
	
	

}

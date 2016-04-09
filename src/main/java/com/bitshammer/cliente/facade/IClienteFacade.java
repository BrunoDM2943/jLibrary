/**
 * 
 */
package com.bitshammer.cliente.facade;

import com.bitshammer.cliente.Cliente;

/**
 * @author Bruno
 *
 */
public interface IClienteFacade {

	/**
	 * Cadastra um usu�rio na base de dados
	 * @param cliente
	 */
	void cadastrarCliente(final Cliente cliente);

	/**
	 * Remove um cliente da base de dados
	 * @param cliente
	 */
	void descadastrarCliente(Cliente cliente);

	/**
	 * Atualiza o cliente
	 * @param cliente
	 */
	void atualizarCliente(Cliente cliente);

}
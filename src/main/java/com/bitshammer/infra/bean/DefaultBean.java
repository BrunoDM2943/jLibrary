package com.bitshammer.infra.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.bitshammer.cliente.Cliente;
import com.bitshammer.security.model.TipoUsuario;
import com.bitshammer.security.model.Usuario;

public abstract class DefaultBean{


	/**
	 * Exibe uma mensagem de informa��o ao usu�rio
	 * 
	 * @param title T�tulo da mensagem
	 * @param detail Detalhe da mensagem
	 */
	protected void addMessage(String title, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, title, detail);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	
	/**
	 * Exibe uma mensagem de erro ao usu�rio
	 * @param error Mensagem
	 */
	protected void showErrorMessage(String error) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", error);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	

	protected void showSucessMessage() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Dados salvos!");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	
	/**
	 * Valida se h� um usu�rio comum na aplica��o
	 * @return
	 */
	public boolean isUsuarioCliente(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if(session.getAttribute("usuario") != null){
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			return TipoUsuario.CLIENTE.equals(usuario.getTipoUsuario());			
		}
		return true;
	}
	
	/**
	 * Valida se h� um usu�rio administrador na aplica��o
	 * @return
	 */
	public boolean isUsuarioAdministrador(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if(session.getAttribute("usuario") != null){
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			return TipoUsuario.ADMINISTRADOR.equals(usuario.getTipoUsuario());			
		}
		return false;
	}
	
	/**
	 * Valida se h� um usu�rio na aplica��o
	 * @return
	 */
	public boolean isUsuarioLogado(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		return session.getAttribute("usuario") != null;
	}

	
	/**
	 * Retorna o usu�rio logado
	 * @return
	 */
	public Usuario getUsuario(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if(session.getAttribute("usuario") != null){
			return (Usuario) session.getAttribute("usuario");
		} else {
			return null;
		}
	}
	
	/**
	 * Retornar o cliente logado
	 * @return
	 */
	public Cliente getClienteLogado(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if(session.getAttribute("cliente") != null){
			return (Cliente) session.getAttribute("cliente");
		} else {
			return null;
		}
	}

}

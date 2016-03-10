/**
 * 
 */
package com.bitshammer.security.services;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;

import com.bitshammer.infra.bean.DefaultBean;
import com.bitshammer.security.facade.ILoginFacade;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
@Named
@RequestScoped
public class LoginBean extends DefaultBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4166072776920035348L;

	@Inject
	private ILoginFacade facade;
	
	private Usuario usuario = new Usuario();
	
	public LoginBean(){
		
	}
	
	/**
	 * Loga o usu�rio
	 * @return
	 * @throws LoginException
	 */
	public String logar() throws LoginException{
		try{	
			usuario = facade.login(usuario);
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("user", usuario);
			return "home";
		}catch(LoginException e){
			addErrorMessage(e.getMessage());
		}
		return "";
	}
	
	/**
	 * Loga o usu�rio
	 * @return
	 * @throws LoginException
	 */
	public String logOff() throws LoginException{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.removeAttribute("user");
		session.invalidate();
		return "login";
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}

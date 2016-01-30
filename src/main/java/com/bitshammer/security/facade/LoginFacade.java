package com.bitshammer.security.facade;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import com.bitshammer.security.dao.ILoginDao;
import com.bitshammer.security.model.Usuario;

public class LoginFacade implements ILoginFacade{

	
	
	@Inject
	private ILoginDao dao;
	
	@Override
	public Usuario login(Usuario user) throws LoginException {
		return dao.findUser(user);
		
	}


	/**
	 * @return the dao
	 */
	public ILoginDao getDao() {
		return dao;
	}


	/**
	 * @param dao the dao to set
	 */
	public void setDao(ILoginDao dao) {
		this.dao = dao;
	}

}
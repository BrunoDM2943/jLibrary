package com.bitshammer.infra.dao;

import javax.persistence.EntityManager;

/**
 * Classe para acesso a 
 * base de dados
 * @author Bruno
 * @param <T>
 *
 */
public abstract class JPADao<T> {
	
	/**
	 * Construtor privado 
	 */
	protected JPADao(){};
	
	/**
	 * Singleton do entityManager
	 * @return {@link EntityManager} j� criado previamente
	 */
	
	protected EntityManager getEntityManager() {
		return EntityManagerSingleton.getInstance().createEntityManager();
		
	}
	
	/**
	 * Persiste um objeto na base
	 * de dados
	 * @param e {@link Object}
	 */
	public void persist(T e){
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		if(entityManager.contains(e)){
			e = (T)entityManager.merge(e);
		} else {
			entityManager.persist(e);
		}
		entityManager.getTransaction().commit();
	}
	
	/**
	 * Procura por um determinado
	 * objeto na base de dados
	 * 
	 * @param id
	 * @param clazz
	 * @return
	 */
	public T find(final Long id, final Class<T> clazz){
		return getEntityManager().find(clazz, id);
	}
	
	/**
	 * Deleta um objeto da base de dados
	 * 
	 * @param id
	 * @param clazz
	 * @return
	 */
	public void remove(final Long id, final Class<T> clazz){
		getEntityManager().remove(find(id, clazz));
	}
	
	/**
	 * Atualiza o objeto da base de dados
	 * 
	 * @param id
	 * @param clazz
	 * @return
	 */
	public void update(T obj){
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.getTransaction().commit();
	}
	
	/**
	 * Deleta um objeto da base de dados
	 * 
	 * @param id
	 * @param clazz
	 * @return
	 */
	public void remove(T obj){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(obj));
		em.getTransaction().commit();
	}
	
}

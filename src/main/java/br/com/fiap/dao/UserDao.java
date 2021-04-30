package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.User;
import br.com.fiap.utils.JPAUtil;

public class UserDao {
	public void save(User user) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public List<User> userList() {
		EntityManager manager = JPAUtil.getEntityManager();
		String list = "SELECT s from User s";
		TypedQuery<User> query = manager.createQuery(list, User.class);
		return query.getResultList();
		
	}

}

package br.com.fiap.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.dao.UserDao;
import br.com.fiap.model.User;

@ManagedBean
public class UserBean {
	private User user = new User();

	public void save() {
		new UserDao().save(this.user);
		System.out.println("Save User..." + this.user);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario cadstrado"));
	}

	public List<User> getUsers() {
		return new UserDao().userList();

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

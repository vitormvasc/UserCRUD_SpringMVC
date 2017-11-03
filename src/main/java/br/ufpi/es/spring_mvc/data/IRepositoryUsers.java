package br.ufpi.es.spring_mvc.data;

import java.util.List;

import br.ufpi.es.spring_mvc.model.User;

public interface IRepositoryUsers {
	public void insert(User u);
	public List<User> list();
	public User search(String login, String password);
	public User searchEmail(String email);
	public void edit(User original, User new_user);
	public void remove(User u);
	public String stringUsersList();
	public List<User> searchByContentAndType(String content, String type);
}
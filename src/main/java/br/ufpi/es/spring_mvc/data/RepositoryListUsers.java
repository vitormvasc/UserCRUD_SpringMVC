package br.ufpi.es.spring_mvc.data;

import java.util.List;

import br.ufpi.es.spring_mvc.model.*;

import java.util.LinkedList;

public class RepositoryListUsers implements IRepositoryUsers{
	List<User> usersList = new LinkedList<User>();
	
	/**
	 * Given an user, it is inserted onto the user's list 
	 */
	public void insert(User u) {
		usersList.add(u);
	}

	/**
	 * Returns a List of Users
	 */
	public List<User> list() {
		return usersList;
	}

	/**
	 * Checks if within the List there's a given user that matches the given credentials
	 */
	public User search(String email, String password) {
		User user = null;
		for(User u:usersList) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				user = u;
				return user;
			}
		}
		return user;
	}
	
	/**
	 * Checks if within the List there's a given user that matches the given email
	 */
	public User searchEmail(String email) {
		User user = null;
		for(User u:usersList) {
			if(u.getEmail().equals(email)) {
				user = u;
				return user;
			}
		}
		return user;
	}
	
	/**
	 * Returns a String with names all of users
	 */
	public String stringUsersList() {
		String allUserNames = "";
		for(User u:usersList) {
			allUserNames += "|| " + u.getName() + "\n";
			System.out.println(u.getName());
		}
		return allUserNames;
	}
	
	/**
	 * Searches an user by a given type
	 * @param given content of an user
	 * @param search by email, login or name
	 * @return list of users that match the credentials
	 */
	public List<User> searchByContentAndType(String content, String type) {
		List<User> list = new LinkedList<User>();
		switch(type) {
		case "name":
			for (User u:usersList) {
				if (u.getName().equals(content)) {
					list.add(u);
				}
			}
			break;
		case "email":
			for(User u:usersList) {
				if (u.getEmail().equals(content)) {
					list.add(u);
				}
			}
			break;
		case "login":
			for(User u:usersList) {
				if(u.getLogin().equals(content)) {
					list.add(u);
				}
			}
			break;
		default:
			list = null;
			break;
		}
		return list;
	}

	public void edit(User original, User new_user) {
		// TODO Auto-generated method stub
	}

	public void remove(User u) {
		usersList.remove(u);
	}
	
	public void populateUsers() {
		User u1 = new User();
        u1.setId(1);
        u1.setName("Armando Soares Sousa");
        u1.setLogin("armando");
        u1.setPassword("armando");
        u1.setEmail("armando@ufpi.edu.br");
		
        User u2 = new User();
        u2.setId(2);
        u2.setName("Maria Soares Sousa");
        u2.setLogin("maria");
        u2.setPassword("maria");
        u2.setEmail("maria");
		
        User u3 = new User();
        u3.setId(3);
        u3.setName("João Soares Sousa");
        u3.setLogin("joao");
        u3.setPassword("joao");
        u3.setEmail("joao@ufpi.edu.br");
		
        User u4 = new User();
        u4.setId(4);
        u4.setName("Francisco Soares Sousa");
        u4.setLogin("francisco");
        u4.setPassword("francisco");
        u4.setEmail("francisco@ufpi.edu.br");
		
        User u5 = new User();
        u5.setId(5);
        u5.setName("Antonio Soares Sousa");
        u5.setLogin("antonio");
        u5.setPassword("antonio");
        u5.setEmail("antonio@ufpi.edu.br");
		
        this.usersList.add(u1);
		this.usersList.add(u2);
		this.usersList.add(u3);
		this.usersList.add(u4);
		this.usersList.add(u5);
	}
}
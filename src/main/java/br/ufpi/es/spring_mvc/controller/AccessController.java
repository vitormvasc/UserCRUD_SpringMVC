package br.ufpi.es.spring_mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufpi.es.spring_mvc.model.User;
import br.ufpi.es.spring_mvc.controller.UsersController;
import br.ufpi.es.spring_mvc.data.*;

@Controller
public class AccessController {
	private RepositoryListUsers repository;
	private UsersController controller;
	
	public AccessController(){
		repository = new RepositoryListUsers();
        repository.populateUsers();
        controller = new UsersController(repository);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String processarLogin(User user, HttpSession session, Model model){
		
		String email;
		String password;
		
		email = user.getEmail();
		password = user.getPassword();
		
		User userDAO = controller.search(email, password);
		
		if (userDAO != null){
			session.setAttribute("Userlogged", email);
			model.addAttribute("mensagem", "Welcome " + email);
			
			System.out.println("User " + email + " logged in!");
			return "mainPage";
		}else{
			model.addAttribute("mensagem", "Error: email or password");
			return "loginForm";
		}
	}
	
	@RequestMapping(value="/loginForm")
	public String loadFormLogin(){
		return "loginForm";
	}
	
	@RequestMapping(value="/addUser")
	public String loadNewUserForm(){
		return "addUser";
	}
		
	@RequestMapping(value="/addNewUser", method=RequestMethod.POST)
	public String addNewUser(User user, HttpSession session, Model model){
		
	    String email;
		
		email = user.getEmail();
		if(controller.searchEmail(email) == null) {
			controller.insert(user);
			System.out.println("User " + email + " added!");
			return "mainPage";
		}
		else{
			model.addAttribute("mensagem", "Email already exists");
			return "loginForm";
		}
	}
			
	@RequestMapping(value="/listUsers", method=RequestMethod.GET)
	public String listOfUsers(User user, HttpSession session, Model model){		
		
		String allUserNames = controller.allUserNames();
	    String email;
		
		email = user.getEmail();

		session.setAttribute("User retrieved info about other users", email);
		model.addAttribute("mensagem", "Users: " + allUserNames);

		return "listUsers";
	}
	
	@RequestMapping(value="/searchUsers")
	public String loadSearchUserForm(){
		return "searchUser";
	}
	
	@RequestMapping(value="/searchUsersForm", method=RequestMethod.POST)
	public String searchByEmail(User user, HttpSession session, Model model){		
	    String email;
		
		email = user.getEmail();
		User userDAO = controller.searchEmail(email);
		session.setAttribute("User retrieved info about other users", email);
		if (userDAO == null){
			System.out.println("User " + email + " has not been found!");
			model.addAttribute("mensagem", "User has not been found");
			return "searchUser";
		}else{
			model.addAttribute("mensagem", "Name: " + userDAO.getName() + "|| Email: " + userDAO.getEmail() + "|| Login: " + userDAO.getLogin());
			return "searchUser";
		}
	}
	
	@RequestMapping(value="/deleteUser")
	public String loadDeleteUserForm(){
		return "deleteUser";
	}
			
	@RequestMapping(value="/deleteGivenUser", method=RequestMethod.POST)
	public String deleteGivenUser(User user, HttpSession session, Model model){
		
		String name;
		String password;
		
		name = user.getName();
		password = user.getPassword();
		
		System.out.println("User removed: " + user.getName());
		controller.remove(user);
		User userDAO = controller.search(name, password);
		
		if (userDAO == null){
			System.out.println("User removed!");
			return "mainPage";
		}else{
			model.addAttribute("mensagem", "Error: email or password");
			return "loginForm";
		}
	}
		
	@RequestMapping(value="/logout")
	public String processarLogout(HttpSession session) {
		String userName;
		
		userName = session.getAttribute("Userlogged").toString();
		session.invalidate();
		System.out.println("User " + userName + " logged out");
		return "loginForm";
	}
}
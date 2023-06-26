package in.inbalokesh.onlyhomefood.service;

import in.inbalokesh.onlyhomefood.dao.UserDAO;
import in.inbalokesh.onlyhomefood.model.User;

public class UserService {
	
	public User[] getAll() {
		
		UserDAO userDao = new UserDAO();
		
		User[] userList =  userDao.findAll();
		
		for(int i = 0; i < userList.length; i++) {
			
			System.out.println(userList[i]);
			
		}
		
		return userList;
		
	}
	
	public void create() {
		User newUser = new User();
		
		newUser.setId(12345);
		newUser.setEmail("inba@gmail.com");
		newUser.setFirstName("Inba");
		newUser.setLastName("Lokesh");
		newUser.setPassword("1234");
		newUser.setActive(true);
		
		UserDAO newUserDao = new UserDAO();
		newUserDao.create(newUser);
		
		
		
	}
	
	

}

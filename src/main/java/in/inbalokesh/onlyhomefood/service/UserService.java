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
	
	

}

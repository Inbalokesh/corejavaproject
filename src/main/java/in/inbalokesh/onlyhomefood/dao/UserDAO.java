package in.inbalokesh.onlyhomefood.dao;

import in.inbalokesh.onlyhomefood.model.User;

public class UserDAO {
	
	public User[] findAll() {
		User[] userlist = UserList.listOfUsers;
				
		
		return userlist;	
	}
	
	public void create() {
		
		User newUser = new User();
		
		newUser.setId(12345);
		newUser.setEmail("inba@gmail.com");
		newUser.setFirstName("Inba");
		newUser.setLastName("Lokesh");
		newUser.setPassword("1234");
		newUser.setActive(true);
		
		UserList.listOfUsers[0] = newUser;
			
	}

}

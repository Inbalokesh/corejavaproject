package in.inbalokesh.onlyhomefood.dao;

import in.inbalokesh.onlyhomefood.model.User;

public class UserDAO {
	
	public User[] findAll() {
		User[] userlist = UserList.listOfUsers;
				
		
		return userlist;	
	}
	
	public void create(User newUser) {
	
		UserList.listOfUsers[0] = newUser;
			
	}

}

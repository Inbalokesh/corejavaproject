package in.inbalokesh.onlyhomefood.dao;

import in.inbalokesh.onlyhomefood.model.User;

public class UserDAO {

	public User[] findAll() {

		User[] userlist = UserList.listOfUsers;

		return userlist;
	}

 /**
  * 
  * @param newUser
  */
	public void create(User newUser) {
		
		User[] arr = UserList.listOfUsers;

		for (int i = 0; i < arr.length; i++) {

			User user = arr[i];

			if (user == null) {
				arr[i] = newUser;
				break;
			}
		}

	}

	public void update(int id, User updateUser) {

		User[] arr = UserList.listOfUsers;
		for (int i = 0; i < arr.length; i++) {

			User user = arr[i];

			if (user == null) {
				continue;
			}

			if (user.getId() == id) {
				
				arr[i].setFirstName(updateUser.getFirstName());
				arr[i].setLastName(updateUser.getLastName());
				arr[i].setPassword(updateUser.getPassword());
				break;
			}
		}
	}
	
	public void delete(int id) {
		
		User[] arr = UserList.listOfUsers;
		for (int i = 0; i < arr.length; i++) {

			User user = arr[i];

			if (user == null) {
				continue;
			}
			if(user.getId() == id) {
				user.setActive(false);
				break;
			}
		}
		
	}
	
	public User findById(int userId) {
		
		User[] userlist = UserList.listOfUsers;
		
		User userMatch = null;
		
		for (int i = 0; i < userlist.length; i++) {

			User user = userlist[i];

			if (user == null) {
				continue;
			}
			if(user.getId() == userId) {
				userMatch = user;
				break;
			}
		}
		return userMatch;	
	}
	
	
}

package in.inbalokesh.onlyhomefood.dao;

import java.util.Set;
import in.inbalokesh.onlyhomefood.Interface.UserInterface;
import in.inbalokesh.onlyhomefood.model.UserEntity;

public class UserDAO implements UserInterface {

	public Set<UserEntity> findAll() {

		Set<UserEntity> userlist = UserList.listOfUsers;

		return userlist;
	}

	/**
	 * 
	 * @param newUser
	 */
	@Override
	public void create(UserEntity newUser) {

		Set<UserEntity> arr = UserList.listOfUsers;

		arr.add(newUser);

	}

	@Override
	public void update(int id, UserEntity updateUser) {

		Set<UserEntity> arr = UserList.listOfUsers;
		for (UserEntity name : arr) {

			UserEntity user = name;

			if (user.getId() == id) {
				user.setFirstName(updateUser.getFirstName());
				user.setLastName(updateUser.getLastName());
				user.setPassword(updateUser.getPassword());
				break;
			}
		}
	}

	@Override
	public void delete(int id) {
		Set<UserEntity> arr = UserList.listOfUsers;

		for (UserEntity name : arr) {

			UserEntity user = name;

			if (user.getId() == id) {
				user.setActive(false);
				break;
			}
		}
	}

	@Override
	public UserEntity findById(int userId) {

		Set<UserEntity> userlist = UserList.listOfUsers;

		UserEntity userMatch = null;
		for (UserEntity name : userlist) {

			UserEntity user = name;

			if (user.getId() == userId) {
				userMatch = user;
				break;
			}
		}
		return userMatch;
	}

	@Override
	public UserEntity findByEmailId(String email) {

		Set<UserEntity> arr = UserList.listOfUsers;
		UserEntity userMatch = null;
		for (UserEntity name : arr) {
			UserEntity user = name;
			if (user.getEmail() == email) {
				userMatch = user;
				break;
			}
		}
		return userMatch;
	}

	@Override
	public int count() {
		Set<UserEntity> userList = UserList.listOfUsers;
		return userList.size();
	}

}

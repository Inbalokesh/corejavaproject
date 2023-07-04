package in.inbalokesh.onlyhomefood.service;

import in.inbalokesh.onlyhomefood.dao.UserDAO;
import in.inbalokesh.onlyhomefood.model.User;
import in.inbalokesh.onlyhomefood.validation.UserValidator;

public class UserService {

	public User[] getAll() {
		UserDAO userDao = new UserDAO();
		User[] userList = userDao.findAll();
		for (int i = 0; i < userList.length; i++) {
			System.out.println(userList[i]);
		}
		return userList;
	}

	public User findUserId(int userId) {
		UserDAO userDao = new UserDAO();
		User user = userDao.findById(userId);
		System.out.println(user);
		return user;
	}

	public void create(User newUser) throws Exception{
		UserValidator.validate(newUser);
		UserDAO userDao = new UserDAO();
		userDao.create(newUser);
	}

	public void update() {
		User updateUser = new User();
		updateUser.setFirstName("Vanakam da");
		updateUser.setLastName("Maapla");
		updateUser.setPassword("14333");
		UserDAO newUserDao = new UserDAO();
		newUserDao.update(updateUser.getId(), updateUser);

	}

	public void delete() {

		User deleteUser = new User();

		deleteUser.setId(12345);

		UserDAO newUserDao = new UserDAO();

		newUserDao.delete(deleteUser.getId());

	}

}


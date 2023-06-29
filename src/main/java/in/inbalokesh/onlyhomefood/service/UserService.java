package in.inbalokesh.onlyhomefood.service;

import in.inbalokesh.onlyhomefood.dao.UserDAO;
import in.inbalokesh.onlyhomefood.model.User;

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

	public void create() {
		User newUser = new User();

		newUser.setId(12345);
		newUser.setEmail("inba@gmail.com");
		newUser.setFirstName("Inba");
		newUser.setLastName("Lokesh");
		newUser.setPassword("14");
		newUser.setActive(true);

		User newUser2 = new User();
		newUser2.setId(12);
		newUser2.setEmail("loki@gmail.com");
		newUser2.setFirstName("Loki");
		newUser2.setLastName("Lokesh");
		newUser2.setPassword("1455");
		newUser2.setActive(true);

		UserDAO newUserDao = new UserDAO();

		newUserDao.create(newUser);
		newUserDao.create(newUser2);

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

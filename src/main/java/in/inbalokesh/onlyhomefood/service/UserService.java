package in.inbalokesh.onlyhomefood.service;

import java.util.Set;

import in.inbalokesh.onlyhomefood.dao.UserDAO;
import in.inbalokesh.onlyhomefood.model.UserEntity;
import in.inbalokesh.onlyhomefood.validation.UserValidator;

public class UserService {

	public Set<UserEntity> getAll() {
		UserDAO userDao = new UserDAO();
		Set<UserEntity> userList = userDao.findAll();
		for (UserEntity name : userList) {
			System.out.println(name);
		}
		return userList;
	}

	public UserEntity findById(int userId) {
		UserDAO userDao = new UserDAO();
		return userDao.findById(userId);
	}

	public void create(UserEntity newUser) throws Exception {
		UserValidator.validate(newUser);
		UserDAO userDao = new UserDAO();
		userDao.create(newUser);
	}

	public void update(int id, UserEntity updateUser) {
		UserDAO newUserDao = new UserDAO();
		newUserDao.update(id, updateUser);

	}

	public void delete(int id) {
		UserDAO newUserDao = new UserDAO();
		newUserDao.delete(id);
	}
	
	public UserEntity findByEmailId(String email) {
		UserDAO newUserDao = new UserDAO();
		return newUserDao.findByEmailId(email);
	}

}

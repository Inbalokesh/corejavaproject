package in.inbalokesh.onlyhomefood;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Set;

import org.junit.jupiter.api.Test;
import in.inbalokesh.onlyhomefood.model.User;
import in.inbalokesh.onlyhomefood.service.UserService;

public class TestGetAllUsers {

	@Test
	public void testGetAllUser() {

		UserService userService = new UserService();
		Set<User> users = userService.getAll();
		System.out.println(users);
	}

	@Test
	public void testGetUserById() {

		UserService userService = new UserService();
		User user = userService.findById(1);
		System.out.println(user);
	}

	@Test
	public void testUpdateUserValid() {
		UserService userService = new UserService();
		User updateUser = new User();
		updateUser.setFirstName("Akil");
		updateUser.setLastName("aaa");
		assertDoesNotThrow(() -> {
			userService.update(1, updateUser);
		});
	}
	
}

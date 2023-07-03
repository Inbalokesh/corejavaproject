package in.inbalokesh.onlyhomefood;

import in.inbalokesh.onlyhomefood.model.User;
import in.inbalokesh.onlyhomefood.service.UserService;

public class App {

	public static void main(String[] args) {

		try {
			UserService userService = new UserService();

			User newUser = new User();

			newUser.setId(12345);
			newUser.setEmail("inba@gmail.com");
			newUser.setFirstName("Inba");
			newUser.setLastName("Lokesh");
			newUser.setPassword("14");
			newUser.setActive(true);

			userService.create(newUser);
			userService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			
		}

//		userService.update();
//		userService.delete();
//		userService.findUserId(12345);
		

	}

}

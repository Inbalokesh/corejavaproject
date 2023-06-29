package in.inbalokesh.onlyhomefood;

import in.inbalokesh.onlyhomefood.service.UserService;

public class App {

	public static void main(String[] args) {

		UserService userService = new UserService();

		userService.create();
		userService.update();
		userService.delete();
		userService.findUserId(12345);
		userService.getAll();

	}

}

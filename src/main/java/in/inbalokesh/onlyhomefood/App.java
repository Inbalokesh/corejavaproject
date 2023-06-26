package in.inbalokesh.onlyhomefood;

import in.inbalokesh.onlyhomefood.service.UserService;

public class App {

	public static void main(String[] args) {
		
		UserService userService = new UserService();
		
		userService.getAll();
	}

}

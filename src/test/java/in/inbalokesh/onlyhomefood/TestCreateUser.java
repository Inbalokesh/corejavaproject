package in.inbalokesh.onlyhomefood;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import in.inbalokesh.onlyhomefood.model.User;
import in.inbalokesh.onlyhomefood.service.UserService;

public class TestCreateUser {
	@Test
	public void testCreateUserWithValidInput() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(12345);
		newUser.setEmail("inba@gmail.com");
		newUser.setFirstName("Inba");
		newUser.setLastName("Lokesh");
		newUser.setPassword("14");
		newUser.setActive(true);
		
		assertDoesNotThrow(()->{
			userService.create(newUser);
		});	
	}
	
	@Test
	public void testCreateUserWithInvaidInput() {	
		UserService userService = new UserService();
		
		Exception exception = assertThrows(Exception.class,()->{
			userService.create(null);
		});
		String expectedMessage = "Invalid Input";
		
		String receivedMessage = exception.getMessage();
		
		assertTrue(expectedMessage.equals(receivedMessage));	
	}
	
	@Test
	public void testCreateUserWithEmailNull() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(12345);
		newUser.setEmail("inba@gmail.com");
		newUser.setFirstName("Inba");
		newUser.setLastName("Lokesh");
		newUser.setPassword("14");
		newUser.setActive(true);
		
		assertDoesNotThrow(()->{
			userService.create(newUser);
		});	
	}
}

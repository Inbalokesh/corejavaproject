package in.inbalokesh.onlyhomefood;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.inbalokesh.onlyhomefood.exception.ValidationException;
import in.inbalokesh.onlyhomefood.model.User;
import in.inbalokesh.onlyhomefood.service.UserService;

public class TestCreateUser {
	@Test
	public void testCreateUserWithValidInput() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail("inba@gmail.com");
		newUser.setFirstName("Inba");
		newUser.setLastName("Lokesh");
		newUser.setPassword("14");
		assertDoesNotThrow(() -> {
			userService.create(newUser);
		});
	}

	@Test
	public void testCreateUserWithInvaidInput() {
		UserService userService = new UserService();

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(null);
		});
		String expectedMessage = "Invalid User Input";

		String receivedMessage = exception.getMessage();

		assertTrue(expectedMessage.equals(receivedMessage));
	}

	@Test
	public void testUserWithEmailNull() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail(null);
		newUser.setFirstName("Inba");
		newUser.setLastName("Lokesh");
		newUser.setPassword("14");

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});

		String expectedMessage = "Email cannot be null or empty";

		String receivedMessage = exception.getMessage();

		assertTrue(expectedMessage.equals(receivedMessage));
	}

	@Test
	public void testUserWithEmailEmpty() {

		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail("");
		newUser.setFirstName("Inba");
		newUser.setLastName("Lokesh");
		newUser.setPassword("14");
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);

		});

		String expectedMessage = "Email cannot be null or empty";
		String receivedMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(receivedMessage));
	}

//	Password

	@Test
	public void testUserWithPasswordNull() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail("inba@gmail.com");
		newUser.setFirstName("Inba");
		newUser.setLastName("Lokesh");
		newUser.setPassword(null);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});

		String expectedMessage = "Password cannot be null or empty";
		String receivedMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(receivedMessage));
	}

	@Test
	public void testUserWithPasswordEmpty() {

		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail("inba@gmail.com");
		newUser.setFirstName("Inba");
		newUser.setLastName("Lokesh");
		newUser.setPassword("");
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);

		});

		String expectedMessage = "Password cannot be null or empty";
		String receivedMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(receivedMessage));
	}

//	First Name

	@Test
	public void testUserWithFirstNameNull() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail("inba@gmail.com");
		newUser.setFirstName(null);
		newUser.setLastName("Lokesh");
		newUser.setPassword("1234");

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});

		String expectedMessage = "FirstName cannot be null or empty";
		String receivedMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(receivedMessage));
	}

	@Test
	public void testUserWithFirstNameEmpty() {

		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail("inba@gmail.com");
		newUser.setFirstName("");
		newUser.setLastName("Lokesh");
		newUser.setPassword("1234");
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);

		});

		String expectedMessage = "FirstName cannot be null or empty";
		String receivedMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(receivedMessage));
	}
}

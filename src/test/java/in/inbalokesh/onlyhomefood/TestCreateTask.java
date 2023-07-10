package in.inbalokesh.onlyhomefood;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import in.inbalokesh.onlyhomefood.exception.ValidationException;
import in.inbalokesh.onlyhomefood.model.Task;
import in.inbalokesh.onlyhomefood.service.TaskService;

public class TestCreateTask {

	@Test
	public void testCreateTaskWithValidInput() {
		TaskService taskService = new TaskService();

		Task newTask = new Task();
		newTask.setId(12345);
		
		String date = "12/09/2023";
		LocalDate updateDuedate = TaskService.convertToDate(date);
		newTask.setDueDate(updateDuedate);
		
		newTask.setName("abcd");
		newTask.setActive(true);

		assertDoesNotThrow(() -> {
			taskService.createTask(newTask);
		});
	}

	@Test
	public void testCreateTaskWithInvaidInput() {
		TaskService taskService = new TaskService();

		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.createTask(null);
		});
		String expectedMessage = "Invalid Task Input";

		String receivedMessage = exception.getMessage();

		assertTrue(expectedMessage.equals(receivedMessage));
	}

	@Test
	public void testTaskWithNameNull() {
		TaskService taskService = new TaskService();

		Task newTask = new Task();
		newTask.setId(12345);
		String date = "12/09/2023";
		LocalDate updateDuedate = TaskService.convertToDate(date);
		newTask.setDueDate(updateDuedate);
		newTask.setName(null);
		newTask.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.createTask(newTask);
		});

		String expectedMessage = "Name cannot be null or empty";

		String receivedMessage = exception.getMessage();

		assertTrue(expectedMessage.equals(receivedMessage));
	}

	@Test
	public void testTaskWithNameEmpty() {
		
		TaskService taskService = new TaskService();
		Task newTask = new Task();
		newTask.setId(12345);
		String date = "12/09/2023";
		LocalDate updateDuedate = TaskService.convertToDate(date);
		newTask.setDueDate(updateDuedate);
		newTask.setName("");
		newTask.setActive(true);
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.createTask(newTask);
		});
		String expectedMessage = "Name cannot be null or empty";
		String receivedMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(receivedMessage));
	}
	
	@Test
	public void testCreateTaskWithInvalidDate() {
		TaskService taskService = new TaskService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			Task newTask = new Task();
			newTask.setId(111);
			String userInput = "23/07/2022";
			newTask.setName("Abcd");
			LocalDate convertedDate = TaskService.convertToDate(userInput);
			newTask.setDueDate(convertedDate);
			newTask.setActive(true);
			taskService.createTask(newTask);
		});
		String expectedMessage = "Due Date can not be in the Past";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
}

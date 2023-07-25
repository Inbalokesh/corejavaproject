package in.inbalokesh.onlyhomefood;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDate;
import java.util.Set;

import org.junit.jupiter.api.Test;

import in.inbalokesh.onlyhomefood.model.Task;
import in.inbalokesh.onlyhomefood.service.TaskService;

public class TestGetAllTask {
	
	@Test
	public void testGetAllUser() {

		TaskService taskService = new TaskService();
		Set<Task> tasks = taskService.getAllTask();
	}
	
	@Test
	public void testGetTaskById() {
		TaskService taskService = new TaskService();
		Task task = taskService.findById(2);
	}
	
	@Test
	public void testUpdateTaskValid() {
		TaskService taskService = new TaskService();
		Task updateTask = new Task();
		updateTask.setName("Buy a chocalate");
		String date = "30/12/2023";
		LocalDate updateDuedate = TaskService.convertToDate(date);
		updateTask.setDueDate(updateDuedate);

		assertDoesNotThrow(() -> {
			taskService.update(2, updateTask);
		});
		
	}


}

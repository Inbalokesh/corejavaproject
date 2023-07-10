package in.inbalokesh.onlyhomefood;

import java.time.LocalDate;

import in.inbalokesh.onlyhomefood.exception.ValidationException;
import in.inbalokesh.onlyhomefood.model.Task;
import in.inbalokesh.onlyhomefood.model.User;
import in.inbalokesh.onlyhomefood.service.TaskService;
import in.inbalokesh.onlyhomefood.service.UserService;

public class App {

	public static void main(String[] args) {

//		try {
//			UserService userService = new UserService();
//
//			User newUser = new User();
//
//			newUser.setId(12345);
//			newUser.setEmail("inba@gmail.com");
//			newUser.setFirstName("Inba");
//			newUser.setLastName("Lokesh");
//			newUser.setPassword("14");
//			newUser.setActive(true);
//
//			userService.create(newUser);
//			userService.getAll();
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		}

//		userService.update();
//		userService.delete();
//		userService.findUserId(12345);

		try {
			TaskService taskService = new TaskService();

			Task newTask = new Task();

			newTask.setId(1233);
			newTask.setName("abcdedf");
			String date = "2/22/2025";
			LocalDate updateDuedate = TaskService.convertToDate(date);
			newTask.setDueDate(updateDuedate);
			
			newTask.setActive(true);
			taskService.createTask(newTask);
			taskService.getAllTask();
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

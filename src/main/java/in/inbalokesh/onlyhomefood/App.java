package in.inbalokesh.onlyhomefood;

import java.time.LocalDate;

import in.inbalokesh.onlyhomefood.exception.ValidationException;
import in.inbalokesh.onlyhomefood.model.TaskEntity;
import in.inbalokesh.onlyhomefood.model.UserEntity;
import in.inbalokesh.onlyhomefood.service.TaskService;
import in.inbalokesh.onlyhomefood.service.UserService;

public class App {

	public static void main(String[] args) {

		try {
			UserService userService = new UserService();

			UserEntity newUser = new UserEntity();

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

		try {
			TaskService taskService = new TaskService();

			TaskEntity newTask = new TaskEntity();

			newTask.setId(1233);
			newTask.setName("abcdedf");
			LocalDate updateDuedate = LocalDate.of(2023, 8, 19);
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

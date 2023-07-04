package in.inbalokesh.onlyhomefood.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import in.inbalokesh.onlyhomefood.dao.TaskDAO;
import in.inbalokesh.onlyhomefood.exception.ValidationException;
import in.inbalokesh.onlyhomefood.model.Task;
import in.inbalokesh.onlyhomefood.validation.TaskValidator;

public class TaskService {

	public Task[] getAllTask() {

		TaskDAO taskDao = new TaskDAO();
		Task[] taskList = taskDao.findAllTask();
		for (int i = 0; i < taskList.length; i++) {
			System.out.println(taskList[i]);
		}
		return taskList;
	}

	public Task findTask(int id) {

		TaskDAO taskDao = new TaskDAO();
		Task task = taskDao.findTaskById(id);
		System.out.println(task);
		return task;

	}

	public void createTask(Task newTask) throws ValidationException {
		TaskValidator.validate(newTask);
		TaskDAO taskDao = new TaskDAO();
		taskDao.createTask(newTask);

	}

	public void update() {
		Task updateTask = new Task();
		updateTask.setName("abcd");
//		updateTask.setDueDate(03-11-2022);

		TaskDAO newTaskDao = new TaskDAO();
		newTaskDao.updateTask(updateTask.getId(), updateTask);

	}

	public void delete() {

		Task deleteTask = new Task();

		deleteTask.setId(111);

		TaskDAO newUserDao = new TaskDAO();

		newUserDao.deleteTask(deleteTask.getId());
	}

	public static LocalDate convertToDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			LocalDate localDate = LocalDate.parse(dateString, formatter);
			return localDate;
		} catch (Exception e) {
			System.out.println("Invalid date format!");
			return null;
		}
	}

}

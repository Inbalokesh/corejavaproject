package in.inbalokesh.onlyhomefood.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import in.inbalokesh.onlyhomefood.dao.TaskDAO;
import in.inbalokesh.onlyhomefood.exception.ValidationException;
import in.inbalokesh.onlyhomefood.model.TaskEntity;
import in.inbalokesh.onlyhomefood.validation.TaskValidator;

public class TaskService {

	public Set<TaskEntity> getAllTask() {

		TaskDAO taskDao = new TaskDAO();
		Set<TaskEntity> taskList = taskDao.findAll();
		 for (TaskEntity name : taskList) {
	    	 System.out.println(name);		
					}
		 
		 return taskList;
	 }

	public TaskEntity findById(int id) {

		TaskDAO taskDao = new TaskDAO();
		TaskEntity task = taskDao.findById(id);
		System.out.println(task);
		return task;

	}

	public void createTask(TaskEntity newTask) throws ValidationException {
		TaskValidator.validate(newTask);
		TaskDAO taskDao = new TaskDAO();
		taskDao.create(newTask);
	}

	public void update(int id, TaskEntity updateTask) {	
		TaskDAO newTaskDao = new TaskDAO();
		newTaskDao.update(id, updateTask);
	}

	public void delete(int id) {
		TaskDAO newUserDao = new TaskDAO();
		newUserDao.delete(id);
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

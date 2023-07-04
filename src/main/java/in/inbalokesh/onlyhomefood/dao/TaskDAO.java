package in.inbalokesh.onlyhomefood.dao;

import in.inbalokesh.onlyhomefood.model.Task;

public class TaskDAO {

	public Task[] findAllTask() {

		Task[] taskList = TaskList.listOfTasks;

		return taskList;
	}

	public void createTask(Task newTask) {

		Task[] list = TaskList.listOfTasks;

		for (int i = 0; i < list.length; i++) {

			Task task = list[i];

			if (task == null) {
				list[i] = newTask;
				break;
			}
		}
	}
	
	public void updateTask(int id, Task updateTask) {
		
		Task[] list = TaskList.listOfTasks;

		for (int i = 0; i < list.length; i++) {

			Task task = list[i];
			
			if (task == null) {
				continue;
			}
			
			if(task.getId() == id) {
				
				list[i].setName(updateTask.getName());
				list[i].setDueDate(updateTask.getDueDate());
				break;
			}
		}
	}
	
	public void deleteTask(int id) {
		
		Task[] list = TaskList.listOfTasks;

		for (int i = 0; i < list.length; i++) {

			Task task = list[i];
			
			if (task == null) {
				continue;
			}
			if(task.getId() == id) {
				task.setActive(false);
				break;
			}
			
		}
	}
	
	public Task findTaskById(int taskId) {
		
		Task[] taskList = TaskList.listOfTasks;
		
		Task taskMatch = null;
		
		for(int i = 0; i < taskList.length; i++) {
			
			Task task = taskList[i];
			
			if(task == null) {
				
				continue;
			}
			
			if(task.getId() == taskId) {
				
				taskMatch = task;
				break;
			}
		}
		return taskMatch;
	}

}

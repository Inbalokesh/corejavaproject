package in.inbalokesh.onlyhomefood.dao;

import java.util.Set;
import in.inbalokesh.onlyhomefood.Interface.TaskInterface;
import in.inbalokesh.onlyhomefood.model.TaskEntity;

public class TaskDAO implements TaskInterface {
	
	public Set<TaskEntity> findAll() {

		Set<TaskEntity> taskList = TaskList.listOfTasks;

		return taskList;
	}

	@Override
	public void create(TaskEntity newTask) {

		Set<TaskEntity> list = TaskList.listOfTasks;

		list.add(newTask);
	}

	@Override
	public void update(int id, TaskEntity updateTask) {

		Set<TaskEntity> list = TaskList.listOfTasks;

		for (TaskEntity name : list) {

			TaskEntity task = name;

			if (task.getId() == id) {
				task.setName(updateTask.getName());
				task.setDueDate(updateTask.getDueDate());
				break;
			}
		}
	}

	@Override
	public void delete(int id) {

		Set<TaskEntity> list = TaskList.listOfTasks;

		for (TaskEntity name : list) {

			TaskEntity task = name;

			if (task.getId() == id) {
				task.setActive(false);
				break;
			}
		}
	}

	@Override
	public TaskEntity findById(int taskId) {

		Set<TaskEntity> taskList = TaskList.listOfTasks;

		TaskEntity taskMatch = null;

		for (TaskEntity name : taskList) {

			TaskEntity task = name;

			if (task.getId() == taskId) {
				taskMatch = task;
				break;
			}
		}
		return taskMatch;
	}


}

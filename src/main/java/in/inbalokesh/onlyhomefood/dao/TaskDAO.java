package in.inbalokesh.onlyhomefood.dao;

import java.util.Set;
import in.inbalokesh.onlyhomefood.Interface.TaskInterface;
import in.inbalokesh.onlyhomefood.model.Task;

public class TaskDAO implements TaskInterface {

	public Set<Task> findAll() {

		Set<Task> taskList = TaskList.listOfTasks;

		return taskList;
	}

	@Override
	public void create(Task newTask) {

		Set<Task> list = TaskList.listOfTasks;

		list.add(newTask);
	}

	@Override
	public void update(int id, Task updateTask) {

		Set<Task> list = TaskList.listOfTasks;

		for (Task name : list) {

			Task task = name;

			if (task.getId() == id) {
				task.setName(updateTask.getName());
				task.setDueDate(updateTask.getDueDate());
				break;
			}
		}
	}

	@Override
	public void delete(int id) {

		Set<Task> list = TaskList.listOfTasks;

		for (Task name : list) {

			Task task = name;

			if (task.getId() == id) {
				task.setActive(false);
				break;
			}
		}
	}

	@Override
	public Task findById(int taskId) {

		Set<Task> taskList = TaskList.listOfTasks;

		Task taskMatch = null;

		for (Task name : taskList) {

			Task task = name;

			if (task.getId() == taskId) {
				taskMatch = task;
				break;
			}
		}
		return taskMatch;
	}

}

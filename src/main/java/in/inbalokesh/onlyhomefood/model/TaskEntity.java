package in.inbalokesh.onlyhomefood.model;

import java.time.LocalDate;

public abstract class TaskEntity {

	int id;
	String name;
	LocalDate dueDate;
	boolean isActive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Task [id= " + id + ", name= " + name + ", dueDate= " + dueDate + ", isActive= " + isActive + "]";
	}

	public int compareTo(Task o) {

		if (this.getId() == o.getId()) {
			return 0;
		} else {
			if (this.getId() > o.getId()) {
				return 1;
			} else {
				return -1;
			}
			// return ( this.getId() > o.getId()) ? 1: -1;
		}
	}

}
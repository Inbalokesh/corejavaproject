package in.inbalokesh.onlyhomefood.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;
import in.inbalokesh.onlyhomefood.Interface.TaskInterface;
import in.inbalokesh.onlyhomefood.model.Task;
import in.inbalokesh.onlyhomefood.util.ConnectionUtil;

public class TaskDAO implements TaskInterface {

	public Set<Task> findAll() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<Task> taskList = new HashSet<>();

		try {
			String query = "select * from task where is_active = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				java.sql.Date sqlDate = rs.getDate("due_date");
				java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
				task.setDueDate(utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				task.setActive(rs.getBoolean("is_active"));

				taskList.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();

		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return taskList;
	}

	@Override
	public void create(Task newTask) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "insert into task (name, due_date) values (?,?)";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			ps.setString(1, newTask.getName());
			Date sqlDate = Date.valueOf(newTask.getDueDate());
			ps.setDate(2, sqlDate);

			ps.executeUpdate();
			System.out.println("Task has been created sucessfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();

		} finally {
			ConnectionUtil.close(con, ps);
		}
	}

	@Override
	public void update(int id, Task updateTask) {

		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			String query = "update task set name = ?, due_date = ? where id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setString(1, updateTask.getName());
			Date sqlDate = Date.valueOf(updateTask.getDueDate());
			ps.setDate(2, sqlDate);
			ps.setInt(3, id);
			
			ps.executeUpdate();
			System.out.println("Task has been updated sucessfully");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}finally {
			ConnectionUtil.close(con, ps);
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

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Task task = null;
		
		try {
			String query = "select * from task where is_active = 1 AND id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, taskId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				task = new Task();
				task.setId(rs.getInt("id"));
				java.sql.Date sqlDate = rs.getDate("due_date");
				java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
				task.setDueDate(utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				task.setName(rs.getString("name"));
				task.setActive(rs.getBoolean("is_active"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return task;
		
	}

}

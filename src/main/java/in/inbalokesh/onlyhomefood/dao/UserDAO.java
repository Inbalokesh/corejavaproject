package in.inbalokesh.onlyhomefood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import in.inbalokesh.onlyhomefood.Interface.UserInterface;
import in.inbalokesh.onlyhomefood.model.User;
import in.inbalokesh.onlyhomefood.util.ConnectionUtil;

public class UserDAO implements UserInterface {

	public Set<User> findAll() throws RuntimeException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<User> userList = new HashSet<>();

		try {
			String query = "select * from users where is_active = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setActive(rs.getBoolean("is_active"));

				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();

		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return userList;
	}

	/**
	 * 
	 * @param newUser
	 */
	@Override
	public void create(User newUser) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "insert into users (first_name, last_name, email, password) values (?,?,?,?)";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			ps.setString(1, newUser.getFirstName());
			ps.setString(2, newUser.getLastName());
			ps.setString(3, newUser.getEmail());
			ps.setString(4, newUser.getPassword());

			ps.executeUpdate();
			System.out.println("User has been created sucessfully");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps);
		}

	}

	@Override
	public void update(int id, User updateUser) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "update users set first_name = ?, last_name = ? where id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			ps.setString(1, updateUser.getFirstName());
			ps.setString(2, updateUser.getLastName());
			ps.setInt(3, id);

			ps.executeUpdate();
			System.out.println("User has been updated sucessfully");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps);
		}
		

	}

	@Override
	public void delete(int id) {
		Set<User> arr = UserList.listOfUsers;

		for (User name : arr) {

			User user = name;

			if (user.getId() == id) {
				user.setActive(false);
				break;
			}
		}
	}

	@Override
	public User findById(int userId) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;

		try {
			String query = "select * from users where is_active = 1 AND id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setActive(rs.getBoolean("is_active"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();

		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return user;

	}

	@Override
	public User findByEmailId(String email) {

		Set<User> arr = UserList.listOfUsers;
		User userMatch = null;
		for (User name : arr) {
			User user = name;
			if (user.getEmail() == email) {
				userMatch = user;
				break;
			}
		}
		return userMatch;
	}

	@Override
	public int count() {
		Set<User> userList = UserList.listOfUsers;
		return userList.size();
	}

}

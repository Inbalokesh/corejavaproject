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

//	Set<User> userlist = UserList.listOfUsers;
//	return userlist;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<User> userList = new HashSet<>();

		try {
			String query = "select * from users where isActive = 1";
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
			e.getMessage();
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

		Set<User> arr = UserList.listOfUsers;

		arr.add(newUser);

	}

	@Override
	public void update(int id, User updateUser) {

		Set<User> arr = UserList.listOfUsers;
		for (User name : arr) {

			User user = name;

			if (user.getId() == id) {
				user.setFirstName(updateUser.getFirstName());
				user.setLastName(updateUser.getLastName());
				user.setPassword(updateUser.getPassword());
				break;
			}
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

		Set<User> userlist = UserList.listOfUsers;

		User userMatch = null;
		for (User name : userlist) {

			User user = name;

			if (user.getId() == userId) {
				userMatch = user;
				break;
			}
		}
		return userMatch;
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

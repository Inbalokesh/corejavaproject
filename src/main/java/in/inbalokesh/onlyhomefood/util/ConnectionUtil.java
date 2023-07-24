package in.inbalokesh.onlyhomefood.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;

public class ConnectionUtil {

	public static Connection getConnection() {

		Connection connection = null;
		String url = null;
		String userName = null;
		String password = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://aws.connect.psdb.cloud/onlyhomefood?sslMode=VERIFY_IDENTITY", "d17cntmkp8626tv6qa8t",
					"pscale_pw_7v6tD3sUSxmVvdh0rQSxRy56FLfM7m16ElWqrAEVzvQ");

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return connection;
	}

	public static void close(Connection connection, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

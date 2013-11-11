package dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

import org.apache.commons.lang3.text.WordUtils;

import utils.NotFoundException;

public class UserDAO extends DAO<User> {

	@Override
	protected User parseResults(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setName(rs.getString("name"));
		user.setIs_admin(rs.getBoolean("is_admin"));
		try {
			user.setPassword(rs.getString("password"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new RuntimeException("Failed to parse password");
		}

		return user;
	}

	public User byUser(String username) {
		try {
			PreparedStatement statement = this.getConnection()
					.prepareStatement(
							"SELECT * FROM " + this.getTable() + " WHERE "
									+ "name = ?");
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();

			User result = this.parseResults(rs);

			rs.close();

			return result;
		} catch (SQLException e) {
			throw new NotFoundException(WordUtils.capitalize(this.getTable())
					+ " Not Found");
		}
	}

	@Override
	protected String getTable() {
		return "user";
	}

}

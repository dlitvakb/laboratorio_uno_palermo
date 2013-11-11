package models;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import utils.Crypt;
import utils.DAOField;

import com.google.gson.Gson;

import dao.DAO;
import dao.UserDAO;

public class User extends APIModel {
	@DAOField
	private String name;

	@DAOField
	private String password;

	@DAOField
	private boolean is_admin;

	@Override
	protected DAO<User> getDAO() {
		return new UserDAO();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User fromJson(String json) {
		User user = new Gson().fromJson(json, User.class);
		// Gson uses reflection, so no logic is applied from the model
		try {
			user.setPassword(user.getPassword());
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// Ignored
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User fromJson(Long id, String json) {
		User user = new Gson().fromJson(json, User.class);
		// Gson uses reflection, so no logic is applied from the model
		try {
			user.setPassword(user.getPassword());
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// Ignored
		}
		user.setId(id);

		return user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		if (password.startsWith("$sha1$") && password.length() == 46) {
			this.password = password;
			return;
		}
		this.password = Crypt.encryptPassword(password);
	}

	public boolean authenticate(String password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return this.getPassword().equals(Crypt.encryptPassword(password));
	}

	public boolean isAdmin() {
		return this.is_admin;
	}

	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}
}

package dao;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    protected User parseResultsSafe(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setIs_admin(rs.getBoolean("is_admin"));
        try {
            Field password = user.getClass().getDeclaredField("password");
            password.setAccessible(true);
            password.set(user, null);
        } catch (SecurityException | NoSuchFieldException
                | IllegalArgumentException | IllegalAccessException e) {
            // Ignore
        }

        return user;
    }

    @Override
    protected User doParseResultsMultiple(ResultSet rs) throws SQLException {
        return this.parseResultsSafe(rs);
    }

    public User byUser(String username) {
        try {
            List<String> args = new ArrayList<String>();
            args.add("name");
            PreparedStatement statement = this.createStatement(args);
            statement.setString(1, username);
            User user = this.parseSingle(statement.executeQuery());
            statement.close();
            return user;
        } catch (SQLException e) {
            throw new NotFoundException(WordUtils.capitalize(this.getTable())
                    + " Not Found", e);
        }
    }

    @Override
    public String getTable() {
        return "user";
    }
}

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Issue;

public class IssueDAO extends DAO<Issue> {

	@Override
	protected Issue parseResults(ResultSet rs) throws SQLException {
		Issue issue = new Issue();
		issue.setId(rs.getLong("id"));
		issue.setName(rs.getString("name"));
		issue.setUser_id(rs.getLong("user_id"));
		issue.setDescription(rs.getString("description"));

		return issue;
	}

	@Override
	protected String getTable() {
		return "issue";
	}
}

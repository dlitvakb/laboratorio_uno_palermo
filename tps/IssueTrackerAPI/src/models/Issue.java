package models;

import utils.DAOField;

import com.google.gson.Gson;

import dao.DAO;
import dao.IssueDAO;

public class Issue extends APIModel {
	@DAOField
	private long user_id;

	@DAOField
	private String name;

	@DAOField
	private String description;

	@Override
	protected DAO<Issue> getDAO() {
		return new IssueDAO();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Issue fromJson(String json) {
		Issue issue = new Gson().fromJson(json, Issue.class);
		return issue;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Issue fromJson(Long id, String json) {
		Issue issue = new Gson().fromJson(json, Issue.class);
		issue.setId(id);

		return issue;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

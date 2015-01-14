package models;

import utils.DAOField;

import com.google.gson.Gson;

import dao.DAO;
import dao.IssueDAO;
import dao.StatusDAO;

public class Issue extends APIModel {
    @DAOField
    private long user_id;

    @DAOField
    private long assignee_user_id;

    @DAOField
    private String name;

    @DAOField
    private String description;

    @DAOField
    private long status;

    @Override
    protected DAO<Issue> getDAO() {
        return new IssueDAO();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Issue fromJson(String json) {
        return new Gson().fromJson(json, Issue.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Issue fromJson(Long id, String json) {
        Issue issue = new Gson().fromJson(json, Issue.class);
        issue.setId(id);

        return issue;
    }

    public long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStatus() {
        return this.status;
    }

    public String getStatusName() {
        return new StatusDAO().byId(this.status).getName();
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getAssignee_user_id() {
        return this.assignee_user_id;
    }

    public void setAssignee_user_id(long assignee_user_id) {
        this.assignee_user_id = assignee_user_id;
    }
}

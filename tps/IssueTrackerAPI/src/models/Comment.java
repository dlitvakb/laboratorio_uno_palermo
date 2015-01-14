package models;

import utils.DAOField;

import com.google.gson.Gson;

import dao.CommentDAO;
import dao.DAO;

public class Comment extends APIModel {
    @DAOField
    private long issue_id;

    @DAOField
    private long user_id;

    @DAOField
    private String content;

    @Override
    protected DAO<Comment> getDAO() {
        return new CommentDAO();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Comment fromJson(String json) {
        return new Gson().fromJson(json, Comment.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Comment fromJson(Long id, String json) {
        Comment comment = new Gson().fromJson(json, Comment.class);
        comment.setId(id);

        return comment;
    }

    public long getIssue_id() {
        return this.issue_id;
    }

    public void setIssue_id(long issue_id) {
        this.issue_id = issue_id;
    }

    public long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

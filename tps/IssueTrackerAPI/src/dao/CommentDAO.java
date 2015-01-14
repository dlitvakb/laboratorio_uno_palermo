package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Comment;

public class CommentDAO extends DAO<Comment> {
    @Override
    protected Comment parseResults(ResultSet rs) throws SQLException {
        Comment comment = new Comment();
        comment.setId(rs.getLong("id"));
        comment.setIssue_id(rs.getLong("issue_id"));
        comment.setUser_id(rs.getLong("user_id"));
        comment.setContent(rs.getString("content"));

        return comment;
    }

    @Override
    public String getTable() {
        return "comment";
    }

    public List<Comment> byIssue(long issueId) {
        List<Comment> comments = new ArrayList<Comment>();
        for (Comment comment : this.all()) {
            if (comment.getIssue_id() == issueId) {
                comments.add(comment);
            }
        }

        return comments;
    }
}

package resources;

import java.util.HashMap;
import java.util.Map;

import models.Comment;
import dao.CommentDAO;
import dao.DAO;

public class CommentResource extends APIResource<Comment> {
    @Override
    protected DAO<Comment> getDAO() {
        return new CommentDAO();
    }

    public Map<String, Object> byIssue(long issueId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("data", ((CommentDAO) this.getDAO()).byIssue(issueId));
        return map;
    }
}

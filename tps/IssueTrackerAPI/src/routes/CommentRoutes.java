package routes;

import java.util.HashMap;
import java.util.Map;

import models.Comment;
import models.Issue;
import models.User;
import resources.CommentResource;
import spark.Request;
import spark.Response;
import spark.Spark;
import utils.JsonTransformerRoute;
import utils.NotFoundException;
import dao.IssueDAO;

public class CommentRoutes {
    public static void routes() {
        Spark.get(new JsonTransformerRoute("/api/issues/:id/comments") {
            @Override
            public Object handle(Request request, Response response) {
                try {
                    Issue issue = new IssueDAO().byId(Long.parseLong(request
                            .params(":id")));
                    return this.render(
                            new CommentResource().byIssue(issue.getId()),
                            response);
                } catch (NotFoundException e) {
                    Map<String, Object> result = new HashMap<String, Object>();
                    result.put("code", 404);
                    result.put("message", e.getMessage());
                    return this.render(result, response);
                }
            }
        });

        Spark.post(new JsonTransformerRoute("/api/issues/:id/comments") {
            @Override
            public Object handle(Request request, Response response) {
                try {
                    Issue issue = new IssueDAO().byId(Long.parseLong(request
                            .params(":id")));
                    Comment comment = new Comment().fromJson(request.body());
                    comment.setIssue_id(issue.getId());
                    comment.setUser_id(((User) request.session().attribute(
                            "user")).getId());

                    return this.render(new CommentResource().save(comment),
                            response);
                } catch (NotFoundException e) {
                    Map<String, Object> result = new HashMap<String, Object>();
                    result.put("code", 404);
                    result.put("message", e.getMessage());
                    return this.render(result, response);
                }
            }
        });
    }
}
